/**
 * @author Brett Logeais
 * Purpose: Holds all databases
 */

import java.util.ArrayList;

public class SystemDatabase {
	public static Database rewards;
	public static Database managers;
	public static Database movies;
	public static Database concerts;
	public static Database plays;
	
	public SystemDatabase() {
		rewards = new Database("src/accountsRewards.json");
		managers = new Database("src/accountsManager.json");
		movies = new Database("src/eventsMovie.json");
		concerts = new Database("src/eventsConcert.json");
		plays = new Database("src/eventsTheatre.json");
	}
	
	/**
	* Purpose: saves all databases
	*/
	public void save() {
		rewards.saveObjects();
		managers.saveObjects();
		movies.saveObjects();
		concerts.saveObjects();
		plays.saveObjects();
	}
	
	/**
	* Purpose: user can log into account
	* @return account
	*/
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
	/**
	* Purpose: user sign up for an account
	* @return true or false if certain criteria has been met
	*/
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
	/**
	* Purpose: to determine if username is already in use
	* @return true or false if username is found in database
	*/
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
