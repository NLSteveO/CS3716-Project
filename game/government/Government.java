package game.government;

import game.character.Character;

public interface Government{

    public boolean elections();

    public int taxRate();

    public String type();

    public double currency(); //was type Currency but it doesn't exist yet so changed to avoid unnecessary error.

    public Character leader();

    public Character[] council(); 

}
