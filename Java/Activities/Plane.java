
package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
	
	private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
	
	public Plane(int maxPass) {
		this.maxPassengers = maxPass;
		this.passengers = new ArrayList<>();
	}
	//onboard(): add passengers to the array using the add() method
	public void onboard(String name) {
		this.passengers.add(name);
	}
	
	//takeOff(): returns the current date and time
	public Date takeOff() {
		this.lastTimeTookOf = new Date();
		return lastTimeTookOf;
	}
	
	//land(): sets the value of lastTimeLanded to the current date and time. Also clear() the array.
	public void land() {
		this.lastTimeLanded = new Date();
		this.passengers.clear();
	}
	
	//getLastTimeLanded(): returns the value of lastTimeLanded.
	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}
	
	//getPassesngers(): returns the array of passengers.
	public List<String> getPassengers(){
		return passengers;
	}
	
}
