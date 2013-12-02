package org.game.engine;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MessageCenter extends JPanel{

	private JTextArea messages;
	
	public MessageCenter(){
		messages = new JTextArea();
		add(messages);
	}
	
	public void sendMsg(String msg){
		messages.setText(msg);
	}

}
