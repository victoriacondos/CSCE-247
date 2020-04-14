/**
 * @author Brett Logeais
 */
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Test {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestSuite.class);
		for (org.junit.runner.notification.Failure f : result.getFailures()) {
			System.out.println(f.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
