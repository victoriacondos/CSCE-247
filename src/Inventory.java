/**
 * @author Elizabeth Stevenson, Victoria Condos
 * Purpose: to check which tickets have been purchased and deal with rewards
 */import java.io.*; //TODO - change this to only be things used probably
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Inventory extends DatabaseObject {
	private static final String TICKETS = "tickets";
	private static final String POINTS = "rewardsPoints";
	
	private ArrayList<Ticket> purchasedTickets;
	private double rewardsPoints;
	private final String astericksLong = "**************************************************";
	private final String astericksShort = "****";
	
	public Inventory(JSONObject objectJSON) {
		this.rewardsPoints = (double)objectJSON.get(POINTS);
		JSONArray arrayJSON = (JSONArray)objectJSON.get(TICKETS);
		ArrayList<Ticket> array = new ArrayList<Ticket>();
		for (int i = 0; i < arrayJSON.size(); i++) array.add(new Ticket((JSONObject)arrayJSON.get(i)));
		this.purchasedTickets = array;
	}
	
	public Inventory() {
		this.rewardsPoints = 0;
		this.purchasedTickets = new ArrayList<Ticket>();
	}
	
	/**
	 * Purpose: to get purchased ticket information
	 * @return purchasedTickets: an array of type Ticket
	 */
	public ArrayList<Ticket> getPurchasedTickets() {
		return purchasedTickets;
	}

	/**
	 * Purpose: to set the purchasedTickets array
	 * @param purchasedTickets: a ticket
	 */
	public void setPurchasedTickets(ArrayList<Ticket> purchasedTickets) {
		this.purchasedTickets = purchasedTickets;
	}

	/**
	 * Purpose: to get rewardsPoints value
	 * @return rewardsPoints: number of rewardsPoints
	 */
	public double getRewardsPoints() {
		return rewardsPoints;
	}

	/**
	 * Purpose: to set rewardsPoints value
	 * @param rewardsPoints: set the rewardsPoints to a specific number
	 */
	public void setRewardsPoints(double rewardsPoints) {
		this.rewardsPoints = rewardsPoints;
	}
	
	public JSONObject toJSON() {
		JSONObject inventoryDetails = new JSONObject();
		inventoryDetails.put(POINTS, this.rewardsPoints);
		JSONArray array = new JSONArray();
		for (int i = 0; i < this.purchasedTickets.size(); i++) array.add(purchasedTickets.get(i).toJSON());
		inventoryDetails.put(TICKETS, array);
		return inventoryDetails;
	}
	
	public String toString() {
		String inventory = "RewardsPoints: " + this.rewardsPoints
				+ "\nTickets: ";
		for (int i = 0; i < purchasedTickets.size(); i++) {
			inventory += "\n\n" + (i+1) + ")\n"+ purchasedTickets.get(i).toString();
		}
		return inventory;
	}
	
	/**
	 * Purpose: creates .txt file of each of purchased tickets []
	 */
	public void TicketWriter(String ticketName) throws IOException {
		try {
			BufferedWriter outputWriter = new BufferedWriter (new FileWriter (ticketName));
			
			for (Ticket ticket : purchasedTickets) {
				outputWriter.write(astericksLong);
				outputWriter.newLine();
				outputWriter.write(astericksShort + ticket.toString() + astericksShort);
				outputWriter.newLine();
				outputWriter.write(astericksLong);
				outputWriter.newLine();
				outputWriter.newLine();
				outputWriter.flush();
			}
			outputWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}