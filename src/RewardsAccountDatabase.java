
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;	
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RewardsAccountDatabase {
	private static final String FILE_NAME = "src/accountsRewards.json";
	private static final String ACC = "accounts";
	private static final String USER = "username";
	private static final String PASS = "password";
	private static final String ANS = "securityAnswer";
	private static final String POINTS = "rewardsPoints";
	
	private static ArrayList<RewardsAccount> accountsList;
	
	public static void loadAccounts() {
		ArrayList<RewardsAccount> accounts = new ArrayList<RewardsAccount>();
		JSONParser parser = new JSONParser();
		
		try {
			FileReader reader = new FileReader(FILE_NAME);
			
			JSONObject jsonData = (JSONObject)parser.parse(reader);
			JSONArray accountsJSON = (JSONArray)jsonData.get(ACC);
			
			for (int i = 0; i < accountsJSON.size(); i++) {
				JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
				String username = (String)accountJSON.get(USER);
				String password = (String)accountJSON.get(PASS);
				String secAnswer = (String)accountJSON.get(ANS);
				double points = Double.parseDouble((String)accountJSON.get(POINTS));
				
				accounts.add(new RewardsAccount(username, password, secAnswer, points));
			}
			
			accountsList = accounts;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveAccounts() {
		//People people = People.getInstance();
		//ArrayList<Person> friends = people.getPeople();
		//JSONArray jsonFriends = new JSONArray();
		JSONArray accountsJSON = new JSONArray();
		
		
		//creating all the json objects
		for (int i = 0; i < accountsList.size(); i++) {
			accountsJSON.add(getAccountJSON(accountsList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(FILE_NAME)) {
 
            file.write(accountsJSON.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getAccountJSON(RewardsAccount account) {
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(USER, account.getUsername());
		accountDetails.put(PASS, account.getPassword());
		accountDetails.put(ANS, account.getSecurityAnswer());
		accountDetails.put(POINTS, account.getRewardsPoints());
		
        return accountDetails;
	}
	
	public static boolean signUp(RewardsAccount accountToSignUp) {
		for (int i = 0; i < accountsList.size(); i++) {
			RewardsAccount account = accountsList.get(i);
			if (accountToSignUp.getUsername().equalsIgnoreCase(account.getUsername())) {
				return false;
			}
		}
		accountsList.add(accountToSignUp);
		return true;
	}
	
	public static Account logIn(Account accountToLogIn) {
		for (int i = 0; i < accountsList.size(); i++) {
			RewardsAccount account = accountsList.get(i);
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