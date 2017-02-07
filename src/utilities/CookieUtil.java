package utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CookieUtil {
	
	public static void addCookieAndVerify(WebDriver driver, Cookie cookie) {
		
		driver.get(cookie.getDomain());
		//verify the cookie is not there
		Assert.assertTrue(driver.manage().getCookieNamed(cookie.getName()) == null);
		//add the cookie
		driver.manage().addCookie(cookie);
		driver.navigate().refresh();
		
		//verify language set to target name
		Assert.assertEquals(driver.manage().getCookieNamed(cookie.getName()).getValue(), cookie.getValue());
	}

}
