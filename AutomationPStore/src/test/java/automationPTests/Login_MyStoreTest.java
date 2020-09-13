package automationPTests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;


import pages.Login_MyStore;

    public class Login_MyStoreTest extends BaseTest{
    	
	 	
	@Test 
	public void login() {
		logger=extent.createTest("login to the store on 9th sept");
		lpage = new Login_MyStore(driver);
		logger.log(Status.INFO, "reached the page");
		lpage.clickSignIn();
		logger.log(Status.INFO, "clicked sign in");
		String title1 = lpage.getTitle();
		lpage.createAccount();
		logger.log(Status.INFO,"created customer");
		System.out.println("title of page is "+ title1);

	}
	
	
	
	
	
}