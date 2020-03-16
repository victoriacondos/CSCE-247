
public class Account {
	private String username;
	private String password;
	private String securityAnswer;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Account(String username, String password, String secAnswer) {
		this.username = username;
		this.password = password;
		this.securityAnswer = secAnswer;
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
}
