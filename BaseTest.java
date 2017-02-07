package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class BaseTest {
	
	protected WebDriver driver;
	public WebDriverWait _wait;
	public WebDriver
	final int BASE_TIMEOUT_SECONDS = 5;
	
	DriverFactory.BrowserType type = BrowserType.CHROME;

	@BeforeClass(alwaysRun=true)
	public void setup() {

		//Creates webdriver instance
        driver = DriverFactory.getDriver(type);
        
        //Setup Explicit WebDriverWait 
        //Tells code to wait for specified amount of time for a certian condition to be 
        //before proceeding with code
        _wait = new WebDriverWait(driver, BASE_TIMEOUT_SECONDS);
        
        //Setup Implicit WebDriver Wait
        //Tells driver to poll DOM for timeout time for elements if they are not 
        //immediately available.  Use if element takes a long time to load and/or
        //to check for a specific property 
        driver.manage().timeouts().implicitlyWait(BASE_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        
        //fluent wait
        //Use to test if present of element appears after x time
        _fluentWait = new FluentWait{driver);

	}

	@AfterClass (alwaysRun=true)
	public void cleanup() {
		driver.close();
		driver.quit();
	}
}
	
