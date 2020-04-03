/**
 * @author Brett Logeais
 * Purpose: works out the user sign up sequence
 */
public class SignUpCommand implements Command {
	/**
	 * Purpose: shows user account is created
	 */
	public void execute() {
		boolean isManager = Dialogue.signUp();
		if (isManager) {
			System.out.println("Congrats");
		} else {
			System.out.println("Rewarddd");
		}
		System.out.println("\n\t----------------\n"
				+ "\tCreating Account\n"
				+ "\t----------------\n");
	}
}
