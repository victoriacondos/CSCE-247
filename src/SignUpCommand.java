
public class SignUpCommand implements Command {
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
