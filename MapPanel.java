import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Rectangle;



import game.map.*;

public class MapPanel extends JPanel {
	Dimension WinDem;
	Dimension TerDem;
	Map gameMap;
	int numTer;
	int dimense;
	
	public MapPanel(Dimension size, int numTer, int dimense){
		WinDem=size;
		this.numTer=numTer;
		this.dimense=dimense;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		
		
		
	}
	
	
	public Rectangle[][] drawMap(int Dimense, int numTer){
		gameMap = new Map(numTer,Dimense);
		TerDem = new Dimension ((int)WinDem.getHeight()/numTer, (int)WinDem.getWidth()/numTer);
		Coord[][] coord = gameMap.getCoordinates();
		Rectangle[][] squareArray= new Rectangle[coord.length][coord.length];
		for(int i=0; i<coord.length;i++){
			for(int j=0; j<coord.length;j++){
				squareArray[i][j]= new Rectangle(i*TerDem.width,j*TerDem.height,TerDem.width,TerDem.height);
			}
			
		}
		return squareArray;
	}
	
	public void paintComponent(Graphics g){
		Rectangle[][] rect = drawMap(dimense, numTer);
		for(int i=0;i<rect.length;i++){
			for(int j=0;j<rect.length;j++){
				if((gameMap.getCoordinates())[i][j].hasTerritory())
					g.setColor(Color.green);
				else
					g.setColor(Color.blue);
				
				g.drawRect((int)rect[i][j].getX(), (int)rect[i][j].getY(), rect[i][j].width, rect[i][j].width);
			}
		}
		
	}
	
}