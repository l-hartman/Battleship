package com.lvm.battleship.gfx;

import java.util.Random;

public class Display {
	
	private int width;
	private int height;
	
	private int displayRenderCount;
	
	public int[] pixels;
	public final int GAME_BOARD_SIZE = 64; 
	public final int BOARD_SIZE_MASK = GAME_BOARD_SIZE - 1;
	
	public int[] tiles = new int[GAME_BOARD_SIZE * GAME_BOARD_SIZE];
		
	private Random random = new Random();
	
	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		
		pixels = new int[width * height];
		
		this.displayRenderCount = 0;
		
		for(int i = 0; i < GAME_BOARD_SIZE * GAME_BOARD_SIZE; i++) {
			tiles[i] = random.nextInt(0xFFFFFF);
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderWater(int xOffset, int yOffset) {
		displayRenderCount++;
		for(int y = 0; y < height; y++) {
			int currentYPixel = y + yOffset;
			if(currentYPixel < 0 || currentYPixel > height)
				continue; 
			for(int x = 0; x < width; x++) {
				int currentXPixel = x + xOffset;
				if(currentXPixel < 0 || currentXPixel > width)
					continue;
				animateWater(currentXPixel, currentYPixel, x, y);

			}
		}
	}
	
	private void animateWater(int xp, int yp, int x, int y) {
		if(displayRenderCount % 400 < 200) {
			pixels[xp + yp * width] = Sprite.water0.pixels[(x & 15) + (y & 15) * Sprite.water0.Y_SIZE];
		}
		else {
			pixels[xp + yp * width] = Sprite.water1.pixels[(x & 15) + (y & 15) * Sprite.water1.Y_SIZE];
		}
		
	}
	
}