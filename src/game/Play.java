import game.map.Map;
import game.map.Territory;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import game.character.Character;

import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.game.engine.Game;
import org.game.engine.GameApplication;
import org.game.engine.MessageCenter;

public class Play extends Game {
	
	public static void main(String[] args) {
		GameApplication.start(new Play(character));
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
			man[0] = ImageIO.read(new File("images/man1.png"));
			man[1] = ImageIO.read(new File("images/man2.png"));
			man[2] = ImageIO.read(new File("images/man3.png"));
			man[3] = ImageIO.read(new File("images/man4.png"));
			map = ImageIO.read(new File("images/MapImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Character x : characters){
			if (x != null) numChar++;
		}
		System.out.println("Player " + turn.getName() + "'s turn..");
	}
	
	public void nextTurn(){
		turnNum++;
		if (turnNum >= numChar) turnNum = 0;
		turn = characters[turnNum];
		System.out.println("Player " + turn.getName() + "'s turn.");
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

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_E){
			System.out.println("hey");
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
