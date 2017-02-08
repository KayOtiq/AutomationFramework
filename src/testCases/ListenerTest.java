package testCases;

/*
 * This example was used to demonstrate how to use TestNg listeners to output custom results
 * into a csv or text file
 */
import static org.testng.Assert.*; //doing this allows us to have more fluent code, skip using "Assert.assertTrue()"
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.TestListeners;

@Listeners(TestListeners.class)
public class ListenerTest {

	@Test
	public void test1Success() {
		assertTrue(true);
		//write to xml or excel with test results
	}
	
	@Test
	public void test2Fail() {
		assertTrue(false,"Asserting false");
		//insert screenshot code here
		//write to excel here
	}
	
	@Test (dependsOnMethods="test2Fail")
	public void test3Skip() {
		//throw new SkipException("Skipping because that's the purpose here");
		assertTrue(true);
		//insert code here for output of test results.
	}
}
