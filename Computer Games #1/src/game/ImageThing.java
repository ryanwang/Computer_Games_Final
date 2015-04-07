package game;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.MediaTracker;
import java.awt.geom.Point2D;

public class ImageThing extends Thing  
{
	double width, height;
	Image img;
	Toolkit tk;
	boolean visible,rotate;
	int angle;
	public ImageThing(String url, double x, double y, double width, double height)
	{
		tk = Toolkit.getDefaultToolkit();
		this.x = x + width/2;
		this.y = y + height/2;
		this.width = width;
		this.height = height;
		X[0] = x;
		Y[0] = y;
		X[1] = x + width;
		Y[1] = y;
		X[2] = x;
		Y[2] = y + height;
		X[3] = x + width;
		Y[3] = y + height;
		setShape(X,Y,4);
		img = tk.getImage(url);
		visible = true;
		angle = 0;
		rotate = false;
	}	

	public void setVisibility(boolean visibility)
	{
		visible = visibility; 
	}

	public void setImage(String url)
	{
		img = tk.getImage(url);
	}
	public void setRotate(boolean rotate, int angle)
	{
		this.rotate=rotate;
		this.angle = angle;
	}


	public void update(Graphics g)
	{
		//ImageObserver imgobs = new MyImageObs();
		if(visible && !rotate)
		{
			g.drawImage(img, (int)(x-width/2), (int)(y-height/2), (int)width, (int)height, platform);
		}
		else if(visible && rotate)
		{

    	
			Graphics2D g2 = (Graphics2D) g.create();
			//g2.drawImage(back, 0, 0, null);
			//AffineTransform transform = new AffineTransform();
		//	transform.setToTranslation(10,10);
			//transform.scale(0.1,0.1);
			//transform.rotate(Math.toRadians(270));
			//g2.rotate(Math.toRadians(270));
		//	g2.translate( (int)(x) , (int)(y-height/2));
			//g2.drawImage(img, transform,platform);
			g2.translate(x,y);

			g2.rotate(Math.toRadians(angle));
			//g2.translate(-200,-200);

			g2.drawImage(img, (int)-width/2 ,(int)-height/2, (int)width, (int)height, platform);
//this.setSize(unit.getWidth(this), unit.getWidth(this));
  	 //	     	Graphics2D g2d = (Graphics2D) g;
        ///scalse picture down
     ///   /		g2d.scale(0.1, 0.1);
        //translates the pictures point of orgin so that it rotates circular
   //     		g2d.translate((int) img.getWidth() , (int) img.getHeight() / 2);
 //
        // g2d.translate(185, 80);
        //		g2d.rotate(Math.toRadians(180));
       // g2d.drawImage(unit, this.getX(), this.getY(), this);
        //g2d.setColor(Color.red);
        //g2d.fillOval((int) this.getWidth() / 2, (int) this.getHeight() / 2, 25, 25);
        //Rotation set back to 0 so if no rotaion upon next repaint unit wont rotate
 
        //Rotation = 0;
			
		}

	}





/*	class MyImageObs implements ImageOberver
	{
		boolean ImageUpdate(Image img, int infoflags, int x, int y, int width, int height)
		{
			System.out.println("Do nothing for now");
		}
	}
	*/
	
}
