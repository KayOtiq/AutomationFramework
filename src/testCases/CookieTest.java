package testCases;

import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseTest;
import utilities.DriverFactory;
import utilities.DriverFactory.BrowserType;

public class CookieTest extends BaseTest{
	
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
	
	Cookie en_cookie = new Cookie(name,languages.get("en"));
	Cookie es_cookie = new Cookie(name,languages.get("es"),"/");
	
	public boolean doesCookieExist(String name) {
		for(Cookie c : driver.manage().getCookies()){
			if(c.getName().equals(name)) {
				return true;
			}
		}
		return false;	
}
	
	@BeforeClass
	public void setupCookies() throws Exception {
		this.driver = DriverFactory.getDriver(type);
		someDate = new Date();
		someDate.setTime(System.currentTimeMillis() + 60000);
		baseURL = "http://"+domain;
	}
	
	@BeforeMethod
	public void removeCookies() {
		driver.get(baseURL);//need to be sure we are on the correct page or will be deleting wrong cookies
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void cleanup() {
		this.driver.quit();
	}
	
	@Test
	public void addEnglishCookie() throws Exception {
		driver.get(baseURL);
				
		//Assert.assertFalse(doesCookieExist(name));
		Assert.assertTrue(driver.manage().getCookieNamed(name) == null);
		//add the cookie
		driver.manage().addCookie(en_cookie);
		driver.navigate().refresh();
		
		//verify language set to English
		boolean doesExist = false;
		Assert.assertEquals(driver.manage().getCookieNamed(name).getValue(), en_cookie.getValue());
		Assert.assertTrue(doesExist, "Cookie exists");
		//Assert the language is English
		
		//To Do later
		
	}
	
	
	@Test
	public void addSpanishCookie() throws Exception {
		driver.get(baseURL);
		Assert.assertTrue(driver.manage().getCookieNamed(name) == null);
		//add en_cookie
		Cookie cookie_by_domain = new Cookie(name,languages.get("es"),domain, "/",someDate);
		driver.manage().addCookie(cookie_by_domain);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
	}
	
	@Test
	public void addSpanishCookieByDomain() throws Exception {
		driver.get(baseURL);
		Assert.assertTrue(driver.manage().getCookieNamed(name) == null);
		//add en_cookie
		driver.manage().addCookie(es_cookie);
		driver.navigate().refresh();
		//verify language is set to english
		Assert.assertEquals(driver.manage().getCookieNamed(name).getValue(), en_cookie.getValue());

		Cookie cookie_by_domain = new Cookie(name,languages.get("es"),domain, "/",someDate);
		driver.manage().addCookie(cookie_by_domain);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
	}
	
	@Test
	public void deleteSpanishCookieTakesYouBackToEnglish() throws Exception{
		
		driver.get(baseURL);
		Assert.assertTrue(driver.manage().getCookieNamed(name) == null);
		//add en_cookie
		driver.manage().addCookie(es_cookie);
		driver.navigate().refresh();
		//verify language is set to english
		Assert.assertEquals(driver.manage().getCookieNamed(name).getValue(), es_cookie.getValue());

		Cookie cookie_by_domain = new Cookie(name,languages.get("es"),domain, "/",someDate);
		driver.manage().addCookie(cookie_by_domain);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
		driver.manage().deleteCookieNamed(name);
		driver.navigate().refresh();
		
	}
	
	@Test
	public void dropDownToSpanish() {
		driver.get(baseURL);
		driver.findElement(By.cssSelector("#language_pulldown")).click();
		driver.findElement(By.cssSelector("a[href='?l=spanish']")).click();
		_wait.until(ExpectedConditions.textToBe(By.cssSelector("language_pulldown"), "idioma"));

		Cookie languageCookie = driver.manage().getCookieNamed(name);
		Assert.assertEquals(languageCookie.getValue(), languages.get("es"));
	}

}
