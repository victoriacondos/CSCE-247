/**
* Author: Brett Logeais
* Purpose: allows use to write reviews on an event
*/

import org.json.simple.JSONObject;

public class Review extends DatabaseObject {
	private static final String USER = "user";
	private static final String RATING = "rating";
	private static final String COMMENT = "comment";
	
	private String user;
	private int rating;
	private String comment;
	
	/**
	* Purpose: creates new review from json
	*/
	public Review(JSONObject objectJSON) {
		this.user = (String)objectJSON.get(USER);
		this.rating = ((Number)objectJSON.get(RATING)).intValue();
		this.comment = (String)objectJSON.get(COMMENT);
	}
	
	/**
	* Purpose: creates new review with user, rating, and comment
	* @param user
	* @param rating
	* @param comment
	*/
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
	/**
	* Purpose: to print a review
	* @return String of the review
	*/
	public String toString() {
		return "Review by " + this.user + "\n" + this.rating + " Stars\n" + this.comment;
	}
}
