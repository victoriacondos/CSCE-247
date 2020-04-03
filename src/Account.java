import org.json.simple.JSONObject;

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
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
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
	
	@Override
	public JSONObject toJSON() {
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(USER, this.getUsername());
		accountDetails.put(PASS, this.getPassword());
		accountDetails.put(ANS, this.getSecurityAnswer());
		return accountDetails;
	}
}
