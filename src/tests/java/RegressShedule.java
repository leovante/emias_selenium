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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Steps;

import java.awt.*;

public class RegressShedule {
    private WebDriver webDriver;
    Steps step;
    WebDriverWait wait;

    @Test//KEYS 0.0
    public void test() throws InterruptedException, ClassNotFoundException {
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
    }

    @Test//KEYS 1.1
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        step.manageShedule().createShedule();
        step.manageShedule().verifyCreatedShedule();
    }

    @Test//KEYS 1.2
    public void copyShedule() throws InterruptedException {
        step.manageShedule().copyShedule();
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
//        Logs logs = webDriver.manage().logs();
//        LogEntries logEntries = logs.get(LogType.DRIVER);
//
//        for (LogEntry logEntry : logEntries) {
//            System.out.println(logEntry.getMessage());
//        }
//        if (webDriver != null)
//            webDriver.quit();
    }
}