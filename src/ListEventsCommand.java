import java.util.Scanner;

public class ListEventsCommand implements Command {
	public void execute() {
		while (true) {
			System.out.println("\nEvents in Columbia\n\n"
					+ "\t\tMOVIE EVENTS\n");
			int movieStart, concertStart, playStart, totalCount;
			movieStart = 1;
			int movieCount = concertStart = UserInterface.system.movies.printDatabase(movieStart);
			System.out.println("\t\tCONCERT EVENTS\n");
			int concertCount = playStart = UserInterface.system.concerts.printDatabase(concertStart);
			System.out.println("\t\tTHEATRE EVENTS\n");
			int playCount = totalCount = UserInterface.system.plays.printDatabase(playStart);
			System.out.println("Enter the number of the Event you would like to view, or 0 to exit:");
			int response = Dialogue.getUserCommand(playCount);
			playCount -= concertCount;
			concertCount -= movieCount;
			if (response == 0) return;
			Event event = null;
			if (response < concertStart) event = (Event)UserInterface.system.movies.getList().get(response-movieStart);
			else if (response < playStart) event = (Event)UserInterface.system.concerts.getList().get(response-concertStart);
			else if (response < totalCount) event = (Event)UserInterface.system.plays.getList().get(response-playStart);
			System.out.println("\n\n" + event + "\n"
					+ "Enter:\n"
					+ "\t1) to Buy Tickets\n"
					+ "\t2) to View User Reviews\n"
					+ "\t3) to Leave a Review\n"
					+ "\t0) to Go Back");
			int option = Dialogue.getUserCommand(3);
			if (option == 1) {
				System.out.println("What Show Time?");
				int options = event.printShowTimes();
				option = Dialogue.getUserCommand(options);
				String time = event.showTimes.get(option);
				System.out.println("How many tickets? (No more than 20)");
				option = Dialogue.getUserCommand(20);
				Booker booker = new Booker(UserInterface.user.getInventory(), event);
				booker.BuyTickets(option, time);
				System.out.println("\t\t*******************\n"
						+ "\t\tWaiting Transaction\n"
						+ "\t\t*******************\n"
						+ "You can find your ticket(s) in your Inventory");
			} else if (option == 2) {
				event.printReviews();
				System.out.println("Press 0 to go back");
				Dialogue.getUserCommand(0);
			} else {
				System.out.println("\tLeave a Review"
						+ "\n\nRate your experience 1-5");
				int rating = Dialogue.getUserCommand(5);
				System.out.println("Please explain your rating");
				Scanner scanner = new Scanner(System.in);
				String comment = scanner.nextLine();
				event.addReview(UserInterface.user.getUsername(), rating, comment);
			}
			System.out.println("Press 0 to exit");
			Dialogue.getUserCommand(0);
		}
		
	}
}
