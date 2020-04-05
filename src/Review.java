import org.json.simple.JSONObject;

public class Review extends DatabaseObject {
	private static final String USER = "user";
	private static final String RATING = "rating";
	private static final String COMMENT = "comment";
	
	private String user;
	private int rating;
	private String comment;
	
	public Review(JSONObject objectJSON) {
		this.user = (String)objectJSON.get(USER);
		this.rating = (int)(long)objectJSON.get(RATING);
		this.comment = (String)objectJSON.get(COMMENT);
	}
	
	public Review(String user, int rating, String comment) {
		this.user = user;
		this.rating = rating;
		this.comment = comment;
	}
	
	public JSONObject toJSON() {
		JSONObject reviewDetails = new JSONObject();
		reviewDetails.put(USER, this.user);
		reviewDetails.put(RATING, this.rating);
		reviewDetails.put(COMMENT, this.comment);
		return reviewDetails;
	}
	public String toString() {
		return "Review by " + this.user + "\n" + this.rating + " Stars\n" + this.comment;
	}
}
