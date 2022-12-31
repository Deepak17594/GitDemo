package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.w2a.utilities.TestUtil;

public class CustomListeners implements ITestListener	 {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
	
		
	//	Reporter.log("Screenshot of passed test cases");
		//System.out.println("Test cases are success through Listeners//Screenshot captured");
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//To get the message of failure method
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("Test cases : "+result.getMethod()+"---->"+ result.getThrowable().getMessage());
		
  	//To get the screenshot on same page
	//	 Reporter.log("<a href=\"E:\\Screenshot\\Deepak.png\">Screenshot Captured</a>");
		 
		 //To get the screenshot on new page
	     Reporter.log("<a target=\"_blank\" href="+TestUtil.fileName+">Screenshot Captured</a>");

	     Reporter.log("<a target=\"_blank\" href="+TestUtil.fileName+"><img src="+TestUtil.fileName+" height=200 width=200></a>");
	}

	public void onTestSkipped(ITestResult result) {

	}

	
}
