package game.map;

import game.character.Character;

import java.util.ArrayList;
public class Map{
	
	
    private ArrayList<Character> characters;
    private ArrayList<Territory> terr;
    
    
    public Map(){
    	createMap();
    }
    
    public void placeCharacter(Character c){
    
    }
    
    public Territory getTerrbyCoord(int x, int y){
    	for(int i=0; i<terr.size();i++){
    		if(terr.get(i).getArea().isInside(x, y));
    			return terr.get(i);
    	}	
    	return null;
    	
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
    	int[] x,y;
    	terr.add(new Territory("Northrend",
    			new Area(4,x=new int[]{82,82,192,192},y=new int[]{28,140,28,140})));
    	terr.add(new Territory("Windhelm",
    			new Area(6,x=new int[]{195,306,195,250,250,306},y=new int[]{96,96,140,140,221,221})));
    	neighbours(terr.get(0),terr.get(1));
    	terr.add(new Territory("Westros",
    			new Area(5,x=new int[]{84,205,84,141,205},y=new int[]{143,143,202,231,221})));
    	neighbours(terr.get(0),terr.get(2));
    	neighbours(terr.get(1),terr.get(2));
    	terr.add(new Territory("Midway",
    			new Area(4,x=new int[]{208,208,248,248},y=new int[]{221,144,144,221})));
    	neighbours(terr.get(1),terr.get(3));
    	neighbours(terr.get(2),terr.get(3));
    	terr.add(new Territory("Rampart",
    			new Area(4,x=new int[]{83,140,83,140},y=new int[]{205,292,292,234})));
    	neighbours(terr.get(4),terr.get(2));
    	terr.add(new Territory("Verth",
    			new Area(4,x=new int[]{143,205,143,205},y=new int[]{233,225,292,292})));
    	neighbours(terr.get(4),terr.get(5));
    	neighbours(terr.get(3),terr.get(5));
    	neighbours(terr.get(2),terr.get(5));
    	terr.add(new Territory("Holdout",
    			new Area(4,x=new int[]{208,208,306,306},y=new int[]{224,292,224,292})));
    	neighbours(terr.get(1),terr.get(6));
    	neighbours(terr.get(3),terr.get(6));
    	neighbours(terr.get(5),terr.get(6));
    	terr.add(new Territory("Gyldenhul",
    			new Area(4,x=new int[]{82,305,82,305},y=new int[]{295,295,342,342})));
    	neighbours(terr.get(4),terr.get(7));
    	neighbours(terr.get(5),terr.get(7));
    	neighbours(terr.get(6),terr.get(7));
    	terr.add(new Territory("Twins",
    			new Area(8,x=new int[]{165,260,190,230,165,190,230,260}
    				,y=new int[]{343,343,380,380,453,453,453,453})));
    	neighbours(terr.get(7),terr.get(8));
    	
    	terr.add(new Territory("Solitude",
    			new Area(4,x=new int[]{94,94,550,550},y=new int[]{550,592,550,592})));
    	neighbours(terr.get(8),terr.get(9));
    	
    	terr.add(new Territory("Power",
    			new Area(3,x=new int[]{443,415,470},y=new int[]{302,356,356})));
    	terr.add(new Territory("Wisdom",
    			new Area(3,x=new int[]{413,385,440},y=new int[]{362,416,416})));
    	terr.add(new Territory("Courage",
    			new Area(3,x=new int[]{473,445,506},y=new int[]{362,416,416})));
    	neighbours(terr.get(9),terr.get(11));
    	neighbours(terr.get(10),terr.get(11));
    	neighbours(terr.get(12),terr.get(11));
    	neighbours(terr.get(10),terr.get(12));

    	terr.add(new Territory("Orange Isle",
    			new Area(0,x=new int[]{360},y=new int[]{103})));
    	terr.add(new Territory("Red Isle",
    			new Area(0,x=new int[]{474},y=new int[]{111})));
    	terr.add(new Territory("Green Isle",
    			new Area(0,x=new int[]{464},y=new int[]{192})));
    	neighbours(terr.get(1),terr.get(13));
    	neighbours(terr.get(13),terr.get(14));
    	neighbours(terr.get(13),terr.get(15));
    	neighbours(terr.get(14),terr.get(15));
    	neighbours(terr.get(10),terr.get(15));

    	terr.add(new Territory("Mobius",
    			new Area(4,x=new int[]{588,632,632,588},y=new int[]{321,321,359,359})));
    	neighbours(terr.get(16),terr.get(12));
    	terr.add(new Territory("Horus",
    			new Area(4,x=new int[]{637,637,681,681},y=new int[]{374,336,336,374})));
    	neighbours(terr.get(16),terr.get(17));
    	terr.add(new Territory("Vayne",
    			new Area(4,x=new int[]{686,730,686,730},y=new int[]{353,353,391,391})));
    	neighbours(terr.get(17),terr.get(18));
    	terr.add(new Territory("Gallows",
    			new Area(4,x=new int[]{734,778,734,778},y=new int[]{370,370,408,408})));
    	neighbours(terr.get(18),terr.get(19));
    	
    	terr.add(new Territory("SouthShield",
    			new Area(3,x=new int[]{740,693,769},y=new int[]{279,229,229})));
    	neighbours(terr.get(19),terr.get(20));
    	terr.add(new Territory("Rearguard",
    			new Area(4,x=new int[]{732,789,732,789},y=new int[]{178,178,224,224})));
    	neighbours(terr.get(20),terr.get(21));
    	terr.add(new Territory("Hearth",
    			new Area(4,x=new int[]{688,728,690,728},y=new int[]{226,226,113,113})));
    	neighbours(terr.get(21),terr.get(22));
    	neighbours(terr.get(20),terr.get(22));
    	terr.add(new Territory("Misery",
    			new Area(4,x=new int[]{733,757,733,757},y=new int[]{137,137,176,176})));
    	neighbours(terr.get(22),terr.get(23));
    	neighbours(terr.get(21),terr.get(23));
    	terr.add(new Territory("Vanguard",
    			new Area(4,x=new int[]{732,732,788,788},y=new int[]{113,133,113,133})));
    	neighbours(terr.get(23),terr.get(24));
    	neighbours(terr.get(22),terr.get(24));
    	neighbours(terr.get(21),terr.get(24));
    	neighbours(terr.get(0),terr.get(24));
    	terr.add(new Territory("Helgan",
    			new Area(4,x=new int[]{617,685,617,685},y=new int[]{190,190,226,226})));
    	neighbours(terr.get(22),terr.get(25));
    	terr.add(new Territory("Ococo",
    			new Area(6,x=new int[]{599,686,599,557,613,686}
    				,y=new int[]{69,69,109,157,186,186})));
    	neighbours(terr.get(25),terr.get(26));
    	neighbours(terr.get(22),terr.get(26));
    	terr.add(new Territory("Primm",
    			new Area(5,x=new int[]{555,555,585,596,596},
    				y=new int[]{68,96,124,109,68})));
    	neighbours(terr.get(26),terr.get(27));
    	terr.add(new Territory("Brill",
    			new Area(5,x=new int[]{582,555,541,522,541},y=new int[]{125,156,145,68,68})));
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
