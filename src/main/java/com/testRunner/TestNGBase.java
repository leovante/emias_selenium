package com.testRunner;


import com.commons.CallDoctorCards;
import com.commons.TestMethodCapture;
import com.commons.Timer;
import com.commons.WebDriverInstansiator;
import com.datas.calldoctor.DataProviderRealisation;
import com.pages.IPage;
import com.settings.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import java.io.IOException;

import static com.commons.Selenium.SeleniumGrid.runSeleniumGrid;
import static com.settings.WebSettings.initFromProperties;

@Listeners({TestMethodCapture.class})
@ContextConfiguration(classes = {AppConfig.class})
public class TestNGBase extends AbstractTestNGSpringContextTests {
    public String testName;
    protected static Timer timer;
    protected CallDoctorCards callDoctorCards;
    private WebDriverInstansiator driverInst;
    public DataProviderRealisation dataProviderRealisationl;

    public static long getTestRunTime() {
        return timer.timePassedInMSec();
    }

    @Autowired
    public IPage IPage;

    public String testName() {
        return TestMethodCapture.getTestMethod().getMethodName();
    }

    @Parameters({"browser"})
    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite(@Optional String browser) {
        initFromProperties(browser);
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