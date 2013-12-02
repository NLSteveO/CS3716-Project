package game.country;

import game.government.Government;
import game.map.Territory;

public class Country{
    
	private Government gov;
	private Territory ter;
	private Country c;
    
    public Country(Territory t){
        ter = t;
    }

    /**public void createCountry(Territory t){
		c = new Country(t);
    }*/

    public void setGovernment(Government g){
    	gov = g;
    }
    
    public Government getGov(){
    	return gov;
    }
    
    public Territory getTerr(){
    	return ter;
    }
    
    public Country getCountry(){
    	return c;
    }
}
