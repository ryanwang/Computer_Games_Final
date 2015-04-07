import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game.DiskThing;
import game.Platform;
import game.RectThing;
import game.Thing;


public class maze extends Platform {

	   int w, h, b = 5;
	   int score = 1000;
	   int radium = 50;
	   //Thing topWall = new Thing();
	   Thing topWall, bottomWall, leftWall;
	   Thing wall1, wall2, wall3, wall4, wall5, wall6, wall7;
	   Thing puck;
	   Thing pool = new Thing();
	   Font font = new Font("Arial", Font.BOLD, 15);
	   Font font1 = new Font("Arial", Font.BOLD, 30);
	   Button bu = new Button("Replay");
	   
	   

	   public void setup() {
		   
		  
	      w = getWidth();
	      h = getHeight();
	      
	      
	      addThing(leftWall   = new RectThing(0, 0, b, h));
	      addThing(topWall    = new RectThing(0, 0, w, b));
	      addThing(bottomWall = new RectThing(0, h-b, w, b));
	      
	      double X2[] = {9*w/10, w, w, 9*w/10};
	      double Y2[] = {0, 0, h, h};
	      pool.setShape(X2, Y2, X2.length);
	      addThing(pool);
	      
	      puck = new DiskThing(w/20, h/2, w/20, h/20);
	      addThing(puck);
	      
	      //addThing(bottomWall);
	      addThing(wall1    = new RectThing(b + 20, h/2 - 100, 20, 80));
	      addThing(wall2    = new RectThing(b + 20, h/2 + 30, 20, 80));
	      addThing(wall3    = new RectThing(b + 70, h/2 -50, 25, 150));
	      
	      wall4 = new Thing();
	      double X0[] = {b+120, b+174, b+174, b+147, b+120};
	      double Y0[] = {0, 0, h/3, h/2, h/3};
	      wall4.setShape(X0, Y0, X0.length);
	      addThing(wall4);
	      
	      wall5 = new Thing();
	      double X1[] = {b+120, b+147, b+147, b+120};
	      double Y1[] = {h+200, h+200, h/2+50, h/3+50};
	      wall5.setShape(X1, Y1, X1.length);
	      addThing(wall5);
	      
	      wall6 = new Thing();
	      double X3[] = {b+147, b+174, b+174, b+147};
	      double Y3[] = {h+200, h+200, h/3+50, h/2+50};
	      wall6.setShape(X3, Y3, X3.length);
	      addThing(wall6);
	      
//addThing(paddle2    = new RectThing(w - b - 30, h/2 - 30, 10, 60));
	      //addThing(puck = new DiskThing(w / 2 - 20, h / 2 - 20, 20, 20));
	   }

	   double dx = 4.5, dy = 5;
	   int counter = 0;
	   
	   boolean dir1 = true;
	   boolean dir2 = true;
	   boolean dir3 = true;
	   
	   public void update(){
		   //topWall.setColor(Color.black);
		   bottomWall.setColor(Color.black);
		   pool.setColor(Color.blue);
		   puck.setColor(Color.black);
		   //disk.setColor(Color.black);
		   counter++;
		   if(counter%11 == 0){dir1 = !dir1;}
		   if(counter%13 == 0){dir2 = !dir2;}
		   if(counter%30 == 0){dir3 = !dir3;}
		   
		   if(dir1){wall1.setY(wall1.getY() + dy);}else{wall1.setY(wall1.getY() - dy);}
		   if(dir1){wall2.setY(wall2.getY() - dy);}else{wall2.setY(wall2.getY() + dy);}
		   if(dir2){wall3.setY(wall3.getY() - dy);}else{wall3.setY(wall3.getY() + dy);}
		   if(dir3){wall4.setY(wall4.getY() - dy);}else{wall4.setY(wall4.getY() + dy);}
		   if(dir3){wall5.setY(wall5.getY() - dy);}else{wall5.setY(wall5.getY() + dy);}
		   if(dir3){wall6.setY(wall6.getY() - dy);}else{wall6.setY(wall6.getY() + dy);}

		   if (colliding(puck, bottomWall)
			||(colliding(puck, wall1))
			||(colliding(puck, wall2))
			||(colliding(puck, wall3))
			||(colliding(puck, wall4))
			||(colliding(puck, wall5))
			||(colliding(puck, wall6))			
			||(colliding(puck, leftWall))
			||(colliding(puck, topWall))
		   ) { puck.setColor(Color.red); score = 0;}
		   if(!colliding(puck, pool)){if(score > 0){score--;}}
		   
	   }

	   public void overlay(Graphics g) {
	      g.setColor(Color.red);
	      g.setFont(font);
	      g.drawString("" + (score/10), 9*w/10, h/10);
	      
	      if(colliding(puck, pool) && (score > 0)){
	    	  g.setColor(Color.green); g.setFont(font1); g.drawString("You Win!", w/8, h/2);}
	      
	      if((score == 0)||(score <0)){g.setColor(Color.green); g.setFont(font1); g.drawString("You Lose!", w/8, h/2);}
	   }

	   void click() { playClip("clips/click.wav"); }
	   
}
