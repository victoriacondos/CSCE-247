/**
 * 
 * @author Victoria Condos
 * Purpose: A ticket decoration for an event with 3D viewing type
 */
public class Ticket3D extends Ticket {
	private Ticket ticket;
	private final double PRICE_3D = 1.5;
	/**
	 * Purpose: constructor that sets private ticket to param ticket
	 * @param ticket: the ticket that is being decorated
	 */
	public Ticket3D(Ticket ticket) {
		this.ticket = ticket;
	}
	/**
	 * Purpose: appends additional info to end of ticket's toString method
	 * return: string of all of tickets info
	 */
	public String toString() {
		return ticket.toString() + " Viewing Type: 3D";
	}
	/**
	 * Purpose: adds additional cost to existing ticket price
	 * @return double of ticket's new price
	 */
	public double getCost() {
		return ticket.getCost() * PRICE_3D;
	}
}
