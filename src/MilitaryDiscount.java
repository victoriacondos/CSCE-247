/**
 * 
 * @author Victoria Condos
 * Purpose: applies discount to cost for a military account purchasing a ticket
 */
public class MilitaryDiscount extends Ticket {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .75;
	
	/**
	 * Purpose: constructor that sets private ticket to param ticket
	 * @param ticket: a Ticket object to be decorated with discount
	 */
	public MilitaryDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Purpose: Appends additional information to ticket's toString method
	 * @return String statement of all of tickets information
	 */
	public String toString() {
		return ticket.toString() + " Discount: Military";
	}
	
	/**
	 * Purpose: alters the price of the ticket based on discount (PERCENT_OF_TOTAL is (100- percent discount)/100)
	 * @return double value of ticket's new price
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
