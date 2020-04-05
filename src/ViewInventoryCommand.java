import java.io.IOException;

public class ViewInventoryCommand implements Command {
	public void execute() {
		System.out.println(UserInterface.user + "\n\n"
				+ "Enter:\n"
				+ "\t1) to Print Tickets\n"
				+ "\t0) to exit\n");
		int option = Dialogue.getUserCommand(1);
		if (option == 0) return;
		Inventory i = UserInterface.user.getInventory();
		try {
			i.TicketWriter(UserInterface.user.getUsername() + "'s Tickets");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
