package game.government;

import game.character.Character;

public class Dictatorship implements Government{

	private Character[] council;//NEED TO INITIALIZE THIS! LATER WHEN I DO MORE DICTAT STUFFF
	private boolean containsMem;
	private int i;
	@Override
	public void startElection() {//probs dont need this here HEIL DICTATOR
		// TODO Auto-generated method stub
	}

	//also need get tax rate method!
	public void setTaxRate(int taxPercent) {
		// TODO Auto-generated method stub
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
