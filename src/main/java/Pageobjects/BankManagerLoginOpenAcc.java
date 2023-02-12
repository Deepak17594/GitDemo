package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponent.AbstractComponent;


public class BankManagerLoginOpenAcc extends AbstractComponent{
	

WebDriver driver;

	public BankManagerLoginOpenAcc(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//div[@class='center']/button[2]")
	WebElement openAccount;
	
	
	@FindBy(xpath="//*[@name='userSelect']")
	WebElement yourName;
	
	@FindBy(xpath="//*[@name='currency']")
	WebElement currency;
	
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement process;
	
	
	public void selectNameandCurrency(String name,String currencyType) throws InterruptedException {
		
		
		openAccount.click();
		Thread.sleep(2000);
		
		Select select= new Select(yourName);
		select.selectByVisibleText(name);
		
		Select select1= new Select(currency);
		select1.selectByVisibleText(currencyType);		
		process.click();
		driver.switchTo().alert().accept();
		System.out.println("Name and currency added");
		
	}

	
}
