package org.game.engine;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameApplication {

	static public void start(final Game game){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new JFrame(game.getTitle());
				frame.setSize(game.getWidth()+12, game.getHeight()+30);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				GameCanvas canvas = new GameCanvas();
				canvas.setGame(game);
				frame.add(canvas);
				frame.setVisible(true);
				canvas.requestFocus();
				new GameLoop(game, canvas).start();
			}
		});
	}
}
