import org.json.simple.JSONObject;

/**
 * 
 * @author Victoria Condos
 * Purpose: Base class of ticket that is decorated with discounts and screening options
 */
public class Ticket extends DatabaseObject{ 
	protected static final String EVENT = "event";
	protected static final String TIME = "time";
	protected static final String SEAT = "seat";
	protected static final String COST = "cost";
	
	protected Event event;
	protected String time;
	protected int seat;
	protected double cost;
	
	public Ticket(JSONObject objectJSON) {
		this.seat = (int)objectJSON.get(SEAT);
		this.cost = (double)objectJSON.get(COST);
		this.event = new Event((JSONObject)objectJSON.get(EVENT));
	}
	
	public Ticket() {}
	
	public Ticket(Event event, String time, int seat) {
		this.event = event;
		this.time = time;
		this.seat = seat;
	}
	
	/**
	 * Purpose: Accessor for event variable
	 * @return: ticket's type of event
	 */
	public Event getEvent() {
		return this.event;
	}
	
	/**
	 * Purpose: Accessor for ticket seat number
	 * @return: the ticket's corresponding seat number
	 */
	public int getSeat() {
		return this.seat;
	}
	
	/**
	 * Purpose: Accessor for ticket cost
	 * @return double value of ticket cost
	 */
	public double getCost() {
		return this.cost;
	}
	
	public JSONObject toJSON() {
		JSONObject ticketDetails = new JSONObject();
		ticketDetails.put(TIME, this.time);
		ticketDetails.put(SEAT, this.seat);
		ticketDetails.put(COST, this.cost);
		ticketDetails.put(EVENT, this.event.toJSON());
		return ticketDetails;
	}
	
	/**
	 * Purpose: returns a string of all the ticket's variables
	 * @return String statement of all of the ticket's information
	 */
	public String toString() {
		return "Event: " + this.event.title
				+ "\nSeat: " + this.seat
				+ "\nTime: " + this.time
				+ "\nLocation: " + this.event.location;
	}
}
