package base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

    protected WebDriver driver;

    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    public WebDriver getDriver() {
        return driver;
    }


    @BeforeSuite
    public void setupReport() {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Selenium Test Results");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Framework", "TestNG");
        extent.setSystemInfo("Tool", "Selenium WebDriver");
        extent.setSystemInfo("Application", "SauceDemo");
    }

    @BeforeClass
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        // Disable password manager
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        // Browser options
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

    @BeforeMethod
    public void startTest(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @AfterMethod(alwaysRun = true)
    public void recordResult(ITestResult result) {

        ExtentTest extentTest = test.get();

        if (extentTest != null) {

            if (result.getStatus() == ITestResult.SUCCESS) {
                extentTest.pass("Test passed successfully");

            } else if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.fail(result.getThrowable());

            } else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.skip("Test skipped");
            }
        }

        test.remove();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void generateReport() {

        if (extent != null) {
            extent.flush();
        }
    }
}