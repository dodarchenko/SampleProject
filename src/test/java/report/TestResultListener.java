package report;

import commonMethods.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;


public class TestResultListener extends BaseTest implements ITestListener{

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed", ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        ExtentTestManager.skippedTest(iTestResult.getMethod().getMethodName(), " ");
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", this.driver);

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentTestManager.endTest();
        ExtentFactory.getInstance().flush();

    }
}