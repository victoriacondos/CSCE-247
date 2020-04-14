/**
 * @author Brett Logeais
 * Purpose: to test Account.java
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

public class AccountTest {
	
	private static final String USER = "username";
	private static final String PASS = "password";
	private static final String ANS = "securityAnswer";
	private static final Inventory INV = new Inventory();
	
	private static void verify(Account account) {
		assertEquals(account.getUsername(), USER);
		assertEquals(account.getPassword(), PASS);
		assertEquals(account.getSecurityAnswer(), ANS);
		if (account instanceof RewardsAccount)
			assertNotEquals(account.getInventory(), null);
		else assertEquals(account.getInventory(), null);
	}
	
	@Test
	public void testConstructor() {
		Account account = new Account(USER, PASS);
		assertEquals(account.getUsername(), USER);
		assertEquals(account.getPassword(), PASS);
		assertEquals(account.getSecurityAnswer(), null);
	}
	
	@Test
	public void testCopyConstructor() {
		Account account = new Account(USER, PASS, ANS);
		Account copy = new Account(account);
		verify(copy);
	}
	
	@Test
	public void testJSON() {
		Account account = new Account(USER, PASS, ANS);
		JSONObject objectJSON = account.toJSON();
		Account newAccount = new Account(objectJSON);
		verify(newAccount);
	}
	
	@Test
	public void managerConstructors() {
		ManagerAccount manAcc1 = new ManagerAccount(USER, PASS, ANS);
		ManagerAccount manAcc2 = new ManagerAccount(manAcc1);
		JSONObject objectJSON = manAcc1.toJSON();
		ManagerAccount manAcc3 = new ManagerAccount(objectJSON);
		verify(manAcc1);
		verify(manAcc2);
		verify(manAcc3);
	}
	
	@Test
	public void rewardsConstructors() {
		Account acc = new Account(USER, PASS, ANS);
		RewardsAccount rewAcc1 = new RewardsAccount(USER, PASS, ANS, INV);
		RewardsAccount rewAcc2 = new RewardsAccount(acc, rewAcc1.getInventory());
		JSONObject objectJSON = rewAcc1.toJSON();
		RewardsAccount rewAcc3 = new RewardsAccount(objectJSON);
		rewAcc3.setInventory(new Inventory());
		verify(rewAcc1);
		verify(rewAcc2);
		verify(rewAcc3);
		assertEquals(rewAcc1.toString(), "My Inventory:\n" + INV.toString() + "\n");
	}
}
