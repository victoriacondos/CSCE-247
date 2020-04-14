import org.json.simple.JSONObject;

import java.util.ArrayList;

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
	private ArrayList<String> directors;
	private ArrayList<String> cast;
	
	public Movie(JSONObject objectJSON) {
		super(objectJSON);
		this.genre = MovieGenre.valueOf((String)objectJSON.get(GENRE));
		this.rating = MpaRating.valueOf((String)objectJSON.get(MPA));
		
		JSONArray arrayJSON = (JSONArray)objectJSON.get(DIRECTORS);
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < arrayJSON.size(); i++) array.add((String)arrayJSON.get(i));
		this.directors = array;
		
		arrayJSON = (JSONArray)objectJSON.get(CAST);
		array = new ArrayList<String>();
		for (int i = 0; i < arrayJSON.size(); i++) array.add((String)arrayJSON.get(i));
		this.cast = array;
	}
	
	/**
	 * Purpose: default constructor for Movies.
	 * @param genre: The overall theme of the movie.
	 * @param rating: The rating from the public for the movie.
	 * @param directors: The directors who helped film the movie.
	 * @param cast: actors that performed within the movie.
	 */
	public Movie(String title, String location, ArrayList<String> times, double price, MovieGenre genre, MpaRating rating, ArrayList<String> directors, ArrayList<String> cast) {
		super(title, location, times, price);
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
	public ArrayList<String> getDirectors() {
		return directors;
	}

	/**
	 * Purpose: Accessor for cast
	 * @return: cast of movie
	 */
	public ArrayList<String> getCast() {
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
	public void setDirectors(ArrayList<String> directors) {
		this.directors = directors;
	}

	/**
	 * Purpose: Mutator for cast
	 * @param cast: cast of the movie
	 */
	public void setCast(ArrayList<String> cast) {
		this.cast = cast;
	}
	
	public JSONObject toJSON() {
		JSONObject movieDetails = super.toJSON();
		movieDetails.put(GENRE, this.genre.toString());
		movieDetails.put(MPA, this.rating.toString());
		
		JSONArray array = new JSONArray();
		for (int i = 0; i < this.directors.size(); i++) array.add(this.directors.get(i));
		movieDetails.put(DIRECTORS, array);
		
		array = new JSONArray();
		for (int i = 0; i < this.cast.size(); i++) array.add(this.cast.get(i));
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
