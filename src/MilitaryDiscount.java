/**
 * 
 * @author Victoria Condos
 * Purpose: applies discount to cost for a military account purchasing a ticket
 */
public class MilitaryDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .75;
	
	/**
	 * Purpose: constructor that sets private ticket to param ticket
	 * @param ticket that will be decorated with discount
	 */
	public MilitaryDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Purpose: append additional info to tickets current info
	 * return: string of all of ticket's info
	 */
	public String toString() {
		return ticket.toString() + " Discout: Military";
	}
	
	/**
	 * Purpose: adjusts cost of ticket to reflect discount
	 * @return double of new ticket cost
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
