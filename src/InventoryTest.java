/**
 * @author Elizabeth Stevenson
 * Purpose: test methods in Inventory that are specific to itself
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
}
