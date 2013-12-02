<<<<<<< HEAD:game/government/Government.java
package game.government;

import game.character.Character;

public interface Government{

    public void setTaxRate(int taxPercent);

    public void currency(String name);//Was type Currency but it doesn't exist yet so temporarily changed
 
    public void setLeader(Character ch);

    public void addCouncilMem(Character chara); 

}
=======
package game.government;

import game.character.Character;

public interface Government{

    public boolean elections();

    public int taxRate();

    public String type();

    public double currency();//Was type Currency but it doesn't exist yet so temporarily changed
 
    public Character leader();

    public Character[] council(); 

}
>>>>>>> origin/Steve's-branch:src/game/government/Government.java
