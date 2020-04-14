/**
* Author: Brett Logeais
* Purpose: command that allows users to view inventory
*/

import java.io.IOException;

public class ViewInventoryCommand implements Command {
	/**
	* Purpose: prompts user to show how many tickets they have
	*/
	public void execute() {
		System.out.println(UserInterface.user + "\n\n"
				+ "Enter:\n"
				+ "\t1) to Print Tickets\n"
				+ "\t0) to exit\n");
		int option = Dialogue.getUserOption(1);
		if (option == 0) return;
		Inventory i = UserInterface.user.getInventory();
		i.TicketWriter(UserInterface.user.getUsername() + "'s Tickets");
	}
}
