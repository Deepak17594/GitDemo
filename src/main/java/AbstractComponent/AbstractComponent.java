package AbstractComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractComponent {
	public static WebDriver driver;
	@FindBy(xpath="//button[@class='btn home']")
	WebElement homebutton;
	
	
	public void gotoHome() {
		
		homebutton.click();		
		
	}
	
}
