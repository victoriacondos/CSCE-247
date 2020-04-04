
public class ListEventsCommand implements Command {
	public void execute() {
		System.out.println("\nEvents in Columbia\n\n"
				+ "\t\tMOVIE EVENTS\n");
		int count = 1;
		count = UserInterface.system.movies.printDatabase(count);
		System.out.println("\t\tCONCERT EVENTS\n");
		count = UserInterface.system.concerts.printDatabase(count);
		System.out.println("\t\tTHEATRE EVENTS\n");
		UserInterface.system.plays.printDatabase(count);
	}
}
