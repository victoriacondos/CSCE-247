/**
 * @author Elizabeth Stevenson
 * Purpose: holds the different movie genres
 */
public enum MovieGenre {
	ACTION, ADVENTURE, COMEDY, DRAMA, HORROR, MUSICAL, ROMANCE, SCIFI;
	/**
	* Purpose: returns name
	* @return: name
	*/
	public String toString() {
		return this.name();
	}
}
