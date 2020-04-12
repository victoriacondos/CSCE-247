import static org.junit.Assert.*;

import org.junit.Test;

public class TicketTest {
	public final Event testEvent = new Event("Test Movie", "Nickelodeon Theater", 10.00);
	public final Ticket testTicket = new Ticket(testEvent, "1:00", 15);
	
	@Test
	/**
	 * Purpose: Test getEvent accessor
	 */
	public void testGetEvent() {
		assertEquals(testEvent.toString() , testTicket.getEvent().toString());
	}
	
	@Test
	/**
	 * Purpose: Test getTime accessor
	 */
	public void testGetTime() {
		assertEquals("1:00", testTicket.getTime());
	}
	
	@Test
	/**
	 * Purpose: Test getSeat accessor
	 */
	public void testGetSeat() {
		assertEquals(15, testTicket.getSeat());
	}


}
