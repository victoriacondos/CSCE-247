/**
 * 
 * @author Victoria Condos
 * Purpose: applies a discount to cost for a student account purchasing a ticket
 **/
 class StudentDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .90;
	
	/**
	 * Purpose: constructor that sets private ticket to param ticket
	 * @param ticket thats being decorated with the discount
	 */
	public StudentDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Purpose: Appends discount information to tickets current info
	 * @return string of all of tickets info
	 */
	public String toString() {
		return ticket.toString() + " Discount: Student";
	}
	
	/**
	 * Purpose: adjusts ticket price to reflect discount
	 * @return double of new price of ticket
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
