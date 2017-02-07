package utilities;

public class Constant {
	

	//login page
	public static String UserName =   "lyndamontanez@gmail.com"; //"ali@ali.com";
	public static String Password =    "Test@123";  //"*()Insellerate0";
	
	public static String LoginTitle = "";
	public static String OpenAppTitle = "t";
	
	//   ~~  Subtitles  ~~
	
	//URLs
	public static String baseURL = "http://automationpractice.com/index.php";
	public static String baseURL_Staging = ""; 
	public static String baseURL_QA = ""; 
	
	
	//Path Names
	
	public static String Path_TestData = "C:\\Users\\lyndam\\workspace3\\MyStore\\src\\testData\\";
	public static String Path_Screenshot = "C:\\Users\\lyndam\\workspace3\\MyStore\\src\\screenshots\\";
	
	public static String ChromeExePath =  "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
	public static String IEExePath =  "C:\\SandboxLibraries\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe";
	
	//File Names
	public static String File_TestData = "TestDataSet1.xlsx";
	
    //Test Data Sheet Columns
    
	public static final int Col_TestCaseName = 0;		 
	public static final int Col_UserName =1 ;
	public static final int Col_Password = 2;
	public static final int Col_Browser = 3;
	public static final int Col_Env = 4;
	public static final int Col_Results = 5;
	public static final int Col_Timestamp = 6;
	public static final int Col_Desc = 7;

}
