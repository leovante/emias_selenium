package com.testRunner;


import com.commons.Timer;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static com.commons.Selenium.SeleniumGrid.runSeleniumGrid;
import static com.commons.WebDriverUtils.killAllRunWebBrowsers;
import static com.settings.WebSettings.initFromProperties;

public class TestNGBase extends AbstractTestNGSpringContextTests {
    protected static Timer timer;

    public static long getTestRunTime() {
        return timer.timePassedInMSec();
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
}