package testData;

import org.testng.annotations.DataProvider;

public class FacebookData {
	
	@DataProvider(name = "pages")
	public static Object[][] pages() {
		return new Object[][] {
			{"http://www.facebook.com","Welcome to Facebook - Lig In, Sign Up or Learn More"},
			{"http://google.com", "Google"},
			{"http://yahoo.com", "Yahoo"}
		};
	}
	
	@DataProvider(name="login")
	public static Object[][] login() {
		System.out.println("DATA PROVIDER");
		return new Object[][] {
			{"lyndamontanez@gmail.com", "lyndam",null}
		};
	}
	
	@DataProvider(name="signup")
	public static Object[][] signup() {
		System.out.println("DATA PROVIDER: signup");
		return new Object[][] {
			{"lyndamontanez@gmail.com", "lyndam",null}
		};
	}

}
