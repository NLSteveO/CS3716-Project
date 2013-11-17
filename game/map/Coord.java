package game.map;

public class Coord {
	private int x;
	private int y;
	private Territory t;
	

	public Coord(int i, int j){
		x=i;
		y=j;
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public Territory getTerritory(){return t;}
	public void setTerritory(Territory t){ this.t=t;}
	public boolean hasTerritory(){
		if(t!= null)
			return true;
		return false;	
	}
}
