package game;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyThing extends Thing{

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//super.update(g);
	      updateShape();
	      g.setColor(color);
	      //g.fillPolygon(polygon);
	      g.setColor(Color.black);
	      g.drawPolygon(polygon);
	}
	
}
