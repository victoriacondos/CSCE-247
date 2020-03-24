/**
 * 
 * @author Victoria Condos
 * Purpose: applies discount to cost for a senior citizen account purchasing a ticket
 */
public class SeniorDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .80; 
	
	/**
	 * Purpose:
	 * @param ticket
	 */
	public SeniorDiscount(Ticket ticket) {
		this.ticket = ticket;
	} 
	
	/**
	 * Purpose:
	 * @return
	 */
	public String toString() {
		return ticket.toString() + " Discount: Senior Citizen";
	}
	
	/**
	 * Purpose:
	 * @return
	 */
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
