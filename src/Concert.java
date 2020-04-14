import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Elijah Dawkins
 * Purpose: type of event used for the majority of the purchases in the app.
 */
public class Concert extends Event {
	private static final String GENRE = "genre";
	private static final String EXPLICIT = "explicitContent";
	private static final String ARTISTS = "artists";
	
	private MusicGenre genre;
	private boolean explicitContent;
	private ArrayList<String> artists;
	
	public Concert(JSONObject objectJSON) {
		super(objectJSON);
		this.genre = MusicGenre.valueOf((String)objectJSON.get(GENRE));
		this.explicitContent = (boolean)objectJSON.get(EXPLICIT);
		JSONArray arrayJSON = (JSONArray)objectJSON.get(ARTISTS);
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < arrayJSON.size(); i++) array.add((String)arrayJSON.get(i));
		this.artists = array;
	}
	
	/**
	 * Purpose: default constructor for Concert parameters.
	 * @param genre: the genre, or type of music, of the concert.
	 * @param explicitContent: boolean determining whether the concert is mature(true) or for all ages(false)
	 * @param artists: the artists, or performers/producers, within the concert.
	 */
	public Concert(String title, String location, ArrayList<String> times, double price, MusicGenre genre, boolean explicitContent, ArrayList<String> artists) {
		super(title, location, times, price);
		this.genre = genre;
		this.explicitContent = explicitContent;
		this.artists = artists;
	}
	
	/**
	 * Purpose: Accessor for genre.
	 * @return: genre of the concerts music
	 */
	public MusicGenre getGenre() {
		return genre;
	}

	/**
	 * Purpose: Accessor for explicitContent
	 * @return: if the concert is mature(true) or all ages(false)
	 */
	public boolean isExplicitContent() {
		return explicitContent;
	}

	/**
	 * Purpose: Accessor for artists
	 * @return: artists attending the concert
	 */
	public ArrayList<String> getArtists() {
		return artists;
	}

	/**
	 * Purpose: Mutator for genre
	 * @param genre: genre of the concerts music.
	 */
	public void setGenre(MusicGenre genre) {
		this.genre = genre;
	}

	/**
	 * Purpose: Mutator for explicitContent.
	 * @param explicitContent: boolean for if the content of the concert is mature(true) or for all ages(false).
	 */
	public void setExplicitContent(boolean explicitContent) {
		this.explicitContent = explicitContent;
	}

	/**
	 * Purpose: Mutator for artists
	 * @param artists: artists attending concert
	 */
	public void setArtists(ArrayList<String> artists) {
		this.artists = artists;
	}
	
	public JSONObject toJSON() {
		JSONObject movieDetails = super.toJSON();
		movieDetails.put(GENRE, this.genre);
		movieDetails.put(EXPLICIT, this.explicitContent);
		
		JSONArray array = new JSONArray();
		for (int i = 0; i < this.artists.size(); i++) array.add(this.artists.get(i));
		movieDetails.put(ARTISTS, array);
		
		return movieDetails;
	}
	
	/**
	 * Purpose: sends message displaying attributes of Concert when called.
	 * @return String statement of parameters from Concert.
	 */
	public String toString() {
		return super.toString() + " Genre: " + this.genre + " Explicit Content: " + 
				this.explicitContent + "Artists: " + this.artists;
	}
	
}
