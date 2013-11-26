package game.character;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Character{

    private Happiness happy;
    //private Teritory location;
    private Status stat;
    private String name;
    private int x, y;
    boolean placed = false;
    BufferedImage man;
    
    public Character(String aName, Happiness h){
        stat = new Status("civ"); //status civilian by default
        name = aName;
        happy = h;
        try {
			man = ImageIO.read(new File("images/mana.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    //public void move(Teritory t){
      
    //}
    
    public void place(int x, int y){
    	if (!placed){
    		placed = true;
    	}
    	this.x = x;
    	this.y = y;
    	System.out.println(x + " " + y);    	
    }
    
    public void draw(Graphics2D g) {
    	if (placed){
			g.drawImage(man.getSubimage(0, 0, 25, 28),  x*2-13,  y*2-14,  null);
		}
    }

    //returns a string that says the status of the character
    public String getStatus(){ //More status' can be added, i.e vice pres., etc
    	if(stat.isPres()){
    		return "President";
    	}
    	else if(stat.isCiv()){
    		return "Civilian";
    	}
    	else if(stat.isDict()){
    		return "Dictator";
    	}
    	else return "";
    }
    
    public Happiness getHappiness(){
        return happy;
    }
    
    public int getPow(){
    	return happy.getPow();
    }
    
    public int getWel(){
    	return happy.getWel();
    }
    
    public int getSol(){
    	return happy.getSol();
    }
    
    public String getName(){
    	return name;
    }

    public void startCountry(){

    }

    public void joinCountry(){

    }
}
