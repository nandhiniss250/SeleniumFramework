package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By username= By.id("user-name");
	By password= By.id("password");
	By loginbtn= By.id("login-button");
    By errormsg= By.xpath("//h3[@data-test='error']");
    By item1= By.xpath("//div[contains(text(),'Sauce Labs Backpa')]");
    
    //create a constructor to invoke driver actions to this page class
    
    public LoginPage(WebDriver driver) {
    	this.driver=driver;//assigns that driver to the LoginPage class.
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
    
    public void clickitem1() {
    	driver.findElement(item1).click();
    }
    
    public void login(String usernamevalue,String passwordvalue) {
    	enterusername(usernamevalue);
    	enterpassword(passwordvalue);
    	clickloginbtn();
    	
    }
    
    
}
