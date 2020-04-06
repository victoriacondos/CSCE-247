import java.util.Scanner;

public class UserInterface {
	
	public static SystemDatabase system;
	public static Account user;
	private Dialogue dialogue;
	private static String menu;
	private static String[] menuOptions = {"Welcome", "Main Menu"};
	
	public UserInterface() {
		system = new SystemDatabase();
		menu = menuOptions[0];
		dialogue = new Dialogue();
	}
	
	public void run() {
		Command command = null;
		while (true) {
			if (menu == menuOptions[0]) command = Dialogue.welcome();
			else if (menu == menuOptions[1]) command = Dialogue.mainMenu();
			
			if (command != null) command.execute();
			else if (menu == menuOptions[0])  {
				system.save();
				return;
			}
		}
	}
	
	public static void setMenu(int option) {
		menu = menuOptions[option];
	}
}