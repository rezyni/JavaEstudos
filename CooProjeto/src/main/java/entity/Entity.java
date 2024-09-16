package entity;
import point.*;
import enums.*;

public class Entity {

	private States state;
	private States powerupstate;
	private Point position;
	private double vx;
	private double vy;

	public Entity (States state, double x, double y, double vx, double vy) {
		this.state = state;
		this.position = new Point(x, y);
		this.vx = vx;
		this.vy = vy;
	}

	public States getState() {
		return this.state;
	}

	public double getX() {
		return this.position.getX();
	}

	public double getY() {
		return this.position.getY();
	}

	public double getVX() {
		return this.vx;
	}

	public double getVY() {
		return this.vy;
	}

	public States getpowerupState() {
		return this.powerupstate;
	}

	public void setState (States state) {
		this.state = state;
	}

	public void setpowerupState (States powerupstate) {
		this.powerupstate = powerupstate;
	}

	public void setX (double x) {
		this.position.setX(x);
	}

	public void setY (double y) {
		this.position.setY(y);
	}

	public void setVX (double vx) {
		this.vx = vx;
	}

	public void setVY (double vy) {
		this.vy = vy;
	}
}