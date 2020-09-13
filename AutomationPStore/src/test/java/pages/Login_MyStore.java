package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_MyStore {
	
	WebDriver ldriver;
	
	@FindBy(xpath = "//div[@class='header_user_info']/a")  WebElement sign_in_tab;
	@FindBy(css = "input#email_create")	 WebElement emailTBox;
	@FindBy(css = "button#SubmitCreate") WebElement submitBtn;
	//@FindBy(xpath = "div[@class='header_user_info']/a")  WebElement sign_in_tab;
	
	
	
	public Login_MyStore(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public  void clickSignIn()
	{
		sign_in_tab.click();
		
	}
	
	public String  getTitle() {
		String title = ldriver.getTitle();
		return title;
	}
	
	public  void createAccount()
	{
	emailTBox.sendKeys("uvw@domain.com");
	submitBtn.click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
		
	}
	}

}
