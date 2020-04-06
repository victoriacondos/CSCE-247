/**
 * @author Brett Logeais
 * Purpose: I/O for the console
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Dialogue {
	
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Purpose: shows login options
	 * @return Command: user-selected command
	 */
	public static Command welcome() {
		String[] options = {"Log In", "Sign Up", "Continue as Guest"};
		System.out.println("Welcome to TicketPlante\n\nPlease Enter:");
		for (int i = 0; i < options.length; i++)
			System.out.println("\t" + (i+1) + ") to " + options[i]);
		System.out.println("\t0) to Exit");
		int option = getUserOption(3);
		if (option == 1) return new LogInCommand();
		if (option == 2) return new SignUpCommand();
		if (option == 3) return new GuestContCommand();
		return null;
	}
	
	/**
	 * Purpose: shows main menu options
	 * @return Command: user-selected command
	 */
	public static Command mainMenu() {
		String[] options = {"Add an Event", "Find Columbia Events", "View Inventory"};
		boolean isManager = UserInterface.user instanceof ManagerAccount;
		if (isManager) {
			System.out.println("Hello Manager " + UserInterface.user.getUsername());
			System.out.println("\t1) to " + options[0]);
		} else {
			System.out.println("Hello " + UserInterface.user.getUsername());
			for (int i = 1; i < options.length; i++)
				System.out.println("\t" + i + ") to " + options[i]);
		}
		System.out.println("\t0) to Log Out");
		int option = getUserOption(2);
		if (option == 0) return new LogOutCommand();
		if (!isManager) option++;
		if (option == 1) return new AddEventCommand();
		if (option == 2) return new ListEventsCommand();
		if (option == 3) return new ViewInventoryCommand();
		return null;
	}
	
	
	/**
	 * Purpose: gets user input and checks for validity
	 * @param numOptions: number of options available
	 * @return option: corrected user input
	 */
	public static int getUserOption(int numOptions) {
		String input;
		int option = -1;
		while (option > numOptions || option < 0) {
			input = scanner.nextLine();
			try {
				option = Integer.parseInt(input);
			} catch (NumberFormatException ex) {
				System.out.println("\tERROR: Invalid Input");
			}
		}
		return option;
	}
	
	/**
	* Purpose: Prompt user to enter username and password
	* @return: account with corresponding username and password
	*/
	public static Account getLogIn() {
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		return new Account(username, password);
	}
	
	/**
	* Purpose: Checks if user is creating a manager aco;unt
	* @return: true or false of whether or not this is a manager account
	*/
	public static boolean signUp() {
		System.out.println("Is this a Manager Account?\n\nEnter y or n\n");
		String response = scanner.nextLine();
		return response.equalsIgnoreCase("y");
	}
	
	/**
	* Purpose: to create a new event in database with correct info
	* @return : newly created event
	*/
	public static Event createEvent() {
		Event event = null;
		System.out.println("Event TITLE:");
		String title = scanner.nextLine();
		System.out.println("Event LOCATION:");
		String location = scanner.nextLine();
		System.out.println("List the SHOW TIMES. Enter 0 when done");
		ArrayList<String> times = new ArrayList<String>();
		String response = "";
		while (!response.equals("0")) {
			response = scanner.nextLine();
			if (!response.equals("0")) times.add(response);
		}
		System.out.println("Event STANDARD TICKET PRICE:");
		double price = Double.parseDouble(scanner.nextLine());
		System.out.println("Is this a (C)oncert, (T)heatre, a (M)ovie or (N)one listed?");
		String type = scanner.nextLine();
		response = "";
		if (type.equalsIgnoreCase("C")) { 
			System.out.println("List the ARTISTS. Enter 0 when done");
			ArrayList<String> artists = new ArrayList<String>();
			while (!response.equals("0")) {
				response = scanner.nextLine();
				if (!response.equals("0")) artists.add(response);
			}
			MusicGenre genre = getGenreMusic();
			System.out.println("Explicit content? y or n");
			response = scanner.nextLine();
			boolean explicit = response.equalsIgnoreCase("y");
			event = new Concert(title, location, times, price, genre, explicit, artists);
		} else {
			System.out.println("List the DIRECTORS. Enter 0 when done.");
			ArrayList<String> directors = new ArrayList<String>();
			while (!response.equals("0")) {
				response = scanner.nextLine();
				if (!response.equals("0")) directors.add(response);
			}
			response = "";
			ArrayList<String> cast = new ArrayList<String>();
			System.out.println("List the CAST. Enter 0 when done.");
			while (!response.equals("0")) {
				response = scanner.nextLine();
				if (!response.equals("0")) cast.add(response);
			}
			if (type.equalsIgnoreCase("T")) {
				TheatreGenre genre = getGenreTheatre();
				event = new Theatre(title, location, times, price, genre, directors, cast);
			} else {
				MovieGenre genre = getGenreMovie();
				MpaRating rating = getMpaRating();
				event = new Movie(title, location, times, price, genre, rating, directors, cast);
			}
			
		}
		return event;
	}
	/**
	* Purpose: accessor for movie genre
	* @return: correct movie genre
	*/
	private static MovieGenre getGenreMovie() {
		MovieGenre[] genres = MovieGenre.class.getEnumConstants();
		System.out.println("Enter a GENRE:");
		for (int i = 0; i < genres.length; i++)
			System.out.println("\n\t" + (i+1) + ") " + genres[i]);
		int option = getUserOption(genres.length);
		return genres[option-1];
	}
	
	/**
	* Purpose: accessor for music genre
	* @return: correct music genre
	*/
	private static MusicGenre getGenreMusic() {
		MusicGenre[] genres = MusicGenre.class.getEnumConstants();
		System.out.println("Enter a GENRE:");
		for (int i = 0; i < genres.length; i++)
			System.out.println("\n\t" + (i+1) + ") " + genres[i]);
		int option = getUserOption(genres.length);
		return genres[option-1];
	}
	
	/**
	* Purpose: accessor for theatre genre
	* @return correct theatre genre
	*/
	private static TheatreGenre getGenreTheatre() {
		TheatreGenre[] genres = TheatreGenre.class.getEnumConstants();
		System.out.println("Enter a GENRE:");
		for (int i = 0; i < genres.length; i++)
			System.out.println("\n\t" + (i+1) + ") " + genres[i]);
		int option = getUserOption(genres.length);
		return genres[option-1];
	}
	
	/**
	* Purpose: accessor for MPA Rating
	* @return: correct MPA Rating
	*/
	private static MpaRating getMpaRating() {
		MpaRating[] ratings = MpaRating.class.getEnumConstants();
		System.out.println("Enter a MPA RATING:");
		for (int i = 0; i < ratings.length; i++)
			System.out.println("\n\t" + (i+1) + ") " + ratings[i]);
		int option = getUserOption(ratings.length);
		return ratings[option-1];
	}
	
}
