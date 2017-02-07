package testData;

import org.testng.annotations.DataProvider;

public class SampleTestData {
	// set up db connections here
	
	@DataProvider(name="pages")
	public static Object[][] pages(){
		// x = # time to run
		// y = what args passing into test
		// args:  Url, title of page
		return new Object[][] {
			{"http://www.amazon.com","amazon"},
			{"http://www.google.com", "google"},
			{"http://www.yahoo.com", "yahoo"}
		};
		
	}
	
	@DataProvider(name="login")
	public static Object[][] login() {
		return new Object[][] {
			{"anthony.vitoli@hotmail.com", "123456"}, //should be a positive test, but the password is wrong and I don't want to iinput my own info
			{"","123456" } //this is a negative test
			
		};
		
	}
	@DataProvider(name="signup")
	public static Object[][] signup() {
		return new Object[][] {
			{"QA","Tester1","tester1@test.com","tester1@test.com","TestPwd@123!" }, //,"3","21","1985"},
			{"BSA","Tester2","tester2@test.com","tester2@test.com","TestPwd@123!"}, //,"5","10","1997"},	
			{"DEV","Tester3","tester3@test.com","tester3@test.com","TestPwd@123!"} //,"10","12","2000"}	
		};
	}
	
}
