package game.map;

import game.character.Character;

import java.util.Random;
import java.util.ArrayList;
public class Map{
	
	private Coord[][] coord;
	private int size;
    private ArrayList<Character> characters;
    
    
    public Map(int numTer, int size){
    	this.size = size;
    	coord = new Coord[size][size];
    	for(int i=0;i<size;i++){
    		for(int j=0;j<size;j++){
    			coord[i][j] = new Coord(i, j);
    		}
    	} 
    	createMap(numTer);
    	fillNeighbours();
    	
    }
    
    // place a character randomly by picking random squares until a territory square is found 
    // and setting a character there
    public void placeCharacter(Character c){
    	boolean truth = true;
    	Random r = new Random();
    	while(truth){
    		int x = r.nextInt(size);
    		int y = r.nextInt(size);
    		if(coord[x][y].hasTerritory()){
    			c.setLocation(coord[x][y].getTerritory());
    			characters.add(c);
    			truth=false;
    		}
    	}
    }
    
    // place a character on the specified territory
    public void placeCharacter(Character c, Territory t){
    	c.setLocation(t);
    	characters.add(c);
    }
    
    public Map(Coord[][] c){
    	coord = c;
    	fillNeighbours();
    }
    
    // create a map according to an algorithm
    // for now it will be a standard map, in future iterations 
    // a more varied and random map will be drawn
    
    public void  createMap(int numTer){
    	if(numTer>coord.length*coord.length)
    		return; // Error Check Better!!!
    	int x,y;
    	Random r= new Random();
    		for(int i=0; i<numTer;i++){
    			x=r.nextInt(coord.length);
    			y=r.nextInt(coord.length);
    			//System.out.print("("+x+","+y+"): ");
    			coord[x][y].setTerritory(new Territory(coord[x][y]));
    			//System.out.println("Territory:"+coord[x][y].getTerritory().getID());
    		}
    }
    
    public void fillNeighbours(){
    	for(int i =0; i< coord.length;i++){
    		for(int j= 0; j< coord.length;j++){
    			if(coord[i][j].hasTerritory()){
    				try{
    					if(coord[i-1][j-1].hasTerritory())
    						dualNeighbourship(i,j,i-1,j-1);
    					if(coord[i][j-1].hasTerritory())
    						dualNeighbourship(i,j,i,j-1);
    					if(coord[i+1][j-1].hasTerritory())
    						dualNeighbourship(i,j,i+1,j-1);
    					if(coord[i-1][j].hasTerritory())
    						dualNeighbourship(i,j,i-1,j);
    					if(coord[i+1][j].hasTerritory())
    						dualNeighbourship(i,j,i+1,j);
    					if(coord[i-1][j+1].hasTerritory())
    						dualNeighbourship(i,j,i-1,j+1);
    					if(coord[i][j+1].hasTerritory())
    						dualNeighbourship(i,j,i,j+1);
    					if(coord[i+1][j+1].hasTerritory())
    						dualNeighbourship(i,j,i+1,j+1);
    				}
    				catch(ArrayIndexOutOfBoundsException e){
    					continue;
    				}
    			}
    				
    		}
    	}
    }
    
    public void dualNeighbourship(int i, int j, int k, int l){
				coord[i][j].getTerritory().addNeighbour(coord[k][l].getTerritory());
				coord[k][l].getTerritory().addNeighbour(coord[i][j].getTerritory());
	}
    
    public ArrayList<Territory> legalMoves(Territory t){
        ArrayList<Territory> ans = t.getNeighbours();
        return ans;
    }
    
    public boolean moveCharacter(Character c, Territory t){
    	if(isLegalMove(c.getLocation(),t)){
    		c.setLocation(t);
    		return true;
    	}
    	return false;
    }
    
    public boolean isLegalMove(Territory start, Territory end){
    	ArrayList<Territory> check = start.getNeighbours();
    	for(int i=0; i<check.size();i++){
    		if(check.get(i).equals(end))
    			return true;
    	}
    	return false;
    }
    
    public int getSize(){
    	return size;
    }
    
    public Coord[][] getCoordinates(){
    	return coord;
    }
}
