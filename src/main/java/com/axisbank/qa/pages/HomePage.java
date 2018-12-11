package com.axisbank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axisbank.qa.base.BaseClass;

public class HomePage extends BaseClass {

	
	//PageFactory OR:
	@FindBy(xpath="//*[@class='logoSect']//img[@src='/assets/images/logo.png']")
	WebElement bankLogo;
	
	@FindBy(xpath="//a[text()='Explore Products']")
	WebElement ExploreProduct;
	
	@FindBy(xpath="//a[@data-eventcategory='Explore Products' and @data-eventaction='Retail'and @data-eventlabel='Accounts']")
	WebElement ExplorePrd_Retail_Accounts ;
	
	@FindBy(xpath="//a[@data-eventcategory='Explore Products'  and @data-eventlabel='Saving Account']")
	WebElement ExplorePrd_Retail_Savingsacc ;
	
	//initializing page objects
	public HomePage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public boolean validateBanklogo() {
	
		return bankLogo.isDisplayed();
	}

	public SaavingsAccount GotoSavingsAccount() {
		
		Actions action = new Actions(driver);
		action.moveToElement(ExploreProduct).build().perform();
		 ExplorePrd_Retail_Savingsacc.click();
		 return new SaavingsAccount();
	}
	


	




}
