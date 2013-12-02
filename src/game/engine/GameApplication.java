package game.engine;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;

public class GameApplication {
        
        static JPanel main = new JPanel();
        static JPanel msg = new JPanel();
        static JTextArea mc = new JTextArea("Start Game!");
        
        public static void updateMSG(String t){
                mc.setText(mc.getText()+"\n"+t);
                }

        static public void start(final Game game){
                SwingUtilities.invokeLater(new Runnable(){
                        public void run(){
                                JFrame frame = new JFrame(game.getTitle());
                                main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
                                main.setMaximumSize(new Dimension(game.getWidth()+12, game.getHeight()+80));
                                main.setMinimumSize(new Dimension(game.getWidth()+12, game.getHeight()+80));
                                main.setPreferredSize(new Dimension(game.getWidth()+12, game.getHeight()+80));
                                msg.setMaximumSize(new Dimension(game.getWidth()+12, 50));
                                msg.setMinimumSize(new Dimension(game.getWidth()+12, 50));
                                msg.setPreferredSize(new Dimension(game.getWidth()+12, 50));
                                frame.setSize(game.getWidth()+12, game.getHeight()+80);
                                frame.setResizable(false);
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                GameCanvas canvas = new GameCanvas();
                                canvas.setGame(game);
                                mc.setColumns(30);
                                mc.setRows(3);
                                JScrollPane scrollPane = new JScrollPane(mc); 
                                mc.setEditable(false);
                                String hots="";
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