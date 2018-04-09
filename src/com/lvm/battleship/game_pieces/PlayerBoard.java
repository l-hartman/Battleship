package com.lvm.battleship.game_pieces;

import com.lvm.battleship.game_pieces.Ship.ShipType;
import com.lvm.battleship.gfx.Sprite;

public class PlayerBoard {
	protected int width = 10;
	protected int height = 10;
	private int arrSize = width * height;
	
	protected Sprite sprite;

	protected boolean shipArray[] = new boolean [arrSize];
	
	public PlayerBoard(Sprite sprite) {
		this.sprite = sprite;
		for(int i = 0; i < shipArray.length; i++) {
			shipArray[i] = false;
		}
	}
	
	public void updateBoardData(int startXPos, int startYPos, boolean horizontal, ShipType type) {
		if (type == ShipType.SUBMARINE) {
			
		}
		else if (type == ShipType.DESTROYER) {
			
		}
		else if(type == ShipType.CRUISER) {
			
		}
		else if(type == ShipType.BATTLESHIP) {
			
		}
		else if(type == ShipType.AIRCRAFT_CARRIER) {
			
		}
		else {

		}
	}
	
	public void resetBoardData() {
		for(int i = 0; i < shipArray.length; i++) {
			shipArray[i] = false;
		}
	}
	
	public boolean checkForCollision(int startXPos, int startYPos, boolean horizontal, ShipType type) {
		return true;
	}
}
