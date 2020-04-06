
public class AddEventCommand implements Command{
	public void execute() {
		System.out.println("\t Add an event\n\n");
		Event event = Dialogue.createEvent();
		if (event == null) return;
		if (event instanceof Movie) {
			UserInterface.system.movies.addObject(event);
		} else if (event instanceof Concert) {
			UserInterface.system.concerts.addObject(event);
		} else if (event instanceof Theatre) {
			UserInterface.system.concerts.addObject(event);
		} else {
			return;
		}
	}
}
