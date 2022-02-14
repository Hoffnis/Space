package com.hoffnisgames.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Bullet2 extends Entity {

	public Bullet2(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		y-=speed;
		x-=2;
		if(y<0) {
			Game.entities.remove(this);
			return;
		}
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(this.getX(), this.getY(), width, height);
	}

}


