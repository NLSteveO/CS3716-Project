package org.game.engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameApplication {

	static public void start(final Game game){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new JFrame(game.getTitle());
				JPanel main = new JPanel();
				JPanel msg = new JPanel();
				main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
				main.setMaximumSize(new Dimension(game.getWidth()+12, game.getHeight()+80));
				main.setMinimumSize(new Dimension(game.getWidth()+12, game.getHeight()+80));
				main.setPreferredSize(new Dimension(game.getWidth()+12, game.getHeight()+80));
				msg.setMaximumSize(new Dimension(game.getWidth()+12, 50));
				msg.setMinimumSize(new Dimension(game.getWidth()+12, 50));
				msg.setPreferredSize(new Dimension(game.getWidth()+12, 50));
				frame.setSize(game.getWidth()+12, game.getHeight()+80);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				GameCanvas canvas = new GameCanvas();
				MessageCenter mc = new MessageCenter();
				canvas.setGame(game);
				msg.add(mc);
				main.add(canvas);
				main.add(msg);
				frame.add(main);
				frame.setVisible(true);
				canvas.requestFocus();
				new GameLoop(game, canvas).start();
			}
		});
	}
}
