
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;	
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ManagerAccountDatabase {
	private static final String FILE_NAME = "src/accountsManager.json";
	private static final String ACC = "account";
	private static final String USER = "username";
	private static final String PASS = "password";
	private static final String ANS = "securityAnswer";
	
	private static ArrayList<ManagerAccount> accountsList;
	
	public static void loadAccounts() {
		ArrayList<ManagerAccount> accounts = new ArrayList<ManagerAccount>();
		
		try {
			FileReader reader = new FileReader(FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray accountsJSON = (JSONArray)parser.parse(reader);
			
			for (int i = 0; i < accountsJSON.size(); i++) {
				JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
				String username = (String)accountJSON.get(USER);
				String password = (String)accountJSON.get(PASS);
				String secAnswer = (String)accountJSON.get(ANS);
				
				accounts.add(new ManagerAccount(username, password, secAnswer));
			}
			accountsList = accounts;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveAccounts() {
		JSONArray accountsJSON = new JSONArray();
		
		for (int i = 0; i < accountsList.size(); i++) {
			accountsJSON.add(getAccountJSON(accountsList.get(i)));
		}
		
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(accountsJSON.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getAccountJSON(ManagerAccount account) {
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(USER, account.getUsername());
		accountDetails.put(PASS, account.getPassword());
		accountDetails.put(ANS, account.getSecurityAnswer());
        return accountDetails;
	}
	
	public static boolean signUp(ManagerAccount accountToSignUp) {
		for (int i = 0; i < accountsList.size(); i++) {
			ManagerAccount account = accountsList.get(i);
			if (accountToSignUp.getUsername().equalsIgnoreCase(account.getUsername())) {
				return false;
			}
		}
		accountsList.add(accountToSignUp);
		return true;
	}
	
	public static Account logIn(Account accountToLogIn) {
		for (int i = 0; i < accountsList.size(); i++) {
			ManagerAccount account = accountsList.get(i);
			if (accountToLogIn.getUsername().equals(account.getUsername()) &&
					accountToLogIn.getPassword().equals(account.getPassword())) {
				return account;
			}
		}
		return null;
	}
	public static void print() {
		for (int i = 0; i < accountsList.size()-1; i++) {
			System.out.println(accountsList.get(i).getUsername());
		}
	}
}