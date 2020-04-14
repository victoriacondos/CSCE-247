import static org.junit.Assert.*;

import org.json.simple.JSONObject;
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
	
	@Test
	public void testGetCost() {
		assertEquals(10, testTicket.getCost(), 0.01);
	}
	
	@Test
	public void testDecorator() {
		Ticket ticket = testTicket;
		ticket = new TicketStandard(ticket);
		ticket = new Ticket3D(ticket);
		ticket = new TicketIMAX(ticket);
		ticket = new MilitaryDiscount(ticket);
		ticket = new SeniorDiscount(ticket);
		ticket = new StudentDiscount(ticket);
		ticket = new TeacherDiscount(ticket);
		String expected = "Event: Test Movie"
				+ "\nSeat: 15"
				+ "\nTime: 1:00"
				+ "\nLocation: Nickelodeon Theater "
				+ "Viewing Type: Standard "
				+ "Viewing Type: 3D "
				+ "Viewing Type: IMAX "
				+ "Discount: Military "
				+ "Discount: Senior Citizen "
				+ "Discount: Student "
				+ "Discount: Teacher";
		assertEquals(expected, ticket.toString());
		assertEquals(8.74, ticket.getCost(), 0.01);
	}
	
	@Test
	public void testToString() {
		String expected = "Event: Test Movie"
				+ "\nSeat: 15"
				+ "\nTime: 1:00"
				+ "\nLocation: Nickelodeon Theater";
		assertEquals(expected, testTicket.toString());
	}

	@Test
	public void testJSON() {
		Ticket newTicket = new Ticket();
		JSONObject objectJSON = testTicket.toJSON();
		newTicket = new Ticket(objectJSON);
		assertEquals(testTicket.toString(), newTicket.toString());
	}
}
