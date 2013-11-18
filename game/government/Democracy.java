package game.government;

import game.character.Character;
/***NOTE: THE WINNER WILL NEED TO BE MADE president = true (status) IN CHARACTER CLASS
 ***This will probably be in main program? ex: check results of election, winner gets president = true
 */
public class Democracy implements Government, Election{//may not even need election interface now
	
	private String[] votes;
	private String[] candits;
	private int[] votesForCan;
	private int i,highest,indexOfHigh,taxRatePer;
	private Character[] council;
	private boolean containsMem;
	
	public void startElection() { //starts an election
		votes = new String[100];
		candits = new String[5];
		votesForCan = new int[5];
	}
	
	public void addVote(String vote){//adds a vote for specified candidate (100 max people to vote)
		i=0;
		while(i<votes.length){
			if(votes[i] == null){
				votes[i] = vote;
				i=votes.length;
			}
			i=i+1;
		}
	}
	
	public void addCandidate(String can){//adds candidate to election (5 max)
		i=0;
		while(i<candits.length){
			if(candits[i] == null){
				candits[i] = can;
				i=candits.length;
			}
			i = i+1;
		}
	}
	
	public String getResults(){//returns a string with the name of the winner of the election
		for(int j=0; j < candits.length; j++){
			for(int k=0; k<votes.length; k++){
				if(votes[k].toLowerCase() == candits[j]){
					votesForCan[j] = votesForCan[j] + 1;
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

	@Override
	public double currency() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Character leader() {
		// TODO Auto-generated method stub
		return null;
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
	
	//MORE TO COME HERE!
    
}
