package uiverificationtest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandleTest {

	WebDriver driver;

    @BeforeClass
    public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
    }
    
    @Test
    public void windowhandletest() {
    	//get parent window ID
    	String PID=driver.getWindowHandle();
    	driver.findElement(By.id("windowButton")).click();
    	WebDriverWait wait =
    		    new WebDriverWait(driver, Duration.ofSeconds(10));

    		wait.until(ExpectedConditions.numberOfWindowsToBe(5));
    	Set<String> windowhandles=driver.getWindowHandles();
    	Iterator<String> it=windowhandles.iterator();
    	while(it.hasNext()) {//check next window is available
    		String window=it.next();// Retrieves the next window ID
    		if(!window.equals(PID)) {//check current window is diff from parent window
    			driver.switchTo().window(window);//switch selenium to child window
    			break;//stops the loop after child window found
    		}
    	}
    	System.out.println("child window title is:"+driver.getTitle());
    	driver.close();
    	driver.switchTo().window(PID);
    	System.out.println("parent window title is:"+driver.getTitle());
    	
    	//driver.switchTo().newWindow(WindowType.TAB);
    	//driver.switchTo().newWindow(WindowType.WINDOW);
    	
    }
   

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}



