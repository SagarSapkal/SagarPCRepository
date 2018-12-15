package com.axisbank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.axisbank.qa.base.BaseClass;



public class Savings_EasyAccessSA extends BaseClass{

	
	@FindBy(xpath="//*[@id=\"Genesys1_txtNames\"]")
	WebElement Name;
	
	@FindBy(xpath="//*[@id=\"Genesys1_txtEmail\"]")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"Genesys1_txtMobile\"]")
	WebElement MobileNo;
	
	@FindBy(xpath="//*[@id=\"Genesys1_ddlState\"]")
	WebElement states;
	
	@FindBy(xpath="//*[@id=\"Genesys1_SampleCaptchaValidator\"]")
	WebElement captchaValidator;
	
	@FindBy(xpath="//*[@id=\"Genesys1_chkDisclaimer1\"]")
	WebElement ChkDisclaimer;
	
	@FindBy(xpath="//*[@id=\"Genesys1_btnSubmit\"]")
	WebElement SubmitButton;
	
	@FindBy(xpath="//*[@id=\"Genesys1_ddlCity\"]")
	WebElement city;
	
	
	public Savings_EasyAccessSA() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public void FillForm() throws InterruptedException {
			
	Name.sendKeys("Sagar Sapkal");	
	Email.sendKeys("sagarsapkal99@gmail.com");
	MobileNo.sendKeys("8087777627");
	
	Select select= new Select(states);
	select.selectByValue("Maharashtra");
	Thread.sleep(2000L);
	Select select1= new Select(city);
	select1.selectByValue("Akola");

	ChkDisclaimer.click();
	SubmitButton.click();
		
	}
	public String CaptchaValidator() {
		return captchaValidator.getText();
		
	}
}
