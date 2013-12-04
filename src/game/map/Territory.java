package game.map;
import game.country.Country;

import java.util.ArrayList;

public class Territory {
        

    private String Name;
    private ArrayList<Territory> neighbours;
    private Area arr;
    private boolean occupied = false;
    private Country count;
    
    public Territory(String Name,Area n){
            neighbours = new ArrayList<Territory>();
            this.Name=Name;
            arr = n;
    }
    
    public ArrayList<Territory> getNeighbours(){
    	ArrayList<Territory> pass = new ArrayList<Territory>();
    	for(int i=0; i<neighbours.size();i++)
    		pass.add(neighbours.get(i));
        return pass;
    }
    
    public void setCountry(Country c){
    	count=c;
    }
    
    public Country getCountry(){
    	return count;
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
    
    public Area getArea(){return arr;}
    
 
    public boolean equals(Territory t){
            if(t.getName().equals(this.getName()))
                    return true;
            return false;
    }
    
    public void addNeighbour(Territory t){
                            neighbours.add(t);
  
    }
    
    public void setOccupied(){
    	occupied = true;
    }
    
    public boolean isOccupied(){
    	return occupied;
    }
    
   }