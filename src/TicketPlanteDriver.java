
public class TicketPlanteDriver {
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		RewardsAccountDatabase.loadAccounts();
		ManagerAccountDatabase.loadAccounts();
		ui.run();
		RewardsAccountDatabase.saveAccounts();
		ManagerAccountDatabase.saveAccounts();
	}
}
