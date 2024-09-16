package entity.player;
import entity.*;
import enums.*;

public class Player extends Entity {

	private States state;
	private double x;
	private double y;
	private double vx;
	private double vy;
	private double player_radius;
	private double player_explosion_start;
	private double player_explosion_end;
	private long player_nextShot;
	private double player_powerup_start;
	private double player_powerup_end;

	public Player (States state, double x, double y, double vx, double vy, long currentTime) {
		super(state, x, y, vx, vy);
		this.player_radius = 12.0;
		this.player_explosion_start = 0;
		this.player_explosion_end = 0;
		this.player_nextShot = currentTime;
	}

	public double getRadius () {
		return this.player_radius;
	}

	public double getExplosionStart () {
		return this.player_explosion_start;
	}

	public double getExplosionEnd () {
		return this.player_explosion_end;
	}

	public double getpowerupStart () {
		return this.player_powerup_start;
	}

	public double getpowerupEnd () {
		return this.player_powerup_end;
	}

	public long getNextShot () {
		return this.player_nextShot;
	}

	public void setRadius (double radius) {
		this.player_radius = radius;
	}

	public void setExplosionStart (double player_explosion_start) {
		this.player_explosion_start = player_explosion_start;
	}

	public void setExplosionEnd (double player_explosion_end) {
		this.player_explosion_end = player_explosion_end;
	}

	public void setpowerupStart (double player_powerup_start) {
		this.player_powerup_start = player_powerup_start;
	}

	public void setpowerupEnd (double player_powerup_end) {
		this.player_powerup_end = player_powerup_end;
	}

	public void setNextShot (long player_nextShot) {
		this.player_nextShot = player_nextShot;
	}

	public void playerCollisions (double eX, double eY, double eRadius, Player player, long currentTime) {
			
		double dx = eX - player.getX();
		double dy = eY - player.getY();
		double dist = Math.sqrt(dx * dx + dy * dy);
		
		if(dist < (player.getRadius() + eRadius) * 0.8){
			
			player.setState(States.EXPLODING);
			player.setExplosionStart(currentTime);
			player.setExplosionEnd(currentTime + 2000);
		}
	}

	public void playerCollisionspowerup (double eX, double eY, double eRadius, Player player, long currentTime) {
			
		double dx = eX - player.getX();
		double dy = eY - player.getY();
		double dist = Math.sqrt(dx * dx + dy * dy);
		
		if(dist < (player.getRadius() + eRadius) * 0.8){
			
			player.setpowerupState(States.ACTIVE);
			player.setpowerupStart(currentTime);
			player.setpowerupEnd(currentTime + 6000);
		}
	}
}