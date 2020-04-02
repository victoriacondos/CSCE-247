/**
 * @author Elijah Dawkins
 * Purpose: Facilitates selling of tickets and transactions between inventory.
 */
public class Booker extends Ticket {
	/**
	 * Purpose: default constructor for booker.
	 * @param event: event connected to ticket.
	 * @param seat: seat connected to ticket.
	 */
	public Booker(Event event, int seat) {
		super();
		// TODO Auto-generated constructor stub ***-> needed for functionality?
	}
	
	/**
	 * Purpose: method for facilitating the purchase of tickets.
	 * @param event: event connected to ticket.
	 * @param seats: location / seating of ticket.
	 */
	public Ticket[] BuyTickets(Event event, int[] seats) {
		// TODO 
		return null;
	}
	
	/**
	 * Purpose: Method for facilitating the refund of tickets.
	 * @param tickets: tickets up for purchase
	 */
	public void RefundTickets(Ticket[] tickets) {
		// TODO
	}
	
	/**
	 * Purpose: Method for reward points.
	 * @param points: amount of points a user has.
	 */
	private void Reward(double points) {
		// TODO
	}
}
