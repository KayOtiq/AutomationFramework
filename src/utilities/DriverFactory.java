package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	
	public enum BrowserType {
		FIREFOX("firefox"),
		CHROME("chrome"),
		IE("ie"),
		SAFARI("safari");  //haven't implemented this one yet
		
		private String val;
		
		BrowserType(String val) {
			this.val = val;
		}
		
		public String getBrowserName() {
			return this.val;
		}
	}

	
	public static WebDriver getDriver (BrowserType type) {
		WebDriver driver = null;
		switch(type){
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", Constant.ChromeExePath); 
			driver = new ChromeDriver();
			break;
		case IE:
			System.setProperty("webdriver.ie.driver", Constant.IEExePath);
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			 driver = new InternetExplorerDriver(ieCapabilities);
		 default:
			System.setProperty("webdriver.chrome.driver", Constant.ChromeExePath); 
			driver = new ChromeDriver(); 
		
		}
		return driver;
	}
	/*
	public static BrowserType getBrowserTypeByProperty() {
		BrowserType type = null;
		String browsername = PropertyManager.getPropety("BROWSER");
		
		for(BrowserType b : BrowserType.values()) {
			if(b.getBrowserName().equalsIgnoreCase(browsername)) {
				type = b;
				System.out.println(("BROWSER = " + type.getBrowserName());
			}
		}
		return type;
	}
	*/
}
