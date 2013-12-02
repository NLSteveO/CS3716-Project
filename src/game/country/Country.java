package game.country;

import game.government.Government;
import game.map.Territory;

public class Country{
    
    @SuppressWarnings("unused")
	private Government gov;
    @SuppressWarnings("unused")
	private Territory ter;
    
    private Country(Government g, Territory t){
        gov = g;
        ter = t;
    }

    public void createCountry(Government g, Territory t){
        @SuppressWarnings("unused")
		Country c = new Country(g, t);
    }

    
}
