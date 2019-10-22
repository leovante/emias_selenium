package com.utils.screenshotsListner;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.message.ReportPortalMessage;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.test.context.TestExecutionListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;


public class CustomTestListener extends TestListenerAdapter implements TestExecutionListener {
    private static Logger logger = LogManager.getLogger();
    private String rp_message = "create screenshot to reportportal";

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test class started: " + result.getTestClass().getName());
        logger.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test SUCCESS: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        saveScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private void saveScreenshot(ITestResult result) {
        Object currentClass = result.getInstance();
        //WebDriver remoteDriver = ((AbstractTest) currentClass).getDriver();
        //return ((TakesScreenshot) remoteDriver).getScreenshotAs(OutputType.BYTES);

        File file = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        ReportPortalMessage message = null;
        try {
            message = new ReportPortalMessage(file, rp_message);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        logger.info(message);
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