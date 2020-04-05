
public class SignUpCommand implements Command {
	public void execute() {
		boolean signedUp = false;
		boolean isManager = Dialogue.signUp();
		Account accountToSignUp;
		while (!signedUp) {
			if (isManager) {
				accountToSignUp = new ManagerAccount(Dialogue.getLogIn());
			} else {
				accountToSignUp = new RewardsAccount(Dialogue.getLogIn(), new Inventory());
			}
			signedUp = SystemDatabase.signUp(accountToSignUp);
			if (!signedUp) System.out.println("\tTHAT USERNAME IS TAKEN");
		}
		System.out.println("\n\t----------------\n"
				+ "\tCreating Account\n"
				+ "\t----------------\n");
	}
}
