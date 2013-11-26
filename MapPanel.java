import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.map.*;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	/*Dimension WinDem;
	Dimension TerDem;
	Map gameMap;
	int numTer;
	int dimense;
	Rectangle[][] squareArray;
	
	public MapPanel(Dimension size, int numTer, int dimense){
		WinDem=size;
		this.numTer=numTer;
		this.dimense=dimense;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(new FlowLayout());
		drawMap(dimense, numTer);
	}
	
	public MapPanel(Map m, Dimension size){
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(new FlowLayout());
		loadMap(m);
	}
	
	public void loadMap(Map m){
		gameMap = m;
		Coord[][] coord = gameMap.getCoordinates();
		squareArray= new Rectangle[coord.length][coord.length];
		for(int i=0; i<coord.length;i++){
			for(int j=0; j<coord.length;j++){
				squareArray[i][j]= new Rectangle(i*50,j*50,50,50);
			}
		}
	}
	
	public Map getMap(){
		return gameMap;
	}
	
	
	public void drawMap(int Dimense, int numTer){
		gameMap = new Map(numTer,Dimense);
		TerDem = new Dimension ((int)WinDem.getHeight()/numTer, (int)WinDem.getWidth()/numTer);
		Coord[][] coord = gameMap.getCoordinates();
		squareArray= new Rectangle[coord.length][coord.length];
		for(int i=0; i<coord.length;i++){
			for(int j=0; j<coord.length;j++){
				squareArray[i][j]= new Rectangle(i*50,j*50,50,50);
			}
			
		}
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent( g );
		for(int i=0;i<squareArray.length;i++){
			for(int j=0;j<squareArray.length;j++){
				if((gameMap.getCoordinates())[i][j].hasTerritory()){
					g.setColor(Color.green);}
				else
					g.setColor(Color.blue);
				
				g.fillRect((int)squareArray[i][j].getX(), (int)squareArray[i][j].getY(), (int)squareArray[i][j].getWidth(), (int)squareArray[i][j].getHeight());
				//g.setColor(Color.black);
				//g.drawRect((int)squareArray[i][j].getX(), (int)squareArray[i][j].getY(), (int)squareArray[i][j].getWidth(), (int)squareArray[i][j].getHeight());
			}
		}
	}
*/	
}
