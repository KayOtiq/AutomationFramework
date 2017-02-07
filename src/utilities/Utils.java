package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utilities.Constant;

public class Utils {
	
		public static WebDriver driver = null;
		private static boolean reportOutput = true;
			
		public static  WebDriver openBrowser(String browserName, String url) throws Exception {
			
			try {
				if(browserName.equalsIgnoreCase("chrome")){
			        System.setProperty("webdriver.chrome.driver", Constant.ChromeExePath);        
					driver = new ChromeDriver();
					Log.info("Utils:  Chrome driver instantiated");
					
					//define variable
			        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			        Log.info("Utils:  Implicit wait for driver set to 30 seconds");
			      
				}else if(browserName.equalsIgnoreCase("firefox")){
					 driver = new FirefoxDriver();
					Log.info("Utils:  Firefox driver instantiated");
						        
				}else if (browserName.equalsIgnoreCase("IE")){
					System.setProperty("webdriver.ie.driver", Constant.IEExePath);
					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
					ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
					 driver = new InternetExplorerDriver(ieCapabilities);
					 Log.info("Utils:  Internet Explorer driver instantiated");
									
				}else {
					Log.error("Utils:  Unidentified browser type");
					Reporter.log("Unidentified browser name",reportOutput);// log to index.html test reporter
				}
		        
			} catch (Exception e) {
				Log.error("Class: Utilities | Method: OpenBrowser | Exception Desc: " + e.getMessage());
				Reporter.log("Unable to open browser",reportOutput);// log to index.html test reporter
				throw e; 
			}
			try{
			 driver.get(url);
		     Log.info("Utils:  Target URL launched");
		     return driver;
		     
			}catch (Exception e){
				Log.error("Class: Utilities | Method: OpenBrowser | Exception Desc: Unidentified environment name. " + e.getMessage());
				Reporter.log("Unidentifed environment name",reportOutput);// log to index.html test reporter
				throw e;
			}
			
		}
		
		//Opens browser using data sheet
		public static WebDriver openBrowser(int iTestCaseRow) throws Exception {
			
			try {
				String browserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
				String env = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Env);
				String url = getUrl(env);
				openBrowser(browserName, url);
				
			}catch (Exception e){
				Log.error("Class: Utilities | Method: OpenBrowser by TestCaseRow | Exception Desc: " + e.getMessage());
				Reporter.log("Unable to open browser",reportOutput);
				throw e;
			}
			
			return driver;
			
		}		
		
		//Get the test case name from the target test data sheet using the test case row number
		public static String getTestCaseName(String testCaseName) throws Exception {
			
			String val = testCaseName;
			
			try{
				int i = val.indexOf("@");
				val = val.substring(0,i);
				i = val.lastIndexOf(".");
				val = val.substring(i + 1);
				
				return val;
						
			}catch (Exception e){
				Log.error("Class:  Utilities  |  Method: getTestCaseName  |  Exception Desc: " + e.getMessage());
				Reporter.log("Unable to get test case name",reportOutput);// log to index.html test reporter
				throw (e);
				
			}
		}
		
		//Gets current system date for time stamping
		public static String getDate(){
			
			String format ="MM/dd/yyyy HH:mm:ss";
			Date date = new Date();

			DateFormat dateFormat = new SimpleDateFormat(format);
		    String formattedDate= dateFormat.format(date);
			
		    Log.info("Utils: Current System date returned");
			return formattedDate;
			
		}
		//Gets the environment name from data sheet and converts to correct URL
		public static String getUrl(String env) throws Exception{
			
			String envName = new String(env);
			String url = null;
			try {
				
				switch(envName.toUpperCase()) {
				case "QA":
					url = Constant.baseURL_QA;
					Log.info("Utils: Using QA Environment");
					break;
				case "STAGING":
					url = Constant.baseURL_Staging;
					Log.info("Utils: Using Staging Environment");
					break;
				}
				return url;
				
			}catch (Exception e){
				Log.error("Class:  Utilities  |  Method: getUrl  |  Exception Desc: " + e.getMessage());
				
		        Reporter.log("Unable to get url.  Env name: " + env + "<br> ",reportOutput);// log to index.html test reporter

				throw (e);
		}
	}
		//Gets screenshot of errors
		 public static void takeScreenshot(WebDriver driver, String testCaseName) throws Exception{
			 
				try{
	 				File filename = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	 
					FileUtils.copyFile(filename, new File(Constant.Path_Screenshot + testCaseName +".jpg"));	
	 
				} catch (Exception e){
	 
					Log.error("Class Utils | Method takeScreenshot | Exception occurred while capturing Screen shot : "+e.getMessage());
					Reporter.log("Unable to take screenshot <br> ",reportOutput);// log to index.html test reporter

	 
					throw new Exception();
	 
				}
	 
		 }	
		 
		  public static boolean isElementPresent(By by) {
			    try {
			      driver.findElement(by);
			      return true;
			    } catch (NoSuchElementException e) {
			      return false;
			    }
			  }
		  public void clickWhenReady(By locator, int timeout) {

			  WebElement element = null;
			  WebDriverWait wait = new WebDriverWait(driver, timeout);
			  element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			  element.click();

			   }
}
