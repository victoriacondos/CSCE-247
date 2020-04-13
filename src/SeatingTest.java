/**
 * @author Elizabeth Stevenson
 * Purpose: test methods in Seating that are specific to itself
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeatingTest {

	public static Seating testSeating;
	
	/**
	 * Purpose: test getSeats
	 */
	@Test
	public void testGetSeats() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		testSeating = new Seating(5, 5, handicapped);
		assertEquals(testSeating.getSeats().length, 5);
	}
	
	/**
	 * Purpose: test setSeats
	 */
	@Test
	public void testSetSeats() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		boolean [] seats = new boolean[] {true, true, true, true, true};
		testSeating = new Seating(5, 5, handicapped);
		testSeating.setSeats(seats);
		assertEquals(testSeating.getSeats().length, 5);
	}
	
	/**
	 * Purpose: test isSoldOut
	 */
	@Test
	public void testIsSoldOut() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		boolean [] seats = new boolean[] {true, true, true, true, true};
		testSeating = new Seating(5, 5, handicapped);
		testSeating.setSeats(seats);
		assertEquals(testSeating.isSoldOut(), false);
	}
	
	/**
	 * Purpose: test isSoldOut but the negative case
	 */
	@Test
	public void testIsNotSoldOut() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		boolean [] seats = new boolean[] {false, false, false, false, false};
		testSeating = new Seating(5, 5, handicapped);
		testSeating.setSeats(seats);
		assertEquals(testSeating.isSoldOut(), false);
	}
	
	/**
	 * Purpose: test setSoldOut
	 */
	@Test
	public void testSetSoldOut() {
		testSeating.setSoldOut(true);
		assertEquals(testSeating.isSoldOut(), true);
	}
	
	/**
	 * Purpose: test isHandicap
	 */
	@Test
	public void testIsHandicap() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		testSeating = new Seating(5, 5, handicapped);
		assertEquals(testSeating.isHandicap(3), false);
	}

	/**
	 * Purpose: test isHandicap but the negative case
	 */
	@Test
	public void testIsNotHandicap() {
		int[] handicapped = new int[] {0, 0, 1, 0, 0};
		testSeating = new Seating(5, 5, handicapped);
		assertEquals(testSeating.isHandicap(3), false);
	}
}
