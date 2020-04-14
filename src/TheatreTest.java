import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class TheatreTest {
	public TheatreGenre genre = TheatreGenre.COMEDY;
	public final ArrayList<String> timesEx = new ArrayList<String>();
	public final ArrayList<String> directorsEx = new ArrayList<String>();
	public final ArrayList<String> castEx = new ArrayList<String>();
	
	Theatre testTheatre = new Theatre("Showtime", "LongStreet Theatre", timesEx, 5.00, genre, directorsEx, castEx);
	
	@Test
	/**
	 * Purpose: Test getGenre accessor
	 */
	public void testGetGenre() {
		assertEquals(testTheatre.getGenre(), genre);
	}
	
	@Test
	/**
	 * Purpose: Test getDirectors accessor
	 */
	public void testGetDirectors() {
		directorsEx.add("Angelina Jolie");
		assertEquals(testTheatre.getDirectors() , directorsEx);
	}
	
	@Test
	/**
	 * Purpose: Test getCast accessor
	 */
	public void testGetCast() {
		castEx.add("Leonardo DiCaprio");
		assertEquals(testTheatre.getCast(), castEx);
	}
	
	@Test
	/**
	 * Purpose: test setGenre mutator
	 */
	public void testSetGenre() {
		TheatreGenre newGenre = TheatreGenre.DRAMA;
		testTheatre.setGenre(newGenre);
		assertEquals(testTheatre.getGenre(), newGenre);
	}
	
	@Test
	/**
	 * Purpose: test setDirectors mutator
	 */
	public void testSetDirectors() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Jacob Jacocks");
		testTheatre.setDirectors(testList);
		assertEquals(testTheatre.getDirectors(), testList);
	}
	
	@Test
	/**
	 * Purpose: test setCast mutator
	 */
	public void testSetCast() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Emma Humphries");
		testTheatre.setCast(testList);
		assertEquals(testTheatre.getCast(), testList);
	}
	
	/**
	 * Purpose: test toString
	 */
	@Test
	public void testToString() {
		Theatre testTheatre = new Theatre("Showtime", "LongStreet Theatre", timesEx, 5.00, genre, directorsEx, castEx);
		String testString = "Title: " + this.testTheatre.title +
				"\n     Location: " + this.testTheatre.location + 
				"\n     Price: $" + this.testTheatre.price +
				"\n     Genre: " + genre +
				"\n     Directors: " + directorsEx +
				"\n     Cast: " + castEx;
		assertEquals(testTheatre.toString(), testString);
	}
	
}
