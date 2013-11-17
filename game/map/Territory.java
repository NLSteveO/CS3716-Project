package game.map;
import java.util.ArrayList;

public class Territory {
	
	@SuppressWarnings("unused")
	private int ID;
    private ArrayList<Territory> neighbours;
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
    

    @SuppressWarnings("unused")
    public boolean addNeighbour(Territory t){
    	for(int i=0; i<neighbours.size();i++){
    		if(neighbours.get(i)==null)
    			neighbours.set(i, t);
    			return true;
    	}
    	 return false;
    }
    
    }