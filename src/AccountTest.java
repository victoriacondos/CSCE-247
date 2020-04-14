/**
 * @author Brett Logeais
 * Purpose: to test Account.java
 */
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

class AccountTest {
	
	private static final String USER = "username";
	private static final String PASS = "password";
	private static final String ANS = "securityAnswer";
	
	@Test
	public void testConstructor() {
		Account account = new Account(USER, PASS);
		assertEquals(account.getUsername(), USER);
		assertEquals(account.getPassword(), PASS);
		assertEquals(account.getSecurityAnswer(), null);
		assertEquals(account.getInventory(), null);
	}
	
	@Test
	public void testCopyConstructor() {
		Account account = new Account(USER, PASS, ANS);
		Account copy = new Account(account);
		assertEquals(copy.getUsername(), USER);
		assertEquals(copy.getPassword(), PASS);
		assertEquals(copy.getSecurityAnswer(), ANS);
		assertEquals(copy.getInventory(), null);
	}
	@Test
	public void testJSON() {
		Account account = new Account(USER, PASS);
		JSONObject objectJSON = account.toJSON();
		Account newAccount = new Account(objectJSON);
		assertEquals(newAccount.getUsername(), USER);
		assertEquals(newAccount.getPassword(), PASS);
		assertEquals(newAccount.getSecurityAnswer(), null);
		assertEquals(newAccount.getInventory(), null);
	}
	
}
