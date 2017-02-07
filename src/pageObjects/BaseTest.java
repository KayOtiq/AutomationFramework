package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class BaseTest {
	
	protected WebDriver driver;
	public WebDriverWait _wait;
	final int BASE_TIMEOUT_SECONDS = 5;
	
	DriverFactory.BrowserType type = BrowserType.CHROME;

	@BeforeClass(alwaysRun=true)
	public void setup() {

		//Creates webdriver instance
        driver = DriverFactory.getDriver(type);
        
        //Setup Explicit WebDriverWait 
        _wait = new WebDriverWait(driver, BASE_TIMEOUT_SECONDS);
        
        //Setup Implicit WebDriver Wait
        driver.manage().timeouts().implicitlyWait(BASE_TIMEOUT_SECONDS, TimeUnit.SECONDS);

	}

	@AfterClass (alwaysRun=true)
	public void cleanup() {
		driver.close();
		driver.quit();
	}
}
	
