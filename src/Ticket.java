/**
 * 
 * @author Victoria Condos
 * Purpose: Base class of ticket that is decorated with discounts and screening options
 */
public abstract class Ticket { //TODO- should this be abstract? with standard as a decoration?
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
	 * Purpose: sets the cost of the ticket
	 * @param cost: double value of ticket price
	 */
	public void setCost(double cost) { //TODO- this was different on UML but this makes more sense
		this.cost = cost;
	}
	
	/**
	 * Purpose: returns a string of all the ticket's variables
	 */
	public String toString() {
		return "Event: " + this.event + " Seat: " + this.seat + "Cost: " + this.cost;
	}
}
