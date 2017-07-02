package testCases;

import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testCases.BaseTest;
import utilities.CookieUtil;
import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class CookieTestRefactored extends BaseTest{
	
	public WebDriver driver;
	DriverFactory.BrowserType type = BrowserType.CHROME;
	
	String name = "Steam_Language";
	String path = "/";
	String domain = "store.steampowered.com";
	Date someDate;
	
	String baseURL;
	
	HashMap<String,String> languages = new HashMap<String, String>() {{
		put("en","english");
		put("es","spanish");
		}
	};
	

	
	@BeforeClass
	public void setupCookies() throws Exception {
		
		someDate = new Date();
		someDate.setTime(System.currentTimeMillis() + 60000);
		baseURL = "http://store.steampowered.com"; //"http://"+domain;

	}
	
	@BeforeMethod
	public void removeCookies() {
		driver.get(baseURL);
		//need to be sure we are on the correct page or will be deleting wrong cookies
		driver.manage().deleteAllCookies();
	}

	@DataProvider(name="steamCookies")
	public Object[][] steamCookies() {
		return new Object[][] {
			{new Cookie(name,languages.get("en"),domain,"/",someDate)},			
			{new Cookie(name,languages.get("es"),domain,"/",someDate)}
			//now have ability to add additional languages here to scale the tests
		};		
	}
	
	@Test(dataProvider="steamCookies")
	public void addLanguageCookie(Cookie cookie) throws Exception {

		CookieUtil.addCookieAndVerify(driver,cookie);		
	}
	
	//To Do, refactor later
	@Test(enabled=false)
	public void deleteSpanishCookieTakesYouBackToEnglish() throws Exception{
		
		//CookieUtil.addCookieAndVerify(driver,cookie);		

		//eyeball language is in Spanish
		Thread.sleep(10000);
		
		driver.manage().deleteCookieNamed(name);
		driver.navigate().refresh();
		Thread.sleep(10000);
	}
	
	//To Do, refactor later
	@Test(enabled=false)
	public void dropDownToLanguage() {
		driver.get(baseURL);
		driver.findElement(By.cssSelector("#language_pulldown")).click();
		driver.findElement(By.cssSelector("a[href='?l=spanish']")).click();
		_wait.until(ExpectedConditions.textToBe(By.cssSelector("language_pulldown"), "idioma"));

		Cookie languageCookie = driver.manage().getCookieNamed(name);
		Assert.assertEquals(languageCookie.getValue(), languages.get("es"));
	}

}
