/**
 * @author Elijah Dawkins
 * Purpose: type of event used for the majority of the purchases in the app.
 */
public class Concert extends Event {
	private MusicGenre genre;
	private boolean explicitContent;
	private String[] artists;
	
	/**
	 * Purpose: default constructor for Concert parameters.
	 * @param genre: the genre, or type of music, of the concert.
	 * @param explicitContent: boolean determining whether the concert is mature(true) or for all ages(false)
	 * @param artists: the artists, or performers/producers, within the concert.
	 */
	public Concert(String title, String location, String time, double price, MusicGenre genre, boolean explicitContent, String[] artists) {
		super(title, location, time, price);
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
	public String[] getArtists() {
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
	public void setArtists(String[] artists) {
		this.artists = artists;
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
