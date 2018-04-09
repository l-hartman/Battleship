package com.lvm.battleship.gfx;

public class Sprite {

	public final int X_SIZE;
	public final int Y_SIZE;
	
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet; 
	
	public static Sprite water0 = new Sprite(16, 16, 0, 0, SpriteSheet.tiles);
	public static Sprite water1 = new Sprite(16, 16, 1, 0, SpriteSheet.tiles);
	
	public Sprite(int xSize, int ySize, int x, int y, SpriteSheet sheet) {
		X_SIZE = xSize;
		Y_SIZE = ySize;
		pixels = new int[X_SIZE * Y_SIZE];
		this.x = x * X_SIZE;  
		this.y = y * Y_SIZE;
		this.sheet = sheet;
		loadSprite();
	}

	private void loadSprite() {
		// TODO Auto-generated method stub
		for(int y = 0; y < Y_SIZE; y++) {
			for(int x = 0; x < X_SIZE; x++) {
				pixels[x + y * Y_SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
}
