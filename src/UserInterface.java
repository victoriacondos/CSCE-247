import java.util.Scanner;

public class UserInterface {
	
	public static SystemDatabase system;
	public static Account user;
	private Dialogue dialogue;
	private static String menu;
	private static String[] menuOptions = {"Welcome", "Main Menu", "Find Events", "View Inventory", "Checkout"};
	
	public UserInterface() {
		dialogue = new Dialogue();
		menu = menuOptions[0];
		system = new SystemDatabase();
	}
	
	public void run() {
		Command command = null;
		while (true) {
			if (menu == menuOptions[1]) command = Dialogue.mainMenu();
			else if (menu == menuOptions[0]) command = Dialogue.welcome();
			
			if (command != null) command.execute();
			else if (menu == menuOptions[0]) return;
		}
	}
	
	private static Command findEvents() {
		System.out.println("Here's some events dawg");
		return new LogInCommand();
	}
	
	public static void setMenu(int option) {
		menu = menuOptions[option];
	}
}
