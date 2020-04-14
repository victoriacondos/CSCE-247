/**
 * 
 * @author Victoria Condos
 * Purpose: applies a discount to cost for a student account purchasing a ticket
 **/
 class StudentDiscount extends Ticket {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .90;
	
	/**
<<<<<<< HEAD
	 * Purpose: Constructor that sets private ticket to param ticket
	 * @param ticket: a Ticket object to be decorated with discount
=======
	 * Purpose: constructor that sets private ticket to param ticket
	 * @param ticket thats being decorated with the discount
>>>>>>> feature-victoria
	 */
	public StudentDiscount(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
<<<<<<< HEAD
	 * Purpose: Appends discount information to end of ticket's pre-existing information
	 * @return String statement of all of tickets information
=======
	 * Purpose: Appends discount information to tickets current info
	 * @return string of all of tickets info
>>>>>>> feature-victoria
	 */
	public String toString() {
		return ticket.toString() + " Discount: Student";
	}
	
	/**
<<<<<<< HEAD
	 * Purpose: Alters the cost of the ticket based on ticket cost after discount (PERCENT_OF_TOTAL is (100- percent discount)/100)
	 * @return double value of new price of ticket
=======
	 * Purpose: adjusts ticket price to reflect discount
	 * @return double of new price of ticket
>>>>>>> feature-victoria
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
