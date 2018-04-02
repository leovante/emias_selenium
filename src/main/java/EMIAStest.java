/*eto pattern proektirovania facad
*echo patterni
* singleton - bil tolko odin instance odnogo klassa po vsey sisteme
* bilder - sobrat config testa. Sobrat' nogo url s raznimi parametrami u kazhdogo
* bridge
* proxy
* factory method -
* factory class
*patternov mnogo i oni delyatca po tipam
* page object
*
*
*
*
* */
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.EmiasSite;
import org.apache.log4j.Logger;

public class EMIAStest {
    WebDriver webDriver;
    EmiasSite website;
    WebDriverWait wait;
    Logger logger;

    @Before
    public void setUp() {
        logger = Logger.getLogger("emias_selenium");
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.setLevel(Level.FATAL);
/*
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        logs.enable(LogType.PERFORMANCE, Level.ALL);
        logs.enable(LogType.PROFILER, Level.ALL);
        logs.enable(LogType.SERVER, Level.ALL);

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
*/
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 60, 500);
        website = new EmiasSite(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("http://mis.softrust.ru/whc/Home");
        logger.info("Step 1: Enter login");
        website.loginPage().enterLoginText("admin");

        logger.info("Step 2: Enter password");
        website.loginPage().enterPasswordText("11");

        logger.info("Step 3: Press Login Button");
        website.loginPage().clickLoginButton();

        logger.fatal("Before: Done");
    }
    @Test
    public void testCallDoctorPage() throws InterruptedException {
        logger.info("KEYS 1: Enter CallDoctor Page");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().waitForSearchResults();

        logger.info("KEYS 1: Done");
    }
    @Test
    public void testCallDoctorPageWithFilter() throws InterruptedException {
        logger.info("KEYS 2: Enter CallDoctor Page with filter");

        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().filterCallDoctorSearchBtn();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().verificationTableGridNull();

        logger.info("KEYS 2: Done");
    }
    @Test
    public void  testVedenieRaspisaniya() throws InterruptedException {
        logger.info("KEYS 3: Enter in doctor's schedule and create task");
        website.emiasPage().clickScheduleDoctors();
        website.scheduleDoctors().sozdanieRaspisaniya();

        logger.error("KEYS 3: Done");
    }
    @After
    public void tearDown() {
        Logs logs = webDriver.manage().logs();
        LogEntries logEntries = logs.get(LogType.DRIVER);

        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.getMessage());
        }
        if (webDriver != null)
            webDriver.quit();

        logger.info("After: Done\n");
    }
}