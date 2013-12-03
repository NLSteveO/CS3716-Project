package game.country;

import game.government.Democracy;
import game.government.Dictatorship;
import game.government.Government;
import game.map.Territory;
import game.character.Character;

public class Country{
    
	//private Government gov;
	private Democracy dem;
	private Dictatorship dic;
	private String name;
	private Government gov;
	private Territory ter;
	private Country c;
	private Character god;
	private boolean demdem, dicdic;
    
    public Country(Territory t,Character creator, String n){
        ter = t;
        god = creator;
        name=n;
    }
    
    public String getName(){return name;}
    public void setName(String n){name=n;}

    public void setGovernment(String g, String gn){
    	 if(g.toLowerCase().equals("democracy")){
    		 dem = new Democracy(gn);
    		 demdem = true;
    	 }
    	 else{
    		 dic = new Dictatorship(god,gn);
    		 dicdic = true;
    	 }
    }
    
    /**public Government getGov(){
    	return gov;
    }**/
    
    public Territory getTerr(){
    	return ter;
    }
    
   /** public void haveElection(){ //DID PROBS USED ELSWHERE BROTHREN MUTHA FUCKAS
    	if(demdem == true){
    		dem.startElection();
    		
    	}
    }**/
}
