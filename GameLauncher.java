import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Dimension;

public class GameLauncher extends JFrame{

	private static JMenuBar menu;
	
    public GameLauncher(){
    	menu = new JMenuBar();
    	menu.add(createFileMenu());
    	menu.add(createEditMenu());
    	menu.add(createCharMenu());
    	menu.add(createHelpMenu());
    }
    
    public JMenu createFileMenu(){
    	JMenu file = new JMenu("File");
        file.add(createNewGame());
        file.add(createSaveItem());
        file.add(createLoadItem());
        file.add(createExitItem());
        return file;
    }
    
    public JMenuItem createNewGame(){
    	JMenuItem nGame = new JMenuItem("New Game");
    	return nGame;
    }
    
    public JMenuItem createSaveItem(){
    	JMenuItem save = new JMenuItem("Save");
    	return save;
    }
    
    public JMenuItem createLoadItem(){
    	JMenuItem load = new JMenuItem("Load");
    	return load;
    }
    
    public JMenuItem createExitItem(){
    	JMenuItem exit = new JMenuItem("Exit");
    	return exit;
    }
    
    public JMenu createEditMenu(){
    	JMenu edit = new JMenu("Edit");
    	edit.add(createEditItem());
    	return edit;
    }
    
    public JMenuItem createEditItem(){
    	JMenuItem edit = new JMenuItem("Edit");
    	return edit;
    }
    
    public JMenu createCharMenu(){
    	JMenu character = new JMenu("Character");
    	character.add(createNewChar());
    	character.add(createEditChar());
    	return character;
    }
    
    public JMenuItem createNewChar(){
    	JMenuItem nChar = new JMenuItem("New Character");
    	return nChar;
    }
    
    public JMenuItem createEditChar(){
    	JMenuItem eChar = new JMenuItem("Edit Character");
    	return eChar;
    }
    
    public JMenu createHelpMenu(){
    	JMenu help = new JMenu("Help");
        help.add(createRulesFrame());
        help.add(createAboutFrame());
        return help;
    }
    
    public JMenuItem createRulesFrame(){
    	JMenuItem rules = new JMenuItem("Rules");
    	return rules;
    }
    
    public JMenuItem createAboutFrame(){
    	JMenuItem about = new JMenuItem("About");
    	return about;
    }
        
    public static void main(String[] args){
    	JFrame frame = new JFrame();
    	frame.setJMenuBar(menu);
        frame.setSize(new Dimension(500, 500));
        frame.setTitle("Game Launcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}