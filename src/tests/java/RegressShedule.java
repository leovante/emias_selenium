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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Steps;

public class RegressShedule {
    private WebDriver webDriver;
    Steps step;
    WebDriverWait wait;

    @Test//KEYS 1.1
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        step.mainPage().clickManageShedule();
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
    }

    @Test//KEYS 1.2
    public void copyShedule() throws InterruptedException {
        step.mainPage().clickManageShedule();
        step.manageShedule().copyShedule();
    }

   @Test//KEYS 1.3
    public void setNotReceiveDays() throws InterruptedException {
        step.mainPage().clickManageShedule();
        step.manageShedule().setNotReciveDays();
        step.manageShedule().verifyNotReciveDays();
    }

    @Test//KEYS 1.4
    public void deleteShedule() throws InterruptedException, ClassNotFoundException {
        step.mainPage().clickManageShedule();
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
        step.manageShedule().deleteShedule();
        step.manageShedule().verifyDeletedShedule();
    }

    @Test//KEYS 1.5
    public void surviveShedule() throws InterruptedException, ClassNotFoundException {
        step.mainPage().clickManageShedule();
        step.manageShedule().createTwoShedule();
        step.mainPage().clickLogoHome();
        step.mainPage().admissionSchedule();
        step.admissionSchedule().createRecord();
        step.mainPage().clickLogoHome();
        step.transferRecords().trancRecord();
    }

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        webDriver = new ChromeDriver(options);
        wait = new WebDriverWait(webDriver, 60, 500);
        step = new Steps(webDriver);
        step.loginPage().loginEmias();
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
    }
}