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
	 * @param ticket: a Ticket object to be decorated with discount
	 */
	public TeacherDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Purpose: Appends discount information to end of information statement
	 * @return String of all of ticket's information
	 */
	public String toString() {
		return ticket.toString() + " Discount: Teacher";
	}
	
	/**
	 * Purpose: alters the cost of ticket based on discount (PERCENT_OF_TOTAL is (100- percent discount)/100)
	 * @return
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
