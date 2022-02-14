package com.hoffnisgames.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class ExplosionP extends Entity {
	private int frames = 0;
	private int maxFrames = 5;
	private int maxA = 3;
	private int A = 0;
	
	public BufferedImage[] explosp = new BufferedImage[4];


	public ExplosionP(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		explosp[0] = Game.spritesheet.getSprite(0, 96, 8, 8);
		explosp[1] = Game.spritesheet.getSprite(8, 96, 8, 8);
		explosp[2] = Game.spritesheet.getSprite(0, 104, 8, 8);
		explosp[3] = Game.spritesheet.getSprite(8, 104, 8, 8);
	
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
		g.drawImage(explosp[A], this.getX(),this.getY(),null);
	}

}
