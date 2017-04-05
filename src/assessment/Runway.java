package assessment;

import java.awt.Rectangle;

/**
 * <h1>PPA assignment 11 </h1> <br>
 * Computer Science <br>
 * Year 1 
 * <p>
 * This class represents dimentions stored in a runway
 * 
 * @author Sadi Ashraful(k1631026), Wonjoon Seol (k1631098)
 */

public class Runway extends Rectangle{
	
	 /**
	  * Constructor calls super class constructor from Class Rectangle to store its dimensions
	  * 
	  * @param width int variable, holding the width of the Runway 
	  * @param length int variable, holding the length of the Runway
	  */
	public Runway(int width, int length){
		super(width, length);
	}

	/**
	 * This method checks whether Plane is inside runway
	 * @param plane
	 * @return boolean Returns whether plane x coodrinate is inside the runway
	 */
	public boolean contains(Plane plane){
		return super.contains(plane.getX(), 0);
	}
}
