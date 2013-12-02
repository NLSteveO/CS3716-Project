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
	private Territory ter;
	private Country c;
	private Character god;
	private boolean demdem, dicdic;
    
    public Country(Territory t,Character creator){
        ter = t;
        god = creator;
    }

    public void setGovernment(String g){
    	 if(g.toLowerCase().equals("democracy")){
    		 dem = new Democracy();
    		 demdem = true;
    	 }
    	 else{
    		 dic = new Dictatorship(god);
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
