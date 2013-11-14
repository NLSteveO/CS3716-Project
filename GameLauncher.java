import javax.swing.JFrame;
import java.awt.Dimension;

public class GameLauncher extends JFrame{

    public GameLauncher(){}
    
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));
        frame.setTitle("Game Launcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}