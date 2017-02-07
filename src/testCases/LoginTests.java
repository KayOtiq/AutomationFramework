package testCases;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.apache.commons.lang3.*;
//import org.openqa.selenium.*;

import pageObjects.FacebookLoginPage;
import pageObjects.FacebookPage;
import testData.SampleTestData;
//import testData.AmazonData;
//import utilities.Constant;
import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class LoginTests {
	
	public WebDriver driver;
	//public WebDriverWait wait;
	DriverFactory.BrowserType type = BrowserType.CHROME;
	
	//BasePage fbPage;
	FacebookPage fbPage;
	FacebookLoginPage fbLoginPage;
	
	
	@BeforeClass (alwaysRun=true)
	public void setup() {
		
        //System.setProperty("webdriver.chrome.driver", Constant.ChromeExePath);  
        //this.driver = new ChromeDriver();
        this.driver = DriverFactory.getDriver(type);
        //wait = new WebDriverWait(driver,5);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       // fbPage = new FacebookPage(driver);
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
		
		//driver.navigate().to(FacebookPage.PAGE_URL);
		fbPage.loadPage();
		driver.manage().deleteAllCookies(); //this deletes all cookies and logs user out of FB
		//fbPage.setTextEmailLogin(email);
		//fbPage.setTextPasswordLogin(password);
		//fbPage.clickSubmit();
		fbPage.login(email, password);
		//Assert.assertEquals(driver.getTitle(), "Facebook");
		
		System.out.println(fbPage.getTitle());
		/*
		if (StringUtils.isBlank(errorType)){
			boolean result = fbLoginPage.checkErrorHeader(errorType);
			Assert.assertTrue(result, "Expected error:  " + errorType);
		}else {
			// for this need to create a FB main feed and get the user name field to 
			// verify logged in successfully 
			//Assert.assertTrue(!fbMainFeed.GetUsername.isEmpty());
		}
		*/
	}
	
	@AfterClass (alwaysRun=true)
	public void cleanup() {
		driver.close();
		driver.quit();
		
	}

}
