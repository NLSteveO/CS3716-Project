package game.government;

import game.character.Character;

public interface Government{

    public void startElection();

    public int taxRate();

    public String type();

    public double currency();//Was type Currency but it doesn't exist yet so temporarily changed
 
    public Character leader();

    public Character[] council(); 

}
