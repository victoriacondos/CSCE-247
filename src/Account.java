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
	 * @param username
	 * @param password
	 * @param secAnswer
	 */
	public Account(String username, String password, String secAnswer) {
		this.username = username;
		this.password = password;
		this.securityAnswer = secAnswer;
	}
	
	public Account(Account account) {
		this.username = account.getUsername();
		this.password = account.getPassword();
		this.securityAnswer = account.getSecurityAnswer();
	}

	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getSecurityAnswer() {
		return this.securityAnswer;
	}
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
