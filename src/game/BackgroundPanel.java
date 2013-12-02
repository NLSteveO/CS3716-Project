package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel{
	
	private Image img;
	
	public BackgroundPanel(String img, Dimension size){
		this(new ImageIcon(img).getImage(), size);
	}
	
	public BackgroundPanel(Image img, Dimension size){
		this.img = img;
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, 700, 500, null);
	}
}