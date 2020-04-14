/**
 * @author Brett Logeais
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith (Suite.class)
@SuiteClasses ( {
		AccountTest.class,
		ConcertTest.class,
		//DialogueTest.class,
		EnumsTest.class,
		EventTest.class,
		MovieTest.class,
		InventoryTest.class,
		ReviewTest.class,
		SeatingTest.class,
		TheatreTest.class,
		TicketTest.class,
		UserInterfaceTest.class
	}
)
public class TestSuite {

}
