package game.character;

public class Status(){
	//this could possbily be an interface instead???
	private String status;
	private boolean president;
	private boolean dictator;
	private boolean civilian;
	//could be more options added later
	public Status(String stat){
		status = stat.toLowerCase();
		if(status == "pres"){
			president = true;
		}
		else if(status == "dict"){
			dictator = true;
		}
		else if(status = "civ"){
			civilian = true;
		}
	}

	public void updateStatus(String newStat){
		if(newStat == "pres"){
			president = true;
			civilian = false;
			dictator = false;
		}
		else if(newStat == "dict"){
			dictator = true;
			president = false;
			civilian = false;
		}
		else if(newStat = "civ"){
			civilian = true;
			president = false;
			dictator = false;
		}
	}
	
	public boolean isPres(){
		return president;
	}

	public boolean isCiv(){
		return civilian;
	}

	public boolean isDict(){
		return dictator;
	}

}	 
