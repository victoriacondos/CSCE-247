import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * @author Elijah Dawkins
 * Purpose: type of event used for the majority of the purchases in the app.
 */
public class Movie extends Event {
	private static final String GENRE = "genre";
	private static final String MPA = "ratingMpa";
	private static final String DIRECTORS = "directors";
	private static final String CAST = "cast";
	
	private MovieGenre genre;
	private MpaRating rating;
	private String[] directors;
	private String[] cast;
	
	public Movie(JSONObject objectJSON) {
		super(objectJSON);
		this.genre = (MovieGenre)objectJSON.get(GENRE);
		this.rating = (MpaRating)objectJSON.get(MPA);
		
		JSONArray arrayJSON = (JSONArray)objectJSON.get(DIRECTORS);
		String[] array = new String[arrayJSON.size()];	
		for (int i = 0; i < array.length; i++) array[i] = (String)arrayJSON.get(i);
		this.directors = array;
		
		arrayJSON = (JSONArray)objectJSON.get(CAST);
		String[] array2 = new String[arrayJSON.size()];	
		for (int i = 0; i < array2.length; i++) array2[i] = (String)arrayJSON.get(i);
		this.cast = array;
	}
	
	/**
	 * Purpose: default constructor for Movies.
	 * @param genre: The overall theme of the movie.
	 * @param rating: The rating from the public for the movie.
	 * @param directors: The directors who helped film the movie.
	 * @param cast: actors that performed within the movie.
	 */
	public Movie(String title, String location, String time, double price, MovieGenre genre, MpaRating rating, String[] directors, String[] cast) {
		super(title, location, time, price);
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
	
	public JSONObject toJSON() {
		JSONObject movieDetails = super.toJSON();
		movieDetails.put(GENRE, this.genre);
		movieDetails.put(MPA, this.rating);
		
		JSONArray array = new JSONArray();
		for (int i = 0; i < this.directors.length; i++) array.add(this.directors[i]);
		movieDetails.put(DIRECTORS, array);
		
		array = new JSONArray();
		for (int i = 0; i < this.cast.length; i++) array.add(this.cast[i]);
		movieDetails.put(CAST, array);
		
		return movieDetails;
	}
	
	/**
	 * Purpose: sends message displaying attributes of Movie when called.
	 * @return: String statement of all parameters defining Movie.
	 */
	public String toString() {
		return super.toString()
				+ "\n     Genre: " + this.genre
				+ "\n     Rating: " + this.rating
				+ "\n     Directors: " + this.directors
				+ "\n     Cast: " + this.cast;
	}
}
