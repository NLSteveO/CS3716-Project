package game.map;

import game.character.Character;

import java.util.ArrayList;
public class Map{
	
	
    private ArrayList<Character> characters;
    private ArrayList<Territory> terr;
    
    
    public Map(){
    	createMap();
    }
    
    // place a character randomly by picking random squares until a territory square is found 
    // and setting a character there
    public void placeCharacter(Character c){
    
    }
    
    // place a character on the specified territory
    public void placeCharacter(Character c, Territory t){
    	c.setLocation(t);
    	characters.add(c);
    }
 
    // create a map according to an algorithm
    // for now it will be a standard map, in future iterations 
    // a more varied and random map will be drawn
    
    public void neighbours(Territory t, Territory y){
    	t.addNeighbour(y);
    	y.addNeighbour(t);
    }
    
    // create the predetermined complicated map thing.
    private void  createMap(){
    	terr.add(new Territory("Northrend"));
    	terr.add(new Territory("Windhelm"));
    	neighbours(terr.get(0),terr.get(1));
    	terr.add(new Territory("Westros"));
    	neighbours(terr.get(0),terr.get(2));
    	neighbours(terr.get(1),terr.get(2));
    	terr.add(new Territory("Midway"));
    	neighbours(terr.get(1),terr.get(3));
    	neighbours(terr.get(2),terr.get(3));
    	terr.add(new Territory("Rampart"));
    	neighbours(terr.get(4),terr.get(2));
    	terr.add(new Territory("Verth"));
    	neighbours(terr.get(4),terr.get(5));
    	neighbours(terr.get(3),terr.get(5));
    	neighbours(terr.get(2),terr.get(5));
    	terr.add(new Territory("Holdout"));
    	neighbours(terr.get(1),terr.get(6));
    	neighbours(terr.get(3),terr.get(6));
    	neighbours(terr.get(5),terr.get(6));
    	terr.add(new Territory("Gyldenhul"));
    	neighbours(terr.get(4),terr.get(7));
    	neighbours(terr.get(5),terr.get(7));
    	neighbours(terr.get(6),terr.get(7));
    	terr.add(new Territory("Twins"));
    	neighbours(terr.get(7),terr.get(8));
    	
    	terr.add(new Territory("Solitude"));
    	neighbours(terr.get(8),terr.get(9));
    	
    	terr.add(new Territory("Power"));
    	terr.add(new Territory("Wisdom"));
    	terr.add(new Territory("Courage"));
    	neighbours(terr.get(9),terr.get(11));
    	neighbours(terr.get(10),terr.get(11));
    	neighbours(terr.get(12),terr.get(11));
    	neighbours(terr.get(10),terr.get(12));

    	terr.add(new Territory("Orange Isle"));
    	terr.add(new Territory("Red Isle"));
    	terr.add(new Territory("Green Isle"));
    	neighbours(terr.get(1),terr.get(13));
    	neighbours(terr.get(13),terr.get(14));
    	neighbours(terr.get(13),terr.get(15));
    	neighbours(terr.get(14),terr.get(15));
    	neighbours(terr.get(10),terr.get(15));

    	terr.add(new Territory("Mobius"));
    	neighbours(terr.get(16),terr.get(12));
    	terr.add(new Territory("Horus"));
    	neighbours(terr.get(16),terr.get(17));
    	terr.add(new Territory("Vayne"));
    	neighbours(terr.get(17),terr.get(18));
    	terr.add(new Territory("Gallows"));
    	neighbours(terr.get(18),terr.get(19));
    	
    	terr.add(new Territory("SouthShield"));
    	neighbours(terr.get(19),terr.get(20));
    	terr.add(new Territory("Rearguard"));
    	neighbours(terr.get(20),terr.get(21));
    	terr.add(new Territory("Hearth"));
    	neighbours(terr.get(21),terr.get(22));
    	neighbours(terr.get(20),terr.get(22));
    	terr.add(new Territory("Misery"));
    	neighbours(terr.get(22),terr.get(23));
    	neighbours(terr.get(21),terr.get(23));
    	terr.add(new Territory("Vanguard"));
    	neighbours(terr.get(23),terr.get(24));
    	neighbours(terr.get(22),terr.get(24));
    	neighbours(terr.get(21),terr.get(24));
    	terr.add(new Territory("Helgan"));
    	neighbours(terr.get(22),terr.get(25));
    	terr.add(new Territory("Ococo"));
    	neighbours(terr.get(25),terr.get(26));
    	neighbours(terr.get(22),terr.get(26));
    	terr.add(new Territory("Primm"));
    	neighbours(terr.get(26),terr.get(27));
    	terr.add(new Territory("Brill"));
    	neighbours(terr.get(26),terr.get(28));
    	neighbours(terr.get(27),terr.get(28));
    	neighbours(terr.get(14),terr.get(28));
    	
    	
    } 
    
    
    
    public ArrayList<Territory> legalMoves(Territory t){
        ArrayList<Territory> ans = t.getNeighbours();
        return ans;
    }
    
    public boolean moveCharacter(Character c, Territory t){
    	if(isLegalMove(c.getLocation(),t)){
    		c.setLocation(t);
    		return true;
    	}
    	return false;
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
