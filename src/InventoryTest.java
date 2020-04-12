import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class InventoryTest {

	public static Inventory testInventory;
	
	@Test
	public void testGetRewardsPoints() {
		testInventory = new Inventory();
		testInventory.setRewardsPoints(10);
		assertEquals(testInventory.getRewardsPoints(), 10);
	}
	
	@Test
	public void testSetRewardsPoints() {
		testInventory = new Inventory();
		testInventory.setRewardsPoints(10);
		assertEquals(testInventory.getRewardsPoints(), 10);
	}
}
