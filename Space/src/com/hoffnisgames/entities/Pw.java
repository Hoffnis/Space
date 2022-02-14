package com.hoffnisgames.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Pw extends Entity {
	
	public BufferedImage[] power = new BufferedImage[3];
	public int frame = 0;
	public int maxFrame = 10;
	public int m = 0;
	public int max = 3;
	


	public Pw(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		
		power[0] = Game.spritesheet.getSprite(8, 0, 8, 8);
		power[1] = Game.spritesheet.getSprite(0, 8, 8, 8);
		power[2] = Game.spritesheet.getSprite(8, 8, 8, 8);

}
	
	
	public void tick() {
		
		frame++;
		if(frame == maxFrame) {
			frame = 0;
			m++;
			if(m == max) {
			m =0;
				
			}
		}
		
		x-=speed;
		if(x >= Game.WIDTH) {
			x = -16;
		} else if(x+16 < 0) {
			x = Game.WIDTH;
		}
		
		for(int i =0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Bullet || e instanceof Bullet2 || e instanceof Bullet3
					|| e instanceof Bullet4 || e instanceof Bullet5) {
				if(Entity.isCollinding(this, e)) {
					Game.entities.remove(e);
					Game.entities.remove(this);
					Game.player.pwu = true;
			
					
				}
			}
		}
		
		
		
	}
	
	public void render(Graphics g) {
		g.drawImage(power[m], this.getX(), this.getY(),null);
	}
	


}

