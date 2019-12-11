package com.testRunner;


import com.commons.TestMethodCapture;
import com.commons.Timer;
import com.commons.WebDriverInstansiator;
import com.pages.Page;
import com.settings.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import java.io.IOException;

import static com.commons.Selenium.SeleniumGrid.runSeleniumGrid;
import static com.commons.WebDriverUtils.killAllRunWebBrowsers;
import static com.settings.WebSettings.initFromProperties;

@Listeners({TestMethodCapture.class})
@ContextConfiguration(classes = {AppConfig.class})
public class TestNGBase extends AbstractTestNGSpringContextTests {
    protected static Timer timer;
    private WebDriverInstansiator driverInst;
    public String testName;

    public static long getTestRunTime() {
        return timer.timePassedInMSec();
    }

    @Autowired
    public Page page;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() throws IOException {
        initFromProperties();
        //logger.info("прикрути статический логгер");
        new StandValidator();
        runSeleniumGrid();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
//        killAllRunWebBrowsers();
//        SeleniumGrid.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driverInst = new WebDriverInstansiator();
        driverInst.setDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
//        new Logging();
        driverInst.driverClose();
    }
}