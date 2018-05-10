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

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Steps;

import java.awt.*;

public class RegressShedule {
    private WebDriver webDriver;
    Steps step;
    WebDriverWait wait;

    @Test//KEYS 1.1
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
    }

    @Test//KEYS 1.2
    public void copyShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().copyShedule();
        step.manageShedule().verifyCreatedShedule();
    }

   @Test//KEYS 1.3
    public void setNotReceiveDays() throws InterruptedException {
        step.manageShedule().setNotReciveDays();
        step.manageShedule().verifyNotReciveDays();
    }

    @Test//KEYS 1.4
    public void deleteShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
        step.manageShedule().deleteShedule();
        step.manageShedule().verifyDeletedShedule();
    }

    @Test//KEYS 1.5
    public void surviveShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().createTwoShedule();
        step.admissionSchedule().createRecord();
        step.transferRecords().trancRecord();//тут не допроверил корректное завершение переноса записи
        step.transferRecords().verifyTransferShedule();//это не проверил ещё
    }

    @Before
    public void setUp() throws InterruptedException, AWTException {
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
//        if (webDriver != null)
//            webDriver.quit();
    }
}