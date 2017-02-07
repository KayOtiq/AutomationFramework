package archive;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import utilities.TestResults;

public class TestListeners extends TestListenerAdapter{
	
	static TestResults results = new TestResults();
	
	@Override
	public void onTestSuccess(ITestResult testResult) {
		System.out.println(testResult.getName() + " was successful");
		results.incrementPassed();
		System.out.println("PASSED TESTS: " + results.getPassed());
		System.out.println("TOTAL TESTS: " + results.getTotalTests());
	}
	
	@Override
	public void onTestFailure(ITestResult testResult) {
		System.out.println(testResult.getName() + " failed\nThrowable: " +testResult.getThrowable().getMessage());
		results.incrementFailed();
		System.out.println("FAILED TESTS: " + results.getFailed());
		System.out.println("TOTAL TESTS: " + results.getTotalTests());

	}
	
	@Override
	public void onTestSkipped(ITestResult testResult) {
		System.out.println(testResult.getName() + " was skipped");
		results.incrementSkipped();
		System.out.println("SKIPPED TESTS: " + results.getSkipped());
		System.out.println("TOTAL TESTS: " + results.getTotalTests());

	}

	@Override
	public void onFinish(ITestContext testContext) {
		try {
			results.write();	
			results.writeToCSV();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
