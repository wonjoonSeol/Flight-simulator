package assessment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * <h1>PPA assignment 11 </h1> <br>
 * Computer Science <br>
 * Year 1 
 * <p>
 * This class is GUI window for flight simulator application
 * 
 * @author Sadi Ashraful(k1631026), Wonjoon Seol (k1631098)
 */
public class GUI extends JFrame {
	private Plane plane;
	private JButton jbReset;
	private JTextArea jtaMessage;
	private JScrollPane jspPlane;
	private JSlider horizontalSlider;
	private JSlider verticalSlider;
	private JLabel speedLabel;
	private JLabel elevationLabel;

	/**
	 * This constructor constructs GUI with supplied plane
	 * @param plane
	 */
	public GUI(Plane plane){ 
		super();
		this.plane = plane;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// when press X button close Jframe
		initWidgets();
		this.setLocationRelativeTo(null);								// make Jframe start in center of the screen
	}
	
	/**
	 *  This private method set up necessary JFrame components and defines its properties.
	 */
	private void initWidgets(){
		jbReset = new JButton("Reset");
		jtaMessage = new JTextArea(20, 40);
		jtaMessage.setEditable(false);
		
		jspPlane = new JScrollPane(jtaMessage);
		speedLabel = new JLabel();
		speedLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Speed"));		// set titled Border
		speedLabel.setPreferredSize(new Dimension(83, 50));
		elevationLabel = new JLabel();
		elevationLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Elevation"));
		elevationLabel.setPreferredSize(new Dimension(83, 50));
	
		//Create the slider
		horizontalSlider = new JSlider(JSlider.HORIZONTAL, plane.getMinimumX(), plane.getMaximumX(), (plane.getMinimumX() + plane.getMaximumX()) / 2);
		verticalSlider = new JSlider(JSlider.VERTICAL, plane.getMinimumSpeed(), plane.getMaximumSpeed(), 0);
		horizontalSlider.setMajorTickSpacing(5);		// set ticks for sliders
		horizontalSlider.setPaintTicks(true);
		
		verticalSlider.setMajorTickSpacing(5);
		verticalSlider.setPaintTicks(true);

		//Create the label table for sliders
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( new Integer( 0 ), new JLabel("Stop") );
		labelTable.put( new Integer( plane.getMaximumSpeed() / 2), new JLabel("Half"));
		labelTable.put( new Integer( plane.getMaximumSpeed() ), new JLabel("Full throttle") );
		verticalSlider.setLabelTable( labelTable );
		verticalSlider.setPaintLabels(true);
	
		/**
		 * This inner class runs the appropriate methods for interacting with the components
		 */
		class FlightListener implements ChangeListener, ActionListener{			
			
			/**
			 * This method overrides stateChanged method from interface ChangeListener 
			 * {@inheritDoc}
			 * 
			 * @return void
			 */
			@Override
			public void stateChanged(ChangeEvent e){						// Listen for changes in the value in a components (here sliders)
				if (e.getSource() == horizontalSlider){						// if the source is from horizontal slider
					plane.setX(horizontalSlider.getValue());				// Set approproriate value to the x coordinate of the plane
				} else if (e.getSource() == verticalSlider){
					plane.setSpeed(verticalSlider.getValue());	
				}
			}

			/**
			 * This method overrides actionPerformed method from interface ActionListener 
			 * {@inheritDoc}
			 */
			@Override
			public void actionPerformed(ActionEvent e){		// checks for action happened (here button)
				if (e.getSource() == jbReset){				// if it is reset button
					GUI.this.dispose(); 					// dispose current JFrame 
					new Thread (new Driver()).start();		// start new thread
				}
			}
		}
		
		horizontalSlider.addChangeListener(new FlightListener());	//add above Listeners to the components
		verticalSlider.addChangeListener(new FlightListener());
		jbReset.addActionListener(new FlightListener());
		
		this.setLayout(new BorderLayout());

		//BorderLayout North
		JPanel jpNorth = new JPanel();
		
		jpNorth.setLayout(new BorderLayout());
		jpNorth.add(jspPlane, BorderLayout.PAGE_START);
		jpNorth.add(horizontalSlider, BorderLayout.CENTER);
		
	
		//BorderLayout Center
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new BorderLayout());
		jpCenter.add(verticalSlider, BorderLayout.CENTER);
		
		//add optional labels for speed and elevation status
		JPanel jpLeft = new JPanel();
		jpLeft.setLayout(new GridLayout(2, 0));
		jpLeft.add(speedLabel);
		jpLeft.add(elevationLabel);
		jpCenter.add(jpLeft, BorderLayout.LINE_START);
		
		//BorderLayout South
		JPanel jpSouth = new JPanel();
		jpSouth.setLayout(new BorderLayout());
		
		jpSouth.add(jbReset); 

		//adding these to myFrame
		this.add(jpNorth, BorderLayout.PAGE_START);
		this.add(jpCenter, BorderLayout.CENTER);
		this.add(jpSouth, BorderLayout.PAGE_END);
		
		this.pack();		// makes the window to fit the preferred size of and layouts of each components
	}

	/**
	 * This method appends supplied string to the jtaMessage and updates carat position to the latest position
	 * @param str String	String to be added
	 */
	public void jtaAppend(String str){
		jtaMessage.append(str);
		jtaMessage.setCaretPosition(jtaMessage.getDocument().getLength());	// get the number of characters of contents and set it as its carat position
	}
	
	/**
	 * This method updates texts in speed and elevation labels (Optional task)
	 */
	public void setLabelUpdate(){
		speedLabel.setText("" + plane.getSpeed());
		elevationLabel.setText("" + plane.getElevation());
	}
}