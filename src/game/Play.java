package game;
import game.map.Map;
import game.map.Territory;

import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import game.character.Character;
import game.country.Country;
import game.engine.Game;
import game.engine.GameApplication;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Play extends Game{
	
	public static void main(Character[] ch) {
		Play p = new Play(ch);
		GameApplication.start(p);
	}
	
	private BufferedImage[] man = new BufferedImage[4];
	private BufferedImage map;
	private int frame, c;
	private int curDir;
	private Map m = new Map();
	private Character[] characters;
	private int turnNum, numChar;
	private Character turn, settler;
	private List<JFrame> popFrame;
	private boolean isAnyoneSettling = false;
	private int numFrame=-1;
	private JTextField countryName,governmentName;
	private String curGovType;

	public Play(Character[] ch) {
		popFrame = new ArrayList<JFrame>();
		characters = ch;
		title = "Play";
		frame = 0;
		c = 0;
		curDir = KeyEvent.VK_RIGHT;
		width = 800;
		height = 608;
		turnNum = 0;
		turn = characters[turnNum];
		try {
			man[0] = ImageIO.read(getClass().getResource("/Images/man1.png"));
			man[1] = ImageIO.read(getClass().getResource("/Images/man2.png"));
			man[2] = ImageIO.read(getClass().getResource("/Images/man3.png"));
			man[3] = ImageIO.read(getClass().getResource("/Images/man4.png"));
			map = ImageIO.read(getClass().getResource("/Images/MapImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Character x : characters){
			if (x != null) numChar++;
		}
		updateMSG("Player " + turn.getName() + " 's turn.");
	}
	
	public void nextTurn(){
		turnNum++;
		if (turnNum >= numChar) turnNum = 0;
		turn = characters[turnNum];
		updateMSG("Player " + turn.getName() + " 's turn.");
		
		for(int i = 0; i < numChar; i++){
			if (characters[i].getSettle()){
				isAnyoneSettling=true;
				break;
			}
			else
				isAnyoneSettling=false;
		}
		
		/**if (turn.timeUp()){
			turn.changeSettle(false);
			System.out.println("time up");
		}*/
		
		if(turn.getSettle()){
			if(turn.isAllowed()){
				System.out.println("settle");
				turn.changeSettle(false);
				// DISPLAY A FRAME WHICH ALLOWS THE PLAYER TO CREATE HIS COUNTRY
				numFrame++;
				createCountry();
			}
			else denyCountry();
		}
		
		ArrayList<Territory> neighbours = new ArrayList<Territory>();
		if (turn.getPlaced()){
			neighbours = turn.getLocation().getNeighbours();
			neighbours.add(turn.getLocation());
		}
		if(isAnyoneSettling){
			for(int i = 0; i < numChar; i++){
				for(Territory t: neighbours){
					if(characters[i].getLocation().equals(t) && characters[i].getSettle() && !characters[i].equals(turn)){
						//DISPLAY THE FRAME WHICH ALLOWS NEIGHBOURS TO ALLOW OR DENY COUNTRIES 
						// NEAR THEM
						numFrame++;
						settler = characters[i];
						System.out.println(settler.getName());
						countryFrame(t,characters[i]);
						
				}
			}
		}
	}
		
		
	}
	
	public void updateMSG(String t){
		System.out.println(t);	//for debugging
		GameApplication.updateMSG(t);
	}
	
	public void mouseClicked(MouseEvent e){
		int a = e.getX();
		int b = e.getY();
		if (map.getRGB(a, b) != -12086273){
			if (!characters[turnNum].getPlaced()){
				characters[turnNum].setPlaced();
				characters[turnNum].setCoord(a, b);
				characters[turnNum].setLocation(m.getTerrbyCoord(a, b));
				System.out.println(characters[turnNum].getLocation().getName());
				nextTurn();
			}
			else{
				Territory t = m.getTerrbyCoord(a, b);
				if (characters[turnNum].getLocation() == t || characters[turnNum].getLocation().isNeighbour(t)){// && characters[turnNum].getPlaced()){
					characters[turnNum].setCoord(a, b);
					characters[turnNum].setLocation(m.getTerrbyCoord(a, b));
					nextTurn();
				}
			}
		}
	}

	
	public void settleCountry(String t){
		characters[turnNum].getLocation().setOccupied();
		Country c = new Country(characters[turnNum].getLocation(), characters[turnNum], t);
		characters[turnNum].getLocation().setCountry(c);
		updateMSG(turn.getName() + " has settled " + c.getName() + " in " + c.getTerr().getName());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_S && !characters[turnNum].getLocation().isOccupied()){
			updateMSG(characters[turnNum].getName() + " is attempting to settle a Country");
			isAnyoneSettling=true;
			turn.changeSettle(true);
			nextTurn();
		}
		else if (e.getKeyCode() == KeyEvent.VK_G && characters[turnNum].getLocation().isOccupied()){
			System.out.println("Establish Government");
			if(characters[turnNum].getLocation().isOccupied() && characters[turnNum].getLocation().getCountry().getGovType()==-1){
				updateMSG(characters[turnNum].getName()+" is creating a government for "+characters[turnNum].getLocation().getCountry().getName());
				numFrame++;
				createGovernment();
				}
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_E){
			System.out.println("Start Election");
		}
		else if (e.getKeyCode() == KeyEvent.VK_F){
			System.out.println(characters[turnNum].getLocation().getName());
		}
	}
	
	@Override
	public void update() {
		frame++;
		if (frame == 3){
			c++;
			if (c > 1){
				c = 0;
			}
		}
		if (frame > 5) {
			frame = 0;
		}
	}
	
	public void createCountry(){
		createFrame("Settling Country.", new Dimension(400, 200));
		popFrame.get(numFrame).setDefaultCloseOperation(0);
		JPanel main = new JPanel(new GridLayout(3,1));
		JTextArea text = new JTextArea("Congratulations you have just settled a country.\n Now give it a name.");
		text.setLineWrap(true);
		text.setEditable(false);
		main.add(text);
		JPanel namePan = new JPanel();
		namePan.add(new JLabel("Enter Name:"));
		countryName = new JTextField();
		countryName.setColumns(15);
		namePan.add(countryName);
		main.add(namePan);
		JButton ok = new JButton("Ok");
		ok.setActionCommand("ok");
		ok.addActionListener(new CountryButtonListener());
		main.add(ok);
		popFrame.get(numFrame).add(main);
	}
	
	public void denyCountry(){
		createFrame("Country Denied", new Dimension (400,200));
		popFrame.get(numFrame).setDefaultCloseOperation(0);
		JPanel main = new JPanel(new GridLayout(3,1));
		JTextArea text = new JTextArea("Sorry you're not allowed to start a country here, so sayeth the masses");
		text.setLineWrap(true);
		text.setEditable(false);
		main.add(text);
		JButton cont = new JButton("continue");
		cont.setActionCommand("continue");
		cont.addActionListener(new CountryButtonListener());
		main.add(cont);
		popFrame.get(numFrame).add(main);
	}
	public void createGovernment(){
		createFrame("Choose Government Type.", new Dimension(400, 300));
		popFrame.get(numFrame).setDefaultCloseOperation(0);
		JPanel main = new JPanel(new GridLayout(3,1));
		JTextArea text = new JTextArea("You are establishing a Government.\n Now what will you be called.");
		text.setLineWrap(true);
		text.setEditable(false);
		main.add(text);
		JPanel namePan = new JPanel();
		namePan.add(new JLabel("Enter Name:"));
		governmentName = new JTextField();
		governmentName.setColumns(15);
		namePan.add(governmentName);
		main.add(namePan);
		JPanel choosePan = new JPanel();
		String[] types = {"Democracy","Dictatorship"};
		JComboBox govStuff = new JComboBox(types);
		govStuff.setSelectedIndex(-1);
		govStuff.addActionListener(new GovChoiceListener());
		choosePan.add(govStuff);
		main.add(choosePan);
		JButton ok = new JButton("Ok");
		ok.setActionCommand("ok");
		ok.addActionListener(new GovernmentButtonListener());
		main.add(ok);
		popFrame.get(numFrame).add(main);
	}
	
	class GovChoiceListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JComboBox breaker = (JComboBox)e.getSource();
			String govType = (String)breaker.getSelectedItem();
			if(govType.toLowerCase().equals("democracy")){
				curGovType="democracy";
			}
			else 
				curGovType="dictatorship";
		}
	}
	
	
	public void countryFrame(Territory t, Character c){
		createFrame("Settling Country.", new Dimension(200, 150));
		popFrame.get(numFrame).setDefaultCloseOperation(0);
		JPanel main = new JPanel(new GridLayout(2,1));
		JTextArea text = new JTextArea(c.getName() + " would like to settle a country in " + t.getName() + ".\n Do you oppose?");
		text.setLineWrap(true);
		text.setEditable(false);
		main.add(text);
		JPanel buttons = new JPanel();
		JButton yes = new JButton("Yes");
		yes.setActionCommand("yes");
		yes.addActionListener(new CountryButtonListener());
		JButton no = new JButton("No");
		no.setActionCommand("no");
		no.addActionListener(new CountryButtonListener());
		buttons.add(no);
		buttons.add(yes);
		main.add(buttons);
		popFrame.get(numFrame).add(main);
	}
	
	
		class GovernmentButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if("ok".equals(e.getActionCommand())){
				System.out.println(governmentName.getText() +"\n" + curGovType);
				turn.getLocation().getCountry().setGovernment(curGovType,governmentName.getText());
				popFrame.get(numFrame).dispose();
				popFrame.remove(numFrame);
				numFrame--;
				if( characters[turnNum].getLocation().getCountry().getGovType()==0)
					updateMSG("New Democracy is "+ characters[turnNum].getLocation().getCountry().getDemocracy().getName());
				if( characters[turnNum].getLocation().getCountry().getGovType()==1)
					updateMSG("New Dictatorship is "+ characters[turnNum].getLocation().getCountry().getDictatorship().getName());
				nextTurn();
			}
		}
	}
	
	class CountryButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if ("yes".equals(e.getActionCommand())){
				settler.voteNotAllowed();
				popFrame.get(numFrame).dispose();
				popFrame.remove(numFrame);
				numFrame--;
			}
			else if ("no".equals(e.getActionCommand())){
				settler.voteAllowed();
				popFrame.get(numFrame).dispose();
				popFrame.remove(numFrame);
				numFrame--;
			}
			else if ("ok".equals(e.getActionCommand())){
				settleCountry(countryName.getText());
				popFrame.get(numFrame).dispose();
				popFrame.remove(numFrame);
				numFrame--;
			}
			else if("continue".equals(e.getActionCommand())){
				popFrame.get(numFrame).dispose();
				popFrame.remove(numFrame);
				numFrame--;
			}
		}
	}
	
	public void createFrame(String title, Dimension size){
    	popFrame.add(new JFrame(title));
    	popFrame.get(numFrame).setSize(size);
    	popFrame.get(numFrame).setLocationRelativeTo(null);
    	popFrame.get(numFrame).setResizable(false);
    	popFrame.get(numFrame).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	popFrame.get(numFrame).setVisible(true);
    }

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(map, 0, 0, null);
		for(int i = 0; i < numChar; i++){
			if (characters[i].getPlaced()){
				g.drawImage(man[i%4].getSubimage((c)*24, (curDir-37)*29, 25, 28),  characters[i].getCoord().getX()-13,  characters[i].getCoord().getY()-14,  null);
			}
		}
	}

}
