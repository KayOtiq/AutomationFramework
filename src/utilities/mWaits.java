package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class mWaits {
	
	public static ExpectedCondition<Boolean> visibilityOfElement(final WebElement element) {
		return new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver webDriver) {
				try{
					return element.isDisplayed();
				}catch(NoSuchElementException e){
					//throws this for x time until limit is met or element is displayed
					return false;
				}catch (StaleElementReferenceException e){
					return false;
					
				}
			}
			
		};
	}

	public static ExpectedCondition<Boolean> wait(final Boolean condition) {
		return new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver webDriver) {
				return condition;
			}
			
		};
		
	}
}
