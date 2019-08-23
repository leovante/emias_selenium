package com.utils.screenshots;

import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class CustomTestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        saveScreenshot(result);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private void saveScreenshot(ITestResult result) {
        Object currentClass = result.getInstance();
        //WebDriver driver = ((AbstractTest) currentClass).getDriver();
        //return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

/**
 * public class CustomTestListener extends TestListenerAdapter {
 * <p>
 * private Logger log = LoggerFactory.getLogger(CustomTestListener.class);
 *
 * @Override public void onTestStart(ITestResult result) {
 * log.info("Test class started: " + result.getTestClass().getName());
 * log.info("Test started: " + result.getName());
 * }
 * @Override public void onTestSuccess(ITestResult result) {
 * log.info("Test SUCCESS: " + result.getName());
 * }
 * @Override public void onTestFailure(ITestResult result) {
 * makeScreenshot();
 * log.info("Test FAILED: " + result.getName());
 * if (result.getThrowable()!=null) {
 * result.getThrowable().printStackTrace();
 * }
 * }
 * @Attachment(value = "Page screenshot", type = "image/png")
 * private byte[] makeScreenshot() {
 * return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
 * }
 * }
 */