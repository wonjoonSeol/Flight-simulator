package assessment;                                        //

import cw5.Coordinates;                                    //

/**
 * <h1>PPA assignment 11 </h1> <br>
 * Computer Science <br>
 * Year 1 
 * <p>
 * This class represents a characteristics of plane 
 * 
 * @author Sadi Ashraful(k1631026), Wonjoon Seol (k1631098)
 */
public class Plane {                                        //Declaring class Plane
	 private int minimumSpeed;                              //Initialising int variable minimumSpeed
	 private int maximumSpeed;                              //Initialising int variable maximumSpeed
	 private int minimumX;                                  //Initialising int variable minimumX
	 private int maximumX;                                  //Initialising int variable maximumX
	 private Coordinates coordinates;                       //Initialising Coordinates variable coordinates
	 private int speedForElevation;                         //Initialising int variable speedforElevation
	 private int timeForElevation;                          //Initialising int variable timeforElevation
	 private int speed;                                     //Initialising int variable speed
	 private int elevation;                                 //Initialising int variable elevation
	 private int elevationRequired;                         //Initialising int variable elevationRequired
	 
	 /**
	  * Declaring the constructor for Plane class
	  * @param minimumSpeed int variable, which is the minimum speed of the plane.
	  * @param maximumSpeed int variable, which is the maximum speed of the plane.
	  * @param minimumX int varibale, which is the minimum possible value for X.
	  * @param maximumX int variable, which is the maximum possible value for X.
	  * @param coordinates Coordinates, which is the coordinates of the plane.
	  * @param speedForElevation int variable, which is the speed of the plane during elevation.
	  * @param timeForElevation int variable, which is the time the plane takes to increase elevation from "0".
	  * @param elevationRequired int variable, it is the elevation that is required for the plane to take off.
	  */
	 public Plane(int minimumSpeed, int maximumSpeed, int minimumX, int maximumX, Coordinates coordinates, int speedForElevation, int timeForElevation, int elevationRequired){
		 this.minimumSpeed = minimumSpeed;                  
		 this.maximumSpeed = maximumSpeed;                  
		 this.coordinates = coordinates;                    
		 this.minimumX = minimumX;                         
		 this.maximumX = maximumX;                          
		 this.timeForElevation = timeForElevation;          
		 this.speedForElevation = speedForElevation;		
		 this.elevationRequired = elevationRequired;
		 speed = 0;
		 elevation = 0;
	 }
     
	/**
	 * This method overrides default toString method in class Object
	 * {@inheritDoc}
	 * 
	 * @return returns the String representation of the object, that can be directly printed
	 */
	 @Override
	public String toString(){
		return "X: " + coordinates.getX() + " Y: " + coordinates.getY() + " Speed: " + speed + " Elevation: " + elevation;
	}
	
	 /**
	  * This is a boolean method which returns true if elevation is greater or equals than the elevationRequired.
	  *@return boolean value to show whether the plane is taking off.
	  */
	public boolean isTakenOff(){
		return elevation >= elevationRequired;
	}

	/**
	  * This is a boolean method which returns true if the timeforElevation is less or equals to seconds.
	  *@param seconds int variable, which is the time required by the plane to be at constant speed for few seconds
	  *@return a boolean value if seconds is greater or equals to five.
	  */
	public boolean isGoingUp(int seconds){
	   return timeForElevation <= seconds; 
	}
	
	/**
	  * This is a boolean method which checks if the plane is travelling fast enough.
	  *@return a boolean value if speed is greater or equals to speedForElevation.
	  */
	public boolean isFastEnough(){
		return speed >= speedForElevation;
	}
	
	/**
	  * This is a void method(have no return values) which increases value of elevation by 1.
	  */
	public void addElevation(){
		elevation += 1;
	}
	
	/**
	  * This method is used to access the Maximumspeed value of the plane.
	  *@return an int variable, which is the Maximumspeed of the plane.
	  */
	public int getMaximumSpeed() {
		return maximumSpeed;
	}

	/**
	  * This method is used to access the Minimumspeed value of the plane.
	  *@return an int variable, which is the Minimumspeed of the plane.
	  */
	public int getMinimumSpeed() {
		return minimumSpeed;
	}

	/**
	  * This method is used to access the Minimum value of X.
	  *@return an int variable, which is the Minimumspeed of X.
	  */
	public int getMinimumX() {
		return minimumX;
	}

	/**
	   * This method is used to access the Maximum value of X.
	  *@return int variable, which is the Maximumspeed of X.
	  */
	public int getMaximumX() {
		return maximumX;
	}

	/**
	  * This method is used to set the value for speed of the plane.
	  *@param speed int variable, which is the speed.
	  */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	  * This void method is used to set the value of X coordinate of the plane.
	  *@param x int variable, which is the X coordinate.
	  */
	public void setX(int x) {
		coordinates.setX(x);
	}

	/**
	  * This method fetches the value of speed.
	  *@return int variable, which is the speed of the plane.
	  */
	public int getSpeed() {
		return speed;
	}

	/**
	 * This method fetches the value of Elevation.
	  *@return int variable, which is the elevation of the plane.
	  */
	public int getElevation() {
		return elevation;
	}

	/**
	  * This method fetches the value of Elevation Required.
	  *@return int variable, which is the value of elevation that is idealy required for the plane.
	  */
	public int getElevationRequired() {
		return elevationRequired;
	}
	 
	/**
	  * This method fetches the value of X coordinate of the plane.
	  *@return int variable, which is the X coordinate of the plane.
	  */
	public int getX(){
		return coordinates.getX();
	}
	
	/**
	  * This method fetches the value of Y coordinate of the plane.
	  *@return int variable, which is the Y coordinate of the plane.
	  */
	public int getY(){
		return coordinates.getY();
	}
	
	/**
	  * This is a void method which adds the value of distance and the Y coordinate of the plane.
	  *@param distance int variable,which is the distance travelled by the plane.
	  */
	public void addY(int distance){
		coordinates.setY(coordinates.getY() + distance);
	}
}