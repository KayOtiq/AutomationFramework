package testCases;
/**
 * This is a working example test case page
 * 
 * Use this as a template to create tests
 * 
 * Created by Lynda Montanez on 2/6/2017
 *  
 */


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import testCases.BaseTest;

import pageObjects.FacebookLoginPage;
import pageObjects.FacebookPage;

import testData.SampleTestData;

import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class LoginTestsWithBaseClass extends BaseTest {
	

	DriverFactory.BrowserType type = BrowserType.CHROME;
	

	FacebookPage fbPage;
	FacebookLoginPage fbLoginPage;
	
	
	@BeforeClass (alwaysRun=true)
	public void setup() {

        fbPage = PageFactory.initElements(driver, FacebookPage.class);
        fbLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class);
	}
	
	//@Parameters({"language","browserType"})
	
	@Parameters({"browserType"})
	
	//use the @optional if the xml injected parameter is not required or if test is not run from the xml
	//use@
	
	@Test (groups={"p1", "pageLoads"})
	public void loadPage(@Optional("Chrome") String browserType) {

		System.out.println("Browser Type:" + browserType);
		fbPage.loadPage();
	}
	
	@Test(groups={"p2", "fields"}, dependsOnMethods="loadPage", enabled=false)
	public void enterEmail() {
		fbPage.setTextEmailLogin("lynsa.test@hotmail.com");
	}
	
	@Test(groups={"p2", "fields"}, dependsOnMethods="enterEmail", enabled=false)
	public void enterPassword() {
		fbPage.setTextPasswordLogin("123456");
	}
	
	//Example Using a test with a data provider and data provider class, located in TestData package
	// Does the same as above two tests, but pulls data from data provider
	
	@Test(groups={"p1"}, dependsOnMethods="loadPage", enabled=true, dataProviderClass=SampleTestData.class, dataProvider="login" )
	public void testMainLoginPage( String email, String password ) {
		

		fbPage.loadPage();
		driver.manage().deleteAllCookies(); //this deletes all cookies and logs user out of FB

		fbPage.login(email, password);
		
		System.out.println(fbPage.getPageTitle());//Remember getPageTitle is inherited from Base Page

	}
	

	

}
