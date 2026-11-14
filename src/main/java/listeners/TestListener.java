package listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    // Executes when a test starts
    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                BaseTest.extent.createTest(
                        result.getMethod().getMethodName());

        BaseTest.test.set(extentTest);

        System.out.println("Test Started: "
                + result.getMethod().getMethodName());
    }

    // Executes when a test passes
    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest extentTest = BaseTest.test.get();

        if (extentTest != null) {

            extentTest.pass("Test passed successfully");
        }

        System.out.println("Test Passed: "
                + result.getMethod().getMethodName());

        BaseTest.test.remove();
    }

    // Executes when a test fails
    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest extentTest = BaseTest.test.get();

        if (extentTest != null) {

            // Log failure exception
            extentTest.fail(result.getThrowable());

            // Get WebDriver from BaseTest
            BaseTest base = (BaseTest) result.getInstance();

            WebDriver driver = base.getDriver();

            if (driver != null) {

                try {

                    // Capture screenshot
                    File source = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

                    // Create screenshot folder
                    Files.createDirectories(
                            Paths.get("test-output/Screenshots"));

                    // Generate timestamp
                    String timestamp =
                            new SimpleDateFormat("yyyyMMdd_HHmmss")
                                    .format(new Date());

                    String screenshotName =
                            result.getMethod().getMethodName()
                            + "_" + timestamp + ".png";

                    String destination =
                            "test-output/Screenshots/" + screenshotName;

                    // Save screenshot
                    Files.copy(
                            source.toPath(),
                            Paths.get(destination),
                            StandardCopyOption.REPLACE_EXISTING);

                    // Attach screenshot to Extent Report
                    String absolutePath =
                            Paths.get(destination)
                                    .toAbsolutePath().toString();

                    extentTest.addScreenCaptureFromPath(absolutePath);

                    System.out.println(
                            "Screenshot captured: " + destination);

                } catch (IOException | RuntimeException e) {

                    extentTest.warning(
                            "Screenshot capture failed: "
                            + e.getMessage());
                }
            }
        }

        System.out.println("Test Failed: "
                + result.getMethod().getMethodName());

        BaseTest.test.remove();
    }

    // Executes when a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTest extentTest = BaseTest.test.get();

        if (extentTest != null) {

            extentTest.skip("Test skipped: "
                    + result.getThrowable());
        }

        System.out.println("Test Skipped: "
                + result.getMethod().getMethodName());

        BaseTest.test.remove();
    }
}
    