package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.LoginPage;
import pageobjects.SmokePage;

public class SmokeTest extends BaseTest {

	@Test(priority=1)
	public void login() throws InterruptedException {
		// TODO Auto-generated method stub
		
		String actualtitle=driver.getTitle();
		String expected_title="Swag Labs";
		Assert.assertEquals(actualtitle, expected_title);
		SmokePage smokepage=new SmokePage(driver);
		smokepage.login("standard_user","secret_sauce");
		
		String actualurl=driver.getCurrentUrl();
		System.out.println(actualurl);
		String expectedurl="inventory";
		
		Assert.assertTrue(actualurl.contains(expectedurl));
		Thread.sleep(5000);

	}
	

	@Test(priority=2)
	public void validateitem3added() {
		SmokePage smokepage=new SmokePage(driver);
		smokepage.clickitem3();
		smokepage.clickaddtocart_item3();
		smokepage.clickaddtocart_icon();
		String actual="Sauce Labs Bolt T-Shirt";
		String expected = "Sauce Labs Bolt T-Shirt";
		Assert.assertEquals(actual,expected);
	}
	@Test(priority=3)
	public void validatecheckoutinfo() {
		SmokePage smokepage=new SmokePage(driver);
		smokepage.clickcheckout();
		smokepage.enterfirstname("nandhini");
		smokepage.enterlastname("s");
		smokepage.enterpostcode("560034");
		smokepage.scrollTocontinueButton();
		smokepage.clickcontinue();
	}
	@Test(priority=4)
	public void validateFinish() {
		SmokePage smokepage=new SmokePage(driver);
		boolean result=smokepage.isPaymentInfoDisplayed();
		Assert.assertTrue(result, "info is not displayed");
		smokepage.clickfinish();
		String acutalmsg=smokepage.getThankYouMessage();
		String expectedmsg="Thank you for your order!";
		Assert.assertEquals(acutalmsg, expectedmsg,"message is incorrect");
		
		
	}
}
