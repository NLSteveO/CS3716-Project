package game.engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public abstract class Game implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener{

	protected boolean over;
	protected int delay = 30;
	protected int width = 400, height = 300;
	protected String title = "My Game";
	
	public boolean isOver(){ return over; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	public String getTitle(){ return title; }
	public long getDelay(){	return delay; }
	public void resize(int width, int height){}
	
	public void init(){}
	abstract public void update();
	abstract public void draw(Graphics2D g);
	
	public void mouseDragged(MouseEvent e) {
	}

	
	public void mouseMoved(MouseEvent e) {
	}

	
	public void mouseClicked(MouseEvent e) {
	}

	
	public void mouseEntered(MouseEvent e) {
	}

	
	public void mouseExited(MouseEvent e) {
	}

	
	public void mousePressed(MouseEvent e) {
	}

	
	public void mouseReleased(MouseEvent e) {
	}

	
	public void keyPressed(KeyEvent e) {
	}

	
	public void keyReleased(KeyEvent e) {
	}

	 
	public void keyTyped(KeyEvent e) {
	}
	
	public void mouseWheelMoved(MouseWheelEvent e){
	}

}
