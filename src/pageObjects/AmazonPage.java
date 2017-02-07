package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPage {
	public static final String PAGE_TITLE = "Amazon";
	public static final String PAGE_URL = "http://www.amazon.com";
	
	@FindBy(css="ap_email") WebElement emailLogin;
	@FindBy(css="ap_password") WebElement passwordLogin;
	@FindBy(css="signInSubmit") WebElement submit;
	@FindBy(css="#twotabsearchtextbox") WebElement searchTxtBox;
	@FindBy(css=".nav-input") WebElement searchButton;
	@FindBy(css="#s-result-count") WebElement searchResults;
	@FindBy(css="#nav-link-accountList") WebElement acctButton;
	
	WebDriver driver;
	
	public  AmazonPage (WebDriver driver) {
	
		this.driver = driver;		
		
	}

	public void setTextEmailLogin(String txt){
		//WebElement e = driver.findElement(By.cssSelector(emailLogin));
		
		emailLogin.sendKeys(txt);
	}
	
	public void setTextPasswordLogin(String txt){
		//WebElement e = driver.findElement(By.cssSelector(passwordLogin));
		passwordLogin.sendKeys(txt);
	} 
	
	public void clickSigninButton() {
		//WebElement e = driver.findElement(By.cssSelector(submit));
		submit.submit();
		
	}
	
	public void setSearchText(String txt) {
		//WebElement e = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchTxtBox.clear();
		searchTxtBox.sendKeys(txt);
		//e.clear();
		//e.sendKeys(txt);
		
	}
	
	public void clickSearchButton() {
		//WebElement e = driver.findElement(By.cssSelector(".nav-input"));
		//e.click();
		searchButton.click();

		
	}
	
	public String getSearchResults() {
		//WebElement e = driver.findElement(By.cssSelector("#s-result-count"));
		return searchResults.getText();
		//return e.getText();
	}
	
	public void clickAcctButton() {
		//WebElement e = driver.findElement(By.cssSelector("#nav-link-accountList"));
		acctButton.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
		
	}
	public void clickBackButton() {
		 driver.navigate().back();
	}

}
