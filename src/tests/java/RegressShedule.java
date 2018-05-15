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

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Steps;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class RegressShedule {
    private WebDriver webDriver;
    Steps step;
    WebDriverWait wait;

    @Ignore
    @Test//KEYS 1.1
    public void test() throws InterruptedException, ClassNotFoundException {

    }

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
        step.transferRecords().trancRecord();
        step.transferRecords().verifyTransferShedule();
    }
//пока не знаю что с этим делать
    private static void addJQuery (JavascriptExecutor js) {
        String script = "";
        boolean needInjection = (Boolean)(js.executeScript("return this.$ === undefined;"));
        if(needInjection) {
            URL u = Resources.getResource("jquery.js");
            try {
                script = Resources.toString(u, Charsets.UTF_8);
            } catch(IOException e) {
                e.printStackTrace();
            }
            js.executeScript(script);
        }
    }

    @Before
    public void setUp() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        webDriver = new ChromeDriver(options);
//        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        wait = new WebDriverWait(webDriver, 60, 500);
        step = new Steps(webDriver);
        step.loginPage().loginEmias();
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}