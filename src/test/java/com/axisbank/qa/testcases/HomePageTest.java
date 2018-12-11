package com.axisbank.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.axisbank.qa.base.BaseClass;
import com.axisbank.qa.pages.HomePage;
import com.axisbank.qa.pages.SaavingsAccount;

public class HomePageTest extends BaseClass{
	HomePage homepage;
	SaavingsAccount saavingsAccount;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 homepage = new HomePage();
	}
	
	@Test(priority=1)
	
	public void logotest() {
		
		homepage.validateBanklogo();	
	}
	
	@Test(priority=2)
	public void Navigatetest() {
		saavingsAccount =homepage.GotoSavingsAccount();
			
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
