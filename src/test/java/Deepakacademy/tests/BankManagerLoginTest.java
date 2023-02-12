package Deepakacademy.tests;

import java.time.Duration;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pageobjects.BankManagerLoginAddCustomer;
import Pageobjects.BankManagerLoginDeleteCustomer;
import Pageobjects.BankManagerLoginOpenAcc;
import Pageobjects.XYZBankHome;


@Test
public class BankManagerLoginTest extends BaseTest  {
	
	
	@Test
	public void bankManagerLogin() throws InterruptedException  {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			
		XYZBankHome xyz= new XYZBankHome(driver);
		xyz.BankManagerLogin();		
		
		BankManagerLoginAddCustomer loginxyz= new BankManagerLoginAddCustomer(driver);
		loginxyz.addCustomer(firstname, lastname, pinCode);
	
		BankManagerLoginOpenAcc openAccXYZ=new BankManagerLoginOpenAcc(driver);	
		openAccXYZ.selectNameandCurrency(firstname+" "+lastname,Currency);	
		openAccXYZ.gotoHome();

	//	BankManagerLoginDeleteCustomer  deleteXYZ=new BankManagerLoginDeleteCustomer(driver);
	//	deleteXYZ.deleteCustomer(firstname);
		
        System.out.println("Execution completedm for creating user account");
     
  
		
	}

}
