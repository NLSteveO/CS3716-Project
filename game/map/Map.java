package game.map;

import game.character.Character;

import java.util.ArrayList;
public class Map{
        
    private Territory undef = new Territory("",null);
    private ArrayList<Character> characters;
    private ArrayList<Territory> terr = new ArrayList<Territory>();
    
    
    public Map(){
            createMap();
    }
    
    public void placeCharacter(Character c){
    
    }
    
    public Territory getTerrbyCoord(int x, int y){
            for(int i=0; i<terr.size();i++){
                    if(terr.get(i).getArea().isInside(x, y))
                            return terr.get(i);
            }        
            return undef;
            
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
    @SuppressWarnings("unused")
	private void  createMap(){
            double[] x,y;
            terr.add(new Territory("Northrend",
                            new Area(4,x=new double[]{82,82,192,192},y=new double[]{28,140,28,140})));
            terr.add(new Territory("Windhelm",
                            new Area(6,x=new double[]{195,195,250,250,306,306},y=new double[]{96,140,140,221,221,96})));
            neighbours(terr.get(0),terr.get(1));
            terr.add(new Territory("Westros",
                            new Area(5,x=new double[]{84,84,141,205,205},y=new double[]{143,202,231,221,143})));
            neighbours(terr.get(0),terr.get(2));
            neighbours(terr.get(1),terr.get(2));
            terr.add(new Territory("Midway",
                            new Area(4,x=new double[]{208,208,248,248},y=new double[]{221,144,144,221})));
            neighbours(terr.get(1),terr.get(3));
            neighbours(terr.get(2),terr.get(3));
            terr.add(new Territory("Rampart",
                            new Area(4,x=new double[]{83,83,140,140},y=new double[]{205,292,292,234})));
            neighbours(terr.get(4),terr.get(2));
            terr.add(new Territory("Verth",
                            new Area(4,x=new double[]{143,143,205,205},y=new double[]{233,292,292,225})));
            neighbours(terr.get(4),terr.get(5));
            neighbours(terr.get(3),terr.get(5));
            neighbours(terr.get(2),terr.get(5));
            terr.add(new Territory("Holdout",
                            new Area(4,x=new double[]{208,208,306,306},y=new double[]{224,292,292,222})));
            neighbours(terr.get(1),terr.get(6));
            neighbours(terr.get(3),terr.get(6));
            neighbours(terr.get(5),terr.get(6));
            terr.add(new Territory("Gyldenhul",
                            new Area(4,x=new double[]{82,82,305,305},y=new double[]{295,342,342,295})));
            neighbours(terr.get(4),terr.get(7));
            neighbours(terr.get(5),terr.get(7));
            neighbours(terr.get(6),terr.get(7));
            terr.add(new Territory("Twins",
                            new Area(8,x=new double[]{165,260,260,230,230,190,190,165}
                                    ,y=new double[]{343,343,453,453,380,380,453,453})));
            neighbours(terr.get(7),terr.get(8));
            
            terr.add(new Territory("Solitude",
                            new Area(4,x=new double[]{94,94,550,550},y=new double[]{550,592,592,550})));
            neighbours(terr.get(8),terr.get(9));
            
            terr.add(new Territory("Power",
                            new Area(3,x=new double[]{443,415,470},y=new double[]{302,356,356})));
            terr.add(new Territory("Wisdom",
                            new Area(3,x=new double[]{413,385,440},y=new double[]{362,416,416})));
            terr.add(new Territory("Courage",
                            new Area(3,x=new double[]{473,445,506},y=new double[]{362,416,416})));
            neighbours(terr.get(9),terr.get(11));
            neighbours(terr.get(10),terr.get(11));
            neighbours(terr.get(12),terr.get(11));
            neighbours(terr.get(10),terr.get(12));

            terr.add(new Territory("Orange Isle",
                            new Area(0,x=new double[]{360},y=new double[]{103})));
            terr.add(new Territory("Red Isle",
                            new Area(0,x=new double[]{474},y=new double[]{111})));
            terr.add(new Territory("Green Isle",
                            new Area(0,x=new double[]{464},y=new double[]{192})));
            neighbours(terr.get(1),terr.get(13));
            neighbours(terr.get(13),terr.get(14));
            neighbours(terr.get(13),terr.get(15));
            neighbours(terr.get(14),terr.get(15));
            neighbours(terr.get(10),terr.get(15));

            terr.add(new Territory("Mobius",
                            new Area(4,x=new double[]{588,632,632,588},y=new double[]{321,321,359,359})));
            neighbours(terr.get(16),terr.get(12));
            terr.add(new Territory("Horus",
                            new Area(4,x=new double[]{637,637,681,681},y=new double[]{374,336,336,374})));
            neighbours(terr.get(16),terr.get(17));
            terr.add(new Territory("Vayne",
                            new Area(4,x=new double[]{686,730,730,686},y=new double[]{353,353,391,391})));
            neighbours(terr.get(17),terr.get(18));
            terr.add(new Territory("Gallows",
                            new Area(4,x=new double[]{734,734,778,778},y=new double[]{370,408,408,370})));
            neighbours(terr.get(18),terr.get(19));
            
            terr.add(new Territory("SouthShield",
                            new Area(3,x=new double[]{740,693,769},y=new double[]{279,229,229})));
            neighbours(terr.get(19),terr.get(20));
            terr.add(new Territory("Rearguard",
                            new Area(4,x=new double[]{732,789,789,732},y=new double[]{178,178,224,224})));
            neighbours(terr.get(20),terr.get(21));
            terr.add(new Territory("Hearth",
                            new Area(4,x=new double[]{690,728,728,688},y=new double[]{113,113,226,226})));
            neighbours(terr.get(21),terr.get(22));
            neighbours(terr.get(20),terr.get(22));
            terr.add(new Territory("Misery",
                            new Area(4,x=new double[]{733,733,757,757},y=new double[]{176,137,137,176})));
            neighbours(terr.get(22),terr.get(23));
            neighbours(terr.get(21),terr.get(23));
            terr.add(new Territory("Vanguard",
                            new Area(4,x=new double[]{732,732,788,788},y=new double[]{133,113,113,133})));
            neighbours(terr.get(23),terr.get(24));
            neighbours(terr.get(22),terr.get(24));
            neighbours(terr.get(21),terr.get(24));
            neighbours(terr.get(0),terr.get(24));
            terr.add(new Territory("Helgan",
                            new Area(4,x=new double[]{685,685,617,617},y=new double[]{226,190,190,226})));
            neighbours(terr.get(22),terr.get(25));
            terr.add(new Territory("Ococo",
                            new Area(6,x=new double[]{686,686,599,599,557,613}
                                    ,y=new double[]{186,69,69,109,157,186})));
            neighbours(terr.get(25),terr.get(26));
            neighbours(terr.get(22),terr.get(26));
            terr.add(new Territory("Primm",
                            new Area(5,x=new double[]{555,555,585,596,596},
                                    y=new double[]{68,96,124,109,68})));
            neighbours(terr.get(26),terr.get(27));
            terr.add(new Territory("Brill",
                            new Area(5,x=new double[]{582,555,541,522,541},y=new double[]{125,156,145,68,68})));
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