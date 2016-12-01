package com.clickergame;

import java.awt.image.*;

import javax.swing.*;

import com.clickergame.graphics.*;

public class ClickerGame implements Runnable{
	
	private static int width = 250, height = 200, scale = 3;
	private static String title = "Clicker Game!";
	
	private boolean running = false;
	private Thread thread;
	private static JFrame frame;
	
	private static GameWindow win = new GameWindow(width, height, scale, title);
	
	public static BufferedImage image;
	public static int[] pixels;
	
	public static Screen screen;
	
	public void start(){
		running = true;
		
		image = new BufferedImage(win.getWidth()*win.getScale(), win.getHeight()*win.getScale(), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		
		thread = new Thread(this, title);
		thread.start();
		
		screen = new Screen(width*scale,height*scale, ClickerGame.pixels);
	}
	
	public void stop(){
		running = false;
		
		try{
			thread.join();
		}catch(InterruptedException e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void run() {
		while(running){			
			win.render();
			win.tick();
			
		}
		
		stop();
	}
	
	

	public static void main(String[] args) {
		ClickerGame game = new ClickerGame();
		frame = new JFrame();
		frame.add(win);
		frame.setSize(win.getWidth()*scale, win.getHeight()*scale);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle(title);
		frame.setVisible(true);
		game.start();
	}
}
