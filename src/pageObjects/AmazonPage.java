package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPage extends BasePage {

	
	@FindBy(css="ap_email") WebElement emailLogin;
	@FindBy(css="ap_password") WebElement passwordLogin;
	@FindBy(css="signInSubmit") WebElement submit;
	@FindBy(css="#twotabsearchtextbox") WebElement searchTxtBox;
	@FindBy(css=".nav-input") WebElement searchButton;
	@FindBy(css="#s-result-count") WebElement searchResults;
	@FindBy(css="#nav-link-accountList") WebElement acctButton;
	
	WebDriver driver;
	
	public  AmazonPage (WebDriver driver) {
	
		super(driver);	
		this.PAGE_TITLE = "Amazon";
		this.PAGE_URL = "http://www.amazon.com";
		
	}

	public void setTextEmailLogin(String txt){
		
		setText(emailLogin,txt);
	}
	
	public void setTextPasswordLogin(String txt){
		// phase 1- hard coded:  WebElement e = driver.findElement(By.cssSelector(passwordLogin));
		// phase 2- PageFactory: passwordLogin.sendKeys(txt);
		// phase 3- Inherited from BasePage:
		setText(passwordLogin,txt);
	} 
	
	public void clickSigninButton() {
		clickElement(submit);
	}
	
	public void setSearchText(String txt) {
		//P1) WebElement e = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		//P2) searchTxtBox.clear();
		//    searchTxtBox.sendKeys(txt);
		//e.clear();
		//e.sendKeys(txt);
		setText(searchTxtBox,txt);
		
	}
	
	public void clickSearchButton() {
		//P1) WebElement e = driver.findElement(By.cssSelector(".nav-input"));
		//    e.click();
		//P2)  searchButton.click();
		clickElement(searchButton);

		
	}
	
	public String getSearchResults() {
		return searchResults.getText();

	}
	
	public void clickAcctButton() {

		clickElement(acctButton);
	}
	/*
	public String getTitle() {
		return driver.getTitle();
		
	}
	
	public void clickBackButton() {
		 driver.navigate().back();
	}
*/
}
