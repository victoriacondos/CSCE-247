import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeatingTest {

	public static Seating testSeating;
	
	@Test
	public void testGetSeats() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		testSeating = new Seating(5, 5, handicapped);
		assertEquals(testSeating.getSeats().length, 5);
	}
	
	@Test
	public void testSetSeats() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		boolean [] seats = new boolean[] {true, true, true, true, true};
		testSeating = new Seating(5, 5, handicapped);
		testSeating.setSeats(seats);
		assertEquals(testSeating.getSeats().length, 5);
	}
	
	@Test
	public void testIsSoldOut() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		boolean [] seats = new boolean[] {true, true, true, true, true};
		testSeating = new Seating(5, 5, handicapped);
		testSeating.setSeats(seats);
		assertEquals(testSeating.isSoldOut(), false);
	}
	
	@Test
	public void testSetSoldOut() {
		testSeating.setSoldOut(true);
		assertEquals(testSeating.isSoldOut(), true);
	}
	
	@Test
	public void testIsHandicap() {
		int[] handicapped = new int[] {0, 0, 0, 0, 0};
		testSeating = new Seating(5, 5, handicapped);
		assertEquals(testSeating.isHandicap(3), false);
	}

}
