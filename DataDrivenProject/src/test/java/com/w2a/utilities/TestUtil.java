package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.BaseTest;

import com.w2a.utilities.ExcelReader;

public class TestUtil extends BaseTest {
	public static String fileName;
	
public static void captureScreenshot() throws IOException {
		
		

		Date d = new Date();
		 fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
	
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File(".\\test-output\\html\\"+fileName));
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@DataProvider(name="dp")
	public static Object[][] getData(Method m) {
		ExcelReader excel= new ExcelReader("./src/test/resources/Excel/testdata.xlsx");
		String sheetName = m.getName();
		System.out.println(sheetName);
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rowNum - 1][colNum];

		for (int rows = 2; rows <= rowNum; rows++) {

			for (int cols = 0; cols < colNum; cols++) {

				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
		return data;
	}

}
