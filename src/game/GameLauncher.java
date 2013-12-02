package game;

import game.character.*;
import game.character.Character;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Scanner;

@SuppressWarnings("serial")
public class GameLauncher extends JFrame{

	static GameLauncher game;
	private BackgroundPanel bg;
	private Dimension size;
	private JFrame frame;
	private JMenuBar menu;
	private JMenu file, /**editMenu,*/ character, help;
	private JMenuItem nGame, save, load, exit, /**edit,*/ nChar, sChar, eChar, rules, about;
	private Character[] charName;
	private int numChar = 0;
	
    public GameLauncher(){
    	super("Game Launcher");
    	size = new Dimension(720, 560);
        setSize(size);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        charName = new Character[100];
    	
		bg = new BackgroundPanel("src/Images/flag.jpg", size);
		add(bg);
		add(new JPanel());
        
    	menu = new JMenuBar();
    	menu.add(createFileMenu());
    	//menu.add(createEditMenu());
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
            	if (charName[0] == null){
            	    createFrame("Error", new Dimension(410, 100));
            		frame.add(new JLabel("You must first create or select a character before starting a new game."));
            	}
            	else {
            		Play.main(charName);
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
   				//    JFileChooser fc = new JFileChooser("src/resources/Saves/");
               // int returnVal = fc.showSaveDialog(GameLauncher.this);
                   /** if (returnVal == JFileChooser.APPROVE_OPTION) {
                    	File file = fc.getSelectedFile();
						Coord[][] m = new Coord[map.getSize()][map.getSize()];
						m = map.getCoordinates();
                    	save(m, file);
                    }*/
            }
         }
         ActionListener listener = new MenuItemListener();
         save.addActionListener(listener);
    	return save;
    }
    
    /**public void save(Coord[][] s, File f){
		try {
			File file;
		      if (f.getName().contains(".txt")){
				    file = new File(f.getName());
				}
			   else{
				    file = new File(f + ".txt");
			   }
		    PrintWriter newChar = new PrintWriter(file);
		    newChar.println(s.length);
			for (int j = 0; j < map.getSize(); j++){
				for (int i = 0; i < map.getSize(); i++){
					if (s[i][j].hasTerritory()){
						newChar.print("G");
					}
					else {
						newChar.print("B");
					}
					if (i == map.getSize()-1)
						newChar.println();
				}
		     }
			  newChar.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	     
	}*/
    
    public JMenuItem createLoadItem(){
    	load = new JMenuItem("Load");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
             //   JFileChooser fc = new JFileChooser("src/resources/Saves/");
            	/**if (charName == null){
            	    createFrame("Error", new Dimension(410, 100));
            		frame.add(new JLabel("You must first create or select a character before loading a game."));
            	}
            	else {
   					 int returnVal = fc.showOpenDialog(GameLauncher.this);
   					     if (returnVal == JFileChooser.APPROVE_OPTION){
							try{
								File file = fc.getSelectedFile();
								Scanner in = new Scanner(file);
								int size = in.nextInt();
						    	Coord[][] coord = new Coord[size][size];
						    	while (in.hasNext()){
						    		for(int i=0;i<size;i++){
							    		String s = in.next();
						    			for(int j=0;j<size;j++){
						    				coord[j][i] = new Coord(i, j);
						    				if (s.substring(j, j+1).equals("G")){
						    					coord[j][i].setTerritory(new Territory());}
						    			}
						    		}
						    	}
						    	in.close();
						    	Map m = new Map(coord);
						    	Dimension s = new Dimension((size*50)+6, (size*50)+28);
						    	createFrame("Map", s);
						    	MapPanel map = new MapPanel(m, s);
						    	frame.add(map);
							}catch(FileNotFoundException e){
								e.printStackTrace();
							}
							
   						  }
            	}*/
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
    
    /**public JMenu createEditMenu(){
    	editMenu = new JMenu("Country");
    	editMenu.add(createEditItem());
    	return editMenu;
    }
    
    public JMenuItem createEditItem(){
    	edit = new JMenuItem("Settle Country");
    	return edit;
    }*/
    
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
            	createFrame("New Character", new Dimension(500, 500));
            	NewCharacter newC = new NewCharacter(frame);
            	frame.add(newC.panel());
            }
         }
         ActionListener listener = new MenuItemListener();
         nChar.addActionListener(listener);
    	return nChar;
    }
        
    public JMenuItem createSelectChar(){
    	sChar = new JMenuItem("Add Character");
        class MenuItemListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
            		String path = GameLauncher.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            		String newPath = "";
            		try {
						newPath = URLDecoder.decode(path, "UTF-8");
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}
            		File f = new File(newPath + "./Characters/");
            		f.mkdirs();
					JFileChooser fc = new JFileChooser(f);
					fc.setMultiSelectionEnabled(true);
					int returnVal = fc.showOpenDialog(GameLauncher.this);
					if (returnVal == JFileChooser.APPROVE_OPTION){
						File[] file = fc.getSelectedFiles();
						Scanner in;
						for (int i = 0; i < file.length; i++){
						try {
							in = new Scanner(file[i]);
							String name = in.nextLine();
							int pow = Integer.parseInt(in.nextLine());
							int wel = Integer.parseInt(in.nextLine());
							int sol = Integer.parseInt(in.nextLine());
							Happiness happy = new Happiness(pow, wel, sol);
							Character c = new Character(name, happy);
							charName[numChar] = c;
							numChar++;
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}					}}
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
            	String path = GameLauncher.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            	String newPath = "";
            	try {
					newPath = URLDecoder.decode(path, "UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
            	File f = new File(newPath + "./Characters/");
            	f.mkdirs();
            	JFileChooser fc = new JFileChooser(f);
				int returnVal = fc.showOpenDialog(GameLauncher.this);
				if (returnVal == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					Scanner in;
					try {
						in = new Scanner(file);
						String name = in.nextLine();
						int pow = Integer.parseInt(in.nextLine());
						int wel = Integer.parseInt(in.nextLine());
						int sol = Integer.parseInt(in.nextLine());
						Happiness happy = new Happiness(pow, wel, sol);
						Character c = new Character(name, happy);
						createFrame("Edit Character", new Dimension(500, 500));
						NewCharacter newC = new NewCharacter(frame);
						newC.load(c);
						frame.add(newC.panel());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
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
               JPanel rulesPanel = new JPanel(new GridLayout(5, 0));
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