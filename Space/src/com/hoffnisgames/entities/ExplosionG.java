package com.hoffnisgames.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class ExplosionG extends Entity {
	
	private int frames = 0;
	private int maxFrames = 5;
	private int maxA = 3;
	private int A = 0;
	
	public BufferedImage[] explosg = new BufferedImage[5];

	public ExplosionG(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		
		explosg[0] = Game.spritesheet.getSprite(0, 112, 32, 32);
		explosg[1] = Game.spritesheet.getSprite(32, 112, 32, 32);
		explosg[2] = Game.spritesheet.getSprite(64, 112, 32, 32);
		explosg[3] = Game.spritesheet.getSprite(96, 112, 32, 32);
		explosg[4] = Game.spritesheet.getSprite(128, 112, 32, 32);
		
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
		g.drawImage(explosg[A], this.getX(),this.getY(),null);
	}

}
