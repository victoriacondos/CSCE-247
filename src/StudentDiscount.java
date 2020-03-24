/**
 * 
 * @author Victoria Condos
 * Purpose: applies a discount to cost for a student account purchasing a ticket
 **/
 class StudentDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .90;
	
	/**
	 * Purpose:
	 * @param ticket
	 */
	public StudentDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Purpose:
	 * @return
	 */
	public String toString() {
		return ticket.toString() + " Discount: Student";
	}
	
	/**
	 * Purpose:
	 * @return
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
