

import java.util.Iterator;
import java.util.Set;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.axisbank.qa.base.BaseClass;
import com.axisbank.qa.pages.HomePage;
import com.axisbank.qa.pages.SaavingsAccount;
import com.axisbank.qa.pages.Savings_EasyAccessSA;

public class Savings_EasyAccessSA_Test extends BaseClass{
	Savings_EasyAccessSA savings_EasyAccessSA;
	public Savings_EasyAccessSA_Test() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
	  savings_EasyAccessSA= new Savings_EasyAccessSA();
	  HomePage HMPage = new HomePage();
	  HMPage.GotoSavingsAccount();
	  SaavingsAccount savAccount = new SaavingsAccount();
	  savAccount.navigateToEASaving();
	

	}
	
	@Test
	public void SubmitFormTest() throws InterruptedException {
		
	    Set<String> handle = driver.getWindowHandles();
	    Iterator<String> it=handle.iterator(); 
	 	String Window1= it.next();
	 	String Window2= it.next();
	 	driver.switchTo().window(Window2);
		savings_EasyAccessSA.FillForm();
		Assert.assertEquals(savings_EasyAccessSA.CaptchaValidator(), "Incorrect CAPTCHA code");
	}
	
	@AfterMethod
	public void TearDown() {
	driver.quit();
	}
}
