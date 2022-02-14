package com.hoffnisgames.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;
import com.hoffnisgames.world.FloorTile;
import com.hoffnisgames.world.Tile;
import com.hoffnisgames.world.WallTile;
import com.hoffnisgames.world.World;

public class Enemy1 extends Entity {
	
	public int life = 4;
	public int drop1 = 0;
	public double veldrop = 1;


	public Enemy1(double x, double y, int width, int heigth, double speed, BufferedImage sprite) {
		super(x, y, width, heigth, speed, sprite);
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
					life-=Game.player.dano;
					if(life <= 0) {
						Game.score+=5;
						Explosion explosion = new Explosion(x,y, 16, 16, 0, null);
						Game.entities.add(explosion);
						Game.entities.remove(this);
						drop1 = Entity.rand.nextInt(100);
						
						if(drop1 > 95) {
						
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
