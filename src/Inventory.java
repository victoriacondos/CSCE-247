/**
 * @author Elizabeth Stevenson
 * Purpose: to check which tickets have been purchased and deal with rewards
 */
public class Inventory {
	private Ticket[] purchasedTickets;
	private double rewardsPoints;

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
	 * Purpose: to show how many tickets were purchased and how many rewards points have
	 * @return String with purchasedTickets value and rewards points
	 */
	public String toString() {
		return "Purchased Tickets" + this.purchasedTickets + " Rewards Points: " + this.rewardsPoints; 
	}
}