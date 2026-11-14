package uiverificationtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest {
	
	WebDriver driver;

    @BeforeClass
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    
    @Test
    public void dropdownverificationTest()  {
    	//locate dropdown webelement
    	WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
    	//Select option1
    	Select s=new Select(dropdown);
    	//s.selectByIndex(1);
    	s.selectByVisibleText("Option 1");
    	//Verify option1 is selected
    	String selectedoption=s.getFirstSelectedOption().getText();
    	Assert.assertEquals(selectedoption,"Option 1");
    	
    	
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


	


