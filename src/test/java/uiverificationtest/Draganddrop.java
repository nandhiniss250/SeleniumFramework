package uiverificationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class Draganddrop {

	WebDriver driver;

    @BeforeClass
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }
    
    @Test
    public void mousehoverTest()  {
    	WebElement a=driver.findElement(By.xpath("//div[@id='column-a']"));
    	WebElement b=driver.findElement(By.xpath("//div[@id='column-b']"));
    	Actions act=new Actions(driver);
    	act.dragAndDrop(b, a).perform();
    	
    	
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


