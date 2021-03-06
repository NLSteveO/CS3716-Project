 package game.government;
  
  import game.character.Character;
  /***NOTE: THE WINNER WILL NEED TO BE MADE president = true (status) IN CHARACTER CLASS
   ***This will probably be in main program? ex: check results of election, winner gets president = true
   */
  public class Democracy implements Government{//may not even need election interface now
    
    private String[] votes;
    private Character[] candits;
    private int[] votesForCan;
    private int i,highest,indexOfHigh,taxRatePer;
    private Character[] council;
    private boolean containsMem;
    private String curName;
    private Character leader;
    private String govName;
    private boolean start=false;
    private int ElectionStart;
    private boolean Continue=false;
  
	public Democracy(String Name){
		  govName=Name;
	      leader = new Character(" ",null);
	      council = new Character[5]; //IS THIS ALL I NEED TO DO? CHECK TIM
	    }
	
	public String getName(){
		return govName;
	}
	    
	    public void setupElection(int i) { //starts an election
	      votes = new String[100];
	      candits = new Character[8];
	      votesForCan = new int[8];
	      start=true;
	      ElectionStart =i;
	    }
	    
	    public boolean isElectionHappening(){return start;}
	    
	    public void continueElection(){
	    	
	    	Continue=true;
	    	start=false;
	    }
	    public boolean isElectionContinue(){return Continue;}
	    
	    public int ElectionStart(){return ElectionStart;}
	    
	    
	    public void addVote(String vote){//adds a vote for specified candidate (100 max people to vote)
	      i=0;
	      while(i<votes.length){
	        if(votes[i] == null){
	          votes[i] = vote;
	          System.out.println(votes[i]+i);
	          i=votes.length;
	        }
	        i=i+1;
	      }
	    }
	    
	    public void addCandidate(Character can){//adds candidate to election (5 max)
	      i=0;
	      while(i<candits.length){
	        if(candits[i] == null){
	          candits[i] = can;
	          i=candits.length;
	        }
	        i = i+1;
	      }
	    }
	    
	    public Character[] getCandidates(){return candits;}
	    
	    public Character finishElection(){
	    	Continue=false;
	    	return getResults();
	    }
	    
	    public Character getResults(){//returns a string with the name of the winner of the election
	      for(int j=0; j < candits.length; j++){
	    	  votesForCan[j]=0;
	        for(int k=0; k<votes.length; k++){
	          if(votes[k]!=null && candits[j]!=null && votes[k].toLowerCase().equals(candits[j].getName().toLowerCase())){
	            votesForCan[j] = votesForCan[j] + 1;
	            System.out.println(votesForCan[j]);
	          }
	        }
	      }
	      highest = votesForCan[0];
	      for(int l=1; l<votesForCan.length; l++){
	        if(votesForCan[l] > highest){
	          highest = votesForCan[l];
	          indexOfHigh = l;
	        }
	      }
	      return candits[indexOfHigh];
	    }
	  
	    //set and get tax rates
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
	      leader.updateStatus("pres");
	    }
	    
	    public Character getLeader(){
	      return leader;
	    }
	  
	    public Character[] getCouncil(){
	    	return council;
	    }
	    
	    //What to do here? Make leader choose council, and have character accept or decline invite
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
	    
	    public String getType(){
	    	return "Democracy";
	    }
	    
	    //MORE TO COME HERE!
}
