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
			else {
				return null;
			}
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
		System.out.println("Is this a (M)ovie, (C)oncert, (P)lay, or (N)one listed?");
		String response = scanner.nextLine();
		if (response.equalsIgnoreCase("C")) { 
			System.out.println("List the artists. Enter 0 when done");
			ArrayList<String> artists = new ArrayList<String>();
			String response2 = "";
			while (!response2.equals("0")) {
				response2 = scanner.nextLine();
				artists.add(response2);
			}
			MusicGenre genre = getGenreMusic();
			System.out.println("Explicit content? y or n");
			response2 = scanner.nextLine();
			boolean explicit = response2.equalsIgnoreCase("y");
			event = new Concert(title, location, time, price, genre, explicit, artists);
		}
		return event;
	}
	private static MovieGenre getGenreMovie() {
		System.out.println("Enter a genre:");
		String[] genres = {"ACTION", "ADVENTURE", "COMEDY", "DRAMA", "HORROR", "MUSICAL", "ROMANCE", "SCIFI"};
		for (int i = 0; i < genres.length; i++) {
			System.out.println("\n\t" + (i+1) + ") " + genres[i]);
		}
		MovieGenre genre = null;
		int response = getUserCommand(genres.length);
		switch (response) {
			case 1:
				genre = MovieGenre.ACTION;
			case 2:
				genre = MovieGenre.ADVENTURE;
			case 3:
				genre = MovieGenre.COMEDY;
			case 4:
				genre = MovieGenre.DRAMA;
			case 5:
				genre = MovieGenre.HORROR;
			case 6:
				genre = MovieGenre.MUSICAL;
			case 7:
				genre = MovieGenre.ROMANCE;
			default:
				genre = MovieGenre.SCIFI;
		}
		return genre;
	}
	
	private static MusicGenre getGenreMusic() {
		System.out.println("Enter a genre:");
		String[] genres = {"COUNTRY", "EDM", "JAZZ", "POP", "RnB", "HIPHOP" , "ROCK", "SEASONAL"};
		for (int i = 0; i < genres.length; i++) {
			System.out.println("\n\t" + (i+1) + ") " + genres[i]);
		}
		MusicGenre genre = null;
		int response = getUserCommand(genres.length);
		switch (response) {
			case 1:
				genre = MusicGenre.COUNTRY;
			case 2:
				genre = MusicGenre.EDM;
			case 3:
				genre = MusicGenre.HIPHOP;
			case 4:
				genre = MusicGenre.JAZZ;
			case 5:
				genre = MusicGenre.POP;
			case 6:
				genre = MusicGenre.RnB;
			case 7:
				genre = MusicGenre.ROCK;
			default:
				genre = MusicGenre.SEASONAL;
		}
		return genre;
	}
	private static TheatreGenre getGenreTheatre() {
		return null;
	}
}
