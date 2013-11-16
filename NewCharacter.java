package Character;

// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewCharacter extends JFrame{
    
	//Instance Variables
	private JButton finish;         // finish button
	private JButton close;          // close the program
	private JSlider pwrSlider;      // slider for power happiness
	private JSlider welSlider;      // slider for wealth happiness
	private JSlider solSlider;      // slider for solitude happiness
	private int pwrPos = 0;
	private int welPos = 0;
	private int solPos = 0;
	private JTextField name;        // enter the character name
	private JTextField pwrField;    // text field for power happiness
	private JTextField welField;    // text field for wealth happiness
	private JTextField solField;    // text field for solitude happiness
	
	
	/**
	 * Construct a new character
	 */
    public NewCharacter(){
    	initiVariables();
    	panel();
    }
    
    /**
     * Initializes Instance Variables
     */
    private void initiVariables(){
    	finish = new JButton("Finish");
    	close = new JButton("Close");
    	pwrSlider = new JSlider();
    	welSlider = new JSlider();
    	solSlider = new JSlider();
    	solSlider.setMaximum(100);
    	solSlider.setMinimum(0);
    	name = new JTextField();
    	pwrField = new JTextField();
    	welField = new JTextField();
    	solField = new JTextField();
    	pwrField.setSize(1, 3);
    	
    	class FinishListener implements ActionListener{
    		public void actionPerformed(ActionEvent evt){
    			System.out.println("test");
    			save();
    		}
    	}
    	
    	class CloseListener implements ActionListener{
    		public void actionPerformed(ActionEvent evt){
    			System.out.println("test");
    		}
    	}
    	
    	class SliderListener implements ActionListener{
    		public void actionPerformed(ActionEvent evt){
    			pwrPos = (int)pwrSlider.getValue();
    			System.out.println(pwrPos);
    		}
    	}
    	
    	ActionListener fin = new FinishListener();
    	finish.addActionListener(fin);
    	
    	ActionListener clo = new CloseListener();
    	close.addActionListener(clo);

    	
    }
    
    /**
     * Creates and lays out panels
     */
    public void panel(){
    	JPanel north = new JPanel();
    	north.add(new JLabel("Create New Character"));
    	
    	JPanel center = new JPanel();
    	GridLayout centerLayout = new GridLayout(4, 4);
    	center.setLayout(centerLayout);
    	center.add(new JLabel("Name"));
    	center.add(name);
    	center.add(new JLabel("       "));
    	center.add(new JLabel("Power"));
    	center.add(pwrField);
    	center.add(pwrSlider);
    	center.add(new JLabel("Wealth"));
    	center.add(welField);
    	center.add(welSlider);
    	center.add(new JLabel("Solitude"));
    	center.add(solField);
    	center.add(solSlider);
    	
    	JPanel south = new JPanel();
    	south.add(finish);
    	south.add(close);
    	
    	add(north, BorderLayout.NORTH);
    	add(south, BorderLayout.SOUTH);
    	add(center, BorderLayout.CENTER);
    }
    
    
    
    private void save(){
    	System.out.println("save");
    }
    
    /**
     * A Main method used for testing NewCharacter
     * @param args
     */
    public static void main(String[] args){
        JFrame f = new NewCharacter();
        f.setSize(new Dimension(500, 500));
        f.setTitle("Create New Character");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
