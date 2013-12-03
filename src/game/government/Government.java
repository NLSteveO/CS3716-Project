 package game.government;
  
  import game.character.Character;
  
  public interface Government{
	  public String getName();

      public void setTaxRate(int taxPercent);
  
      public void currency(String name);//Was type Currency but it doesn't exist yet so temporarily changed
   
      public void setLeader(Character ch);
      
      public Character getLeader();
  
      public void addCouncilMem(Character chara); 
      
      public String getType();

      public Character[] getCouncil();
  
  }
