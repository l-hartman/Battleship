package com.lvm.battleship.game_pieces;

import com.lvm.battleship.game_pieces.Ship.ShipType;
import com.lvm.battleship.gfx.Sprite;
import com.lvm.battleship.gfx.SpriteSheet;

public class Fleet {
	Ship[] fleet = new Ship[5];
	
	public Fleet() {
		fleet[0] = new Ship(0, 0, ShipType.SUBMARINE, new Sprite(32, 32, 2, 0, SpriteSheet.tiles));
		fleet[1] = new Ship(0, 0, ShipType.DESTROYER, new Sprite(32, 64, 2, 0, SpriteSheet.tiles));
		fleet[2] = new Ship(0, 0, ShipType.CRUISER, new Sprite(32, 96, 2, 0, SpriteSheet.tiles));
		fleet[3] = new Ship(0, 0, ShipType.BATTLESHIP, new Sprite(32, 128, 2, 0, SpriteSheet.tiles));
		fleet[4] = new Ship(0, 0, ShipType.AIRCRAFT_CARRIER, new Sprite(32, 150, 2, 0, SpriteSheet.tiles));
	}
	
}
