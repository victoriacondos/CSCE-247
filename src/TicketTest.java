import static org.junit.Assert.*;

import org.junit.Test;

public class TicketTest {
	//create variables to be used in tests
	public final Event testEvent = new Event("Test Movie", "Nickelodeon Theater", 10.00);
	public final Ticket testTicket = new Ticket(testEvent, "1:00", 15);
	@Test
	public void testGetEvent() {
		assertEquals(testEvent.toString() , testTicket.getEvent().toString());
	}
	@Test
	public void testGetTime() {
		assertEquals("1:00", testTicket.getTime());
	}
	@Test
	public void testGetSeat() {
		assertEquals(15, testTicket.getSeat());
	}


}
