package com.axisbank.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axisbank.qa.base.BaseClass;
import com.axisbank.qa.util.TestUtil;


public class SaavingsAccount extends BaseClass{
	
	
	

	@FindBy(xpath="//h3[text()='EasyAccess Savings Account']")
	WebElement EASavingsAccForm;
	
	@FindBy(xpath="//*[@id=\"ulSavingsAccount\"]/li[2]/div[2]/a[2]")
	WebElement EASavingsAccApplyBtn; 
	

	public SaavingsAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public Savings_EasyAccessSA navigateToEASaving() {
		
	
	  
		Actions action = new Actions(driver);
		action.moveToElement(EASavingsAccApplyBtn).build().perform();
		
		//EASavingsAccApplyBtn.click();
		TestUtil.clickElementByJS(EASavingsAccApplyBtn, driver);
		return new Savings_EasyAccessSA();
	}


}
