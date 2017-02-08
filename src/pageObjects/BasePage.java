package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public String PAGE_URL;
	public String PAGE_TITLE;
	public WebDriver driver;  		
	public WebDriverWait wait; 		//explicit wait driver
	
	public BasePage(WebDriver driver) {
		this.driver = driver;	
        wait = new WebDriverWait(driver,5);
	}
	
	public void loadPage() {
		driver.get(getPageURL());
	}
	
	public void clickElement(WebElement e) {
		e.click();
	}
	
	public void setText(WebElement e, String txt) {
		e.clear();
		e.sendKeys(txt);		
	}
	
	public void selectDropDown(WebElement d, String val) {
		Select select = new Select(d);
		select.selectByValue(val);
	}
	
	public String getPageURL () {
		return PAGE_URL;
	}
	
	public  String getPageTitle() {
		return PAGE_TITLE;		
	}
	
	public void clickBack() {
		 driver.navigate().back();
	}

}
