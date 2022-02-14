package com.hoffnisgames.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;
import com.hoffnisgames.world.Camera;
import com.hoffnisgames.world.World;

public class Player extends Entity{
	
	public boolean right, left;
	public boolean shoting = false;
	public boolean shoting2 = false;
	public int life = 10;
	public boolean pwu = false;
	public int poder = 0;
	public boolean sqrshot = false;
	public boolean drtshot = false;
	public boolean dceshot = false;
	public boolean dcdshot = false;
	public static double dano = 1;




	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	
	
	}
	public void tick() {
		
		if(right) {
			x+=speed;
		}
		
		else if(left) {
			x-=speed;
		}
		
		if(x >= Game.WIDTH) {
			x = -16;
		} else if(x+16 < 0) {
			x = Game.WIDTH;
		}
		
		if(shoting) {
			shoting = false;
			int xx = this.getX() +5;
			int yy = this.getY();
			Bullet bullet = new Bullet(xx,yy,2,2,4,null);
			Game.entities.add(bullet);
			if(sqrshot) {
				Bullet2 bullet2 = new Bullet2(xx,yy,2,2,4,null);
				Game.entities.add(bullet2);
			}
			if(drtshot) {
				Bullet3 bullet3 = new Bullet3(xx,yy,2,2,4,null);
				Game.entities.add(bullet3);
			}
			if(dceshot) {
				Bullet4 bullet4 = new Bullet4(xx,yy,2,2,4,null);
				Game.entities.add(bullet4);
			}
			if(dcdshot) {
				Bullet5 bullet5 = new Bullet5(xx,yy,2,2,4,null);
				Game.entities.add(bullet5);
			}
		}
		
		if(pwu) {
			
			poder = Entity.rand.nextInt(100);
			
			if(poder == 0 && poder < 30) {
				Game.player.speed+=0.1;
			}
			if(poder >= 30 && poder < 35 && Game.player.dcdshot == false) {
				Game.player.dcdshot = true;
			}
			if(poder >= 35 && poder < 40 && Game.player.dceshot == false) {
				Game.player.dceshot = true;
			}
			if(poder >= 40 && poder < 50 && Game.player.sqrshot == false) {
				Game.player.sqrshot = true;
			}
			if(poder >= 50 && poder < 60 && Game.player.drtshot == false) {
				Game.player.drtshot = true;
			}
			if(poder >= 60 && poder < 70) {
				Game.player.speed+=0.2;
			} 
			if(poder>= 70 && poder < 80) {
				Game.player.dano+=0.25;
				Game.player.life++;
			}
			if(poder >= 80 && poder <87) {
				Game.player.life+=3;
			}
			if(poder >= 87 && poder < 90) {
				Game.player.life+=5;
			}
			if(poder == 92) {
				Game.player.life+=10;
			}
			if(poder == 93) {
				Game.player.life+=2;
				Game.player.speed+=0.3;
			}
			if(poder == 99) {
				Game.player.life+=4;
				Game.player.speed+=0.5;
				Game.player.dano += 0.5;
			}
			
			else {
				Game.score+=500;
				
			}
			Game.score+=100;
			pwu = false;
			
		}
		
		
		
		
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	


}
