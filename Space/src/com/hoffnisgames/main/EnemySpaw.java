package com.hoffnisgames.main;

import com.hoffnisgames.entities.Enemy1;
import com.hoffnisgames.entities.Enemy2;
import com.hoffnisgames.entities.Enemy3;
import com.hoffnisgames.entities.Enemy4;
import com.hoffnisgames.entities.Enemy5;
import com.hoffnisgames.entities.Enemy6;
import com.hoffnisgames.entities.Enemy7;
import com.hoffnisgames.entities.Enemy8;
import com.hoffnisgames.entities.Entity;
import com.hoffnisgames.graficos.UI;

public class EnemySpaw {
	
	public int targ = 60*1;
	public int curtime = 0;
	public int enem;

	
	
	
	public void tick() {
		curtime++;
		
		if(curtime >= targ) {
			if(UI.minutes ==0) {
			targ = Entity.rand.nextInt(300 -150) +200;
			}
			if(UI.minutes == 1) {
				targ = Entity.rand.nextInt(250 -125) +150;
			}
			if(UI.minutes == 2) {
				targ = Entity.rand.nextInt(200 -100) +110;
			}
			if(UI.minutes == 3) {
				targ = Entity.rand.nextInt(180 -100) +100;
			}
			if(UI.minutes == 4) {
				targ = Entity.rand.nextInt(150 -100) +100;
			}
			if(UI.minutes == 5) {
				targ = Entity.rand.nextInt(150 -100) + 70;
			}
			if(UI.minutes == 6) {
				targ = Entity.rand.nextInt(135 - 100) + 65;
			}
			if(UI.minutes == 7) {
				targ = Entity.rand.nextInt(100);
			}
			if(UI.minutes == 8) {
		
				targ = Entity.rand.nextInt(75);
			}
			if(UI.minutes == 9) {
		
				targ = Entity.rand.nextInt(50);
			}
			if(UI.minutes == 10) {
	
				targ = Entity.rand.nextInt(35);
			}
			if(UI.minutes == 11) {
	
				targ = Entity.rand.nextInt(25);
			}
			if(UI.minutes == 12) {
		
				targ = Entity.rand.nextInt(20);
			}
			if(UI.minutes == 13) {
				
				targ = Entity.rand.nextInt(15);
			}
			if(UI.minutes == 14) {
				
				targ = Entity.rand.nextInt(10);
			}
			if(UI.minutes >= 15) {
				
				targ = Entity.rand.nextInt(5);
			}
		
			curtime = 0;
			int yy = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH-16);
			
			if(UI.minutes ==0) {
			enem = Entity.rand.nextInt(200);
			}
			if(UI.minutes == 1) {
				enem = Entity.rand.nextInt(250);
			}
			if(UI.minutes == 2) {
				enem = Entity.rand.nextInt(300);
			}
			if(UI.minutes >= 3 && UI.minutes < 6) {
				enem = Entity.rand.nextInt(310);
			}
			if(UI.minutes >= 6 && UI.minutes < 8) {
				enem = Entity.rand.nextInt(325);
			}
			if(UI.minutes >= 8 && UI.minutes < 10) {
				enem = Entity.rand.nextInt(350);
			}if(UI.minutes >= 10 && UI.minutes < 12) {
				enem = Entity.rand.nextInt(370);
			}if(UI.minutes >= 12) {
				enem = Entity.rand.nextInt(400);
			}
			
			
			if(enem <= 180) {
			Enemy1 enemy1 = new Enemy1(xx,yy,16,16,1,Game.spritesheet.getSprite(16, 16, 16, 16));
			Game.entities.add(enemy1);
			}else if(enem > 180 && enem < 210) {
				Enemy2 enemy2 = new Enemy2(xx,yy,16,16,3,Game.spritesheet.getSprite(16, 0, 16, 16));
				Game.entities.add(enemy2);
			} else if(enem >= 210 && enem < 235) {
			Enemy3 enemy3 = new Enemy3(xx,yy,8,8,1.2,Game.spritesheet.getSprite(0, 80, 8, 8));
			Game.entities.add(enemy3);
		}
			else if(enem >= 235 && enem < 265) {
				Enemy4 enemy4 = new Enemy4(xx,yy,8,8,0.7,Game.spritesheet.getSprite(0, 88, 8, 8));
				Game.entities.add(enemy4);
			}
			else if(enem >= 265 && enem < 275) {
				Enemy5 enemy5 = new Enemy5(xx,yy,8,8,1.8,Game.spritesheet.getSprite(8, 88, 8, 8));
				Game.entities.add(enemy5);
			}
			else if(enem >= 275 && enem < 293) {
				Enemy6 enemy6 = new Enemy6(xx,yy,4,4,1.5,Game.spritesheet.getSprite(8, 80, 4, 4));
				Game.entities.add(enemy6);
			}
			else if(enem >= 294 && enem < 299) {
				Enemy7 enemy7 = new Enemy7(xx,yy,8,8,0.9,Game.spritesheet.getSprite(12, 80, 4, 8));
				Game.entities.add(enemy7);
			}
			else if(enem >= 299) {
				Enemy8 enemy8 = new Enemy8(xx,yy,32,32,0.1,Game.spritesheet.getSprite(16, 64, 32, 32));
				Game.entities.add(enemy8);
			}
			
		}
	}
	
}
