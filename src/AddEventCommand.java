/**
* Author: Brett Logeais
* Purpose: command that allows for events to be added to system
*/
public class AddEventCommand implements Command{
	/**
	* Purpose: prompts for event to be added based on its type (Movie, Concert, Theatre Event)
	*/
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
