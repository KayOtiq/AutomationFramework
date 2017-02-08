package testCases;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import testCases.BaseTest;

import pageObjects.FacebookPage;

import testData.SampleTestData;

import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class SignUpWorkflowTest extends BaseTest{
	
	FacebookPage fbPage;
	DriverFactory.BrowserType type = BrowserType.CHROME;
	
	/*
	 * This is an example of using a Data Factory, using hash map to pull 
	 * more than one element of data from a data provide
	 */
	
	HashMap<String, String> signUpMap;
	
	@Factory(dataProvider="signup", dataProviderClass=SampleTestData.class)
	public SignUpWorkflowTest(String first, String last, String email, String emailConf, String pwd ) {
		
		signUpMap  = new HashMap<>();
		
		signUpMap.put("first", first);
		signUpMap.put("last", last);
		signUpMap.put("email", email);
		signUpMap.put("emailConf", emailConf);
		signUpMap.put("pwd", pwd);
		
	}
	
	@BeforeClass(alwaysRun=true)
	public void setup() {
		
		/*
		All of this gets removed when we added the BaseTest class.
		Now all of this is called as part of the 'extends BaseTest'
		BaseTest gets called first.  Anything specifically for this class/test gets called after
		
	    System.setProperty("webdriver.chrome.driver", Constant.ChromeExePath);  
	    this.driver = new ChromeDriver();
		this.driver = DriverFactory.getDriver(type);
		wait = new WebDriverWait(driver,5);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    */
		
	    fbPage = PageFactory.initElements(driver, FacebookPage.class);
	
	}
	/*
	 * 
	 * The @AfterClass gets removed because it is now part of the BaseTest
	 * 
	@AfterClass(alwaysRun=true)
	public void cleanup() {
		this.driver.quit();
	}
	*/
	@Test
	public void loadPage(){
		fbPage.loadPage();	
		driver.manage().deleteAllCookies();
	}
	@Test(dependsOnMethods="loadPage")
	public void enterName() {
		
		fbPage.setFirstName(signUpMap.get("firstname"));
		fbPage.setLastName(signUpMap.get("lastname"));
	}
	
	@Test(dependsOnMethods="enterName")
	public void enterSignupInfo() {

		fbPage.setSignUp(signUpMap.get("email"));
		fbPage.setConfirm("emailConf");
		fbPage.setPassword(signUpMap.get("pwd"));
	}
	
	@Test(dependsOnMethods="enterSignupInfo", enabled=false)
	public void enterBirthdate() {
		
		fbPage.setMonth("3");
		fbPage.setDay("21");
		fbPage.setYear("1985");
	}
	
}
