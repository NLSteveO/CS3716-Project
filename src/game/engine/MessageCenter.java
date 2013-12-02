package game.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MessageCenter extends JPanel{

	private String messages;
	
	public MessageCenter(){
		messages = "Messages will be displayed here.";
	}
	
	public void sendMsg(String msg){
		messages = msg;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString(messages, 0, 0);
	}

}
