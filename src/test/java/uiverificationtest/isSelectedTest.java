package uiverificationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;


public class isSelectedTest {
	

		
		WebDriver driver;

		@BeforeClass
		public void setUp() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		    driver.get("https://the-internet.herokuapp.com/checkboxes");
		}
		
		@Test
		public void checkboxisselectedornot()  {
			
			WebElement ch1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			WebElement ch2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			
			if(ch1.isSelected()) {
				System.out.println("ch1 is selected");
			}
			else
				System.out.println("ch2 is selected");
			
			
	
			
		}

		@AfterClass
		public void tearDown() {
		    driver.quit();
		}
		}


