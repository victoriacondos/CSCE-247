/**
 * 
 * @author Victoria Condos
 * Purpose: applies discount to cost for a senior citizen account purchasing a ticket
 */
public class SeniorDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .80; 
	
	/**
	 * Purpose: SeniorDiscount construct sets private ticket to inputted one
	 * @param ticket: a Ticket object to be decorated with discount
	 */
	public SeniorDiscount(Ticket ticket) {
		this.ticket = ticket;
	} 
	
	/**
	 * Purpose: Appends additional information to ticket's toString method
	 * @return String statement of ticket's information
	 */
	public String toString() {
		return ticket.toString() + " Discount: Senior Citizen";
	}
	
	/**
	 * Purpose: Alters the cost of ticket based on discount (PERCENT_OF_TOTAL is (100- percent discount)/100)
	 * @return double value of tickets updated price
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
