package assessment;

import cw5.Coordinates;

/**
 * <h1>PPA assignment 11 </h1> <br>
 * Computer Science <br>
 * Year 1 
 * <p>
 * This class is a driver class
 * 
 * @author Sadi Ashraful(k1631026), Wonjoon Seol (k1631098)
 */
public class Driver implements Runnable {			// Implement Runnable interface to override run() method to make a thread

    public static Thread t;
    public static boolean flag;

	public static void main(String[] args) {	
		t = (new Thread (new Driver()));
		t.start();											// start new thread t, which would run the method run()
	}
	
	@Override
	public void run() {
		Plane plane = new Plane(0, 10, 0, 10, new Coordinates(5, 0), 10, 5, 5);
		Runway runway = new Runway(10, 100);
		GUI gui = new GUI(plane);
		gui.setVisible(true);								// make JFrame visible
	
		int seconds = 0;
		int conseqSec = 0;
		
		while(plane.getY() < runway.getHeight()) {
			try {
				gui.jtaAppend("Seconds: " + seconds +"\n");
				gui.jtaAppend(plane.toString() + "\n");
				Thread.sleep(1000);							// Thread sleeps for 1 second
				
				seconds += 1;

				if (plane.isFastEnough()) {
					conseqSec += 1;							// if plane is fast enough, add 1 to conseqSec
				} else {
					conseqSec = 0;							// otherwise reset to 0
				}
				
				if (plane.isGoingUp(conseqSec)) {			// if conseqSec is more than time for elevation
					plane.addElevation();					// add elevation by 1
				}
				 plane.addY(plane.getSpeed());
				 gui.setLabelUpdate();						// update speed, elevation status label

			} catch (InterruptedException e) {
				 System.out.println(e);
			}
		}
	
		gui.jtaAppend("Seconds: " + seconds +"\n");
		gui.jtaAppend(plane.toString() + "\n"); 	// reporting the final position of the plane (consistent to brief example)
		
		if (plane.isTakenOff() && runway.contains(plane) && plane.isFastEnough()) { // checks the case when plane suddenly lowers the speed right before the take off.
			gui.jtaAppend("Plane in air");
			
		} else {
			gui.jtaAppend("Take off failed");
		}
	}
}
