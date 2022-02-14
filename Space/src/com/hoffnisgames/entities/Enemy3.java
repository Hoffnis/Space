package com.hoffnisgames.entities;

import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Enemy3 extends Entity {
	
	public int life3 = 5;
	public int drop3 = 0;

	public Enemy3(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		
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
					life3-=Game.player.dano;
					if(life3 <= 0) {
						Game.score+=10;
						ExplosionP explosionp = new ExplosionP(x,y, 8, 8, 0, null);
						Game.entities.add(explosionp);
						Game.entities.remove(this);
				

						drop3 = Entity.rand.nextInt(100);
						
						if(drop3 > 90) {
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
