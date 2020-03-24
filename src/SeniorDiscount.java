/**
 * 
 * @author Victoria Condos
 * Purpose: gives a discount for a senior citizen account purchasing a ticket
 */
public class SeniorDiscount {
	private Ticket ticket;
	private final double PERCENT_OF_TOTAL = .85; 
	
	public SeniorDiscount(Ticket ticket) {
		this.ticket = ticket;
	} 
	
	public String toString() {
		return ticket.toString() + "Discount: Senior Citizen";
	}
	
	public double getCost() {
		return ticket.getCost() * PERCENT_OF_TOTAL;
	}
}
