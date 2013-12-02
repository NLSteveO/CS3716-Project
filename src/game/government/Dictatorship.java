 package game.government;
  
  import game.character.Character;
  
  public class Dictatorship implements Government{
  
    private Character[] council;//NEED TO INITIALIZE THIS! LATER WHEN I DO MORE DICTAT STUFFF
    private boolean containsMem;
    private int i,taxRatePer;
    private String curName;
    private Character leader;
    private String govName;
    
    public Dictatorship(Character chr, String Name){
      setLeader(chr);
      govName = Name;
      council = new Character[5]; ///IS THIS ALL I NEED TO DO? CHECK TIM!
    }
  
    //also need get tax rate method!
    public void setTaxRate(int taxPercent) {
      taxRatePer = taxPercent;
    }
    
    public int getTaxRate(){
      return taxRatePer;
    }
  
    
    public void currency(String name) {
      curName = name;
    }
    
    public String getCurrency() {
	      return curName;
	}
  
    
    public void setLeader(Character ch) {
      leader = ch;
      leader.updateStatus("dict");
    }
    
    public Character getLeader(){
      return leader;
    }
    
    public Character[] getCouncil(){
    	return council;
    }
  
    public void addCouncilMem(Character chara) {
      i=0;
      while(i<council.length){
        if(council[i] == null){
          council[i] = chara;
          i=council.length;
        }
        i = i+1;
      }
    }
    public String getName(){return govName;}
    
    public boolean isCouncilMem(Character cc){
      for(int i=0;i<council.length;i++){
        if(council[i].equals(cc)){
          containsMem = true;
        }
        else{
          containsMem = false;
        }
      }
      return containsMem;
    }
  
  }
  