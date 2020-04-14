/**
 * @author Brett Logeais
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnumsTest {
	
	private static MpaRating mpa;
	private static MovieGenre mov;
	private static MusicGenre mus;
	private static TheatreGenre ttr;
	
	@Test
	public void testMpaRating() {
		mpa = MpaRating.NC17;
		assertEquals(mpa.toString(), "NC17");
	}
	
	@Test
	public void testMovieGenre() {
		mov = MovieGenre.SCIFI;
		assertEquals(mov.toString(), "SCIFI");
	}
	
	@Test
	public void testMusicGenre() {
		mus = MusicGenre.SEASONAL;
		assertEquals(mus.toString(), "SEASONAL");
	}
	
	@Test
	public void testTheatreGenre() {
		ttr = TheatreGenre.TRAGEDY;
		assertEquals(ttr.toString(), "TRAGEDY");
	}
}
