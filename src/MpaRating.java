/**
 * @author Elizabeth Stevenson
 * Purpose: holds the different mpa ratings
 */
public enum MpaRating {
	G, PG, PG13, R, NC17;
	/**
	* Purpose: shows the name
	* @return: name
	*/
	public String toString() {
		return this.name();
	}
	/**
	* Purpose: finds mpa rating in the input
	* @return: MpaRating
	*/
	public static MpaRating fromString(String string) {
		MpaRating rating;
		if (string.equalsIgnoreCase("G")) {
			rating = G;
		} else if (string.equalsIgnoreCase("PG")) {
			rating = PG;
		} else if (string.equalsIgnoreCase("PG13")) {
			rating = PG13;
		} else if (string.equalsIgnoreCase("R")) {
			rating = R;
		} else {
			rating = NC17;
		}
		return rating;
	}
}
