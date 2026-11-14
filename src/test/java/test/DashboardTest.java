package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.DashboardPage;

public class DashboardTest extends BaseTest {
	@Test(priority=0,enabled=true)
	public void Verifytotalproductcounts() {
		DashboardPage dashboardpage=new DashboardPage(driver);
		dashboardpage.enterusername("standard_user");
		dashboardpage.enterpassword("secret_sauce");
		dashboardpage.clickloginbtn();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='inventory-item-name']")));
		
		List<WebElement> products=driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
		Assert.assertEquals(products.size(),6);
		
	}
	
	@Test(priority=1,enabled=true)
	public void VerifyLeftMenuItems() {
		DashboardPage dashboardpage=new DashboardPage(driver);
		dashboardpage.clickleftmenuicon();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_sidebar_link")));
		
		
		Assert.assertTrue(driver.findElement(By.id("inventory_sidebar_link")).isDisplayed(),"All item is not displayed");
		Assert.assertTrue(driver.findElement(By.id("about_sidebar_link")).isDisplayed(),"about not displayed");
		Assert.assertTrue(driver.findElement(By.id("logout_sidebar_link")).isDisplayed(),"logout not displayed");
		Assert.assertTrue(driver.findElement(By.id("reset_sidebar_link")).isDisplayed(),"reset not displayed");
		
	}
	
	@Test(priority=2,enabled=true)
	public void VerifyProuductNameIsDisplayed() {
		List<WebElement> productnames=driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		Assert.assertEquals(productnames.size(),6);
		
		for(int i=0;i<productnames.size();i++) {
			WebElement ProductName=productnames.get(i);
			System.out.println(ProductName.getText());
			Assert.assertTrue(ProductName.isDisplayed());
			Assert.assertFalse(ProductName.getText().isEmpty());
			
			
		}
		
	}
	
	@Test(priority=3,enabled=true)
	public void VerifyAddToCartFunctionality() {
		DashboardPage dashboardpage=new DashboardPage(driver);
		dashboardpage.clickaddtocart();
		
    WebElement cartcount=driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']"));
    Assert.assertEquals(cartcount.getText(),"1");
	}
	
	@Test(priority=4,enabled=true)
	
	public void VerifyProductPrizeisdisplayed() {
		
		List<WebElement> productprizes=driver.findElements(By.xpath("//div[@data-test='inventory-item-price']"));
		Assert.assertEquals(productprizes.size(),6);
		
		for(int i=0;i<productprizes.size();i++) {
			WebElement ProductPrize=productprizes.get(i);
			System.out.println(ProductPrize.getText());
			Assert.assertTrue(ProductPrize.isDisplayed());
			Assert.assertFalse(ProductPrize.getText().isEmpty());
			
			
		}
		
		
	}
	
	

}
