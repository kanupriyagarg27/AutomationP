package automationPTests;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import pages.Login_MyStore;
import pages.Login_MyStore_Form;
import utility.TakescreenshotonFailure;



public class BaseTest{
	
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest logger;
	 Login_MyStore lpage;
	 Login_MyStore_Form loginformpage;
	 
	
	public BaseTest() {
		try 
		{
			System.out.println("i am in BaseTest constructor");
			File src = new File("configuration./config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
	    }	
		catch(Exception e)
		{
			System.out.println("The File was not found");
		}
	}
	
	@BeforeClass
	public void setup() {

	String browser = prop.getProperty("browsername");
	String myurl = prop.getProperty("url2");
	System.out.println(browser);
	System.out.println(myurl);

	if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
		driver = new ChromeDriver();
	}
	if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", prop.getProperty("geckopath"));
		driver = new FirefoxDriver();
	}
   System.out.println(driver);
	driver.get(myurl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
	driver.manage().deleteAllCookies();
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String reportName= "Report" +timeStamp+ ".html";
	htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/ExtentReports/"+reportName);
	extent= new ExtentReports();
	extent.attachReporter(htmlReport);
	
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
	 if (result.getStatus()==ITestResult.FAILURE) {
	    logger.log(Status.FAIL, "The test case "+result.getName()+"failed");
		 TakescreenshotonFailure.takescrshotonFailure(driver, result.getName());
	 }
		
		driver.close();
		extent.flush();
	}

}

