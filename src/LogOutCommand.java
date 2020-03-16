
public class LogOutCommand implements Command {
	public void execute() {
		System.out.println("\n\t-----------\n"
				+ "\tLogging Out\n"
				+ "\t-----------\n");
		
		UserInterface.setMenu(0);
	}
}
