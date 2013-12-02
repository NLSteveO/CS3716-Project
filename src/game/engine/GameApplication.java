package game.engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;

public class GameApplication {
        
        static JPanel main = new JPanel();
        static JPanel msg = new JPanel();
        static JTextArea mc = new JTextArea("Start Game!", 3, 30);
        
        public static void updateMSG(String t){
                mc.setText(mc.getText()+"\n"+t);
                }

        static public void start(final Game game){
                SwingUtilities.invokeLater(new Runnable(){
                        public void run(){
                                JFrame frame = new JFrame(game.getTitle());
                                main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
                                main.setMaximumSize(new Dimension(game.getWidth()+12, game.getHeight()+100));
                                main.setMinimumSize(new Dimension(game.getWidth()+12, game.getHeight()+100));
                                main.setPreferredSize(new Dimension(game.getWidth()+12, game.getHeight()+100));
                                msg.setMaximumSize(new Dimension(game.getWidth()+12, 80));
                                msg.setMinimumSize(new Dimension(game.getWidth()+12, 80));
                                msg.setPreferredSize(new Dimension(game.getWidth()+12, 80));
                                frame.setSize(game.getWidth()+1, game.getHeight()+100);
                                frame.setResizable(false);
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                GameCanvas canvas = new GameCanvas();
                                canvas.setGame(game);
                                mc.setLineWrap(true);
                                JScrollPane scrollPane = new JScrollPane(mc); 
                                mc.setEditable(false);
                                String hots="Hot Keys: \n S = Settle Country \n G = Start Government \n E = Start Election";
                                JTextArea hotkey = new JTextArea(hots);
                                hotkey.setEditable(false);
                                msg.add(scrollPane);
                                msg.add(hotkey);
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