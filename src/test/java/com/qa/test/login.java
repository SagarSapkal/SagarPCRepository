package com.qa.test;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class login {

 
	WebDriver driver;
	

	
	@BeforeMethod
	
	public void Beforemethod() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}

	@Test(priority=3)
	 public void actions() throws InterruptedException {
		
		
		
		driver.get("https://www.axisbank.com/");
	
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("/html/body/header/div[4]/div/div/div/div/div[1]/div[3]/ul/li[1]/a"))).build().perform();
		
		
		driver.findElement(By.xpath("//a[@href='/retail/accounts/savings-account'  and @data-eventlabel='Saving Account']")).click();
		driver.close();
		System.out.println("test");
}
}
