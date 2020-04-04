/**
 * @author Brett Logeais
 * Purpose: logs out user
 */
public class LogOutCommand implements Command {
	/**
	 * Purpose: shows user that they are logged out of their account and goes to the main menu
	 */
	public void execute() {
		System.out.println("\n\t-----------\n"
				+ "\tLogging Out\n"
				+ "\t-----------\n");
		
		UserInterface.setMenu(0);
	}
}
