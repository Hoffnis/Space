package com.hoffnisgames.entities;

import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Enemy6 extends Entity {
	
	public int life6 = 1;
	
	public Enemy6(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}

	
	
	public void tick() {
		y+=speed;
	
		if(y >= Game.HEIGHT) {
			Game.entities.remove(this);
			Game.player.life--;
			return;
		}
		
		for(int i =0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Bullet || e instanceof Bullet2 || e instanceof Bullet3
					|| e instanceof Bullet4 || e instanceof Bullet5) {
				if(Entity.isCollinding(this, e)) {
					Game.entities.remove(e);
					life6-=Game.player.dano;
					if(life6 <= 0) {
						Game.score+=25;
						ExplosionP explosionp = new ExplosionP(x,y, 4, 4, 0, null);
						Game.entities.add(explosionp);
						Game.entities.remove(this);
				
						
						return;
					}
					break;
				}
			}
		}
	}

}
