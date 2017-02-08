package pageObjects;

/**
 * This is a working example page object page
 * 
 * Use this as a template to page objects
 * 
 * Created by Lynda Montanez on 2/6/2017
 *  
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.mWaits;

public class FacebookPage extends BasePage {
	
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

	
	public FacebookPage (WebDriver driver) {

		super(driver);
		this.PAGE_TITLE = "Facebook - Log In or Sign up";
		this.PAGE_URL = "http://www.facebook.com";
	}

	public void setTextEmailLogin(String txt){
		// inherited from basePage object
		setText(emailLogin,txt);
	}
	
	public void setTextPasswordLogin(String txt){

		setText(passwordLogin,txt);
	}
	
	public void clickSubmit() {
		// Inherited from BasePage object
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
		// Inherited from BasePage object
		selectDropDown(month,val);
	}
	
	public void setDay(String val){
		selectDropDown(day,val);
	}
	
	public void setYear(String val){
		selectDropDown(year,val);
	}
	
	public void setSexMale(String val){

		
	}
	
	public void login(String email, String password){
		
		//example of using explicit wait to wait when object is visible
		wait.until(mWaits.visibilityOfElement(emailLogin)); 
		
		//example of using explicit wait, expected condition = clicable

		//wait.until(ExpectedConditions.elementToBeClickable(emailLogin));
		
		setTextEmailLogin(email);
		setTextPasswordLogin(password);
		clickSubmit();
	}

}
