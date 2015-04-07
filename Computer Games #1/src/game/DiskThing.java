package game;

// A THING SHAPED LIKE A DISK

public class DiskThing extends Thing
{
   public DiskThing(double x, double y, double width, double height) {
      this.x = x + width / 2;
      this.y = y + height / 2;
      for (int i = 0 ; i < 20 ; i++) {
         double theta = 2 * Math.PI * i / 20, cos = Math.cos(theta), sin = Math.sin(theta);
         X[i] = this.x + width /2 * Math.cos(theta);
         Y[i] = this.y + height/2 * Math.sin(theta);
      }
      setShape(X, Y, 20);
   }
   
   public void setR(double rad){
	   this.x = x+ rad/2; 
	   this.y = y+rad/2;
   for (int i = 0 ; i < 20 ; i++) {
       double theta = 2 * Math.PI * i / 20, cos = Math.cos(theta), sin = Math.sin(theta);
       X[i] = this.x + rad /2 * Math.cos(theta);
       Y[i] = this.y + rad/2 * Math.sin(theta);
    }
    setShape(X, Y, 20);
   }
}

