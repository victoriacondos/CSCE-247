
public class SignUpCommand implements Command {
	public void execute() {
		boolean signedUp = false;
		boolean isManager = Dialogue.signUp();
		if (isManager) {
			System.out.println("Congrats");
		} else {
			while (!signedUp) {
				RewardsAccount accountToSignUp = new RewardsAccount(Dialogue.logIn());
				signedUp = RewardsAccountDatabase.signUp(accountToSignUp);
				if (!signedUp) System.out.println("\tTHAT USERNAME IS TAKEN");
			}
		}
		System.out.println("\n\t----------------\n"
				+ "\tCreating Account\n"
				+ "\t----------------\n");
	}
}
