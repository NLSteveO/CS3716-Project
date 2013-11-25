package game.map;
import java.awt.Point;

import java.util.ArrayList;

public class Area {
	
	private ArrayList<Point> corners;
	int terrSides;
	
	public Area(int sides,int[] x, int [] y){
		if(x.length!=y.length){
			return;
		}
		terrSides=sides;
		for(int i=0; i<x.length;i++){
			corners.add(new Point(x[i],y[i]));
		}
		
	}
	public boolean isInside(int x, int y){
		if(terrSides==0)
			return isInsideCirc(x,y);
		return isInsideCorn(x,y);
	}
	
	public boolean isInsideCirc(int x, int y){
		if((x-corners.get(0).getX())*(x-corners.get(0).getX())+(y-corners.get(0).getY())*(y-corners.get(0).getY())<30*30){
			return true;
		}
		return false;
		
	}
	//implementation of complex polygon algorithm
	public boolean isInsideCorn(int x,int y){
		int i, j = terrSides-1;
		boolean oddNodes = false;
		
		for(i=0;i<terrSides;i++){
			if(corners.get(i).getY()<y && corners.get(j).getY()>=y
					|| corners.get(j).getY()<y && corners.get(i).getY()>=y){
				
						if((corners.get(i).getX()+(y-corners.get(i).getY())
								/ (corners.get(j).getY()-corners.get(i).getY())
									*(corners.get(j).getX()-corners.get(i).getX()))<x){
									oddNodes=!oddNodes;
						}
			}
		j=i;
		}		
		return oddNodes;
	}

}
