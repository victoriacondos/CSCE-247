import org.json.simple.JSONObject;

public class RewardsAccount extends Account {
	private static final String POINTS = "rewardsPoints";
	private double rewardsPoints;
	
	public RewardsAccount(JSONObject objectJSON) {
		super(objectJSON);
		this.rewardsPoints = (Double)objectJSON.get(POINTS);
	}
	
	public RewardsAccount(String username, String password, String secAnswer, double points) {
		super(username, password, secAnswer);
		setRewardsPoints(points);
	}
	public RewardsAccount(Account account, double points) {
		super(account);
		setRewardsPoints(points);
	}
	
	public double getRewardsPoints() {
		return this.rewardsPoints;
	}
	
	public void setRewardsPoints(double points) {
		this.rewardsPoints = points;
	}
	@Override
	public JSONObject toJSON() {
		JSONObject accountDetails = super.toJSON();
		accountDetails.put(POINTS, this.getRewardsPoints());
        return accountDetails;
	}
}
