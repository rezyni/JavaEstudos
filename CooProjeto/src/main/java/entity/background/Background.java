package entity.background;
import point.*;

public class Background {

	private final Point position;
	private double speed;
	private double count;

	public Background (double x, double y, double speed) {
		this.position = new Point(x, y);
		this.speed = speed;
		this.count = 0.0;
	}

	public double getX() {
		return this.position.getX();
	}

	public double getY() {
		return this.position.getY();
	}

	public double getSpeed() {
		return this.speed;
	}

	public double getCount() {
		return this.count;
	}

	public void setX (double x) {
		this.position.setX(x);
	}

	public void setY (double y) {
		this.position.setY(y);
	}

	public void setSpeed (double spedd) {
		this.speed = spedd;
	}

	public void setCount (double count) {
		this.count = count;
	}

}