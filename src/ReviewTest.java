import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

public class ReviewTest {
	private static final String USER = "user";
	private static final int RATING = 5;
	private static final String COMMENT = "comment";
	
	private Review review;
	
	@Test
	public void testConstructor() {
		review = new Review(USER, RATING, COMMENT);
		String expected = "Review by " + USER +
				"\n" + RATING + " Stars\n" + COMMENT;
		assertEquals(expected, review.toString());
	}
	
	@Test
	public void testJSON() {
		review = new Review(USER, RATING, COMMENT);
		JSONObject objectJSON = review.toJSON();
		Review newReview = new Review(objectJSON);
		assertEquals(review.toString(), newReview.toString());
	}
}
