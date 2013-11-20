package game.government;

import game.character.Character;

public class Dictatorship implements Government{

	private Character[] council;//NEED TO INITIALIZE THIS! LATER WHEN I DO MORE DICTAT STUFFF
	private boolean containsMem;
	private int i,taxRatePer;
	private String curName;
	private Character leader;
	@Override
	public void startElection() {//probs dont need this here HEIL DICTATOR
		// TODO Auto-generated method stub
	}

	//also need get tax rate method!
	public void setTaxRate(int taxPercent) {
		taxRatePer = taxPercent;
	}
	
	public int getTaxRate(){
		return taxRatePer;
	}

	@Override
	public void currency(String name) {
		curName = name;
	}

	@Override
	public void setLeader(Character ch) {
		leader = ch;
		leader.updateStatus("dict");
	}
	
	public Character getLeader(){
		return leader;
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
