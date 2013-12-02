package game;
import game.map.Map;
import game.map.Territory;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import game.character.Character;
import game.country.Country;
import game.engine.Game;
import game.engine.GameApplication;
import game.engine.MessageCenter;

import javax.imageio.ImageIO;

public class Play extends Game {
	
	public static void main(Character[] ch) {
		Play p = new Play(ch);
		GameApplication.start(p);
	}
	
	BufferedImage[] man = new BufferedImage[4];
	BufferedImage map;
	int frame, c;
	int reqDir, curDir;
	int columns, rows;
	Map m = new Map();
	static Character[] character;
	Character[] characters;
	MessageCenter mc = new MessageCenter();
	int turnNum, numChar;
	Character turn;
		
	public Play(Character[] ch) {
		character = ch;
		characters = ch;
		title = "Play";
		frame = 0;
		c = 0;
		curDir = reqDir = KeyEvent.VK_RIGHT;
		width = 800;
		height = 608;
		turnNum = 0;
		turn = characters[turnNum];
		try {
			man[0] = ImageIO.read(getClass().getResource("/Images/man1.png"));
			man[1] = ImageIO.read(getClass().getResource("/Images/man2.png"));
			man[2] = ImageIO.read(getClass().getResource("/Images/man3.png"));
			man[3] = ImageIO.read(getClass().getResource("/Images/man4.png"));
			map = ImageIO.read(getClass().getResource("/Images/MapImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Character x : characters){
			if (x != null) numChar++;
		}
		System.out.println("Player " + turn.getName() + "'s turn.");
	}
	
	public void nextTurn(){
		turnNum++;
		if (turnNum >= numChar) turnNum = 0;
		turn = characters[turnNum];
		System.out.println("Player " + turn.getName() + "'s turn.");
		updateMSG("Player " + turn.getName() + "'s turn.");
	}
	
	public void updateMSG(String t){
		GameApplication.updateMSG(t);
	}
	
	public void mouseClicked(MouseEvent e){
		int a = e.getX();
		int b = e.getY();
		if (map.getRGB(a, b) != -12086273){
			if (!characters[turnNum].getPlaced()){
				characters[turnNum].setPlaced();
				characters[turnNum].setCoord(a, b);
				characters[turnNum].setLocation(m.getTerrbyCoord(a, b));
				nextTurn();
			}
			else{
				Territory t = m.getTerrbyCoord(a, b);
				if (characters[turnNum].getLocation() == t || characters[turnNum].getLocation().isNeighbour(t)){// && characters[turnNum].getPlaced()){
					characters[turnNum].setCoord(a, b);
					characters[turnNum].setLocation(m.getTerrbyCoord(a, b));
					nextTurn();
				}
			}
		}
	}

	// MAKE CERTIAN WE CHANGE THIS< NOT ALWAYS TRUE
	public boolean askPermissionSettle(){
		return true;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_S && !characters[turnNum].getLocation().isOccupied()){
			if(askPermissionSettle()){
			System.out.println(characters[turnNum].getName() + " Settled a Country");
			characters[turnNum].getLocation().setOccupied();
			Country c = new Country(characters[turnNum].getLocation(), "UnterLand");
			System.out.println(c.getTerr().getName()+"\n"+ c.getName()); //just so its not unused
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_G && characters[turnNum].getLocation().isOccupied()){
			System.out.println("Establish Government");
		}
		else if (e.getKeyCode() == KeyEvent.VK_E){
			System.out.println("Start Election");
		}
		else if (e.getKeyCode() == KeyEvent.VK_F){
			System.out.println(characters[turnNum].getLocation().getName());
		}
	}
	
	@Override
	public void update() {
		frame++;
		if (frame == 3){
			c++;
			if (c > 1){
				c = 0;
			}
		}
		if (frame > 5) {
			frame = 0;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(map, 0, 0, null);
		for(int i = 0; i < numChar; i++){
			if (characters[i].getPlaced()){
				g.drawImage(man[i%4].getSubimage((c)*24, (curDir-37)*29, 25, 28),  characters[i].getCoord().getX()-13,  characters[i].getCoord().getY()-14,  null);
			}
		}
	}

}
