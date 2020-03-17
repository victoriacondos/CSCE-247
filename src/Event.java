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
	
	public Event(String title, String location, double time) {
		this.title = title;
		this.location = location;
		this.time = time;
	}
	
	public String toString() {
		return "Title: " + this.title +
				" Location: " + this.location + 
				" Time: " + this.time +
				" Price: " + this.price;
	}
}
