package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;
import com.w2a.utilities.TestUtil;



public class AddCustomerTest extends BaseTest{

	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomer(String firstName, String lastName, String postCode) throws InterruptedException {
		
		log.info("-----Inside Add Customer Test-----");
		
		click("addCustomer_CSS");
		type("firstName_CSS",firstName);
		type("lastName_CSS",lastName);
		type("postCode_CSS",postCode);
		click("addCustomerBtn_CSS");
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Customer added successfully"),"Customer not added successfully");
		Thread.sleep(3000);
		alert.accept();
		
	}
}
