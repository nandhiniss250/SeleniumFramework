package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	WebDriver driver;
	
	By username= By.id("user-name");
	By password= By.id("password");
	By loginbtn= By.id("login-button");
	By leftmenuicon= By.xpath("//button[@id='react-burger-menu-btn']");
	By addtocartbtn= By.id("add-to-cart-sauce-labs-backpack");
	
	
	public DashboardPage(WebDriver driver) {
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
    
    public void clickleftmenuicon() {
    	driver.findElement(leftmenuicon).click();
    }
    
    public void clickaddtocart() {
    	driver.findElement(addtocartbtn).click();
    	
    }
}
