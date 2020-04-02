
public class SignUpCommand implements Command {
	public void execute() {
		boolean signedUp = false;
		boolean isManager = Dialogue.signUp();

		while (!signedUp) {
			if (isManager) {
				ManagerAccount accountToSignUp = new ManagerAccount(Dialogue.getLogIn());
				signedUp = ManagerAccountDatabase.signUp(accountToSignUp);
			} else {
				RewardsAccount accountToSignUp = new RewardsAccount(Dialogue.getLogIn());
				signedUp = RewardsAccountDatabase.signUp(accountToSignUp);
			}
			if (!signedUp) System.out.println("\tTHAT USERNAME IS TAKEN");
		}
		System.out.println("\n\t----------------\n"
				+ "\tCreating Account\n"
				+ "\t----------------\n");
	}
}
