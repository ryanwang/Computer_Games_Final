package game;
import java.math.*;

public class TriangleEmptyThing extends EmptyThing{
	
	double [] x, y;
	
	public TriangleEmptyThing(double [] Xs, double [] Ys){
		x = Xs; y = Ys;
		this.setShape(x, y, 3);
	}
	
	public double getAngle1(){
		double ab = getAB();
		double bc = getBC();
		double ac = getAC();
		return Math.acos(( (x[1]-x[0]) * (x[2] - x[0]) + (y[1] - y[0]) * (y[2] - y[0]))/(ab*ac)) *180 / 3.14;
	}
	
	public double getAB(){
		return Math.sqrt((x[1] - x[0])*(x[1] - x[0]) + (y[1] - y[0])*(y[1] - y[0]));
	}
	
	public double getBC(){
		return Math.sqrt((x[1] - x[2])*(x[1] - x[2]) + (y[1] - y[2])*(y[1] - y[2]));
	}
	
	public double getAC(){
		return Math.sqrt((x[2] - x[0])*(x[2] - x[0]) + (y[2] - y[0])*(y[2] - y[0]));
	}

}
