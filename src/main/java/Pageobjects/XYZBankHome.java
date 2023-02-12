package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZBankHome {
	WebDriver driver;
	
	@FindBy(xpath="(//button[@class='btn btn-primary btn-lg'])[1]")
	WebElement customerlogin;

	@FindBy(xpath="(//button[@class='btn btn-primary btn-lg'])[2]")
	WebElement bankmanagerlogin;
	
	public void CustomerLogin() {	
		customerlogin.click();
		
	}
	public void BankManagerLogin() {	
		bankmanagerlogin.click();
	
	}
	
	public XYZBankHome(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
}


