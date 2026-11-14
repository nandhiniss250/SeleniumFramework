package uiverificationtest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class isEnabled {
	
	WebDriver driver;

    @BeforeClass
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }
    
    @Test
    public void alertverificationTest()  {
    	WebElement inputtextfield=driver.findElement(By.xpath("//input[@type='text']"));
    	System.out.println(inputtextfield.isEnabled());//false
    	WebElement enablebtn=driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
    	enablebtn.click();
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(enablebtn));
    	System.out.println(inputtextfield.isEnabled());//true

    	inputtextfield.sendKeys("gfdrtr");
    	
    	
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


