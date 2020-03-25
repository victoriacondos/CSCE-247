/**
 * @author Elijah Dawkins
 * Purpose: Theatre is a type of event used by the app for showings involving movies.
 */
public class Theatre extends Event {
	private TheatreGenre genre;
	private String[] directors;
	private String[] cast;
	
	/**
	 * Purpose: Default constructor for Theatre parameters.
	 * @param genre: The genre, or overall theme, of the theatre show.
	 * @param directors: the people who directed the production of the threatre show.
	 * @param cast: actors within the theatre show.
	 */
	public Theatre(TheatreGenre genre, String[] directors, String[] cast) {
		this.TheatreGenre = genre;
		this.directors = directors;
		this.cast = cast;
	}
	
	/**
	 * Purpose: Accessor for genre.
	 * @return: this Theatre's genre
	 */
	public TheatreGenre getGenre() {
		return genre;
	}

	/**
	 * Purpose: Accessor for directors.
	 * @return: this Theatre's directors
	 */
	public String[] getDirectors() {
		return directors;
	}

	/**
	 * Purpose: Accessor for cast.
	 * @return: this Theatre's cast
	 */
	public String[] getCast() {
		return cast;
	}

	/**
	 * Purpose: Mutator for genre.
	 * @param genre: value of genre.
	 */
	public void setGenre(TheatreGenre genre) {
		this.genre = genre;
	}

	/**
	 * Purpose: Mutator for directors.
	 * @param directors: values of directors.
	 */
	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	/**
	 * Purpose: Mutator for cast.
	 * @param values of cast members.
	 */
	public void setCast(String[] cast) {
		this.cast = cast;
	}

	/**
	 * Purpose: sends message displaying attributes of Theatre when called.
	 * @return String to user
	 */
	public String toString() {
		// TODO
	}
	
}
