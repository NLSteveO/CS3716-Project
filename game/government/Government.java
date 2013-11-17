package game.government;

import game.character.Character;

public interface Government{

    public boolean elections();

    public int taxRate();

    public String type();

    public Currency currency();

    public Character leader();

    public Character[] council(); 

}
