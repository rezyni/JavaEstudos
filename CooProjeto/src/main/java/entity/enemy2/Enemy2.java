package entity.enemy2;
import entity.*;
import enums.*;

public class Enemy2 extends Entity {

	private States state;
	private double x;
	private double y;
	private double v;
	private double angle;
	private double rv;
	private double enemy2_radius;
	private double enemy2_explosion_start;
	private double enemy2_explosion_end;
	private long nextEnemy2;
	private long nextShot;
	private double spawnX;
	private int enemy2_count;

	public Enemy2 (States state, double x, double y, double v, long currentTime, double WIDTH) {
		super(state, x, y, 0, v);
		this.enemy2_radius = 12.0;
		this.nextEnemy2 = currentTime + 7000;
		this.spawnX = WIDTH * 0.2;
		this.enemy2_count = 0;
	}

	public double getAngle () {
		return this.angle;
	}

	public double getRV () {
		return this.rv;
	}

	public double getRadius () {
		return this.enemy2_radius;
	}

	public double getExplosionStart () {
		return this.enemy2_explosion_start;
	}

	public double getExplosionEnd () {
		return this.enemy2_explosion_end;
	}

	public long getNextEnemy () {
		return this.nextEnemy2;
	}

	public long getNextShot () {
		return this.nextShot;
	}

	public double getSpawnX () {
		return this.spawnX;
	}

	public int getCount () {
		return this.enemy2_count;
	}

	public void setAngle (double angle) {
		this.angle = angle;
	}

	public void setRV (double rv) {
		this.rv = rv;
	}

	public void setExplosionStart (double explosion_start) {
		this.enemy2_explosion_start = explosion_start;
	}

	public void setExplosionEnd (double explosion_end) {
		this.enemy2_explosion_end = explosion_end;
	}

	public void setNextEnemy (long nextEnemy) {
		this.nextEnemy2 = nextEnemy;
	}

	public void setNextShot (long nextShot) {
		this.nextShot = nextShot;
	}

	public void setSpawnX (double spawnX) {
		this.spawnX = spawnX;
	}

	public void setCount (int count) {
		this.enemy2_count = count;
	}
}