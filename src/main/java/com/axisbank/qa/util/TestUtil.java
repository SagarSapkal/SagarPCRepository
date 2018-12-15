package com.axisbank.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.axisbank.qa.base.BaseClass;

public class TestUtil extends BaseClass {

	public static long Page_Load_TimeOut = 20;
	public static long Implicit_Wait =10;
	
	
	  public static void clickElementByJS(WebElement element, WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("arguments[0].click();", element);
	  } 

	  public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
			
		}



}
 



