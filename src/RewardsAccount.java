
public class RewardsAccount extends Account {
	private double rewardsPoints;
	
	public RewardsAccount(String username, String password, String secAnswer, double points) {
		super(username, password, secAnswer);
		setRewardsPoints(points);
	}
	
	public double getRewardsPoints() {
		return this.rewardsPoints;
	}
	
	public void setRewardsPoints(double points) {
		this.rewardsPoints = points;
	}
}
