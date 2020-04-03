import java.util.ArrayList;

public class SystemDatabase {
	public static Database rewards;
	public static Database managers;
	public static Database events;
	
	public SystemDatabase() {
		rewards = new Database("src/accountsRewards.json");
		managers = new Database("src/accountsManager.json");
	}
	
	public static Account logIn(Account accountToLogIn) {
		ArrayList<DatabaseObject> accountsList = managers.getList();
		for (int i = 0; i < accountsList.size(); i++) {
			ManagerAccount account = (ManagerAccount)accountsList.get(i);
			if (accountToLogIn.getUsername().equals(account.getUsername()) &&
					accountToLogIn.getPassword().equals(account.getPassword())) {
				return account;
			}
		}
		accountsList = rewards.getList();
		for (int i = 0; i < accountsList.size(); i++) {
			RewardsAccount account = (RewardsAccount)accountsList.get(i);
			if (accountToLogIn.getUsername().equals(account.getUsername()) &&
					accountToLogIn.getPassword().equals(account.getPassword())) {
				return account;
			}
		}
		return null;
	}
	
	public static boolean signUp(Account accountToSignUp) {
		ArrayList<DatabaseObject> accountsList = managers.getList();
		boolean nameTaken = false;
		nameTaken = searchUsername(accountsList, accountToSignUp.getUsername());
		if (nameTaken) return false;
		accountsList = rewards.getList();
		nameTaken = searchUsername(accountsList, accountToSignUp.getUsername());
		if (nameTaken) return false;
		if (accountToSignUp instanceof ManagerAccount) managers.addObject(accountToSignUp);
		else rewards.addObject(accountToSignUp);
		return true;
	}
	
	private static boolean searchUsername(ArrayList<DatabaseObject> accountsList, String user) {
		for (int i = 0; i < accountsList.size(); i++) {
			Account account = (Account)accountsList.get(i);
			if (account.getUsername().equalsIgnoreCase(user)) {
				return true;
			}
		}
		return false;
	}
}
