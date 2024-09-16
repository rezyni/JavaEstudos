package com.mycompany.projetocoo_caique.entity.enemy3;
import com.mycompany.projetocoo_caique.enums.States;
import com.mycompany.projetocoo_caique.entity.Entity;

/*
 * @author Caique
 */
public class Enemy3 extends Entity {

	private States state;
	private double x;
	private double y;
	private double v;
	private double angle;
	private double rv;
	private double enemy3_radius;
	private double enemy3_explosion_start;
	private double enemy3_explosion_end;
	private long nextEnemy3;
	private long nextShot;

	public Enemy3 (States state, double x, double y, double v, long currentTime) {
		super(state, x, y, 0, v);
		this.enemy3_radius = 15.0;
		this.nextEnemy3 = currentTime + 6000;
	}

	public double getAngle () {
		return this.angle;
	}

	public double getRV () {
		return this.rv;
	}

	public double getRadius () {
		return this.enemy3_radius;
	}

	public double getExplosionStart () {
		return this.enemy3_explosion_start;
	}

	public double getExplosionEnd () {
		return this.enemy3_explosion_end;
	}

	public long getNextEnemy () {
		return this.nextEnemy3;
	}

	public long getNextShot () {
		return this.nextShot;
	}

	public void setAngle (double angle) {
		this.angle = angle;
	}

	public void setRV (double rv) {
		this.rv = rv;
	}

	public void setExplosionStart (double explosion_start) {
		this.enemy3_explosion_start = explosion_start;
	}

	public void setExplosionEnd (double explosion_end) {
		this.enemy3_explosion_end = explosion_end;
	}

	public void setNextEnemy (long nextEnemy) {
		this.nextEnemy3 = nextEnemy;
	}

	public void setNextShot (long nextShot) {
		this.nextShot = nextShot;
	}

}
