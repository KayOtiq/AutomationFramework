package testCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.AmazonPage;
import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class AmazonLoginTests extends BaseTest {
	
	AmazonPage amazonPg; 
	DriverFactory.BrowserType type = BrowserType.CHROME;

	@BeforeClass (alwaysRun=true)
	public void setup() {
		
        amazonPg = PageFactory.initElements(driver, AmazonPage.class);
	}
	
	@Parameters({"browserType"})
	@Test (groups={"startup","pageLoads"})
	public void loadPage(@Optional("Chrome") String browserType) {
		
		amazonPg.loadPage();

	}
	@Test (groups={"p2"}, dependsOnMethods="loadPage", enabled=true)
	public void testGetTitle() {
		String str = amazonPg.getPageTitle();
		System.out.println(str);
		
	}
	@Test (groups={"p3","acctLink"}, dependsOnMethods="loadPage", enabled=true)
	public void testClickAcctLink()  {

		amazonPg.clickAcctButton();
        amazonPg.clickBack();
	}
	
	@Test (groups={"p3","search"},dependsOnMethods="loadPage" )
	public void testSearch() {
		amazonPg.setSearchText("To Kill A Mockingbird");
		amazonPg.clickSearchButton();
		String str = amazonPg.getSearchResults();
		System.out.println(str);
	}


}
