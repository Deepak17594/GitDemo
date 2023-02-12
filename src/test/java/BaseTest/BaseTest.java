package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static String firstname="Anshu";
	public static String lastname="Choudhary";
	public static String pinCode="21134";
	public static String Currency="Dollar";
	
	
	@BeforeSuite
	public static WebDriver launchBrowser() throws Exception {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
 driver=new ChromeDriver();

driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
Thread.sleep(2000);
	   	return driver;
	}

	@AfterSuite
	public void  quitBrowser() {
		
		driver.quit();
		
		
	}
}
