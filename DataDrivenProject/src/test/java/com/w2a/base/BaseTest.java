package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.DbManager;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.MonitoringMail;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	/*
	 * WebDriver 
	 * TestNG 
	 * Screenshots
	 *  Keywords - click, type, isElementPresent etc
	 * Excel 
	 * Logs
	 *  Properties
	 *   Mail 
	 *   Reporting
	 *    Listeners
	 *     Wait
	 */

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(BaseTest.class.getSimpleName());
	public static Properties or = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	public static WebDriverWait wait;
	public static MonitoringMail mail = new MonitoringMail();
	public static Boolean b;
	public static WebElement dropdown;

	public static boolean isVisible(String locatorKey) {

		if (locatorKey.endsWith("_XPATH")) {

			b = driver.findElement(By.xpath(or.getProperty(locatorKey))).isDisplayed();
		} else if (locatorKey.endsWith("_CSS")) {
			b = driver.findElement(By.cssSelector(or.getProperty(locatorKey))).isDisplayed();
		} else if (locatorKey.endsWith("_ID")) {
			b = driver.findElement(By.id(or.getProperty(locatorKey))).isDisplayed();
		}

		log.info("Finding an Element : " + locatorKey);

		return b;

	}
	
	

	public static boolean isElementPresent(String locatorKey) {

		try {
			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(or.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locatorKey)));
			}

			log.info("Finding an Element : " + locatorKey);
			return true;
		} catch (Throwable t) {

			log.info("Error while finding an Element : " + locatorKey + " error message is : " + t.getMessage());
			return false;
		}

	}

	public static void click(String locatorKey) {

		if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(locatorKey))).click();
		}

		log.info("Clicking on an Element : " + locatorKey);
	}

	
	public static void select(String locatorKey, String value) {

		
		if (locatorKey.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(or.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(or.getProperty(locatorKey)));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.info("Selecting an Element : " + locatorKey+" selected value is : "+value);
	}


	public static void type(String locatorKey, String value) {

		if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(value);
		}

		log.info("Typing in an Element : " + locatorKey + " entered value as : " + value);
	}

	@BeforeSuite
	public void setUp() {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("Config properties file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			or.load(fis);
			log.info("OR properties file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched !!!");

		} else if (config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox browser launched !!!");

		}

		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		 wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		try {
			DbManager.setDbConnection();
			log.info("Db connection created !!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void tearDown() {

		
		driver.quit();
		log.info("Test execution completed !!!");
	}

}
