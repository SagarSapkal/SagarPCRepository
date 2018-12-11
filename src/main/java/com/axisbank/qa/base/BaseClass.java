 package com.axisbank.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


import com.axisbank.qa.util.TestUtil;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass(){
		
		try {
		prop = new Properties();
		FileInputStream fil = new FileInputStream("C:\\Users\\Sagar Sapkal\\eclipse-workspace\\POM\\src\\main\\java\\com\\axisbank\\qa\\config\\config.properties");
		prop.load(fil);
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();		
		}
	}
	
	public static void initialization(){
		String browserName= prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
	 
		}else if(browserName.equals("internetexplorer")) {

			System.setProperty("webdriver.edge.driver","‪C:\\Selenium\\Drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
