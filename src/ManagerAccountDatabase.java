
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;	
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ManagerAccountDatabase {
	private static final String FILE_NAME = "src/accountsManager.json";
	
	private static ArrayList<ManagerAccount> accountsList;
	
	public static void loadAccounts() {
		ArrayList<ManagerAccount> accounts = new ArrayList<ManagerAccount>();
		JSONParser parser = new JSONParser();
		
		try {
			FileReader reader = new FileReader(FILE_NAME);
			
			JSONObject jsonData = (JSONObject)parser.parse(reader);
			JSONArray accountsJSON = (JSONArray)jsonData.get("accounts");
			
			for (int i = 0; i < accountsJSON.size(); i++) {
				JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
				String username = (String)accountJSON.get("username");
				String password = (String)accountJSON.get("password");
				String secAnswer = (String)accountJSON.get("securityAnswer");
				
				accounts.add(new ManagerAccount(username, password, secAnswer));
			}
			
			accountsList = accounts;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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