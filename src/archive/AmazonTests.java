package archive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Constant;

public class AmazonTests {
	
	private WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setup() {
        System.setProperty("webdriver.chrome.driver", Constant.ChromeExePath);        
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@Test (groups={"p1"})
	public void loadPage() {
		
		//driver.navigate().to("https://www.amazon.com/");
		driver.get("https://www.amazon.com/");
	}
	


	@Test// (groups={"p3", "search"}, dependsOnMethods="clickAcctLnk")
	public void search1() {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("1984");
		driver.findElement(By.cssSelector(".nav-input")).click();
		String str = driver.findElement(By.cssSelector("#s-result-count")).getText();
		System.out.println(str);
	}
	
	@Test //(groups={"p3", "search"}, dependsOnMethods="clickAcctLnk")
	public void search2() {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("To Kill A Mockingbird");
		driver.findElement(By.cssSelector(".nav-input")).click();
		String str = driver.findElement(By.cssSelector("#s-result-count")).getText();
		System.out.println(str);
	}
	

	/*
	 @Test (groups={"p2", "acctLink"}, dependsOnMethods="loadPage")
	public void clickAcctLnk() {
        driver.findElement(By.cssSelector("#nav-link-accountList")).click();
        driver.navigate().back();
		
	}
	@AfterClass//(alwaysRun=true)
	public void teardown() {
		//this.driver.close();
		this.driver.quit();
	}
	*/
}
