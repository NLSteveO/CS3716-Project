package game.character;

<<<<<<< HEAD
public class Status{
=======
public class Status(){
>>>>>>> 773c6045ca5ac8dd60a122492b6633e15963724a
	//this could possbily be an interface instead???
	private String status;
	private boolean president;
	private boolean dictator;
	private boolean civilian;
<<<<<<< HEAD
	
=======
>>>>>>> 773c6045ca5ac8dd60a122492b6633e15963724a
	//could be more options added later
	public Status(String stat){
		status = stat.toLowerCase();
		if(status == "pres"){
			president = true;
		}
		else if(status == "dict"){
			dictator = true;
		}
<<<<<<< HEAD
		else if(status == "civ"){
=======
		else if(status = "civ"){
>>>>>>> 773c6045ca5ac8dd60a122492b6633e15963724a
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
<<<<<<< HEAD
		else if(newStat == "civ"){
=======
		else if(newStat = "civ"){
>>>>>>> 773c6045ca5ac8dd60a122492b6633e15963724a
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
