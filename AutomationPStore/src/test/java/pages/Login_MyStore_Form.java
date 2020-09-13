package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class Login_MyStore_Form{
	WebDriver ldriver;
	
	
	@FindBy(css = "input#id_gender2") WebElement genderRadioBtn;
	@FindBy(css = "input#customer_firstname") WebElement fNameTBox;
	@FindBy(css="input#customer_lastname")WebElement lNameTBox;
	@FindBy(css="input#email")WebElement emailTbox;
	@FindBy(css="input#passwd")WebElement pWordTBox;
	@FindBy(css="select#days")WebElement ageDayDDown;
	@FindBy(css="select#months")WebElement ageMonthDDown;
	@FindBy(css="select#years")WebElement ageYearDDown;
	@FindBy(css="input#firstname")WebElement addressFNameTbox;
	@FindBy(css="input#lastname")WebElement addressLNameTbox;
	@FindBy(css="input#company")WebElement companyTbox;
	@FindBy(css="input#address1")WebElement address1Tbox;
	@FindBy(css="input#city")WebElement addressCityTbox;
	@FindBy(css="select#id_state")WebElement addressStateTbox;
	@FindBy(css="input#postcode")WebElement addressPostCodeTbox;
	@FindBy(css="select#id_country")WebElement addressCountryTbox;
	@FindBy(css="textarea#other")WebElement addressTArea;
	@FindBy(css="input#phone_mobile")WebElement mobileNumTbox;
	@FindBy(css="input#alias")WebElement aliasTBox;
	@FindBy(css="button#submitAccount")WebElement registerBtn;
	
	 public Login_MyStore_Form(WebDriver rdriver) {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver,this);
	}
	
		
	public void enterNameDetails() {
		genderRadioBtn.click();
		fNameTBox.sendKeys("xyz");
		lNameTBox.sendKeys("garg");
		emailTbox.sendKeys("xyz@domain.com");
		pWordTBox.sendKeys("xyzgarg");
	}	
	
	public void SelectDOB() {
		
		Select selDay = new Select(ageDayDDown);
		selDay.selectByValue("27");
		Select selMonth= new Select(ageMonthDDown);
		selMonth.selectByValue("7");
		Select selYear = new Select(ageYearDDown);
		selYear.selectByValue("1980");
		
	}
	
	public void enterAddressDetails() {
		addressFNameTbox.sendKeys("XYZ");
		addressLNameTbox.sendKeys("Garg");
		companyTbox.sendKeys("KPG.org");
		address1Tbox.sendKeys("132 firefox lane");
		addressCityTbox.sendKeys("Fairfax");
		Select selState = new Select(addressStateTbox);
		selState.selectByVisibleText("Virginia");
		addressPostCodeTbox.sendKeys("22031");
		Select selCountry = new Select(addressCountryTbox);
		selCountry.selectByVisibleText("United States");
		addressTArea.sendKeys("The quick brown fox jumps over a lazy dog");
		mobileNumTbox.sendKeys("7033352168");
		registerBtn.click();
		
	}
	
	
	

}
