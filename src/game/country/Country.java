package game.country;

import game.government.Government;
import game.map.Territory;

public class Country{
    
	private String Name;
	private Government gov;
	private Territory ter;
    
    public Country(Territory t, String n){
        ter = t;
        Name=n;
    }
    
    public String getName(){return Name;}
    public void setName(String n){Name=n;}

    public void setGovernment(Government g){
    	gov = g;
    }
    
    public Government getGov(){
    	return gov;
    }
    
    public Territory getTerr(){
    	return ter;
    }
}
