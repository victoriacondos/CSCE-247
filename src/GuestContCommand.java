
public class GuestContCommand implements Command {
	public void execute() {
		System.out.println("\n\t-------------------\n"
				+ "\tContinuing as Guest\n"
				+ "\t-------------------\n");
		UserInterface.user = new Account("Guest", "");
		UserInterface.setMenu(1);
	}
}
