package testCases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pageObjects.AmazonPage;
import utilities.DriverFactory;
import utilities.ExcelUtils;
import utilities.DriverFactory.BrowserType;

public class AmazonSearchTests2 extends BaseTest {
	
	AmazonPage amazonPg; 
	DriverFactory.BrowserType type = BrowserType.CHROME;
	
	String path = "C:Users//lyndam//workspace3//BaseProject//src//testData//";
	String file = "testData.LogIn.xlsx";

	@BeforeClass (alwaysRun=true)
	public void setup() {
		
        amazonPg = PageFactory.initElements(driver, AmazonPage.class);
	}
	
	@Parameters({"browserType"})
	@Test
	public void loadPage(@Optional("Chrome") String browserType) {
		
		amazonPg.loadPage();

	}
	@Test (dependsOnMethods="loadPage", enabled=true)
	public void testGetTitle() {
		String str = amazonPg.getPageTitle();
		System.out.println(str);
		
	}
	
	@Test (dataProvider = "searchAmazon",dependsOnMethods="loadPage", enabled=true)
	public void SearchAmazonWithExcelData(String name) throws Exception {

		//ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "AmazonBooks");
		amazonPg.setSearchText(name);
		amazonPg.clickSearchButton();
		String str = amazonPg.getSearchResults();
		System.out.println(str);
	}
	
	@Test(dataProvider = "searchAmazon", dependsOnMethods="loadPage", enabled=false)
	public void searchAmazonBooks(String bookName) {
		amazonPg.setSearchText(bookName);
		amazonPg.clickSearchButton();
		String str = amazonPg.getSearchResults();
		System.out.println(str);
		
	}

	@DataProvider(name="searchAmazon")
	public Object[][] loginData() throws Exception {
		Object[][] arrayObject = ExcelUtils.getTableArray(path + file,"AmazonBooks");  
		return arrayObject;
	}


}
