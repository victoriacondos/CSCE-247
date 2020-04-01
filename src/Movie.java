/**
 * @author Elijah Dawkins
 * Purpose: type of event used for the majority of the purchases in the app.
 */
public class Movie extends Event {
	private MovieGenre genre;
	private MpaRating rating;
	private String[] directors;
	private String[] cast;
	
	/**
	 * Purpose: default constructor for Movies.
	 * @param genre: The overall theme of the movie.
	 * @param rating: The rating from the public for the movie.
	 * @param directors: The directors who helped film the movie.
	 * @param cast: actors that performed within the movie.
	 */
	public Movie(String title, String location, double price, MovieGenre genre, MpaRating rating, String[] directors, String[] cast) {
		super(title, location, price);
		this.genre = genre;
		this.rating = rating;
		this.directors = directors;
		this.cast = cast;
	}
	
	/**
	 * Purpose: Accessor for genre
	 * @return: genre of movie
	 */
	public MovieGenre getGenre() {
		return genre;
	}

	/**
	 * Purpose: Accessor for rating
	 * @return: rating of movie
	 */
	public MpaRating getRating() {
		return rating;
	}

	/**
	 * Purpose: Accessor for directors
	 * @return directors of movie
	 */
	public String[] getDirectors() {
		return directors;
	}

	/**
	 * Purpose: Accessor for cast
	 * @return: cast of movie
	 */
	public String[] getCast() {
		return cast;
	}

	/**
	 * Purpose: Mutator for genre
	 * @param genre: genre of the movie
	 */
	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

	/**
	 * Purpose: Mutator for ratings
	 * @param rating: rating of the movie
	 */
	public void setRating(MpaRating rating) {
		this.rating = rating;
	}

	/**
	 * Purpose: Mutator for directors
	 * @param directors: directors of the movie
	 */
	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	/**
	 * Purpose: Mutator for cast
	 * @param cast: cast of the movie
	 */
	public void setCast(String[] cast) {
		this.cast = cast;
	}

	/**
	 * Purpose: sends message displaying attributes of Movie when called.
	 * @return: String statement of all parameters defining Movie.
	 */
	public String toString() {
		return super.toString() + " Genre: " + this.genre + " Rating: " + this.rating + 
				" Directors: " + this.directors + " Cast: " + this.cast;
	}
}
