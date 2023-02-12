package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;

public class CustomerLoginPassbook {
	WebDriver driver;
	
	public void CustomerLoginPassbook(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
@FindBy(xpath="//div[@class='center'][2]/button[1]")
WebElement transaction;


@FindBy(xpath="//div[@class='center'][2]/button[2]")
WebElement deposit;


@FindBy(xpath="//div[@class='center'][2]/button[3]")
WebElement withdrawl;

	//Validation message

@FindBy(xpath="//*[contains(text(),' Welcome ')]")
WebElement welcomeMsg;

public void loginValidation(WebDriver driver) {
	
	String textMsg=welcomeMsg.getText();

}


	public void transaction() {
		
		transaction.click();
		
		
	}
public void deposit() {
		
		transaction.click();
		
		
	}


public void withdrawl() {
	
	transaction.click();
	
	
}
	

}
