package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AAAHomePage extends BasePage {
	
	@FindBy(css=".logo>a>img") WebElement logoHomeLink;
	@FindBy(css="search_box") WebElement searchBox;
	@FindBy(css="locations") WebElement locationsLink;
	@FindBy(xpath = "html/body/header/div[2]/div/div[1]/div[2]/span[1]/a[2]") WebElement contactUsLink;
	@FindBy(id=".//*[@id='notYourClub']") WebElement notYourClubLink;
	@FindBy(xpath="html/body/header/div[2]/div/div[1]/div[2]/span[1]/a[2]") WebElement callForAssistanceLink;
	@FindBy(id = "membership") WebElement membership;
	@FindBy(id="insurance") WebElement insurance;
	@FindBy(id="travel") WebElement travel;
	@FindBy(id="discounts") WebElement discounts;
	@FindBy(id="automotive") WebElement automotive;
	@FindBy(id  = "financial") WebElement financial;
	@FindBy(id="about aaa") WebElement aboutAAA;
	
	
WebDriver driver;
	
	public  AAAHomePage (WebDriver driver) {
	
		super(driver);	
		this.PAGE_TITLE = "Automobile Club of Sothern California - home";
		this.PAGE_URL = "http://www.calif.aaa.com.com";
		
	}
	
	public void clickHomeLogo() {
		clickElement(logoHomeLink);
	}
	
	public void clickAAALocationsLink() {
		clickElement(locationsLink);
	}

	public void clickContactUsLink() {
		clickElement();
	}
	
	public void clickNotYourClubLink () {
		clickElement();
	}

	public void clickCallRodesideAssistLink() {
		clickElement();
	}
	
	public void clickMembership() {
		clickElement(membership);
		
	}
	
	public void 
}
