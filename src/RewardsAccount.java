/**
 * @author Brett Logeais
 * Purpose: holds rewards information
 */
public class RewardsAccount extends Account {
	private double rewardsPoints;
	
	/**
	 * Purpose: create a rewards account
	 * @param username: account username
	 * @param password: account password
	 * @param secAnswer: account securty answer
	 * @param points: account points
	 */
	public RewardsAccount(String username, String password, String secAnswer, double points) {
		super(username, password, secAnswer);
		setRewardsPoints(points);
	}
	
	/**
	 * Purpose: accessor for points
	 * @return points: account rewards points
	 */
	public double getRewardsPoints() {
		return this.rewardsPoints;
	}
	
	/**
	 * Purpose: mutator for points
	 * @param points: account rewards points
	 */
	public void setRewardsPoints(double points) {
		this.rewardsPoints = points;
	}
}
