<<<<<<< HEAD:game/government/Dictatorship.java
package game.government;

import game.character.Character;

public class Dictatorship implements Government{

	private Character[] council;//NEED TO INITIALIZE THIS! LATER WHEN I DO MORE DICTAT STUFFF
	private boolean containsMem;
	private int i,taxRatePer;
	private String curName;
	private Character leader;
	
	public Dictatorship(Character chr){
		setLeader(chr);
		council = new Character[5]; ///IS THIS ALL I NEED TO DO? CHECK TIM!
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
=======
package game.government;

import game.character.Character;

public class Dictatorship implements Government{

	@Override
	public boolean elections() {
		
		return false;
	}

	@Override
	public int taxRate() {
		
		return 0;
	}

	@Override
	public String type() {
		
		return null;
	}

	@Override
	public double currency() {
		
		return 0;
	}

	@Override
	public Character leader() {
		
		return null;
	}

	@Override
	public Character[] council() {
		
		return null;
	}

}
>>>>>>> origin/Steve's-branch:src/game/government/Dictatorship.java
