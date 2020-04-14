import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author Brett Logeais
 * Purpose: test methods in Event that are specific to itself
 */


class DialogueTest {
	
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	private static final String USER = "username";
	private static final String PASS = "password";
	
	@Before
	public void setupStreams() {
		System.setOut(new PrintStream(output));
	}
	
	@After
	public void teardownStreams() {
		System.setOut(System.out);
	}

	@Test
	public void testUserOption() {
		//ByteArrayOutputStream output = new ByteArrayOutputStream();
		//System.setOut(new PrintStream(output));
		InputStream sysInBackup = System.in;
		int testOptions = 3;
		String input = (testOptions+1) + System.lineSeparator() + testOptions + 
				System.lineSeparator() + "Test" + System.lineSeparator() + 0; 
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		int option = Dialogue.getUserOption(testOptions);
		assert(option == testOptions);
		option = Dialogue.getUserOption(testOptions);
		assert(option == 0);
		System.setIn(sysInBackup);
	}
	
	@Test
	public void testGetLogin() {
		InputStream sysInBackup = System.in;
		String input = USER + System.lineSeparator() + PASS + System.lineSeparator();
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Account account = Dialogue.getLogIn();
		assertEquals(USER, account.getUsername());
		assertEquals(PASS, account.getPassword());
		System.setIn(sysInBackup);
	}
	
	
	

}