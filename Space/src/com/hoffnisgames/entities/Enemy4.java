package com.hoffnisgames.entities;

import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Enemy4 extends Entity {
	
	public int life4 = 15;
	public int drop4 = 0;

	public Enemy4(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		y+=speed;
	
		if(y >= Game.HEIGHT) {
			Game.entities.remove(this);
			Game.player.life-=3;
			return;
		}
		
		for(int i =0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Bullet || e instanceof Bullet2 || e instanceof Bullet3
					|| e instanceof Bullet4 || e instanceof Bullet5) {
				if(Entity.isCollinding(this, e)) {
					Game.entities.remove(e);
					life4-=Game.player.dano;
					if(life4 <= 0) {
						Game.score+=30;
						ExplosionP explosionp = new ExplosionP(x,y, 8, 8, 0, null);
						Game.entities.add(explosionp);
						Game.entities.remove(this);
						

						drop4 = Entity.rand.nextInt(100);
						
						if(drop4 > 80) {
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
