/**
 * 
 * @author Victoria Condos
 * Purpose: applies discount to the cost for a teacher account when purchasing a ticket
 */
public class TeacherDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .90;
	
	/**
	 * Purpose: constructor that sets private ticket to param ticket
	 * @param ticket that is decorated with the discount
	 */
	public TeacherDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Purpose: appends discount info to tickets current info
	 * @return string of all of tickets info
	 */
	public String toString() {
		return ticket.toString() + " Discount: Teacher";
	}
	
	/**
	 * Purpose: adjusts price of ticket to reflect the discount
	 * @return double of new ticket price
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
