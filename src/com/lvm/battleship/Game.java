package com.lvm.battleship;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.lvm.battleship.gfx.Display;
import com.lvm.battleship.input.Keyboard;
 
public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static int width = 500;
	public static int height = width / 16 * 10;
	public static int scale = 3;
	
	private Display display;
	
	private Thread thread;
	private Keyboard key;
	
	private boolean running = false;
	
	// an image with an accessible buffer of image data
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	// A raster represents a rectangular array of pixels
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		display = new Display(width,height);
		key = new Keyboard();
		
		addKeyListener(key);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		// ns = 1 second / 60 frames
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		long lastTime = System.nanoTime();

	    requestFocus();
	    
		// TODO Auto-generated method stub
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			// delta equals one 60 times per second,
			// update is called at this rate
			while(delta >= 1) {
				update();	
				delta--;
			}
			render();
		}
	    stop();
	}
	
	int x = 0, y = 0;
	
	private void update() {
		// TODO Auto-generated method stub
		key.update();
		if (key.up) y++;
		if (key.down) y--;
		if (key.left) x++;
		if (key.right) x--;
	}
	
	/**
	 *  render is in charge of rendering all the needed graphics to the
	 *  display. It uses a triple buffer to render raster array
	 */
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		
		// if bs has not been created,
		// create a triple buffer BufferStrategy
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		display.clear();
		display.renderWater(x, y);
		
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = display.pixels[i];
		}
		
		// create a link between the graphics and buffer
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		// after every frame is rendered, remove old graphics
		g.dispose();
		
		// make next available buffer visible
		bs.show();
		
	}
}
