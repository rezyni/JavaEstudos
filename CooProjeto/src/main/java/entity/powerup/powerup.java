package entity.powerup;
import entity.*;
import enums.*;

public class powerup extends Entity {

	private States state;
	private double x;
	private double y;
	private double v;
	private double angle;
	private double rv;
	private double powerup_radius;
	private long nextpowerup;

	public powerup (States state, double x, double y, double v, long currentTime) {
		super(state, x, y, 0, v);
		this.powerup_radius = 15.0;
		this.nextpowerup = currentTime + 10000;
	}

	public double getAngle () {
		return this.angle;
	}

	public double getRV () {
		return this.rv;
	}

	public double getRadius () {
		return this.powerup_radius;
	}

	public long getNextEnemy () {
		return this.nextpowerup;
	}	

	public void setAngle (double angle) {
		this.angle = angle;
	}

	public void setRV (double rv) {
		this.rv = rv;
	}

	public void setNextEnemy (long nextEnemy) {
		this.nextpowerup = nextEnemy;
	}
}