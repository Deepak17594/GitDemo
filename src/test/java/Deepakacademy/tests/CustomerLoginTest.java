package Deepakacademy.tests;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pageobjects.CustomerLoginByName;
import Pageobjects.XYZBankHome;


@Test
public class CustomerLoginTest extends BaseTest{
	
	
	@Test(dependsOnMethods={"bankManagerLogin"})
	public void CustomerLogin() throws Exception {	
		XYZBankHome xyz= new XYZBankHome(driver);
		xyz.CustomerLogin();
	    CustomerLoginByName customer= new CustomerLoginByName(driver);
		customer.SelectName(firstname+" "+lastname);	
		System.out.println("user logged in successfully");
		
	}

}
