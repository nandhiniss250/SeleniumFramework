package uiverificationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Uploadfile {
	

	WebDriver driver;

    @BeforeClass
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
    }
    
    @Test
    public void uploadfileTest() throws InterruptedException  {
    	WebElement uf=driver.findElement(By.xpath("//input[@id='file-upload']"));
    	uf.sendKeys("C:\\Users\\raswa\\OneDrive\\Pictures\\Screenshots 1\\Screenshot 2024-08-12 160758.png");
    	//click on upload button
    	driver.findElement(By.xpath("//input[@id='file-submit']")).click();
    	Thread.sleep(5000);
    	String actual_msg=driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
    	Assert.assertEquals(actual_msg,"File Uploaded!","img not uploaded");
    	
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }
}


	





