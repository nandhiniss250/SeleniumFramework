package uiverificationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_browserTest {

	WebDriver driver;
	@BeforeClass
	@Parameters({"browser","env"})
	public void launchapp(String browser,String env) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			throw new IllegalArgumentException("unsupported browser"+browser);
		}
		
		String url;
		
		if(env.equalsIgnoreCase("qa")) {
			url="https://www.qa.saucedemo.com/";
		}
		else if(env.equalsIgnoreCase("prod")) {
			url="https://www.saucedemo.com/";
		}
		else {
			throw new IllegalArgumentException("unsupported url"+env);
		}
		driver.get(url);
	}

	@Test
	public void logintest() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	
}
	
	@AfterClass(alwaysRun = true)
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
	}
	


}