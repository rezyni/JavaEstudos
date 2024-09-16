package com.mycompany.aula07coo;
import java.util.Random;
/*
 * @author Caique
 */
public class Luta {
    
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;
    
    public Lutador getDesafiado(){
        return desafiado;
    }
    public void setDesafiado(Lutador d){
        this.desafiado = d;
    }
    
    public Lutador getDesafiante(){
        return desafiante;
    }
    public void setDesafiante(Lutador df){
        this.desafiante = df;
    }
    
    public int getRounds(){
        return rounds;
    }
    public void setRounds(int r){
        this.rounds = r;
    }

    public boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    
    
    
    
    public void marcarLuta(Lutador l1,Lutador l2){
        if(l1.getCategoria().equals(l2.getCategoria())== true && l1.equals(l2)==false){
            setAprovada(true);
            setDesafiado(l1);
            setDesafiante(l2);
        }else {
            setAprovada(false);
            setDesafiado(null);
            setDesafiante(null);
            System.out.println("Os lutadores possuem Categoria diferente");
        }
    }
    
    public void lutar(){
        if(getAprovada()==true){
            System.out.println("##### DESAFIADO #####");
            this.desafiado.apresentar();
            System.out.println("##### DESAFIANTE #####");
            this.desafiante.apresentar();
            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3); //0 1 2
            
            switch(vencedor){
                case 0 -> {
                    //Empate
                    System.out.println("Empatou");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
                }
                    
                case 1 -> {
                    //Desafiado vence
                    System.out.println(this.desafiado.getNome()+" Ganhou");
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                }
                    
                case 2 -> {
                    //Desafiante vence
                    System.out.println(this.desafiante.getNome()+" Ganhou");
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                }
            }
        }else{
            System.out.println("A luta nao pode acontecer");
        }
    }
}
