package com.testRunner;


import com.commons.Selenium.SeleniumGrid;
import com.commons.Timer;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.commons.WebDriverUtils.killAllRunWebBrowsers;
import static com.settings.WebSettings.initFromProperties;
import static com.settings.STSettings.logger;

public class TestNGBase extends AbstractTestNGSpringContextTests {
    protected static Timer timer;

    public static long getTestRunTime() {
        return timer.timePassedInMSec();
    }

    @Parameters({"gridRun"})
    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite(@Optional String gridRun) {
        initFromProperties();
        //logger.info("прикрути статический логгер");
        new BeforeRun(gridRun);
        SeleniumGrid.run(gridRun);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllRunWebBrowsers();
//        SeleniumGrid.stop();
    }
}