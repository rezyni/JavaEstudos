package com.mycompany.projetocoo_caique.entity.enemyProjectile3;
import com.mycompany.projetocoo_caique.enums.States;
import com.mycompany.projetocoo_caique.entity.Entity;
/*
 * @author Caique
 */
public class EnemyProjectile3 extends Entity {
	private States state;
	private double x;
	private double y;
	private double vx;
	private double vy;
	private double radius;

	public EnemyProjectile3 (States state, double x, double y, double vx, double vy) {
		super(state, x, y, vx, vy);
		this.radius = 12.0;
	}

	public double getRadius () {
		return this.radius;
	}

}