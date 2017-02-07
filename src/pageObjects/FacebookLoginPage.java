package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BasePage {
	
	//public static final String PAGE_TITLE = "Facebook - Log In or Sign up";
	//public static final String PAGE_URL = "http://www.facebook.com/login.php";
	
	@FindBy(css="#email") WebElement emailLogin;
	@FindBy(css="#pass") WebElement passwordLogin;
	@FindBy(css="#loginbutton") WebElement submitButton;
	@FindBy(css=".login_error_box>div:first-child") WebElement errorHeader;
	

	//WebDriver driver;
	
	public FacebookLoginPage (WebDriver driver) {
	
		//this.driver = driver;
		super(driver);
		this.PAGE_TITLE = "Facebook - Log In or Sign up";
		this.PAGE_URL ="http://www.facebook.com/login.php";
	}

	public void setTextEmailLogin(String txt){

		emailLogin.clear();
		emailLogin.sendKeys(txt);
	}
	
	public void setTextPasswordLogin(String txt){

		passwordLogin.clear();
		passwordLogin.sendKeys(txt);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
		
	}
	public boolean checkErrorHeader(String txt) {
		try{
			return errorHeader.equals(txt);
		}catch (NoSuchElementException e) {
			return false;
		}
	}

}
