/**
 * @author Elizabeth Stevenson, Victoria Condos
 * Purpose: to check which tickets have been purchased and deal with rewards
 */import java.io.*; //TODO - change this to only be things used probably
public class Inventory {
	private Ticket[] purchasedTickets;
	private double rewardsPoints;
	private final String astericksLong = "**************************************************";
	private final String astericksShort = "****"

	/**
	 * Purpose: to get purchased ticket information
	 * @return purchasedTickets: an array of type Ticket
	 */
	public Ticket[] getPurchasedTickets() {
		return purchasedTickets;
	}

	/**
	 * Purpose: to set the purchasedTickets array
	 * @param purchasedTickets: a ticket
	 */
	public void setPurchasedTickets(Ticket[] purchasedTickets) {
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

	/**
	 * Purpose: creates .txt file of each of purchased tickets []
	 */
	public void TicketWriter(String ticketName) throws IOException {
		BufferedWriter outputWriter = new BufferedWriter (new FileWriter (ticketName));
		
		for (Ticket ticket : purchasedTickets) {
			outputWriter.write(astericksLong);
			outputWriter.newLine();
			outputWriter.write(astericksShort + ticket.toString() + astericksShort);
			outputWriter.newLine();
			outputWriter.write(astericksLong);
		
			outputWriter.flush();
			outputWriter.close();
		}
	}
}