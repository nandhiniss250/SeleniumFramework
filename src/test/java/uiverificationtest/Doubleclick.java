package uiverificationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Doubleclick {

	WebDriver driver;

    @BeforeClass
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
    }
    
    @Test
    public void doubleclickTest()  {
    	
    	WebElement dc=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
    	Actions act=new Actions(driver);
    	act.doubleClick(dc);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

