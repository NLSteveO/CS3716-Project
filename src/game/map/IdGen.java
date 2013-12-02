package game.map;

public class IdGen{
	
	private int nextInt;
	private static final IdGen Instance = new IdGen();
	
	private IdGen(){
		nextInt=0;
	}
	
	public static IdGen getIdGen(){
		return Instance;
	}
	
	public int getID(){
		nextInt++;
		return nextInt;
	}
	
}