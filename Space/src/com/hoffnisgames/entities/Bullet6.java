package com.hoffnisgames.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Bullet6 extends Entity{
	
	public BufferedImage po = Game.spritesheet.getSprite(32, 16, 16, 16);

	public Bullet6(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	
	}
	
	public void tick() {
		y-=speed;
		if(y<0) {
			Game.entities.remove(this);
			return;
		}
		
		
	}
	
	
	public void render(Graphics g) {
		g.drawImage(po, this.getX(),this.getY(),null);
	}

}
