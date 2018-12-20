package com.axisbank.qa.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

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
	
	

	  public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
			
		}

	  public static void flash(WebElement element, WebDriver driver) {
	        JavascriptExecutor js = ((JavascriptExecutor) driver);
	        String bgcolor  = element.getCssValue("backgroundColor");
	        for (int i = 0; i <  10; i++) {
	            changeColor("rgb(0,200,0)", element,driver);//1
	            changeColor(bgcolor, element,driver);//2
	        }
	    }
	    public static void changeColor(String color, WebElement element, WebDriver driver) {
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

	        try {
	            Thread.sleep(20);
	        }  catch (InterruptedException e) {
	        }
	     }
		
		// JavaScript Methods 
	    public static void drawBorder(WebElement element, WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("arguments[0].style.border='3px solid red'", element);
	    }
	    
	    public static void generateAlert(WebDriver driver, String message){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("alert('"+message+"')");

	    }
	    
	    public static void clickElementByJS(WebElement element, WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("arguments[0].click();", element);
	    	
	    }
		
	    public static void refreshBrowserByJS(WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("history.go(0)");
	    }
	    
	    public static String getTitleByJS(WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	String title = js.executeScript("return document.title;").toString();
	    	return title;
	    }
	    
	    public static String getPageInnerText(WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
	    	return pageText;
	    }
	    
	    public static void scrollPageDown(WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	    }
	    
	    public static void scrollIntoView(WebElement element, WebDriver driver){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	    
		 public static HashMap<String,String> GetTestData(String SheetName,String TestCaseName) throws SQLException, ClassNotFoundException {
			
			 HashMap<String,String> hm=new HashMap<String,String>(); 	
			 Class.forName(prop.getProperty("dbDriver"));
			 Connection con =DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUsername"),prop.getProperty("dbPassword"));			
			 Statement stm = con.createStatement();
			 ResultSet rs = stm.executeQuery("select * from"+SheetName+" where TestCaseID="+TestCaseName);
			 //Get Coulumn Count
			 ResultSetMetaData rsmd = rs.getMetaData();
			 int ColumnCount = rsmd.getColumnCount();

				while( rs.next()){
						 
					for(int i = 1;i<=ColumnCount;i++) {
					
						String ColumnName = rsmd.getColumnName(i);
						String ColumnData = rs.getString(i);
						hm.put(ColumnName, ColumnData);
								
				    }				 
				}
			
				return hm;
			
	 
			}
	    
	    
	    
	    
	    
	    
	    
}
 



