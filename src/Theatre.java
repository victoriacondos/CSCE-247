import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Elijah Dawkins
 * Purpose: Theatre is a type of event used by the app for showings involving movies.
 */
public class Theatre extends Event {
	private static final String GENRE = "genre";
	private static final String DIRECTORS = "directors";
	private static final String CAST = "cast";
	
	private TheatreGenre genre;
	private ArrayList<String> directors;
	private ArrayList<String> cast;
	
	public Theatre(JSONObject objectJSON) {
		super(objectJSON);
		this.genre = (TheatreGenre)objectJSON.get(GENRE);
		
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
	 * Purpose: Default constructor for Theatre parameters.
	 * @param genre: The genre, or overall theme, of the theatre show.
	 * @param directors: the people who directed the production of the threatre show.
	 * @param cast: actors within the theatre show.
	 */
	public Theatre(String title, String location, String time, double price, TheatreGenre genre, ArrayList<String> directors, ArrayList<String> cast) {
		super(title, location, time, price);
		this.genre = genre;
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
	public ArrayList<String> getDirectors() {
		return directors;
	}

	/**
	 * Purpose: Accessor for cast.
	 * @return: this Theatre's cast
	 */
	public ArrayList<String> getCast() {
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
	public void setDirectors(ArrayList<String> directors) {
		this.directors = directors;
	}

	/**
	 * Purpose: Mutator for cast.
	 * @param values of cast members.
	 */
	public void setCast(ArrayList<String> cast) {
		this.cast = cast;
	}

	public JSONObject toJSON() {
		JSONObject movieDetails = super.toJSON();
		movieDetails.put(GENRE, this.genre);
		
		JSONArray array = new JSONArray();
		for (int i = 0; i < this.directors.size(); i++) array.add(this.directors.get(i));
		movieDetails.put(DIRECTORS, array);
		
		array = new JSONArray();
		for (int i = 0; i < this.cast.size(); i++) array.add(this.cast.get(i));
		movieDetails.put(CAST, array);
		
		return movieDetails;
	}
	
	/**
	 * Purpose: sends message displaying attributes of Theatre when called.
	 * @return String statement of parameters from Theatre.
	 */
	public String toString() {
		return super.toString() + " Genre: " + this.genre + " Directors: " + this.directors +
				" Cast: " + this.cast;
	}
	
}
