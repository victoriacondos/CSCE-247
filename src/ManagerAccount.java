/**
* author Brett Logeais
* Purpose: object for an account belonging to a Manager
*/
import org.json.simple.JSONObject;

public class ManagerAccount extends Account {
	/**
	* Purpose: constructor that loads data from JSON file into constructor from base account class
	* @param: objectJSON: a JSONObject that holds account data
	*/
	public ManagerAccount(JSONObject objectJSON) {
		super(objectJSON);
	}
	
	/**
	* Purpsoe: constructor that loads params username, password, and secAnswer into constructor from base account class
	* @param: username: String of account username
	* @param: password: String of account password
	* @param secAnswer: String of account secAnswer
	*/
	public ManagerAccount(String username, String password, String secAnswer) {
		super(username, password, secAnswer);
	}
	
	/**
	* Purpose: constructor that loads account info from existing account into constructor from base account class
	* @param: account: An account that has already been created
	*/
	public ManagerAccount(Account account) {
		super(account);
	}
}
