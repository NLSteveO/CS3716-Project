package game.map;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

public class Area {
	
	private ArrayList<Point2D.Double> corners;
	int terrSides;
	
	public Area(int sides,double[] x, double [] y){
		if(x.length!=y.length){
			return;
		}
		terrSides=sides;
		for(int i=0; i<x.length;i++){
			corners.add(new Point2D.Double(x[i],y[i]));
		}
		
	}
	public boolean isInside(double x, double y){
		if(terrSides==0)
			return isInsideCirc(x,y);
		return isInsideCorn(x,y);
	}
	
	public boolean isInsideCirc(double x, double y){
		if((x-corners.get(0).getX())*(x-corners.get(0).getX())+(y-corners.get(0).getY())*(y-corners.get(0).getY())<30*30){
			return true;
		}
		return false;
		
	}
	//implementation of complex polygon algorithm
	public boolean isInsideCorn(double x,double y){
		int i, j = terrSides-1;
		boolean oddNodes = false;
		
		for(i=0;i<terrSides;i++){
			if(corners.get(i).getY()<y && corners.get(j).getY()>=y
					|| corners.get(j).getY()<y && corners.get(i).getY()>=y){
				
						if(corners.get(i).getX()+(y-corners.get(i).getY())
								/ (corners.get(j).getY()-corners.get(i).getY())
									*(corners.get(j).getX()-corners.get(i).getX())<x){
									oddNodes=!oddNodes;
						}
			}
		j=i;
		}		
		return oddNodes;
	}

}
