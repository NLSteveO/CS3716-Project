package game.map;


import java.util.ArrayList;
import java.util.Random;
@SuppressWarnings("unused")
public class Map{
	
	private final int terLimit=4;
    private ArrayList<Territory> territories;
    private ArrayList<Character> characters;
    
    //For now, generate one of several preset maps, in future iterations random
    //map generation may be implemented.
    public Map(int mapCode){
    	if(mapCode==1){
    		createMap(5);
    			
    		
    	}
    	if(mapCode==2){
    		
    	}
        if(mapCode==3){
        	
        }
        
    }
    
    // create a map according to an algorithm
    // for now it will be a standard map, in future iterations 
    // a more varied and random map will be drawn
    
    public void createMap(int numTer){
    	initialMap(numTer, terLimit);
    	fillNeighbours();
    	
    }
    
    public void  initialMap(int numTer, int limNeighbour){
    	territories = new ArrayList<Territory>();
    	territories.add(new Territory());
    	int tail = 0;
    	
    	for(int i=0; i<numTer; i++){
    		if(territories.get(tail).numNeighbours()<=limNeighbour)
    			territories.add(new Territory(territories.get(tail)));
    		else
    			territories.add(new Territory(territories.get(tail++)));
    	}
    }
    
    public void fillNeighbours(){
    	
    }

    public void drawMap(){
        
    }

    public void updateMap(){
        
    }

    public ArrayList<Territory> legalMoves(Territory t){
        ArrayList<Territory> ans = t.getNeighbours();
        return ans;
    }
    
    public boolean isLegalMove(Territory start, Territory end){
    	ArrayList<Territory> check = start.getNeighbours();
    	for(int i=0; i<check.size();i++){
    		if(check.get(i).equals(end))
    			return true;
    	}
    	return false;
    }
}
