package game.character;


public class Character{

    private Happiness happy;
    //private Teritory location;
    private Status stat;
    private String name;
    
    public Character(String aName, Happiness h){
        stat = new Status("civ"); //status civilian by default
        name = aName;
        happy = h;
    }

    //public void move(Teritory t){
      
    //}

    //returns a string that says the status of the character
    public String getStat(){ //More status' can be added, i.e vice pres., etc
    	return stat.getStatus();
    }
    
    public Happiness getHappiness(){
        return happy;
    }
    
    public String getName(){
    	return name;
    }

    public void startCountry(){

    }

    public void joinCountry(){

    }
}
