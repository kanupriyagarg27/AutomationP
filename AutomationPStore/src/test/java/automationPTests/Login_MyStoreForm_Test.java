package automationPTests;

import org.testng.annotations.Test;
import pages.Login_MyStore_Form;


public class Login_MyStoreForm_Test extends BaseTest{
	
	Login_MyStore_Form login_form = new Login_MyStore_Form(driver);
	Login_MyStoreTest logintest= new Login_MyStoreTest();
	
	
	@Test
	public void fillform() {
		
		logintest.login();
		login_form.enterNameDetails();
		login_form.enterAddressDetails();
		login_form.SelectDOB();
		
		
	}
	
	

}
