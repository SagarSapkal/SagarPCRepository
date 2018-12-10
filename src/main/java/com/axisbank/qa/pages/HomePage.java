package com.axisbank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.axisbank.qa.base.BaseClass;

public class HomePage extends BaseClass {

	
	//PageFactory OR:
	@FindBy(xpath="//*[@class='logoSect']")
	WebElement bankLogo;
	
	@FindBy(xpath="//a[text()='Explore Products']")
	WebElement ExploreProduct;
	
	@FindBy(xpath="//a[@data-eventcategory='Explore Products' and @data-eventaction='Retail'and @data-eventlabel='Accounts']")
	WebElement ExplorePrd_Retail_Accounts ;
	
	@FindBy(xpath="//a[@data-event='Explore Products'  and @data-eventlabel='Saving Account']")
	WebElement ExplorePrd_Retail_Savingsacc ;
}
