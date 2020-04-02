/**
 * @author Brett Logeais
 * Purpose: to create a user account with a username, password, and security answer to a security question
 */
public class Account {
	private String username;
	private String password;
	private String securityAnswer;
	
	/**
	 * Purpose: the create a new account with only a username and password
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

	/**
	 * Purpose: accessor for username
	 * @return username: username of an account
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Purpose: accessor for password
	 * @return password: password of an account
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Purpose: accessor for security answer
	 * @return securityAnswer: security answer for an account's security question
	 */
	public String getSecurityAnswer() {
		return this.securityAnswer;
	}
}
