package uiverificationtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTest {
		
		WebDriver driver;

	    @BeforeClass
	    public void setUp() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	    }
	    
	    @Test
	    public void alertverificationTest()  {
	    	driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	    	//switch selenium control to alert
	    	Alert a=driver.switchTo().alert();
	    	a.accept();
	    	//a.dismiss();
	    	
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}

