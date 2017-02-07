package testCases;

import static org.testng.Assert.*; //doing this allows us to skip using "Assert.assertTrue()"
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import archive.TestListeners;

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
