import java.util.ArrayList;

import org.json.simple.JSONObject;

public class RewardsAccount extends Account {
	private static final String INVENTORY = "inventory";
	private Inventory inventory;
	
	public RewardsAccount(JSONObject objectJSON) {
		super(objectJSON);
		this.inventory = new Inventory((JSONObject)objectJSON.get(INVENTORY));
	}
	
	public RewardsAccount(String username, String password, String secAnswer, Inventory inventory) {
		super(username, password, secAnswer);
		setInventrory(inventory);
	}
	public RewardsAccount(Account account, Inventory inventory) {
		super(account);
		setInventrory(inventory);
	}
	
	@Override
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public void setInventrory(Inventory inventory) {
		this.inventory = inventory;
	}
	@Override
	public JSONObject toJSON() {
		JSONObject accountDetails = super.toJSON();
		accountDetails.put(INVENTORY, this.inventory.toJSON());
        return accountDetails;
	}
	
	public String toString() {
		return "My Inventory:\n" + this.inventory.toString() + "\n";
	}
}
