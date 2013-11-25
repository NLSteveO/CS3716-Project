package game.map;
import java.util.ArrayList;

public class Territory {
	

	private String Name;
    private ArrayList<Territory> neighbours;
    
    public Territory(String Name){
    	neighbours = new ArrayList<Territory>();
    	this.Name=Name;
    }  
    
    public ArrayList<Territory> getNeighbours(){
        return neighbours;
    }
    
    public int numNeighbours(){
    	return neighbours.size();
    }
    
    public String getName(){return Name;}
    
    public boolean isNeighbour(Territory query){
        for(int i=0;i<neighbours.size();i++){
            if(neighbours.get(i).equals(query))
            	return true;
        }
        return false;
    }
    
 
    public boolean equals(Territory t){
    	if(t.getName().equals(this.getName()))
    		return true;
    	return false;
    }
    
    public void addNeighbour(Territory t){
    			neighbours.add(t);
  
    }
    
   }
