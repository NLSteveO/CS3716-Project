package game.country;

import game.government.Democracy;
import game.government.Dictatorship;
import game.map.Territory;
import game.character.Character;

public class Country{
    
	private String name;
	private Territory ter;
	private Character god;
	private boolean demdem=false, dicdic=false;
	private Democracy dem;
	private Dictatorship dic;
    
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
    
    public int getGovType(){
    	if(demdem) return 0;
    	if(dicdic) return 1;
    	else return -1;
    }
    
    public Dictatorship getDictatorship(){
    	return dic;
    }
    public Democracy getDemocracy(){
    	return dem;
    }
    
    public Territory getTerr(){
    	return ter;
    }
    
   /** public void haveElection(){ //DID PROBS USED ELSWHERE BROTHREN MUTHA FUCKAS
    	if(demdem == true){
    		dem.startElection();
    		
    	}
    }**/
}
