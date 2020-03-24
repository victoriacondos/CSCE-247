/**
 * 
 * @author Victoria Condos
 * Purpose: applies discount to the cost for a teacher account when purchasing a ticket
 */
public class TeacherDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .90;
	
	/**
	 * 
	 * @param ticket
	 */
	public TeacherDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return ticket.toString() + " Discount: Teacher";
	}
	
	/**
	 * 
	 * @return
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
