package com.hoffnisgames.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Explosao extends Entity {
	
	private int frames = 0;
	private int maxFrames = 5;
	private int maxA = 3;
	private int A = 0;
	
	public BufferedImage[] explosa = new BufferedImage[5];
	
	public Explosao(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		
		explosa[0] = Game.spritesheet.getSprite(48, 64, 32, 32);
		explosa[1] = Game.spritesheet.getSprite(80, 64, 32, 32);
		explosa[2] = Game.spritesheet.getSprite(112, 64, 32, 32);
		explosa[3] = Game.spritesheet.getSprite(96, 0, 32, 32);
		explosa[4] = Game.spritesheet.getSprite(128, 0, 32, 32);
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
		g.drawImage(explosa[A], this.getX(),this.getY(),null);
	}
	
	
	

}
