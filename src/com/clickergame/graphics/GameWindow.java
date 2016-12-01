package com.clickergame.graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import com.clickergame.*;

@SuppressWarnings("serial")
public class GameWindow extends Canvas implements MouseListener{
	private final int WIDTH, HEIGHT, SCALE;
	private final String TITLE;
	
	private int mousex, mousey;
	
	public GameWindow(int width, int height, int scale, String title){
		this.WIDTH = width;
		this.HEIGHT = height;
		this.SCALE = scale;
		this.TITLE = title;
		
	}
	
	public int getWidth(){
		return this.WIDTH;
	}
	
	public int getHeight(){
		return this.HEIGHT;
	}
	
	public int getScale(){
		return this.SCALE;
	}
	
	public String getTitle(){
		return this.TITLE;
	}
	
	/**
	 * renders shit to the screen
	 */
	public void render(){
		// = getBufferStrategy()
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		ClickerGame.screen.clear(0);
		ClickerGame.screen.draw(0);
		
		Graphics g = bs.getDrawGraphics();
		
		g.create();
		g.drawImage(ClickerGame.image, 0, 0, this.getWidth()*this.getScale(), this.getHeight()*this.getHeight(), null);
		g.setColor(new Color(0xffffff));
		int width = 10, height = 100;
		int x = 50, y = 50;
		if((mousex < x+width && mousex > x) && (mousey < y+height && mousey > y)){
			width = 20;
			height = 200;
			System.out.println("grow!!");
		}else{
			width = 10;
			height = 100;
		}
		g.fillRect(x, y, width, height);
		g.dispose();
		bs.show();
	}
	
	/**
	 * updates shit to the game
	 */
	public void tick(){}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
	}

	public void mouseExited(MouseEvent e) {
		
	}
}
