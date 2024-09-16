package com.mycompany.cooprojeto;

import java.awt.Color;
import java.util.*;
import enums.*;
import entity.player.*;
import entity.playerProjectile.*;
import entity.enemyProjectile.*;
import entity.enemyProjectile3.*;
import entity.enemy1.*;
import entity.enemy2.*;
import entity.enemy3.*;
import entity.powerup.*;
import entity.background.*;

/***********************************************************************/
/*                                                                     */
/* Para jogar:                                                         */
/*                                                                     */
/*    - cima, baixo, esquerda, direita: movimentação do player.        */
/*    - control: disparo de projéteis.                                 */
/*    - ESC: para sair do jogo.                                        */
/*                                                                     */
/***********************************************************************/

public class Main {
	/*testegit*/
	/* Espera, sem fazer nada, até que o instante de tempo atual seja */
	/* maior ou igual ao instante especificado no parâmetro "time.    */

	public static void busyWait(long time){
		
		while(System.currentTimeMillis() < time) Thread.yield();
	}
	
	
	/* Método principal */
	
	public static void main(String [] args){

		/* Indica que o jogo está em execução */

		boolean running = true;

		/* variáveis usadas no controle de tempo efetuado no main loop */
		
		long delta;
		long currentTime = System.currentTimeMillis();
		
		Player player = new Player(States.ACTIVE, GameLib.WIDTH/2, GameLib.HEIGHT*0.9, 0.25, 0.25, currentTime); /* variáveis do player */
		
		LinkedList<PlayerProjectile> player_projectiles = new LinkedList<>();/* variáveis dos projéteis disparados pelo player */

		LinkedList<Enemy1> enemies1 = new LinkedList<>();/* variáveis dos inimigos tipo 1 */		
		LinkedList<Enemy2> enemies2 = new LinkedList<>();/* variáveis dos inimigos tipo 2 */		
		LinkedList<Enemy3> enemies3 = new LinkedList<>();/* variáveis dos inimigos tipo 3 */
		
		LinkedList<powerup> powerup = new LinkedList<>();/* variáveis dos powerups */
		
		LinkedList<EnemyProjectile> enemies_projectiles = new LinkedList<>();/* variáveis dos projéteis lançados pelos inimigos (tanto tipo 1 e 2) */
		LinkedList<EnemyProjectile3> enemies_projectiles3 = new LinkedList<>();/* variáveis dos projéteis lançados pelos inimigos (tipo 3) */
		
		LinkedList<Background> background1 = new LinkedList<>();/* estrelas que formam o fundo de primeiro plano */		
		LinkedList<Background> background2 = new LinkedList<>();/* estrelas que formam o fundo de segundo plano */
		
		/* inicializações */
		
		for(int i = 0; i < 10; i++) player_projectiles.add(new PlayerProjectile(States.INACTIVE, 0.0, 0.0, 0.0, 0.0));
		for(int i = 0; i < 200; i++) enemies_projectiles.add(new EnemyProjectile(States.INACTIVE, 0.0, 0.0, 0.0, 0.0));
		for(int i = 0; i < 200; i++) enemies_projectiles3.add(new EnemyProjectile3(States.INACTIVE, 0.0, 0.0, 0.0, 0.0));
		for(int i = 0; i < 10; i++) enemies1.add(new Enemy1(States.INACTIVE, 0.0, 0.0, 0.0, currentTime));
		for(int i = 0; i < 10; i++) enemies2.add(new Enemy2(States.INACTIVE, 0.0, 0.0, 0.0, currentTime, 0.0));
		for(int i = 0; i < 10; i++) enemies3.add(new Enemy3(States.INACTIVE, 0.0, 0.0, 0.0, currentTime));
		for(int i = 0; i < 10; i++) powerup.add(new powerup(States.INACTIVE, 0.0, 0.0, 0.0, currentTime));
		player.setpowerupState(States.INACTIVE);
		
		for(int i = 0; i < 20; i++)
			background1.add(new Background(Math.random() * GameLib.WIDTH, Math.random() * GameLib.HEIGHT, 0.07));
		
		for(int i = 0; i < 50; i++)
			background1.add(new Background(Math.random() * GameLib.WIDTH, Math.random() * GameLib.HEIGHT, 0.045));
						
		/* iniciado interface gráfica */
		
		GameLib.initGraphics();
		//GameLib.initGraphics_SAFE_MODE();  // chame esta versão do método caso nada seja desenhado na janela do jogo.
		
		/*************************************************************************************************/
		/*                                                                                               */
		/* Main loop do jogo                                                                             */
		/* -----------------                                                                             */
		/*                                                                                               */
		/* O main loop do jogo executa as seguintes operações:                                           */
		/*                                                                                               */
		/* 1) Verifica se há colisões e atualiza estados dos elementos conforme a necessidade.           */
		/*                                                                                               */
		/* 2) Atualiza estados dos elementos baseados no tempo que correu entre a última atualização     */
		/*    e o timestamp atual: posição e orientação, execução de disparos de projéteis, etc.         */
		/*                                                                                               */
		/* 3) Processa entrada do usuário (teclado) e atualiza estados do player conforme a necessidade. */
		/*                                                                                               */
		/* 4) Desenha a cena, a partir dos estados dos elementos.                                        */
		/*                                                                                               */
		/* 5) Espera um período de tempo (de modo que delta seja aproximadamente sempre constante).      */
		/*                                                                                               */
		/*************************************************************************************************/
		
		while(running){
		
			/* Usada para atualizar o estado dos elementos do jogo    */
			/* (player, projéteis e inimigos) "delta" indica quantos  */
			/* ms se passaram desde a última atualização.             */
			
			delta = System.currentTimeMillis() - currentTime;
			
			/* Já a variável "currentTime" nos dá o timestamp atual.  */
			
			currentTime = System.currentTimeMillis();
			
			/***************************/
			/* Verificação de colisões */
			/***************************/
						
			if(player.getState() == States.ACTIVE  && player.getpowerupState() == States.INACTIVE){
				
				/* colisões player - projeteis (inimigo) */ 
				
				for(int i = 0; i < enemies_projectiles.size(); i++)
					player.playerCollisions(enemies_projectiles.get(i).getX(), enemies_projectiles.get(i).getY(),
						enemies_projectiles.get(i).getRadius(), player, currentTime);

				for(int i = 0; i < enemies_projectiles3.size(); i++)
					player.playerCollisions(enemies_projectiles3.get(i).getX(), enemies_projectiles3.get(i).getY(),
						enemies_projectiles3.get(i).getRadius(), player, currentTime);

				/* colisões player - inimigos */
							
				for(int i = 0; i < enemies1.size(); i++)
					player.playerCollisions(enemies1.get(i).getX(), enemies1.get(i).getY(),
						enemies1.get(i).getRadius(), player, currentTime);
				
				for(int i = 0; i < enemies2.size(); i++)
					player.playerCollisions(enemies2.get(i).getX(), enemies2.get(i).getY(),
						enemies2.get(i).getRadius(), player, currentTime);

				for(int i = 0; i < enemies3.size(); i++)
					player.playerCollisions(enemies3.get(i).getX(), enemies3.get(i).getY(),
						enemies3.get(i).getRadius(), player, currentTime);

				
			} 
			
			if(player.getState() == States.ACTIVE){

				for(int i = 0; i < powerup.size(); i++){
					player.playerCollisionspowerup(powerup.get(i).getX(), powerup.get(i).getY(),
						powerup.get(i).getRadius(), player, currentTime);
				}

				for(int i = 0; i < powerup.size(); i++){
										
					if(powerup.get(i).getState() == States.ACTIVE){
					
						double dx = powerup.get(i).getX() - player.getX();
						double dy = powerup.get(i).getY() - player.getY();
						double dist = Math.sqrt(dx * dx + dy * dy);
						
						if(dist < powerup.get(i).getRadius()){
							
							powerup.get(i).setState(States.INACTIVE);
						}
					}
				}

			}

			/* colisões projeteis (player) - inimigos */
			
			for(int k = 0; k < player_projectiles.size(); k++){
				
				for(int i = 0; i < enemies1.size(); i++){
										
					if(enemies1.get(i).getState() == States.ACTIVE){
					
						double dx = enemies1.get(i).getX() - player_projectiles.get(k).getX();
						double dy = enemies1.get(i).getY() - player_projectiles.get(k).getY();
						double dist = Math.sqrt(dx * dx + dy * dy);
						
						if(dist < enemies1.get(i).getRadius()){
							
							enemies1.get(i).setState(States.EXPLODING);
							enemies1.get(i).setExplosionStart(currentTime);
							enemies1.get(i).setExplosionEnd(currentTime + 500);
						}
					}
				}
				
				for(int i = 0; i < enemies2.size(); i++){
					
					if(enemies2.get(i).getState() == States.ACTIVE){
						
						double dx = enemies2.get(i).getX() - player_projectiles.get(k).getX();
						double dy = enemies2.get(i).getY() - player_projectiles.get(k).getY();
						double dist = Math.sqrt(dx * dx + dy * dy);
						
						if(dist < enemies2.get(i).getRadius()){
							
							enemies2.get(i).setState(States.EXPLODING);
							enemies2.get(i).setExplosionStart(currentTime);
							enemies2.get(i).setExplosionEnd(currentTime + 500);
						}
					}
				}

				for(int i = 0; i < enemies3.size(); i++){
										
					if(enemies3.get(i).getState() == States.ACTIVE){
					
						double dx = enemies3.get(i).getX() - player_projectiles.get(k).getX();
						double dy = enemies3.get(i).getY() - player_projectiles.get(k).getY();
						double dist = Math.sqrt(dx * dx + dy * dy);
						
						if(dist < enemies3.get(i).getRadius()){
							
							enemies3.get(i).setState(States.EXPLODING);
							enemies3.get(i).setExplosionStart(currentTime);
							enemies3.get(i).setExplosionEnd(currentTime + 500);
						}
					}
				}
			}
				
			/***************************/
			/* Atualizações de estados */
			/***************************/
			
			/* projeteis (player) */
			
			for(int i = 0; i < player_projectiles.size(); i++){
				
				if(player_projectiles.get(i).getState() == States.ACTIVE){
					
					/* verificando se projétil saiu da tela */
					if(player_projectiles.get(i).getY() < 0) {
						
						player_projectiles.get(i).setState(States.INACTIVE);
						player_projectiles.remove(i);
					}
					else {
					
						player_projectiles.get(i).setX(player_projectiles.get(i).getX() + player_projectiles.get(i).getVX() * delta);
						player_projectiles.get(i).setY(player_projectiles.get(i).getY() + player_projectiles.get(i).getVY() * delta);
					}
				}
			}
			
			/* projeteis (inimigos tipo 1 e 2) */
			
			for(int i = 0; i < enemies_projectiles.size(); i++){
				
				if(enemies_projectiles.get(i).getState() == States.ACTIVE){
					
					/* verificando se projétil saiu da tela */
					if(enemies_projectiles.get(i).getY() > GameLib.HEIGHT) {
						
						enemies_projectiles.get(i).setState(States.INACTIVE);
					}
					else {
					
						enemies_projectiles.get(i).setX(enemies_projectiles.get(i).getX() + enemies_projectiles.get(i).getVX() * delta);
						enemies_projectiles.get(i).setY(enemies_projectiles.get(i).getY() + enemies_projectiles.get(i).getVY() * delta);
					}
				}
			}

			/* projeteis (inimigos tipo 3) */
			
			for(int i = 0; i < enemies_projectiles3.size(); i++){
				
				if(enemies_projectiles3.get(i).getState() == States.ACTIVE){
					
					/* verificando se projétil saiu da tela */
					if(enemies_projectiles3.get(i).getY() > GameLib.HEIGHT) {
						
						enemies_projectiles3.get(i).setState(States.INACTIVE);
					}
					else {
					
						enemies_projectiles3.get(i).setX(enemies_projectiles3.get(i).getX() + enemies_projectiles3.get(i).getVX() * delta / 3);
						enemies_projectiles3.get(i).setY(enemies_projectiles3.get(i).getY() + enemies_projectiles3.get(i).getVY() * delta / 3);
					}
				}
			}
			
			/* inimigos tipo 1 */
			
			for(int i = 0; i < enemies1.size()-1; i++){
				
				if(enemies1.get(i).getState() == States.EXPLODING){
					
					if(currentTime > enemies1.get(i).getExplosionEnd()) {
						
						enemies1.get(i).setState(States.INACTIVE);
						enemies1.remove(i);
					}
				}
				
				if(enemies1.get(i).getState() == States.ACTIVE){
					
					/* verificando se inimigo saiu da tela */
					if(enemies1.get(i).getY() > GameLib.HEIGHT + 10) {
						
						enemies1.get(i).setState(States.INACTIVE);
						enemies1.remove(i);
					}
					else {
					
						enemies1.get(i).setX(enemies1.get(i).getX() + enemies1.get(i).getVY() * Math.cos(enemies1.get(i).getAngle()) * delta);
						enemies1.get(i).setY(enemies1.get(i).getY() + enemies1.get(i).getVY() * Math.sin(enemies1.get(i).getAngle()) * delta * (-1.0));
						enemies1.get(i).setAngle(enemies1.get(i).getAngle() + enemies1.get(i).getRV() * delta);
						
						if(currentTime > enemies1.get(i).getNextShot() && enemies1.get(i).getY() < player.getY()){
																							
							
							if(enemies_projectiles.size() > 0){
								
								enemies_projectiles.add(new EnemyProjectile(States.ACTIVE, enemies1.get(i).getX(), enemies1.get(i).getY(), 
									Math.cos(enemies1.get(i).getAngle()) * 0.45, Math.sin(enemies1.get(i).getAngle()) * 0.45 * (-1.0)));
								
								enemies1.get(i).setNextShot((long) (currentTime + 200 + Math.random() * 500));
							}
						}
					}
				}
			}
			
			/* inimigos tipo 2 */
			
			for(int i = 0; i < enemies2.size()-1; i++){
				
				if(enemies2.get(i).getState() == States.EXPLODING){
					
					if(currentTime > enemies2.get(i).getExplosionEnd()){
						
						enemies2.get(i).setState(States.INACTIVE);
						enemies2.remove(i);
						continue;
					}
				}
				
				if(enemies2.get(i).getState() == States.ACTIVE){
					
					/* verificando se inimigo saiu da tela */
					if(	enemies2.get(i).getX() < -10 || enemies2.get(i).getX() > GameLib.WIDTH + 10 ) {
						
						enemies2.get(i).setState(States.INACTIVE);
						enemies2.remove(i);
					}
					else {
						
						boolean shootNow = false;
						double previousY = enemies2.get(i).getY();
												
						enemies2.get(i).setX(enemies2.get(i).getX() + enemies2.get(i).getVY() * Math.cos(enemies2.get(i).getAngle()) * delta);
						enemies2.get(i).setY(enemies2.get(i).getY() + enemies2.get(i).getVY() * Math.sin(enemies2.get(i).getAngle()) * delta * (-1.0));
						enemies2.get(i).setAngle(enemies2.get(i).getAngle() + enemies2.get(i).getRV() * delta);
						
						double threshold = GameLib.HEIGHT * 0.30;
						
						if(previousY < threshold && enemies2.get(i).getY() >= threshold) {
							
							if(enemies2.get(i).getX() < GameLib.WIDTH / 2) enemies2.get(i).setRV(0.003);
							else enemies2.get(i).setRV(-0.003);
						}
						
						if(enemies2.get(i).getRV() > 0 && Math.abs(enemies2.get(i).getAngle() - 3 * Math.PI) < 0.05){
							
							enemies2.get(i).setRV(0.0);
							enemies2.get(i).setAngle(3 * Math.PI);
							shootNow = true;
						}
						
						if(enemies2.get(i).getRV() < 0 && Math.abs(enemies2.get(i).getAngle()) < 0.05){
							
							enemies2.get(i).setRV(0.0);
							enemies2.get(i).setAngle(0.0);
							shootNow = true;
						}
																		
						if(shootNow){

							double [] angles = { Math.PI/2 + Math.PI/8, Math.PI/2, Math.PI/2 - Math.PI/8 };

							if (enemies_projectiles.size() > 0) {
								//caso queira uma rajada maior, aumentar o 3 abaixo
								for (int l = 0; l < 3; l++) {
									int k = (int) (Math.random() * 2);
									
									double a = angles[k] + Math.random() * Math.PI/6 - Math.PI/12;
									double vx = Math.cos(a);
									double vy = Math.sin(a);
											
									enemies_projectiles.add(new EnemyProjectile(States.ACTIVE, enemies2.get(i).getX(), enemies2.get(i).getY(),
											vx*0.3, vy*0.3));
								}
							}
						}
					}
				}
			}

			/* inimigos tipo 3 */
			
			for(int i = 0; i < enemies3.size() - 1; i++){
				
				if(enemies3.get(i).getState() == States.EXPLODING){
					
					if(currentTime > enemies3.get(i).getExplosionEnd()) {
						
						enemies3.get(i).setState(States.INACTIVE);
						enemies3.remove(i);
					}
				}
				
				if(enemies3.get(i).getState() == States.ACTIVE){
					
					/* verificando se inimigo saiu da tela */
					if(enemies3.get(i).getY() > GameLib.HEIGHT + 10) {
						
						enemies3.get(i).setState(States.INACTIVE);
						enemies3.remove(i);
					}
					else {
					
						double previousY = enemies3.get(i).getY();
												
						enemies3.get(i).setX(enemies3.get(i).getX() + enemies3.get(i).getVY() * Math.cos(enemies3.get(i).getAngle()) * delta);
						enemies3.get(i).setY(enemies3.get(i).getY() + enemies3.get(i).getVY() * Math.sin(enemies3.get(i).getAngle()) * delta * (-1.0));
						enemies3.get(i).setAngle(enemies3.get(i).getAngle() + enemies3.get(i).getRV() * delta);
						
						double threshold = GameLib.HEIGHT * 0.10;
						
						if(previousY < threshold && enemies3.get(i).getY() >= threshold) {
							
							if(enemies3.get(i).getX() < GameLib.WIDTH / 2) 
								enemies3.get(i).setRV(0.003);
							else 
								enemies3.get(i).setRV(-0.003);
						}
						
						if(enemies3.get(i).getRV() > 0 && Math.abs(enemies3.get(i).getAngle() - 3 * Math.PI) < 3.3){
							
							enemies3.get(i).setRV(-0.003);
						}
						
						if(enemies3.get(i).getRV() < 0 && Math.abs(enemies3.get(i).getAngle()) < 3.3){
							
							enemies3.get(i).setRV(0.003);
						}

						if(currentTime > enemies3.get(i).getNextShot() && enemies3.get(i).getY() < player.getY()){
																							
							if(enemies_projectiles3.size() > 0){
								
								enemies_projectiles3.add(new EnemyProjectile3(States.ACTIVE, enemies3.get(i).getX(), enemies3.get(i).getY(), 
									Math.cos(3 * Math.PI/2) * 0.45, Math.sin(3 * Math.PI/2) * 0.45 * (-1.0)));
								
								enemies3.get(i).setNextShot((long) (currentTime + 1000 + Math.random() * 1500));
							}
						}
					}
				}
			}
			
			/* powerups */
			
			for(int i = 0; i < powerup.size(); i++){
				
				if(powerup.get(i).getState() == States.ACTIVE){
					
					/* verificando se inimigo saiu da tela */
					if(powerup.get(i).getY() > GameLib.HEIGHT + 10 || powerup.get(i).getX() > GameLib.WIDTH + 10) {
						
						powerup.get(i).setState(States.INACTIVE);
						powerup.remove(i);
					}
					else {
					
						powerup.get(i).setX(powerup.get(i).getX() + powerup.get(i).getVY() * Math.sin(powerup.get(i).getAngle()) * delta * (-1.0));
						powerup.get(i).setY(powerup.get(i).getY() + powerup.get(i).getVY() * Math.cos(powerup.get(i).getAngle()) * delta);
						powerup.get(i).setAngle(powerup.get(i).getAngle() + powerup.get(i).getRV() * delta);
					}
				}
			}
			
			/* verificando se novos inimigos (tipo 1) devem ser "lançados" */
			
			if(currentTime > enemies1.get(enemies1.size()-1).getNextEnemy()){
								
				if(enemies1.size() > 0){
					
					enemies1.add(new Enemy1(States.ACTIVE, Math.random() * (GameLib.WIDTH - 20.0) + 10.0, -10.0,
						0.20 + Math.random() * 0.15, currentTime));
					
					enemies1.get(enemies1.size()-1).setAngle((3 * Math.PI) / 2);
					enemies1.get(enemies1.size()-1).setRV(0.0);
					enemies1.get(enemies1.size()-1).setNextShot(currentTime + 500);
					enemies1.get(enemies1.size()-1).setNextEnemy(currentTime + 1000);
				}
			}

			/* verificando se novos inimigos (tipo 2) devem ser "lançados" */

			if(currentTime > enemies2.get(0).getNextEnemy()){
			
				if(enemies2.size() > 0){			
					enemies2.add(new Enemy2(States.ACTIVE, enemies2.get(enemies2.size()-1).getSpawnX(), -10.0, 0.42, currentTime, GameLib.WIDTH));

					enemies2.get(enemies2.size()-1).setAngle((3 * Math.PI) / 2);
					enemies2.get(enemies2.size()-1).setRV(0.0);
					enemies2.get(0).setCount(enemies2.get(0).getCount() + 1);
					
					if(enemies2.get(0).getCount() < 14){
						
						enemies2.get(0).setNextEnemy(currentTime + 120);
					}
					else {
						enemies2.get(0).setCount(0);
						enemies2.get(0).setSpawnX(Math.random() > 0.5 ? GameLib.WIDTH * 0.2 : GameLib.WIDTH * 0.8);
						enemies2.get(0).setNextEnemy((long) (currentTime + 6000 + Math.random() * 3000));
					}
				}
			}

			/* verificando se novos inimigos (tipo 3) devem ser "lançados" */
			
			if(currentTime > enemies3.get(enemies3.size()-1).getNextEnemy()){
								
				if(enemies3.size() > 0){
					
					enemies3.add(new Enemy3(States.ACTIVE, Math.random() * (GameLib.WIDTH - 20.0) + 10.0, -10.0,
						0.05 + Math.random() * 0.05, currentTime));
					
					enemies3.get(enemies3.size()-1).setAngle((3 * Math.PI) / 2);
					enemies3.get(enemies3.size()-1).setRV(0.0);
					enemies3.get(enemies3.size()-1).setNextShot(currentTime + 2000);
					enemies3.get(enemies3.size()-1).setNextEnemy(currentTime + 4500);
				}
			}

			/* verificando se novos powerups devem ser "lançados" */
			
			if(currentTime > powerup.get(powerup.size()-1).getNextEnemy()){
								
				if(powerup.size() > 0){
					
					powerup.add(new powerup(States.ACTIVE,  0.0, 350.0,
						0.05 + Math.random() * 0.05, currentTime));
					
					powerup.get(powerup.size()-1).setAngle((3 * Math.PI) / 2);
					powerup.get(powerup.size()-1).setRV(0.0);
					powerup.get(powerup.size()-1).setNextEnemy(currentTime + 15000);
				}
			}
			
			/* Verificando se a explosão do player já acabou.         */
			/* Ao final da explosão, o player volta a ser controlável */
			if(player.getState() == States.EXPLODING){
				
				if(currentTime > player.getExplosionEnd()){
					
					player.setState(States.ACTIVE);
				}
			}

			/* Verificando se o powerup do player já acabou.         */
			/* Ao final do powerup, o player volta a ser alvejável */
			if(player.getpowerupState() == States.ACTIVE){
				
				if(currentTime > player.getpowerupEnd()){
					
					player.setpowerupState(States.INACTIVE);
				}
			}
			
			/********************************************/
			/* Verificando entrada do usuário (teclado) */
			/********************************************/
			
			if(player.getState() == States.ACTIVE){
				
				if(GameLib.iskeyPressed(GameLib.KEY_UP)) player.setY(player.getY() - delta * player.getVY());
				if(GameLib.iskeyPressed(GameLib.KEY_DOWN)) player.setY(player.getY() + delta * player.getVY());
				if(GameLib.iskeyPressed(GameLib.KEY_LEFT)) player.setX(player.getX() - delta * player.getVX());
				if(GameLib.iskeyPressed(GameLib.KEY_RIGHT)) player.setX(player.getX() + delta * player.getVY());
				
				if(GameLib.iskeyPressed(GameLib.KEY_CONTROL)) {
					
					if(currentTime > player.getNextShot()){							
						player_projectiles.add(new PlayerProjectile(States.ACTIVE, player.getX(), player.getY() - 2 * player.getRadius(), 0.0, -1.0));
						player.setNextShot(currentTime + 100);
					}	
				}
			}
			
			if(GameLib.iskeyPressed(GameLib.KEY_ESCAPE)) running = false;
			
			/* Verificando se coordenadas do player ainda estão dentro */
			/* da tela de jogo após processar entrada do usuário.      */
			
			if(player.getX() < 0.0) player.setX(0.0);
			if(player.getX() >= GameLib.WIDTH) player.setX(GameLib.WIDTH - 1);
			if(player.getY() < 25.0) player.setY(25.0);
			if(player.getY() >= GameLib.HEIGHT) player.setY(GameLib.HEIGHT - 1);

			/*******************/
			/* Desenho da cena */
			/*******************/
			
			/* desenhando plano fundo distante */
			
			GameLib.setColor(Color.DARK_GRAY);
			for(int i = 0; i < background2.size(); i++)
				background2.get(i).setCount(background2.get(i).getCount() + background2.get(i).getSpeed() * delta);
			
			for(int i = 0; i < background2.size(); i++){
				
				GameLib.fillRect(background2.get(i).getX(), (background2.get(i).getY() + background2.get(i).getCount()) % GameLib.HEIGHT, 2, 2);
			}
			
			/* desenhando plano de fundo próximo */
			
			GameLib.setColor(Color.GRAY);
			for(int i = 0; i < background1.size(); i++)
				background1.get(i).setCount(background1.get(i).getCount() + background1.get(i).getSpeed() * delta);
			
			for(int i = 0; i < background1.size(); i++){
				
				GameLib.fillRect(background1.get(i).getX(), (background1.get(i).getY() + background1.get(i).getCount()) % GameLib.HEIGHT, 3, 3);
			}
						
			/* desenhando player */
			
			if(player.getState() == States.EXPLODING){
				
				double alpha = (currentTime - player.getExplosionStart()) / (player.getExplosionEnd() - player.getExplosionStart());
				GameLib.drawExplosion(player.getX(), player.getY(), alpha);
			}
			else{				
				GameLib.setColor(Color.BLUE);

				for(int j = 0; j < player.getRadius(); j++){
					GameLib.drawPlayer(player.getX(), player.getY(), player.getRadius() - j);
				}

				if(player.getpowerupState() == States.ACTIVE){
					GameLib.setColor(Color.YELLOW);
					GameLib.drawPlayer(player.getX(), player.getY(), player.getRadius());
					GameLib.drawPlayer(player.getX(), player.getY(), player.getRadius() - 1);
				}
			}
				
			/* deenhando projeteis (player) */
			
			for(int i = 0; i < player_projectiles.size(); i++){
				
				if(player_projectiles.get(i).getState() == States.ACTIVE){
					
					GameLib.setColor(Color.GREEN);
					GameLib.drawLine(player_projectiles.get(i).getX(), player_projectiles.get(i).getY() - 5, player_projectiles.get(i).getX(), player_projectiles.get(i).getY() + 5);
					GameLib.drawLine(player_projectiles.get(i).getX() - 1, player_projectiles.get(i).getY() - 3, player_projectiles.get(i).getX() - 1, player_projectiles.get(i).getY() + 3);
					GameLib.drawLine(player_projectiles.get(i).getX() + 1, player_projectiles.get(i).getY() - 3, player_projectiles.get(i).getX() + 1, player_projectiles.get(i).getY() + 3);
				}
			}
			
			/* desenhando projeteis (inimigos 1 e 2) */
		
			for(int i = 0; i < enemies_projectiles.size(); i++){
				
				if(enemies_projectiles.get(i).getState() == States.ACTIVE){
	
					GameLib.setColor(Color.RED);
					GameLib.drawCircle(enemies_projectiles.get(i).getX(), enemies_projectiles.get(i).getY(), enemies_projectiles.get(i).getRadius());
				}
			}

			/* desenhando projeteis (inimigos 3) */
		
			for(int i = 0; i < enemies_projectiles3.size(); i++){
				
				if(enemies_projectiles3.get(i).getState() == States.ACTIVE){
	
					GameLib.setColor(Color.RED);
					GameLib.drawCircle(enemies_projectiles3.get(i).getX(), enemies_projectiles3.get(i).getY(), enemies_projectiles3.get(i).getRadius());
				}
			}
			
			/* desenhando inimigos (tipo 1) */
			
			for(int i = 0; i < enemies1.size(); i++){
				
				if(enemies1.get(i).getState() == States.EXPLODING){
					
					double alpha = (currentTime - enemies1.get(i).getExplosionStart()) / (enemies1.get(i).getExplosionEnd() - enemies1.get(i).getExplosionStart());
					if (alpha < 1)
						GameLib.drawExplosion(enemies1.get(i).getX(), enemies1.get(i).getY(), alpha);
				}
				
				if(enemies1.get(i).getState() == States.ACTIVE){
			
					GameLib.setColor(Color.CYAN);

					for(int j = 0; j < enemies1.get(i).getRadius(); j++){
						GameLib.drawCircle(enemies1.get(i).getX(), enemies1.get(i).getY(), enemies1.get(i).getRadius() - j);
					}
				}
			}
			
			/* desenhando inimigos (tipo 2) */
			
			for(int i = 0; i < enemies2.size(); i++){
				
				if(enemies2.get(i).getState() == States.EXPLODING){
					
					double alpha = (currentTime - enemies2.get(i).getExplosionStart()) / (enemies2.get(i).getExplosionEnd() - enemies2.get(i).getExplosionStart());
					if (alpha < 1)
						GameLib.drawExplosion(enemies2.get(i).getX(), enemies2.get(i).getY(), alpha);
				}
				
				if(enemies2.get(i).getState() == States.ACTIVE){
			
					GameLib.setColor(Color.MAGENTA);

					for(int j = 0; j < enemies2.get(i).getRadius(); j++){
						GameLib.drawDiamond(enemies2.get(i).getX(), enemies2.get(i).getY(), enemies2.get(i).getRadius() - j);
					}
				}
			}
			
			/* desenhando inimigos (tipo 3) */
			
			for(int i = 0; i < enemies3.size(); i++){
				
				if(enemies3.get(i).getState() == States.EXPLODING){
					
					double alpha = (currentTime - enemies3.get(i).getExplosionStart()) / (enemies3.get(i).getExplosionEnd() - enemies3.get(i).getExplosionStart());
					if (alpha < 1)
						GameLib.drawExplosion(enemies3.get(i).getX(), enemies3.get(i).getY(), alpha);
				}
				
				if(enemies3.get(i).getState() == States.ACTIVE){
			
					GameLib.setColor(Color.ORANGE);

					for(int j = 0; j < enemies3.get(i).getRadius(); j++){
						GameLib.drawCircle(enemies3.get(i).getX(), enemies3.get(i).getY(), enemies3.get(i).getRadius() - j);
					}
				}
			}

			/* desenhando powerups */
			
			for(int i = 0; i < powerup.size(); i++){
				
				if(powerup.get(i).getState() == States.ACTIVE){
			
					GameLib.setColor(Color.RED);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 14.0);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 13.0);
					GameLib.setColor(Color.ORANGE);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 12.0);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 11.0);
					GameLib.setColor(Color.YELLOW);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 10.0);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 9.0);
					GameLib.setColor(Color.GREEN);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 8.0);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 7.0);
					GameLib.setColor(Color.BLUE);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 6.0);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 5.0);
					GameLib.setColor(Color.MAGENTA);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 4.0);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 3.0);
					GameLib.setColor(Color.PINK);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 2.0);
					GameLib.drawDiamond(powerup.get(i).getX(), powerup.get(i).getY(), 1.0);
				}
			}

			/* chamada a display() da classe GameLib atualiza o desenho exibido pela interface do jogo. */
			
			GameLib.display();
			
			/* faz uma pausa de modo que cada execução do laço do main loop demore aproximadamente 3 ms. */
			
			busyWait(currentTime + 3);
		}
		
		System.exit(0);
	}
}

