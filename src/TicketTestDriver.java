/**
 * 
 * @author Victoria Condos
 * Purpose: driver to be used in TicketDecorators JUnit Test
 */
public class TicketTestDriver {
	public void runDriver() {
		Ticket ticketArray[] = new Ticket[3];
		ticketArray[0] = new TicketStandard(ticketArray[0]);
		ticketArray[1] = new Ticket3D(ticketArray[1]);
		ticketArray[2] = new TicketIMAX(ticketArray[2]);
	}
}
