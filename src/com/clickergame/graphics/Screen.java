package com.clickergame.graphics;

public class Screen {
	private int w, h, pix[];
	
	public Screen(int w, int h, int[] pix){
		this.w = w;
		this.h = h;
		this.pix = pix;
	}
	
	public void clear(int c){
		for(int i = 0; i < pix.length;i++){
			pix[i] = c;
		}
	}
	
	public void draw(int c){
		for(int y = 0; y < h;y++){
			for(int x = 0; x < w;x++){
				pix[x+y*w] = c;
			}
		}
	}
}
