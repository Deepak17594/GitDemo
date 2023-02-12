package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerLoginDeleteCustomer {
	WebDriver driver;

	
	public BankManagerLoginDeleteCustomer(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	

	@FindBy(xpath="//div[@class='center']/button[3]")
	WebElement Customers;
	
	
	@FindBy(xpath="//div[@class='form-group']//input[@type='text']")
	WebElement searchCustomer;
	
	@FindBy(xpath="//button[contains(text(),'Delete')]")
	WebElement deleteCustomer;
	
	public void deleteCustomer(String name) {
		
		Customers.click();
		searchCustomer.sendKeys(name);
		deleteCustomer.click();
		System.out.println("Customer deleted");
		
		
	}
}
