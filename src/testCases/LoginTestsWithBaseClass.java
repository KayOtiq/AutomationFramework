package testCases;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.apache.commons.lang3.*;
//import org.openqa.selenium.*;

import pageObjects.BaseTest;
import pageObjects.FacebookLoginPage;
import pageObjects.FacebookPage;
import testData.SampleTestData;
//import testData.AmazonData;
//import utilities.Constant;
import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class LoginTestsWithBaseClass extends BaseTest {
	
	public WebDriver driver;
	//public WebDriverWait wait;
	DriverFactory.BrowserType type = BrowserType.CHROME;
	
	//BasePage fbPage;
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
	@Test (groups={"p1", "pageLoads"})//, dataProvider="pages") //, dataProviderClass=AmazonData.class)
	public void loadPage(@Optional("Chrome") String browserType) {
       // driver.navigate().to(FacebookPage.PAGE_URL);  //("http://automationpractice.com/index.php");
        //Assert.assertEquals(fbPage.getTitle(), "Facebook - Log In or Sign Up");
		
		//System.out.println("Language: " + language);
		System.out.println("Browser Type:" + browserType);
		fbPage.loadPage();
	}
	
	@Test(groups={"p2", "fields"}, dependsOnMethods="loadPage", enabled=false)
	public void enterEmail() {
		fbPage.setTextEmailLogin("anthony.vitoli@hotmail.com");
	}
	
	@Test(groups={"p2", "fields"}, dependsOnMethods="enterEmail", enabled=false)
	public void enterPassword() {
		fbPage.setTextPasswordLogin("123456");
	}
	
	@Test(groups={"p1"}, dependsOnMethods="loadPage", enabled=true, 
			dataProviderClass=SampleTestData.class, dataProvider="login" )
	public void testMainLoginPage( String email, String password ) {//, String errorType) {
		

		fbPage.loadPage();
		driver.manage().deleteAllCookies(); //this deletes all cookies and logs user out of FB

		fbPage.login(email, password);
		//Assert.assertEquals(driver.getTitle(), "Facebook");
		
		System.out.println(fbPage.getTitle());

	}
	

	

}
