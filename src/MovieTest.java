import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class MovieTest {
	public MpaRating rating = MpaRating.PG13;
	public MovieGenre genre = MovieGenre.HORROR;
	public final ArrayList<String> timesEx = new ArrayList<String>();
	public final ArrayList<String> directorsEx = new ArrayList<String>();
	public final ArrayList<String> castEx = new ArrayList<String>();
	
	Movie testMovie = new Movie("The Folklore", "Jones Theater", timesEx, 5.00, genre, rating, directorsEx, castEx); 
	
	@Test
	/**
	 * Purpose: Test getGenre accessor
	 */
	public void testGetGenre() {
		assertEquals(testMovie.getGenre(), genre);
	}
	
	@Test
	/**
	 * Purpose: Test getRating accessor
	 */
	public void testGetRating() {
		assertEquals(testMovie.getRating() , rating);
	}
	
	@Test
	/**
	 * Purpose: Test getDirectors accessor
	 */
	public void testGetDirectors() {
		directorsEx.add("Steven Spielburg");
		assertEquals(testMovie.getDirectors() , directorsEx);
	}
	
	@Test
	/**
	 * Purpose: Test getCast accessor
	 */
	public void testGetCast() {
		castEx.add("Brad Pitt");
		assertEquals(testMovie.getCast(), castEx);
	}
	
	@Test
	/**
	 * Purpose: test setGenre mutator
	 */
	public void testSetGenre() {
		MovieGenre newGenre = MovieGenre.ACTION;
		testMovie.setGenre(newGenre);
		assertEquals(testMovie.getGenre(), newGenre);
	}
	
	@Test
	/**
	 * Purpose: test setRating mutator
	 */
	public void testSetRating() {
		MpaRating newRating = MpaRating.R;
		testMovie.setRating(newRating);
		assertEquals(testMovie.getRating(), newRating);
	}
	
	@Test
	/**
	 * Purpose: test setDirectors mutator
	 */
	public void testSetDirectors() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Jordan Peele");
		testMovie.setDirectors(testList);
		assertEquals(testMovie.getDirectors(), testList);
	}
	
	@Test
	/**
	 * Purpose: test setCast mutator
	 */
	public void testSetCast() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Nick Cannon");
		testMovie.setCast(testList);
		assertEquals(testMovie.getCast(), testList);
	}
	
	
	/**
	 * Purpose: test toString
	 */
	@Test
	public void testToString() {
		Movie testMovie = new Movie("The Folklore", "Jones Theater", timesEx, 5.00, genre, rating, directorsEx, castEx);
		String testString = super.toString()
				+ "\n     Genre: " + this.genre
				+ "\n     Rating: " + this.rating
				+ "\n     Directors: " + this.directorsEx
				+ "\n     Cast: " + this.castEx;
		assertEquals(testMovie.toString(), testString);
	}
	
}
