package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponent.AbstractComponent;

public class CustomerLoginByName extends AbstractComponent	 {
	WebDriver driver;

	public CustomerLoginByName(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//*[@id='userSelect']")
	WebElement yourName;
	
	
	@FindBy(xpath="//button[@class='btn btn-default']")
    WebElement login;
	
	public void SelectName(String name) {	
		Select select= new Select(yourName);
		select.selectByVisibleText(name);
		login.click();
	
	}

}
