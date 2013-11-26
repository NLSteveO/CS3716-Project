import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.game.engine.Game;
import org.game.engine.GameApplication;

public class Play extends Game {
	
	public static void main(String[] args) {
		GameApplication.start(new Play());
	}
	
	BufferedImage man;
	BufferedImage map;
	int frame, c;
	int reqDir, curDir;
	int column, row;
	int columns, rows;
	boolean placed = false;
		
	public Play() {
		title = "Play";
		frame = 0;
		c = 0;
		curDir = reqDir = KeyEvent.VK_RIGHT;
		width = 800;
		height = 608;
		try {
			man = ImageIO.read(new File("images/mana.png"));
			map = ImageIO.read(new File("images/MapImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mouseClicked(MouseEvent e){
		if (!placed) placed = true;
		int a = e.getX();
		int b = e.getY();
		if (map.getRGB(a, b) != -12086273){
			column = a;
			row = b;
		}
		System.out.println(a + "  " + b);
		System.out.println(column + "  " + row + " " + rows);
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
		if (placed){
			g.drawImage(man.getSubimage((c)*24, (curDir-37)*29, 25, 28),  column-13,  row-14,  null);
		}
	}

}
