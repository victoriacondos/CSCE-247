
public class ListEventsCommand implements Command {
	public void execute() {
		System.out.println("\nEvents in Columbia\n\n"
				+ "\t\tMOVIE EVENTS\n");
		int movieStart, concertStart, playStart, totalCount;
		movieStart = 1;
		int movieCount = concertStart = UserInterface.system.movies.printDatabase(movieStart);
		System.out.println("\t\tCONCERT EVENTS\n");
		int concertCount = playStart = UserInterface.system.concerts.printDatabase(concertStart);
		System.out.println("\t\tTHEATRE EVENTS\n");
		int playCount = totalCount = UserInterface.system.plays.printDatabase(playStart);
		System.out.println("Enter the number of the Event you would like to purchase:");
		int response = Dialogue.getUserCommand(playCount);
		playCount -= concertCount;
		concertCount -= movieCount;
		if (response == 0) return;
		Event event = null;
		if (response < concertStart) event = (Event)UserInterface.system.movies.getList().get(response-movieStart);
		else if (response < playStart) event = (Event)UserInterface.system.concerts.getList().get(response-concertStart);
		else if (response < totalCount) event = (Event)UserInterface.system.plays.getList().get(response-playStart);
		
		
	}
}
