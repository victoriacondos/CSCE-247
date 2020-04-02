/**
 * @author Elizabeth Stevenson
 * Purpose: to create the different types of events
 */
public class Event {
	protected String title;
	protected String location;
	protected double time;
	protected double price;
	protected Seating seating;
	
	/**
	 * Purpose: to create a new event
	 * @param title: name of event
	 * @param location: place of event
	 * @param time: time of event
	 */
	public Event(String title, String location, double time) {
		//super(); //Seating constructor
		this.title = title;
		this.location = location;
		this.time = time;
	}
	
	/**
	 * Purpose: returns the title, location, time, and price of event
	 * @return title: name of event
	 * @return location: place of event
	 * @return time: time of event
	 * @return price: price of event
	 * @return Seating: Seating's to string statement
	 */
	public String toString() {
		return "Title: " + this.title +
				" Location: " + this.location + 
				" Time: " + this.time +
				" Price: " + this.price +
				" Seating: " + super.toString();
	}
}

