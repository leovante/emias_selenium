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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EmiasSite;

import java.util.List;

public class EMIAStest {
    WebDriver webDriver;
    EmiasSite website;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 60, 500);
        website = new EmiasSite(webDriver);

        webDriver.get("http://mis.softrust.ru/whc/Home");
        //System.out.println("привет");
        System.out.println("Step 1: Enter login");
        website.loginPage().enterLoginText("admin");

        System.out.println("Step 2: Enter password");
        website.loginPage().enterPasswordText("11");

        System.out.println("Step 3: Press Login Button");
        website.loginPage().clickLoginButton();
    }

    @Test
    public void testCallDoctorPage() throws InterruptedException {
        System.out.println("KEYS 1: Enter CallDoctor Page");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().waitForSearchResults();
    }

    @Test
    public void testCallDoctorPageWithFilter() throws InterruptedException {
        System.out.println("KEYS 2: Enter CallDoctor Page with filter");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().filterCallDoctorSearchBtn();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().verificationTableGridNull();
    }

    @Test
    public void  testVedenieRaspisaniya() throws InterruptedException {
        System.out.println("KEYS 3: Enter in doctor's schedule and create task");
        website.emiasPage().clickScheduleDoctors();
        website.scheduleDoctors().sozdanieRaspisaniya();
    }
    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}