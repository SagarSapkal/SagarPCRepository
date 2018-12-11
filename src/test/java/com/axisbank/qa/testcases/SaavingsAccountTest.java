package com.axisbank.qa.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.axisbank.qa.base.BaseClass;
import com.axisbank.qa.pages.HomePage;
import com.axisbank.qa.pages.SaavingsAccount;
import com.axisbank.qa.pages.Savings_EasyAccessSA;

public class SaavingsAccountTest extends BaseClass {
	SaavingsAccount saavingsAccount;
	Savings_EasyAccessSA savings_EasyAccessSA;
	
	

	public SaavingsAccountTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		 saavingsAccount = new SaavingsAccount();
		 HomePage HMPage = new HomePage();
		  HMPage.GotoSavingsAccount();
	}
	
	@Test
	public void navigate() {

		savings_EasyAccessSA=saavingsAccount.navigateToEASaving();
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	

}
