/**
 * @author Elizabeth Stevenson
 * Purpose: holds the different movie genres
 */
public enum MovieGenre {
	ACTION, ADVENTURE, COMEDY, DRAMA, HORROR, MUSICAL, ROMANCE, SCIFI;
	public String toString() {
		return this.name();
	}
	public static MovieGenre fromString(String string) {
		MovieGenre genre;
		if (string.equalsIgnoreCase("ACTION")) {
			genre = ACTION;
		} else if (string.equalsIgnoreCase("ADVENTURE")) {
			genre = ADVENTURE;
		} else if (string.equalsIgnoreCase("COMEDY")) {
			genre = COMEDY;
		} else if (string.equalsIgnoreCase("DRAMA")) {
			genre = DRAMA;
		} else if (string.equalsIgnoreCase("HORROR")) {
			genre = HORROR;
		} else if (string.equalsIgnoreCase("MUSICAL")) {
			genre = MUSICAL;
		} else if (string.equalsIgnoreCase("ROMANCE")) {
			genre = ROMANCE;
		} else {
			genre = SCIFI;
		}
		return genre;
	}
}