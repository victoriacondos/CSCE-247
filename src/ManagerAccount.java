/**
* Author: Brett Logeais
* Purpose: manages manageraccount info
*/

import org.json.simple.JSONObject;

public class ManagerAccount extends Account {
	/**
	* Purpose: creates manager account from json
	*/
	public ManagerAccount(JSONObject objectJSON) {
		super(objectJSON);
	}
	/**
	* Purpose: creates manager account from username, password, and security answer
	*/
	public ManagerAccount(String username, String password, String secAnswer) {
		super(username, password, secAnswer);
	}
	/**
	* Purpose: creates manager account from preexisting account
	*/
	public ManagerAccount(Account account) {
		super(account);
	}
}
