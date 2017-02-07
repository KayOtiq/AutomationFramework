package testCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BaseTest;
import pageObjects.FacebookPage;
//import utilities.DriverFactory;
//import utilities.DriverFactory.BrowserType;

public class SignUpTest extends BaseTest {
	
	FacebookPage fbPage;
	//DriverFactory.BrowserType type = BrowserType.CHROME;
	
	@BeforeClass(alwaysRun=true)
	public void setup() {

	    fbPage = PageFactory.initElements(driver, FacebookPage.class);
	}
	
	@AfterClass(alwaysRun=true)
	public void cleanup() {
		this.driver.quit();
	}
	
	@Test(groups={"p1"})
	public void SignupPageTest(){
		fbPage.loadPage();
		fbPage.setFirstName("Test");
		fbPage.setLastName("User");
		fbPage.setSignUp("TestUser@testing.com");
		fbPage.setConfirm("TestUser@testing.com");
		fbPage.setPassword("TestPwd@123!");
		fbPage.setMonth("3");
		fbPage.setDay("21");
		fbPage.setYear("1985");
		
	try {//just want a hard wait to see if everything is entered, but do not actually create
		Thread.sleep(5000);
	} catch (InterruptedException e){
		e.printStackTrace();
	}
		
	}
}
