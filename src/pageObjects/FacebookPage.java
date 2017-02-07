package pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.mWaits;

public class FacebookPage extends BasePage {
	
	//public static final String PAGE_TITLE = "Facebook - Log In or Sign up";
	//public static final String PAGE_URL = "http://www.facebook.com";
	
	@FindBy(css="#email") WebElement emailLogin;
	@FindBy(css="#pass") WebElement passwordLogin;
	@FindBy(css="#u_0_o") WebElement submitButton;
	
	@FindBy(name="firstname") WebElement firstname;
	@FindBy(name="lastname") WebElement lastname;
	@FindBy(name="reg_email__") WebElement signup;
	@FindBy(name="reg_email_confirmation__") WebElement confirm;
	@FindBy(name="reg_passwd__") WebElement password;
	
	@FindBy(id="month") WebElement month;
	@FindBy(id="day") WebElement day;
	@FindBy(id="year") WebElement year;
	
	@FindBy(id="sex") WebElement sex;
	
	//String emailLogin = "#email"; //id="email"
	//String passwordLogin = "#pass"; //id="pass"
	//String submit = "submit"; //
	
	//WebDriver driver;
	
	public FacebookPage (WebDriver driver) {
	
		//this.driver = driver;
		super(driver);
		this.PAGE_TITLE = "Facebook - Log In or Sign up";
		this.PAGE_URL = "http://www.facebook.com";
	}

	public void setTextEmailLogin(String txt){
		//WebElement e = driver.findElement(By.cssSelector(emailLogin));
		//e.sendKeys(txt);
		//emailLogin.clear();
		//emailLogin.sendKeys(txt);
		setText(emailLogin,txt);
	}
	
	public void setTextPasswordLogin(String txt){
		//WebElement e = driver.findElement(By.cssSelector(passwordLogin));
		//e.sendKeys(txt);
		//passwordLogin.clear();
		//passwordLogin.sendKeys(txt);
		setText(passwordLogin,txt);
	}
	
	public void clickSubmit() {
		//submitButton.click();
		clickElement(submitButton);
	}
	
	public void setFirstName(String txt){
		setText(firstname,txt);
	}
	
	public void setLastName(String txt) {
		setText(lastname,txt);
	}
	
	public void setSignUp(String txt) {
		setText(signup,txt);
	}
	
	public void setConfirm(String txt) {
		setText(confirm,txt);
	}
	
	public void setPassword(String txt){
		setText(password,txt);
	}
	
	
	public void setMonth(String val){
		selectDropDown(month,val);
	}
	
	public void setDay(String val){
		selectDropDown(day,val);
	}
	
	public void setYear(String val){
		selectDropDown(year,val);
	}
	
	public void setSex(String val){
		
		
	}
	
	public void login(String email, String password){
		wait.until(mWaits.visibilityOfElement(emailLogin));
		wait.until(ExpectedConditions.elementToBeClickable(emailLogin));
		setTextEmailLogin(email);
		setTextPasswordLogin(password);
		clickSubmit();
	}
	
	public String getTitle() {
		return driver.getTitle();
		
	}
}
