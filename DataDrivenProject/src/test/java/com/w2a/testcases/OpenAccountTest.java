package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends BaseTest{

	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void openAccount(String customer, String currency) throws InterruptedException {
	
		
		log.info("-----Inside Open Account Test-----");
		
		
		click("openAccountBtn_CSS");
		select("customer_CSS",customer);
		select("currency_CSS",currency);
		click("process_CSS");
		
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Account created successfully"),"Account not created successfully");
		Thread.sleep(3000);
		alert.accept();
		Assert.fail();
	}
}
