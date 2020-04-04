import org.json.simple.JSONObject;

/**
 * @author Elizabeth Stevenson, Brett Logeais
 * Purpose: to create the different types of events
 */
public class Event extends DatabaseObject {
	protected static final String TITLE = "title";
	protected static final String LOCATION = "location";
	protected static final String TIME = "time";
	protected static final String PRICE = "price";
	protected static final String SEATING = "seating";
	
	protected String title;
	protected String location;
	protected String time;
	protected double price;
	protected Seating seating;
	
	/**
	 * Purpose: creates an event from a jsonobject
	 * @param objectJSON
	 */
	public Event(JSONObject objectJSON) {
		this.title = (String)objectJSON.get(TITLE);
		this.location = (String)objectJSON.get(LOCATION);
		this.time = (String)objectJSON.get(TIME);
		this.price = (double)objectJSON.get(PRICE);
		this.seating = new Seating((JSONObject)objectJSON.get(SEATING));
	}
	
	/**
	 * Purpose: to create a new event
	 * @param title: name of event
	 * @param location: place of event
	 * @param time: time of event
	 */
	public Event(String title, String location, String time, double price) {
		this.title = title;
		this.location = location;
		this.time = time;
		this.price = price;
		int[] hand = {};
		this.seating = new Seating(50, 5, hand);
	}
	
	/**
	 * Purpose: returns the title, location, time, and price of event
	 * @return title: name of event
	 * @return location: place of event
	 * @return time: time of event
	 * @return price: price of event
	 * @return Seating: Seating's to string statement
	 */
	@Override
	public String toString() {
		return "   Title: " + this.title +
				"\n     Location: " + this.location + 
				"\n     Time: " + this.time +
				"\n     Price: $" + this.price;
	}
	
	@Override
	public JSONObject toJSON() {
		JSONObject eventDetails = new JSONObject();
		eventDetails.put(TITLE, this.title);
		eventDetails.put(LOCATION, this.location);
		eventDetails.put(TIME, this.time);
		eventDetails.put(PRICE, this.price);
		eventDetails.put(SEATING, this.seating.toJSON());
		return eventDetails;
	}
}

