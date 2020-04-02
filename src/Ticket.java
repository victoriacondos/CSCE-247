/**
 * 
 * @author Victoria Condos
 * Purpose: Base class of ticket that is decorated with discounts and screening options
 */
public abstract class Ticket { 
	protected Event event;
	protected int seat;
	protected double cost;
	
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
	
	/**
	 * Purpose: returns a string of all the ticket's variables
	 * @return String statement of all of the ticket's information
	 */
	public String toString() {
		return "Event: " + this.event + " Seat: " + this.seat + "Cost: " + this.cost;
	}
}
