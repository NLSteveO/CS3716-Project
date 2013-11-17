package game.character;

public class Character{

    private Happiness happy;
    //private Teritory location;
    //private Status stat;
    private String name;
    
    public Character(String aName, Happiness h){
        //stat = new Status("Civ");
        name = aName;
        happy = h;
    }

    //public void move(Teritory t){
      
    //}

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
