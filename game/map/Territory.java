package game.map;
import java.util.ArrayList;

public class Territory {
	

	private int ID;
    private ArrayList<Territory> neighbours, T;
    private IdGen generator = IdGen.getIdGen(); 
    
    public Territory(){
    	ID=generator.getID();
    	neighbours = new ArrayList<Territory>();
    }
    
    public Territory(Territory t){
    	ID=generator.getID();
    	neighbours= new ArrayList<Territory>();
    	neighbours.add(t);
    }
    
    public ArrayList<Territory> getNeighbours(){
        return neighbours;
    }
    
    public int numNeighbours(){
    	return neighbours.size();
    }
    
    public boolean isNeighbour(Territory query){
        for(int i=0;i<neighbours.size();i++){
            if(neighbours.get(i).equals(query))
            	return true;
        }
        return false;
    }
    

    public int getID(){
    	return ID;
    }
    
    public boolean equals(Territory t){
    	if(t.getID()==this.getID())
    		return true;
    	return false;
    }
    
    public void addNeighbour(Territory t){
    			neighbours.add(t);
  
    }
    
   }
