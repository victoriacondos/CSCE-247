import org.json.simple.JSONObject;

public class ManagerAccount extends Account {
	public ManagerAccount(JSONObject objectJSON) {
		super(objectJSON);
	}
	public ManagerAccount(String username, String password, String secAnswer) {
		super(username, password, secAnswer);
	}
	public ManagerAccount(Account account) {
		super(account);
	}
}
