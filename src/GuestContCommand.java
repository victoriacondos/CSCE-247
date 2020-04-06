/**
* Author: Brett Logeais
* Purpose: command that allows for guests to use system
*/
public class GuestContCommand implements Command {
	/**
	* Purpose: prompts user that they are a guest
	*/
	public void execute() {
		System.out.println("\n\t-------------------\n"
				+ "\tContinuing as Guest\n"
				+ "\t-------------------\n");
		UserInterface.user = new Account("Guest", "");
		UserInterface.setMenu(1);
	}
}
