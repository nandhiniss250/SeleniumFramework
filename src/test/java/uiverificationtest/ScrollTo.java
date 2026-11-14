package uiverificationtest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class ScrollTo {

	WebDriver driver;

    @BeforeClass
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
     	//Disable password manager properly
     	Map<String, Object> prefs = new HashMap<>();
     	prefs.put("credentials_enable_service", false);
     	prefs.put("profile.password_manager_enabled", false);
     	prefs.put("profile.password_manager_leak_detection", false);
     	options.setExperimentalOption("prefs", prefs);
     	// Your existing options
     	options.addArguments("--disable-notifications");
     	options.addArguments("--disable-infobars");
     	options.addArguments("--disable-extensions");
     	// Stability options
     	options.addArguments("--disable-gpu");
     	options.addArguments("--no-sandbox");
     	options.addArguments("--disable-dev-shm-usage");
     	options.addArguments("--window-size=1920,1080");
     	driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
    }
    
    @Test
    public void mousehoverTest()  {
    	LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername("standard_user");
		loginpage.enterpassword("secret_sauce");
		loginpage.clickloginbtn();
		WebElement ele=driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", ele);
    	ele.click();
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }
}



