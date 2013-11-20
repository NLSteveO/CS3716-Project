package game.government;

import game.character.Character;

public interface Government{

    public void startElection();

    public void setTaxRate(int taxPercent);

    public void currency(String name);//Was type Currency but it doesn't exist yet so temporarily changed
 
    public Character leader();

    public void addCouncilMem(Character chara); 

}
