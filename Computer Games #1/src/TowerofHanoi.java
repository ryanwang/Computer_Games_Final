
import java.awt.*;
import java.lang.reflect.Array;


import game.*;

public class TowerofHanoi extends Platform
{
	
	
	double w,h,r,dx1,dx2,dx3,dx4,dx5,dy1,dy2,dy3,dy4,dy5;
	Thing leftWall, rightWall, topWall, bottomWall, puck, b1,b2,b3,b4,b5;
	long score,base,countdown,pause;
	boolean gameover;
	public void setup() {
		base = System.currentTimeMillis();
		score = System.currentTimeMillis();
		gameover=false;
		//score=Timestamp.g
		w=getWidth();
		h=getHeight();
		r=h/15.0;
		addThing(leftWall   = new RectThing(0, 0, r, h));
	    addThing(rightWall  = new RectThing(w-r, 0, r, h));
	    addThing(topWall    = new RectThing(0, 0, w, r));
	    addThing(bottomWall = new RectThing(0, h-r, w, r));
		addThing(puck 		= new DiskThing(w/2-r/2, h/2-r/2, r, r));
		addThing(b1 		= new DiskThing(w*Math.random(), h*Math.random(), r, r));
		addThing(b2 		= new DiskThing(w*Math.random(), h*Math.random(), r, r));
		addThing(b3 		= new DiskThing(w*Math.random(), h*Math.random(), r, r));
		addThing(b4 		= new DiskThing(w*Math.random(), h*Math.random(), r, r));
		addThing(b5 		= new DiskThing(w*Math.random(), h*Math.random(), r, r));
		dx1=10*(Math.random()-0.5);
		dx2=10*(Math.random()-0.5);
		dx3=10*(Math.random()-0.5);
		dx4=10*(Math.random()-0.5);
		dx5=10*(Math.random()-0.5);
		dy1=10*(Math.random()-0.5);
		dy2=10*(Math.random()-0.5);
		dy3=10*(Math.random()-0.5);
		dy4=10*(Math.random()-0.5);
		dy5=10*(Math.random()-0.5);
		puck.setColor(Color.red);
		
	}
	private double[] move(Thing t,double dx,double dy){
		t.setX(t.getX()+dx);
		t.setY(t.getY()+dy);
		if (colliding(t, leftWall  )) { if (dx < 0) if(!gameover)click(); dx =  Math.abs(dx); }
		if (colliding(t, rightWall )) { if (dx > 0) if(!gameover)click(); dx = -Math.abs(dx); }
		if (colliding(t, topWall   )) { if (dy < 0) if(!gameover)click(); dy =  Math.abs(dy); }
		if (colliding(t, bottomWall)) { if (dy > 0) if(!gameover)click(); dy = -Math.abs(dy); }
		double r[]={dx,dy};
		return r;
	}


   public void update() {
	   
	   double temp[];
	   temp=move(b1,dx1,dy1);
	   dx1=temp[0];
	   dy1=temp[1];
	   temp=move(b2,dx2,dy2);
	   dx2=temp[0];
	   dy2=temp[1];
	   temp=move(b3,dx3,dy3);
	   dx3=temp[0];
	   dy3=temp[1];
	   temp=move(b4,dx4,dy4);
	   dx4=temp[0];
	   dy4=temp[1];
	   temp=move(b5,dx5,dy5);
	   dx5=temp[0];
	   dy5=temp[1];
	   if(!gameover){
		   score = System.currentTimeMillis();
		   if ((colliding(puck,leftWall)||colliding(puck,rightWall)||
				   colliding(puck,topWall)||colliding(puck,bottomWall)||
				   colliding(puck,b1)||colliding(puck,b2)||colliding(puck,b3)||
				   colliding(puck,b4)||colliding(puck,b5))){
			   
			   gameover = true;
			   pause = System.currentTimeMillis();
			   gameover();
		   }
	   }else{
		   countdown = 3+(pause-System.currentTimeMillis())/1000;
		   if (countdown<=0.0){
			   gameover = false;
			   base = System.currentTimeMillis();
		   }
	   }
	   
   }

   
   public void overlay(Graphics g) {
	   	g.setColor(Color.black);
	     // g.setFont(font);
	   	g.drawString("Drag the red ball and avoid collision.", (int)(r+20),40);
	      g.drawString("" + (score-base)/100, (int) (r + 20), 50);
	      if(gameover)
	    	  g.drawString("Game Over, restart in "+countdown+" seconds", (int)r+20,60);
	   }
   void click() { playClip("https://files.nyu.edu/hc905/public/gamesclass/hw1/clips/click.wav"); }
   void gameover(){playClip("https://files.nyu.edu/hc905/public/gamesclass/hw1/clips/applause5.wav");}
   boolean wasColliding = false;
}
