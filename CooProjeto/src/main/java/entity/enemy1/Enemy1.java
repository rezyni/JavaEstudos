package entity.enemy1;
import entity.*;
import enums.*;

public class Enemy1 extends Entity {

	private States state;
	private double x;
	private double y;
	private double v;
	private double angle;
	private double rv;
	private double enemy1_radius;
	private double enemy1_explosion_start;
	private double enemy1_explosion_end;
	private long nextEnemy1;
	private long nextShot;

	public Enemy1 (States state, double x, double y, double v, long currentTime) {
		super(state, x, y, 0, v);
		this.enemy1_radius = 9.0;
		this.nextEnemy1 = currentTime + 2000;
	}

	public double getAngle () {
		return this.angle;
	}

	public double getRV () {
		return this.rv;
	}

	public double getRadius () {
		return this.enemy1_radius;
	}

	public double getExplosionStart () {
		return this.enemy1_explosion_start;
	}

	public double getExplosionEnd () {
		return this.enemy1_explosion_end;
	}

	public long getNextEnemy () {
		return this.nextEnemy1;
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
		this.enemy1_explosion_start = explosion_start;
	}

	public void setExplosionEnd (double explosion_end) {
		this.enemy1_explosion_end = explosion_end;
	}

	public void setNextEnemy (long nextEnemy) {
		this.nextEnemy1 = nextEnemy;
	}

	public void setNextShot (long nextShot) {
		this.nextShot = nextShot;
	}

}