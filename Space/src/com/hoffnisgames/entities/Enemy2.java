package com.hoffnisgames.entities;

import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;

public class Enemy2 extends Entity {
	
	public int life2 = 1;
	public int drop2 = 0;

	public Enemy2(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}
	public void tick() {
		y+=speed;
	
		if(y >= Game.HEIGHT) {
			Game.entities.remove(this);
			Game.player.life-=2;
			return;
		}
		
		for(int i =0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Bullet || e instanceof Bullet2 || e instanceof Bullet3
					|| e instanceof Bullet4 || e instanceof Bullet5) {
				if(Entity.isCollinding(this, e)) {
					Game.entities.remove(e);
					life2-=Game.player.dano;
					if(life2 <= 0) {
						Game.score+=150;
						Explosion explosion = new Explosion(x,y, 16, 16, 0, null);
						Game.entities.add(explosion);
						Game.entities.remove(this);

						drop2 = Entity.rand.nextInt(100);
						
						if(drop2 > 30) {
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


