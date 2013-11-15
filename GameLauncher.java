import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Dimension;
import javax.swing.SwingUtilities;

public class GameLauncher extends JFrame{

	static GameLauncher game;
	private JMenuBar menu;
	private JMenu file, editMenu, character, help;
	private JMenuItem nGame, save, load, exit, edit, nChar, eChar, rules, about;
	
    public GameLauncher(){
    	super("Game Launcher");
        setSize(new Dimension(500, 500));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	menu = new JMenuBar();
    	menu.add(createFileMenu());
    	menu.add(createEditMenu());
    	menu.add(createCharMenu());
    	menu.add(createHelpMenu());
    	setJMenuBar(menu);
    }
    
    public JMenu createFileMenu(){
    	file = new JMenu("File");
        file.add(createNewGame());
        file.addSeparator();
        file.add(createSaveItem());
        file.add(createLoadItem());
        file.addSeparator();
        file.add(createExitItem());
        return file;
    }
    
    public JMenuItem createNewGame(){
    	nGame = new JMenuItem("New Game");
    	return nGame;
    }
    
    public JMenuItem createSaveItem(){
    	save = new JMenuItem("Save");
    	return save;
    }
    
    public JMenuItem createLoadItem(){
    	load = new JMenuItem("Load");
    	return load;
    }
    
    public JMenuItem createExitItem(){
    	exit = new JMenuItem("Exit");
    	return exit;
    }
    
    public JMenu createEditMenu(){
    	editMenu = new JMenu("Edit");
    	editMenu.add(createEditItem());
    	return editMenu;
    }
    
    public JMenuItem createEditItem(){
    	edit = new JMenuItem("Edit");
    	return edit;
    }
    
    public JMenu createCharMenu(){
    	character = new JMenu("Character");
    	character.add(createNewChar());
    	character.add(createEditChar());
    	return character;
    }
    
    public JMenuItem createNewChar(){
    	nChar = new JMenuItem("New Character");
    	return nChar;
    }
    
    public JMenuItem createEditChar(){
    	eChar = new JMenuItem("Edit Character");
    	return eChar;
    }
    
    public JMenu createHelpMenu(){
    	help = new JMenu("Help");
        help.add(createRulesFrame());
        help.add(createAboutFrame());
        return help;
    }
    
    public JMenuItem createRulesFrame(){
    	rules = new JMenuItem("Rules");
    	return rules;
    }
    
    public JMenuItem createAboutFrame(){
    	about = new JMenuItem("About");
    	return about;
    }
        
    public static void main(String[] args){
    	SwingUtilities.invokeLater(new Runnable(){
    		public void run(){game = new GameLauncher();}
    	});
    }
}