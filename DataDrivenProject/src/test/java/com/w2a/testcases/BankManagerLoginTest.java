package com.w2a.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;

public class BankManagerLoginTest extends BaseTest {


	@Test
	public void loginAsBankManager() {
		
		log.info("-----Bank Manager Test-----");
		
		click("bmlBtn_CSS");
		Assert.assertTrue(isElementPresent("addCustomer_CSS"),"Test case failed as Login was not success");
		
	}
	
	
}
