/**
 * 
 * @author Victoria Condos
 * Purpose: applies discount to cost for a military account purchasing a ticket
 */
public class MilitaryDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .75;
	
	/**
	 * 
	 * @param ticket
	 */
	public MilitaryDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return ticket.toString() + " Discout: Military";
	}
	
	/**
	 * 
	 * @return
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
