/**
 * @author Brett Logeais
 * Purpose: user interface to the ticketing system
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
		System.out.println("Welcome to TicketPlante\n\n"
				+ "Please enter:\n"
				+ "\t1) to Log In\n"
				+ "\t2) to Sign Up\n"
				+ "\t3) to Continue as Guest\n"
				+ "\t0) to Exit\n");
		int option = getUserCommand(3);
		if (option == 0) return null;
		if (option == 1) return new LogInCommand();
		if (option == 2) return new SignUpCommand();
		else {
			System.out.println("\n\t-------------------\n"
					+ "\tContinuing as Guest\n"
					+ "\t-------------------\n");
			UserInterface.user = new Account("Guest", "");
			UserInterface.setMenu(1);
			return null;
		}
	}
	
	/**
	 * Purpose: shows main menu options
	 * @return Command: user-selected command
	 */
	public static Command mainMenu() {
		if (UserInterface.user instanceof ManagerAccount) {
			System.out.println("Hello Manager " + UserInterface.user.getUsername() + "\n\n"
					+ "Please enter:\n"
					+ "\t1) to Add an Event\n"
					+ "\t2) to Edit an Event\n"
					+ "\t3) to Remove an Event\n"
					+ "\t0) to Log Out");
			int option = getUserCommand(3);
			if (option == 0) return new LogOutCommand();
			if (option == 1) return new AddEventCommand();
			
		} else {
			System.out.println("Hello " + UserInterface.user.getUsername() + "\n\n"
					+ "Please enter:\n"
					+ "\t1) to Find Columbia Events\n"
					+ "\t2) to View Inventory\n"
					+ "\t0) to Log Out");
			int option = getUserCommand(2);
			if (option == 0) return new LogOutCommand();
			if (option == 1) return new ListEventsCommand();
			else return new ViewInventoryCommand();
		}
		return null;
	}
	
	
	/**
	 * Purpose: gets user input and checks for validity
	 * @param numCommands: number of commands available
	 * @return command: corrected user input
	 */
	public static int getUserCommand(int numCommands) {
		String input;
		int command = -1;
		while (command > numCommands || command < 0) {
			input = scanner.nextLine();
			try {
				command = Integer.parseInt(input);
			} catch (NumberFormatException ex) {
				System.out.println("\tERROR: Invalid Input");
			}
		}
		return command;
	}
	
	public static Account getLogIn() {
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		return new Account(username, password);
	}
	
	public static boolean signUp() {
		System.out.println("Is this a Manager Account?\n\nEnter y or n\n");
		String response = scanner.nextLine();
		return response.equalsIgnoreCase("y");
	}
	
	public static Event createEvent() {
		Event event = null;
		System.out.println("Event TITLE:");
		String title = scanner.nextLine();
		System.out.println("Event LOCATION:");
		String location = scanner.nextLine();
		System.out.println("Event TIME:");
		String time = scanner.nextLine();
		System.out.println("Event STANDARD TICKET PRICE:");
		double price = Double.parseDouble(scanner.nextLine());
		System.out.println("Is this a (C)oncert, (T)heatre, a (M)ovie or (N)one listed?");
		String type = scanner.nextLine();
		String response = "";
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
			event = new Concert(title, location, time, price, genre, explicit, artists);
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
				event = new Theatre(title, location, time, price, genre, directors, cast);
			} else {
				MovieGenre genre = getGenreMovie();
				MpaRating rating = getMpaRating();
				event = new Movie(title, location, time, price, genre, rating, directors, cast);
			}
			
		}
		return event;
	}
	private static MovieGenre getGenreMovie() {
		System.out.println("Enter a GENRE:");
		String[] genres = {"ACTION", "ADVENTURE", "COMEDY", "DRAMA", "HORROR", "MUSICAL", "ROMANCE", "SCIFI"};
		for (int i = 0; i < genres.length; i++) {
			System.out.println("\n\t" + (i+1) + ") " + genres[i]);
		}
		MovieGenre genre = null;
		int response = getUserCommand(8);
		switch (response) {
			case 1: genre = MovieGenre.ACTION; break;
			case 2: genre = MovieGenre.ADVENTURE; break;
			case 3: genre = MovieGenre.COMEDY; break;
			case 4: genre = MovieGenre.DRAMA; break;
			case 5: genre = MovieGenre.HORROR; break;
			case 6: genre = MovieGenre.MUSICAL; break;
			case 7: genre = MovieGenre.ROMANCE; break;
			default: genre = MovieGenre.SCIFI; break;
		}
		return genre;
	}
	
	private static MusicGenre getGenreMusic() {
		System.out.println("Enter a GENRE:");
		String[] genres = {"COUNTRY", "EDM", "JAZZ", "POP", "RnB", "HIPHOP" , "ROCK", "SEASONAL"};
		for (int i = 0; i < genres.length; i++) System.out.println("\n\t" + (i+1) + ") " + genres[i]);
		MusicGenre genre = null;
		int response = getUserCommand(8);
		System.out.println(response);
		switch (response) {
			case 1: genre = MusicGenre.COUNTRY; break;
			case 2: genre = MusicGenre.EDM; break;
			case 3: genre = MusicGenre.HIPHOP; break;
			case 4: genre = MusicGenre.JAZZ; break;
			case 5: genre = MusicGenre.POP; break;
			case 6: genre = MusicGenre.RnB; break;
			case 7: genre = MusicGenre.ROCK; break;
			default: genre = MusicGenre.SEASONAL; break;
		}
		return genre;
	}
	private static TheatreGenre getGenreTheatre() {
		System.out.println("Enter a GENRE:");
		String[] genres = {"COMEDY", "DRAMA", "EXPERIMENTAL", "MUSICAL", "PHYSICAL", "TRAGEDY"};
		for (int i = 0; i < genres.length; i++) {
			System.out.println("\n\t" + (i+1) + ") " + genres[i]);
		}
		TheatreGenre genre = null;
		int response = getUserCommand(6);
		switch (response) {
			case 1: genre = TheatreGenre.COMEDY; break;
			case 2: genre = TheatreGenre.DRAMA; break;
			case 3: genre = TheatreGenre.EXPERIMENTAL; break;
			case 4: genre = TheatreGenre.MUSICAL; break;
			case 5: genre = TheatreGenre.PHYSICAL; break;
			default: genre = TheatreGenre.TRAGEDY; break;
		}
		return genre;
	}
	
	private static MpaRating getMpaRating() {
		System.out.println("Enter a MPA RATING:");
		String[] ratings = {"G", "PG", "PG13", "R", "NC17"};
		for (int i = 0; i < ratings.length; i++) {
			System.out.println("\n\t" + (i+1) + ") " + ratings[i]);
		}
		MpaRating rating = null;
		int response = getUserCommand(5);
		switch (response) {
			case 1: rating = MpaRating.G; break;
			case 2: rating = MpaRating.PG; break;
			case 3: rating = MpaRating.PG13; break;
			case 4: rating = MpaRating.R; break;
			default: rating = MpaRating.NC17; break;
		}
		return rating;
	}
	
}
