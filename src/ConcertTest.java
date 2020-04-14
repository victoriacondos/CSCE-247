import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class ConcertTest {
	public final MusicGenre genre = MusicGenre.POP;
	public final Event testEvent = new Event("Test Event", "Ampitheather", 5.00);
	public final ArrayList<String> timeEx = new ArrayList<String>();
	public final ArrayList<String> artistsEx = new ArrayList<String>();

	Concert testConcert = new Concert("Test Event", "Ampitheater", timeEx , 5.00, genre, false, artistsEx);
	
	@Test
	/**
	 * Purpose: Test getGenre accessor
	 */
	public void testGetGenre() {
		assertEquals(testConcert.getGenre() , genre);
	}
	
	@Test
	/**
	 * Purpose: Test isExplicitContent
	 */
	public void testIsExplicitContent() {
		assertEquals(testConcert.isExplicitContent() , false);
	}
	
	@Test
	/**
	 * Purpose: Test getArtists accessor
	 */
	public void testGetArtists() {
		artistsEx.add("Ariana Grande");
		assertEquals(testConcert.getArtists() , artistsEx);
	}
	
	@Test
	/**
	 * Purpose: test setGenre mutator
	 */
	public void testSetGenre() {
		MusicGenre newGenre = MusicGenre.ROCK;
		testConcert.setGenre(newGenre);
		assertEquals(testConcert.getGenre(), newGenre);
	}
	
	@Test
	/**
	 * Purpose: test setExplicitContent mutator
	 */
	public void testSetExplicitContent() {
		Concert testConcert = new Concert("Test Event", "Ampitheater", timeEx , 5.00, genre, false, artistsEx);
		testConcert.setExplicitContent(true);
		assertEquals(testConcert.isExplicitContent(), true);
	}
	
	@Test
	/**
	 * Purpose: test setExplicitContent mutator
	 */
	public void testSetArtists() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Cage the Elephant");
		Concert testConcert = new Concert("Test Event", "Ampitheater", timeEx , 5.00, genre, false, testList);
		testConcert.setArtists(testList);
		assertEquals(testConcert.getArtists(), testList);
	}
	
	/**
	 * Purpose: test toString
	 */
	@Test
	public void testToString() {
		Concert testConcert = new Concert("Test Event", "Ampitheater", timeEx , 5.00, genre, false, artistsEx);
		String testString = super.toString() + " Genre: " + this.genre + " Explicit Content: " + 
				false + "Artists: " + this.artistsEx;
		assertEquals(testConcert.toString(), testString);
	}
	
}
