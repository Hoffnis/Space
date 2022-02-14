package com.hoffnisgames.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Explosion extends Entity {
	
	private int frames = 0;
	private int maxFrames = 5;
	private int maxA = 3;
	private int A = 0;
	
	public BufferedImage[] explos = new BufferedImage[4];

	public Explosion(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		explos[0] = Game.spritesheet.getSprite(32, 48, 16, 16);
		explos[1] = Game.spritesheet.getSprite(16, 32, 16, 16);
		explos[2] = Game.spritesheet.getSprite(0, 32, 16, 16);
		explos[3] = Game.spritesheet.getSprite(0, 64, 16, 16);
	}
	
	public void tick() {
		frames++;
		if(frames == maxFrames) {
			frames = 0;
			A++;
			if(A > maxA) {
				Game.entities.remove(this);
				return;
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(explos[A], this.getX(),this.getY(),null);
	}

}
