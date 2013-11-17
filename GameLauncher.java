import game.character.NewCharacter;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

@SuppressWarnings("serial")
public class GameLauncher extends JFrame{

	static GameLauncher game;
	private Dimension size;
	private JFrame frame;
	private JMenuBar menu;
	private JMenu file, editMenu, character, help;
	private JMenuItem nGame, save, load, exit, edit, nChar, sChar, eChar, rules, about;
	private int selectedChar = 0;
	
    public GameLauncher(){
    	super("Game Launcher");
    	size = new Dimension(720, 560);
        setSize(size);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        BackgroundPanel bg = new BackgroundPanel("./Images/flag.jpg", size);
    	add(bg);
    	add(new JPanel());
        
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
    	class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
            	if (selectedChar == 0){
            	    createFrame("Error", new Dimension(300, 300));
            		frame.add(new JLabel("You must first create or select a character before starting a new game."));
            	}
            	else {
            		createFrame("New Game", new Dimension(300, 300));
            	}
            }
        }
        ActionListener listener = new MenuItemListener();
        nGame.addActionListener(listener);
    	return nGame;
    }
    
    public JMenuItem createSaveItem(){
    	save = new JMenuItem("Save");
    	class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
   				    JFileChooser fc = new JFileChooser("./Saves/");
                int returnVal = fc.showSaveDialog(GameLauncher.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
   						      @SuppressWarnings("unused")
							File file = fc.getSelectedFile();
                    }
            }
         }
         ActionListener listener = new MenuItemListener();
         save.addActionListener(listener);
    	return save;
    }
    
    public JMenuItem createLoadItem(){
    	load = new JMenuItem("Load");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                JFileChooser fc = new JFileChooser("./Saves/");
   					 int returnVal = fc.showOpenDialog(GameLauncher.this);
   					     if (returnVal == JFileChooser.APPROVE_OPTION){
   						      @SuppressWarnings("unused")
							File file = fc.getSelectedFile();
   						  }
            }
         }
         ActionListener listener = new MenuItemListener();
         load.addActionListener(listener);
    	return load;
    }
    
    public JMenuItem createExitItem(){
    	exit = new JMenuItem("Exit");
    	class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
               System.exit(0);
            }
         }
         ActionListener listener = new MenuItemListener();
         exit.addActionListener(listener);
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
    	character.add(createSelectChar());
    	character.add(createEditChar());
    	return character;
    }
    
    public JMenuItem createNewChar(){
    	nChar = new JMenuItem("New Character");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
            	NewCharacter newC = new NewCharacter();
            	createFrame("New Character", new Dimension(500, 500));
            	frame.add(newC);
            }
         }
         ActionListener listener = new MenuItemListener();
         nChar.addActionListener(listener);
    	return nChar;
    }
    
    public JMenuItem createSelectChar(){
    	sChar = new JMenuItem("Select Character");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
					JFileChooser fc = new JFileChooser("./Characters/");
					int returnVal = fc.showOpenDialog(GameLauncher.this);
					if (returnVal == JFileChooser.APPROVE_OPTION){
					    @SuppressWarnings("unused")
						File file = fc.getSelectedFile();
					}
            }
         }
         ActionListener listener = new MenuItemListener();
         sChar.addActionListener(listener);
    	return sChar;
    }
    
    public JMenuItem createEditChar(){
    	eChar = new JMenuItem("Edit Character");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
            	
            }
         }
         ActionListener listener = new MenuItemListener();
         eChar.addActionListener(listener);
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
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
               JPanel rulesPanel = new JPanel();
               rulesPanel.add(new JLabel("The"));
               rulesPanel.add(new JLabel("Rules"));
               rulesPanel.add(new JLabel("Will"));
               rulesPanel.add(new JLabel("Go"));
               rulesPanel.add(new JLabel("Here!"));
               createFrame("Rules", new Dimension(250, 150));
               frame.add(rulesPanel);
            }
         }
         ActionListener listener = new MenuItemListener();
         rules.addActionListener(listener);
    	return rules;
    }
    
    public JMenuItem createAboutFrame(){
    	about = new JMenuItem("About");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
               JPanel main = new JPanel();
               main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
               main.add(new JLabel("About:"));
               main.add(new JLabel("Created by: Stephen O'Keefe, Brandon Bemister, Tim Murray, and Scott Maher"));
               main.add(new JLabel("Student Number: 200644979, 201121159, 201129574, and 201004603"));
               main.add(new JLabel("Created for Computer Science 3716"));
               main.add(new JLabel("Instructor: Dr. Fiech"));
               createFrame("About", new Dimension(550, 150));
               frame.add(main);
            }
         }
         ActionListener listener = new MenuItemListener();
         about.addActionListener(listener);
    	return about;
    }
    
    public void createFrame(String title, Dimension size){
    	frame = new JFrame(title);
    	frame.setSize(size);
    	frame.setLocationRelativeTo(null);
    	frame.setResizable(false);
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.setVisible(true);
    }
        
    public static void main(String[] args){
    	SwingUtilities.invokeLater(new Runnable(){
    		public void run(){game = new GameLauncher();}
    	});
    }
}