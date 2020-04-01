/**
 * 
 * @author Victoria Condos
 * Purpose: A ticket decoration for an event with IMAX viewing type
 */
public class TicketIMAX {
	private Ticket ticket;
	private final double IMAX_PRICE = 12.0;
	/**
	 * Purpose: constructor that sets private ticket to param ticket
	 * @param ticket: the ticket that is being decorated
	 */
	public TicketIMAX(Ticket ticket) {
		this.ticket = ticket;
	}
	/**
	 * Purpose: appends additional info to end of ticket's toString method
	 * return: string of all of tickets info
	 */
	public String toString() {
		return ticket.toString() + " Viewing Type: IMAX";
	}
	/**
	 * Purpose: adds additional cost to existing ticket price
	 * @return double of ticket's new price
	 */
	public double getCost() {
		return ticket.getCost() + IMAX_PRICE;
	}
}
