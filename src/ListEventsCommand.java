
public class ListEventsCommand implements Command {
	public void execute() {
		System.out.println("\nEvents in Columbia\n");
		UserInterface.system.events.printDatabase();
	}
}
