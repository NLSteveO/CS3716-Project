

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GameLauncher extends JFrame{

	static GameLauncher game;
	private Dimension size;
	private JMenuBar menu;
	private JMenu file, editMenu, character, help;
	private JMenuItem nGame, save, load, exit, edit, nChar, eChar, rules, about;
	
    public GameLauncher(){
    	super("Game Launcher");
    	size = new Dimension(720, 560);
        setSize(size);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        BackgroundPanel bg = new BackgroundPanel("./Images/flag.jpg", size);
    	add(bg);
        
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
    	class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
   				    JFileChooser fc = new JFileChooser("./Saves/");
                int returnVal = fc.showSaveDialog(GameLauncher.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
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
    	character.add(createEditChar());
    	return character;
    }
    
    public JMenuItem createNewChar(){
    	nChar = new JMenuItem("New Character");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
            }
         }
         ActionListener listener = new MenuItemListener();
         nChar.addActionListener(listener);
    	return nChar;
    }
    
    public JMenuItem createEditChar(){
    	eChar = new JMenuItem("Edit Character");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
   					JFileChooser fc = new JFileChooser("./Characters/");
   					int returnVal = fc.showOpenDialog(GameLauncher.this);
   					if (returnVal == JFileChooser.APPROVE_OPTION){
   					    File file = fc.getSelectedFile();
   					}
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
               JFrame rulesFrame = new JFrame("Rules");
               JPanel rulesPanel = new JPanel();
               rulesPanel.add(new JLabel("The"));
               rulesPanel.add(new JLabel("Rules"));
               rulesPanel.add(new JLabel("Will"));
               rulesPanel.add(new JLabel("Go"));
               rulesPanel.add(new JLabel("Here!"));
               rulesFrame.add(rulesPanel);
               rulesFrame.setSize(250, 150);
               rulesFrame.setLocationRelativeTo(null);
               rulesFrame.setResizable(false);
               rulesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               rulesFrame.setVisible(true);
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
               JFrame aboutFrame = new JFrame();
               JPanel main = new JPanel();
               main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
               main.add(new JLabel("About:"));
               main.add(new JLabel("Created by: Stephen O'Keefe, Brandon Bemister, Tim Murray, and Scott Maher"));
               main.add(new JLabel("Student Number: 200644979, 201121159, 201129574, and 201004603"));
               main.add(new JLabel("Created for Computer Science 3716"));
               main.add(new JLabel("Instructor: Dr. Fiech"));
               aboutFrame.add(main);
               aboutFrame.setSize(550, 150);
               aboutFrame.setLocationRelativeTo(null);
               aboutFrame.setTitle("About");
               aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               aboutFrame.setVisible(true);
            }
         }
         ActionListener listener = new MenuItemListener();
         about.addActionListener(listener);
    	return about;
    }
        
    public static void main(String[] args){
    	SwingUtilities.invokeLater(new Runnable(){
    		public void run(){game = new GameLauncher();}
    	});
    }
}