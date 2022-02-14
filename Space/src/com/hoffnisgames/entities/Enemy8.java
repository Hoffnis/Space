package com.hoffnisgames.entities;

import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Enemy8 extends Entity{
	
	public int life8 = 100;
	public int drop;

	public Enemy8(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	
	}
	public void tick() {
		y+=speed;
	
		if(y >= Game.HEIGHT) {
			Game.entities.remove(this);
			Game.player.life-=5;
			return;
		}
		
		for(int i =0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Bullet || e instanceof Bullet2 || e instanceof Bullet3
					|| e instanceof Bullet4 || e instanceof Bullet5) {
				if(Entity.isCollinding(this, e)) {
					Game.entities.remove(e);
					life8-=Game.player.dano;
					if(life8 <= 0) {
						Game.score+=700;
						ExplosionG explosiong = new ExplosionG(x,y, 32, 32, 0, null);
						Game.entities.add(explosiong);
						Game.entities.remove(this);
						

						drop = Entity.rand.nextInt(100);
						
						if(drop > 22) {
							Pw pw = new Pw(x,y,8,8,1, null);
							Game.entities.add(pw);
						}
				
						
						return;
					}
					break;
				}
			}
		}
	}

}
