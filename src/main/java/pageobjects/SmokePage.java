package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmokePage {
	

	WebDriver driver;
	
	By username= By.id("user-name");
	By password= By.id("password");
	By loginbtn= By.id("login-button");
    By errormsg= By.xpath("//h3[@data-test='error']");
    By item3=By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
    By addtocart=By.id("add-to-cart");
    By addtocart_icon=By.xpath("//a[@class='shopping_cart_link']");
    By checkout_button=By.id("checkout");
    By checkout_firstname=By.id("first-name");
    By checkout_lastname=By.id("last-name");
    By checkout_postcode=By.id("postal-code");
    By continue_button=By.id("continue");
    By payment_inf=By.xpath("//div[text()='Payment Information:']");
    By finish_button=By.id("finish");
    By thankyoumsg=By.xpath("//h2[text()='Thank you for your order!']");
    //create a constructor to invoke driver actions to this page class
    
    public SmokePage(WebDriver driver) {
    	this.driver=driver;
    }
    
    public void enterusername(String usernamevalue) {
    	driver.findElement(username).sendKeys(usernamevalue);	
    }
    
    public void enterpassword(String passwordvalue) {
    	driver.findElement(password).sendKeys(passwordvalue);
    }
    
    public void clickloginbtn() {
    	driver.findElement(loginbtn).click();
    }
    
    public void login(String usernamevalue,String passwordvalue) {
    	enterusername(usernamevalue);
    	enterpassword(passwordvalue);
    	clickloginbtn();
    	
    }
    public void clickitem3() {
    	driver.findElement(item3).click();
    }
    
    public void clickaddtocart_item3() {
    	driver.findElement(addtocart).click();
    }
    
    public void clickaddtocart_icon() {
    	driver.findElement(addtocart_icon).click();
    }
    public void clickcheckout() {
    	driver.findElement(checkout_button).click();
    }
    public void enterfirstname(String firstnamevalue) {
    	driver.findElement(checkout_firstname).sendKeys(firstnamevalue);
    }
    public void enterlastname(String lastnamevalue) {
    	driver.findElement(checkout_lastname).sendKeys(lastnamevalue);
    }
    public void enterpostcode(String postcodevalue) {
    	driver.findElement(checkout_postcode).sendKeys(postcodevalue);
    }
    public void scrollTocontinueButton() {
    	WebElement button=driver.findElement(continue_button);
    	JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",button);
    }
    public void clickcontinue() {
    	driver.findElement(continue_button).click();
    }
    public boolean isPaymentInfoDisplayed() {
    	return 
    			driver.findElement(payment_inf).isDisplayed();
    }
    public void clickfinish() {
    	driver.findElement(finish_button).click();
    }
    public String getThankYouMessage() {
    	return driver.findElement(thankyoumsg).getText();
    }
    
}
