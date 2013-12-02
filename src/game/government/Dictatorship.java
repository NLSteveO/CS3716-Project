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
