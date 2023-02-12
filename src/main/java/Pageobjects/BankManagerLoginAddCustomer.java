package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponent.AbstractComponent;

public class BankManagerLoginAddCustomer extends AbstractComponent {
WebDriver driver;
	
public BankManagerLoginAddCustomer(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//Buttons
	@FindBy(xpath="//button[@class='btn btn-lg tab'][1]")
	WebElement addCustomer;
	

	//Add Customer
	
	@FindBy(xpath="//form[@name='myForm']/div[1]/input")
	WebElement firstName;
	
	@FindBy(xpath="//form[@name='myForm']/div[2]/input")
	WebElement secondName;
	
	@FindBy(xpath="//form[@name='myForm']/div[3]/input")
	WebElement postalCode;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement addCustomerbutton;
	

	
	
	public void addCustomer(String firstname,String lastname,String code)  {

		addCustomer.click();
	
		firstName.sendKeys(firstname);
		secondName.sendKeys(lastname);
		postalCode.sendKeys(code);
		addCustomerbutton.click();
		driver.switchTo().alert().accept();
		System.out.println("Customer added");
	}
	
	
	
	
	
	
	
}
