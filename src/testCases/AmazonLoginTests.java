package testCases;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AmazonPage;

import utilities.Constant;

public class AmazonLoginTests {
	
	public WebDriver driver;
	AmazonPage amazonPg; 

	@BeforeClass (alwaysRun=true)
	public void setup() {
		
        System.setProperty("webdriver.chrome.driver", Constant.ChromeExePath);  
        this.driver = new ChromeDriver(); 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        amazonPg = new AmazonPage(driver);
        amazonPg = PageFactory.initElements(driver, AmazonPage.class);
	}

	@Test (groups={"p1","pageLoads"})
	public void loadPage() {
        driver.navigate().to(AmazonPage.PAGE_URL);  //("http://automationpractice.com/index.php");

	}
	@Test (groups={"p2"}, dependsOnMethods="loadPage", enabled=false)
	public void testGetTitle() {
		String str = amazonPg.getTitle();
		System.out.println(str);
		
	}
	@Test (groups={"p3","acctLink"}, dependsOnMethods="loadPage", enabled=false)
	public void testClickAcctLink()  {

       // driver.findElement(By.cssSelector("#nav-link-accountList")).click();
		amazonPg.clickAcctButton();
        amazonPg.clickBackButton();
	}
	
	@Test (groups={"p3","search"},dependsOnMethods="loadPage" )
	public void testSearch() {
		amazonPg.setSearchText("To Kill A Mockingbird");
		amazonPg.clickSearchButton();
		String str = amazonPg.getSearchResults();
		System.out.println(str);
	}
	
	@AfterClass (alwaysRun=true)
	public void cleanup() {
		this.driver.close();
		this.driver.quit();
		
	}

}
