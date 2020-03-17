
public class TicketPlanteDriver {
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		RewardsAccountDatabase.loadAccounts();
		ui.run();
	}
}
