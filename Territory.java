package game.map;


public class Territory {
	
	public static final int LIMIT_NEIGHBOUR = 4;
	private int ID;
    private Territory[] neighbours;
    private IdGen generator = IdGen.getIdGen(); 
    
    public Territory(){
    	ID=generator.getID();
    	neighbours = new Territory[LIMIT_NEIGHBOUR];
    }
    
    public Territory(Territory[] neighbours){
        ID = generator.getID();
    	this.neighbours = neighbours;
        
    }
    
    public Territory[] getNeighbours(){
        return neighbours;
    }
    
    public boolean isNeighbour(Territory query){
        for(int i=0;i<neighbours.length;i++){
            if(neighbours[i].equals(query))
            	return true;
        }
        return false;
    }
    
    public boolean addNeighbour(Territory t){
    	for(int i=0; i<neighbours.length;i++){
    		if(neighbours[i]==null)
    			neighbours[i]=t;
    			return true;
    	}
    	 return false;
    }
    
    }