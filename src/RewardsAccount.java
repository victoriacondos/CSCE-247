/**
* Author: Brett Logeais
* Purpose: connects rewards with account and inventory
*/

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class RewardsAccount extends Account {
	private static final String INVENTORY = "inventory";
	private Inventory inventory;
	
	/**
	* Purpose: creates a rewardsaccount from json
	*/
	public RewardsAccount(JSONObject objectJSON) {
		super(objectJSON);
		this.inventory = new Inventory((JSONObject)objectJSON.get(INVENTORY));
	}
	
	/**
	* Purpose: creates a rewardsaccount with username, password, security answer, and inventory
	* @param username
	* @param password
	* @param secAnswer
	* @param inventory
	*/
	public RewardsAccount(String username, String password, String secAnswer, Inventory inventory) {
		super(username, password, secAnswer);
		setInventrory(inventory);
	}
	
	/**
	* Purpose: creates a rewardsaccount from preexisting account and inventory
	* @param account
	* @param inventory
	*/
	public RewardsAccount(Account account, Inventory inventory) {
		super(account);
		setInventrory(inventory);
	}
	
	
	/**
	* Purpose: accessor for inventory
	* @return inventory
	*/
	@Override
	public Inventory getInventory() {
		return this.inventory;
	}
	
	
	/**
	* Purpose: mutator for inventory
	* @param inventory
	*/
	public void setInventrory(Inventory inventory) {
		this.inventory = inventory;
	}
	@Override
	public JSONObject toJSON() {
		JSONObject accountDetails = super.toJSON();
		accountDetails.put(INVENTORY, this.inventory.toJSON());
        return accountDetails;
	}
	
	
	/**
	* Purpose: shows account inventory
	* @return String that shows inventory
	*/
	public String toString() {
		return "My Inventory:\n" + this.inventory.toString() + "\n";
	}
}
