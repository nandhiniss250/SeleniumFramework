package test;
import java.util.HashMap;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.LoginPage;
import listeners.TestListener;
@Listeners(TestListener.class)
public class Logintest extends BaseTest {
	
	
	@Test(priority=0)
	
	public void errormsgvalidation() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername("standard_user");
		loginpage.enterpassword("wrgpwd");
		loginpage.clickloginbtn();
		
		String actualmsg=driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		String expectedmsg="Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actualmsg, expectedmsg);
		driver.navigate().refresh();
	
	}
	@Test(priority=1)
	public void login() throws InterruptedException {
		// TODO Auto-generated method stub
		
		String actualtitle=driver.getTitle();
		String expected_title="Swag L";
		Assert.assertEquals(actualtitle, expected_title);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("standard_user","secret_sauce");
		String actualurl=driver.getCurrentUrl();
		System.out.println(actualurl);
		String expectedurl="inventory";
		Assert.assertTrue(actualurl.contains(expectedurl));
		Thread.sleep(5000);

	}
	
	@Test(priority=2)
	public void validatedashboard() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickitem1();
	}
	
	

}
