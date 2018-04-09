
package com.lvm.battleship.game_pieces;

import com.lvm.battleship.gfx.Display;
import com.lvm.battleship.gfx.Sprite;

public class Ship {
	
	protected boolean alive = false;
	protected int xPos;
	protected int yPos;
	
	protected ShipType type;	
	protected Sprite sprite;

	
	public enum ShipType {
		SUBMARINE, DESTROYER, CRUISER, BATTLESHIP, AIRCRAFT_CARRIER;
	}
	
	public Ship(int x, int y, ShipType type, Sprite sprite) {
		this.xPos = x;
		this.yPos =y;
		this.type = type;
		this.sprite = sprite;
	}

	public void renderShip(Display display) {
		
	}

	public void sink() {
		alive = false;
	}

	public int getXPosition() {
		return xPos;
	}
	
	public int getYPosition() {
		return yPos;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public boolean isSunk() {
		return !(alive);
	}
}
