
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
	
	public int shipLength() {
		int length;		
		switch(this.type) {
		case SUBMARINE:
			length = 1;
			break;
		case DESTROYER:
			length = 2;
		case CRUISER:
			length = 3;
		case BATTLESHIP:
			length = 4;
		case AIRCRAFT_CARRIER:
			length = 5;
		default:
			length = -1;
		}
		return length;
	}
	
}
