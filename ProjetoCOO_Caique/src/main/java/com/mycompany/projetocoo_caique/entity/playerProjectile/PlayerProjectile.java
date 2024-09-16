
package com.mycompany.projetocoo_caique.entity.playerProjectile;
import com.mycompany.projetocoo_caique.enums.States;
import com.mycompany.projetocoo_caique.entity.Entity;
/*
 * @author Caique
 */
public class PlayerProjectile extends Entity {

	private States state;
	private double x;
	private double y;
	private double vx;
	private double vy;

	public PlayerProjectile (States state, double x, double y, double vx, double vy) {
		super(state, x, y, vx, vy);
	}
}
