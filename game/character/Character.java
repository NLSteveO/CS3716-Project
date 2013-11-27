package game.character;
import game.map.Territory;
import game.country.Country;
import game.government.*;
import java.util.ArrayList;
public class Character{

	// Instance Variables
    private Happiness happy;      // a happiness object for the character
    private Territory location;   // the location of the character
    private String name;          // the name of the character
	private boolean president;    // is the character president
	private boolean dictator;     // is the character a dictator
	private boolean civilian;     // is the character a civilian
	private boolean councilMem;   // is the character a council member
	private Country c;            // create a country
    
	/**
	 * A constructor for the character class
	 * @param aName, the name of the character
	 * @param h, the happiness of the character
	 */
    public Character(String aName, Happiness h){
        civilian = true;//status civilian by default
        president = false;
		dictator = false;
		councilMem = false;
        name = aName;
        happy = h;
        c = null;
    }

    /**
     * A method to get the location of a character
     * @return location, the current location of the character
     */
    public Territory getLocation(){
    	return location;
    }
    
    /**
     * A method to set the location of a character
     * @param t, the territory to move to
     */
    public void setLocation(Territory t){
    	location = t;
    }
    //public void move(Teritory t){
      
    //}
 
	//could be more options added later

    /**
     * A method to update characters status 
     * @param newStat, the new status
     */
	public void updateStatus(String newStat){
		if(newStat == "pres"){
			president = true;
			civilian = false;
			dictator = false;
			councilMem = false;
		}
		else if(newStat == "dict"){
			dictator = true;
			president = false;
			civilian = false;
			councilMem = false;
		}
		else if(newStat == "civ"){
			civilian = true;
			president = false;
			dictator = false;
			councilMem = false;
		}
		else if(newStat == "coun"){
			councilMem = true;
			civilian = false;
			president = false;
			dictator = false;
		}
	}
	
	/**
	 * A method to test if character is president
	 * @return is a president
	 */
	public boolean isPres(){
		return president;
	}

	/**
	 * A method to test if character is a civilian
	 * @return is a civilian
	 */
	public boolean isCiv(){
		return civilian;
	}

	/**
	 * A method to test if character is a dictator
	 * @return is a dictator
	 */
	public boolean isDict(){
		return dictator;
	}
	
	/**
	 * A method to test if character is a council member
	 * @return is a council member
	 */
	public boolean isCoun(){
		return councilMem;
	}
	
	/**
	 * A method to get the current status of the character
	 * @return the character status
	 */
	public String getStatus(){
		if(isPres()){
    		return "President";
    	}
    	else if(isCoun()){
    		return "Council Member";
    	}
    	else if(isDict()){
    		return "Dictator";
    	}
    	else{
    		return "Civilian";
    	}
	}
	
    /**
     * A method to get the happiness of the character
     * @return the happiness object associated with the character
     */
    public Happiness getHappiness(){
        return happy;
    }
    
    /**
     * A method to get the power importance of a character
     * @return the importance of power
     */
    public int getPow(){
    	return happy.getPow();
    }
    
    /**
     * A method to get the wealth importance of a character
     * @return the importance of wealth
     */
    public int getWel(){
    	return happy.getWel();
    }
    
    /**
     * A method to get the solitude importance of a character
     * @return the importance of solitude
     */
    public int getSol(){
    	return happy.getSol();
    }
    
    /**
     * A method to get the name of a character
     * @return the name of a character
     */
    public String getName(){
    	return name;
    }
    
    /**
     * A method to start a new country
     * @param g, the government type
     * @param chr, a list of characters who also want to start a country
     */
    public void startCountry(Government g, ArrayList<Character> chr){
    	c.createCountry(g, location, chr);
    }
    
    /**
     * A method to join a country
     */
    public void joinCountry(){
    	
    }
}
