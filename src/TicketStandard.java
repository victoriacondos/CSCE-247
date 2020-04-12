/**
 * 
 * @author Victoria Condos
 * Purpose: A ticket decoration for an event that is not IMAX or 3D
 */
public class TicketStandard extends Ticket {
	private Ticket ticket;
	private final double STANDARD_PRICE = 10.0;
	/**
	 * Purpose: constructor that sets private ticket to param ticket
	 * @param ticket: the ticket that is being decorated
	 */
	public TicketStandard(Ticket ticket) {
		this.ticket = ticket;
	}
	/**
	 * Purpose: appends additional info to end of ticket's toString method
	 * return: string of all of tickets info
	 */
	public String toString() {
		return ticket.toString() + " Viewing Type: Standard";
	}
	/**
	 * Purpose: adds additional cost to existing ticket price
	 * @return double of ticket's new price
	 */
	public double getCost() {
		return ticket.getCost() + STANDARD_PRICE;
	}
}
