
import java.awt.*;
import game.*;

public class test1 extends Platform
{
   Thing topWall = new Thing();

   public void setup() {
	   int w, h;
	   w = getWidth();
	      h = getHeight();
	      double X0[] = {w/5, 4*w/5, 4*w/5, w/2, w/5};
	      double Y0[] = {0, 0, h/3, h/6, h/3};

	   double X1[] = { 200, 250, 300 };
	   double Y1[] = { 300, 200, 300 };
	   
	   double X2[] = {50, 75, 100 };
	   double Y2[] = {100, 75, 100 };
	   
      addThing(topWall);
      addThing("game.Thing");
      addThing("game.Thing");
      topWall.setShape(X0, Y0, X0.length);
      thing(1).setShape(X1, Y1, X1.length);
      thing(2).setShape(X2, Y2, X2.length);
   }

   public void update() {
      boolean isColliding = colliding(topWall, thing(1));

      topWall.setColor(isColliding ? Color.red : Color.black);
      thing(1).setColor(isColliding ? Color.red : Color.black);
      thing(2).setColor(isColliding ? Color.red : Color.black);

      if (isColliding && ! wasColliding)
         playClip("clips/click.wav");

      wasColliding = isColliding;;
   }

   boolean wasColliding = false;
}

