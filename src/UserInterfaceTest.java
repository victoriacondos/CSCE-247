import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class UserInterfaceTest {
	
	@Test
	public void runTest() {
		InputStream sysInBackup = System.in;
		String input = 
				"0" + System.lineSeparator() + 
				"0" + System.lineSeparator() + 
				"0" + System.lineSeparator();
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		UserInterface ui = new UserInterface();
		ui.run();
		UserInterface.setMenu(1);
		ui.run();
		System.setIn(sysInBackup);
	}
}
