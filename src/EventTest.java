import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.io.*;


import org.junit.Before;
import org.junit.jupiter.api.Test;

class EventTest {

	public static Event testEvent;
	public static Review testReview;
	
	@Test
	public void testGetTitle() {
		testEvent = new Event("The Little Mermaid", "JUnit Theater", 5.50);
		assertEquals(testEvent.getTitle(), "The Little Mermaid");
	}
	
	@Test
	public void testGetLocation() {
		testEvent = new Event("The Little Mermaid", "JUnit Theater", 5.50);
		assertEquals(testEvent.getLocation(), "JUnit Theater");
	}
	
	@Test
	public void testSetTitle() {
		testEvent.setTitle("The Little Mermaid");
		assertEquals(testEvent.getTitle(), "The Little Mermaid");
	}
	
	@Test
	public void testSetLocation() {
		testEvent.setLocation("JUnit Theater");
		assertEquals(testEvent.getLocation(), "JUnit Theater");
	}
	
	@Test
	public void testToString() {
		testEvent = new Event("The Little Mermaid", "JUnit Theater", 5.50);
		String testString = "Title: " + this.testEvent.title +
				"\n     Location: " + this.testEvent.location + 
				"\n     Price: $" + this.testEvent.price;
		assertEquals(testEvent.toString(), testString);
	}

}
