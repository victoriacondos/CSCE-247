import org.json.simple.JSONObject;

/**
 * @author Brett Logeais
 * Purpose: to create a user account with a username, password, and security answer to a security question
 */
public class Account extends DatabaseObject {
	protected static final String USER = "username";
	protected static final String PASS = "password";
	protected static final String ANS = "securityAnswer";
	
	private String username;
	private String password;
	private String securityAnswer;
	
	/**
	* Purpose: to create a new account from JSON file
	* @param objectJSON: contains info about account username password and security answer
	*/
	public Account(JSONObject objectJSON) {
		this.username = (String)objectJSON.get(USER);
		this.password = (String)objectJSON.get(PASS);
		this.securityAnswer = (String)objectJSON.get(ANS);
	}
	
	/**
	 * Purpose: to create a new account with only a username and password
	 * @param username: username of an account
	 * @param password: password of an account
	 */
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Purpose: to create a new account with username, password, and security answer
	 * @param username: username of an account
	 * @param password: password of an account
	 * @param secAnswer: security answer for an account
	 */
	public Account(String username, String password, String secAnswer) {
		this.username = username;
		this.password = password;
		this.securityAnswer = secAnswer;
	}
	
	/**
	* Purpose: to access an existing account TODO- ?
	* @param account: a pre-existing account
	*/
	public Account(Account account) {
		this.username = account.getUsername();
		this.password = account.getPassword();
		this.securityAnswer = account.getSecurityAnswer();
	}
	
	/**
	* Purpose: accessor for account username
	* @return: a string of account's username
	*/
	public String getUsername() {
		return this.username;
	}
	
	/**
	* Purpose: accessor for account password
	* @return: a string of account's password
	*/
	public String getPassword() {
		return this.password;
	}
	
	/**
	* Purpose: accessor for accounts answer to security question
	* @return: string of account's security answer
	*/
	public String getSecurityAnswer() {
		return this.securityAnswer;
	}
	/**
	* Purpose: TODO- ??
	* @return: Inventory of accounts TODO-??
	*/
	public Inventory getInventory() {
		return null;
	}
	@Override
	public JSONObject toJSON() {
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(USER, this.username);
		accountDetails.put(PASS, this.password);
		accountDetails.put(ANS, this.securityAnswer);
		return accountDetails;
	}
}
