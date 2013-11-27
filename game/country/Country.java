package game.country;

import game.government.Government;
import game.map.Territory;
import game.character.Character;
import java.util.ArrayList;

public class Country{
    
    @SuppressWarnings("unused")
	private Government gov;
    @SuppressWarnings("unused")
	private Territory ter;
    private ArrayList<Character> citizens;
    private final int MINIMUM_CITIZENS = 10;
    
    public Country(Government g, Territory t){
        gov = g;
        ter = t;
        citizens = new ArrayList<Character>();
    }

    public void createCountry(Government g, Territory t, ArrayList<Character> initialCitizens){
        if(initialCitizens.size() > MINIMUM_CITIZENS){
        	@SuppressWarnings("unused")
        	Country c = new Country(g, t);
        	for(int i = 0; i < initialCitizens.size(); i++){
        		if(meetsRequirements(initialCitizens.get(i))){
        			citizens.add(initialCitizens.get(i));
        		}
        	}
        }
        else{
        	System.out.println("Not Enough Citizens");
        }
    }
    
    public void joinCountry(Character chr){
    	if(meetsRequirements(chr)){
    		citizens.add(chr);
    	}
    }
    
    public boolean meetsRequirements(Character chr){
    	boolean met = false;
    	met = true;
    	return met;
    }
}
