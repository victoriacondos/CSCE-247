/**
 * @author Elizabeth Stevenson
 * Purpose: test methods in Inventory that are specific to itself
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.Test;

public class InventoryTest {

	public static Inventory testInventory;
	
	/**
	 * Purpose: test getRewardsPoints
	 */
	@Test
	public void testGetRewardsPoints() {
		testInventory = new Inventory();
		testInventory.setRewardsPoints(10);
		assertEquals(testInventory.getRewardsPoints(), 10);
	}
	
	/**
	 * Purpose: test setRewardsPoints with positive value
	 */
	@Test
	public void testSetRewardsPoints() {
		testInventory = new Inventory();
		testInventory.setRewardsPoints(10);
		assertEquals(testInventory.getRewardsPoints(), 10);
	}
	
	/**
	 * Purpose: test setRewardsPoints with negative value
	 */
	@Test
	public void testSetNegativeRewardsPoints() {
		testInventory = new Inventory();
		testInventory.setRewardsPoints(-10);
		assertEquals(testInventory.getRewardsPoints(), -10);
	}
	
	@Test
	public void testPurchasedTickets() {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Event testEvent = new Event("Test Movie", "Nickelodeon Theater", 10.00);
		Ticket testTicket = new Ticket(testEvent, "1:00", 15);
		tickets.add(testTicket);
		testInventory.setPurchasedTickets(tickets);
		assertEquals(tickets.toString(), testInventory.getPurchasedTickets().toString());
	}
	
	@Test
	public void testToString() {
		testInventory = new Inventory();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Event testEvent = new Event("Test Movie", "Nickelodeon Theater", 10.00);
		Ticket testTicket = new Ticket(testEvent, "1:00", 15);
		tickets.add(testTicket);
		testInventory.setPurchasedTickets(tickets);
		String expected = "RewardsPoints: 0.0" 
				+ "\nTickets: \n\n1)\n" + testTicket.toString();
		assertEquals(expected, testInventory.toString());
	}
	
	@Test
	public void testJSON() {
		testInventory = new Inventory();
		JSONObject objectJSON = testInventory.toJSON();
		Inventory inv = new Inventory(objectJSON);
		assertEquals(testInventory.toString(), inv.toString());
	}
}
