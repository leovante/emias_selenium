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
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EmiasSite;

import java.util.concurrent.TimeUnit;

public class EMIAStest {
    WebDriver webDriver;
    EmiasSite website;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 30, 500);
        website = new EmiasSite(webDriver);

        webDriver.get("http://mis.softrust.ru/whc/Home");

        System.out.println("Step 1: Enter login");
        website.loginPage().enterLoginText("admin");

        System.out.println("Step 2: Enter password");
        website.loginPage().enterPasswordText("11");

        System.out.println("Step 3: Press Login Button");
        website.loginPage().clickLoginButton();
    }

    @Test
    public void testCallDoctorPage(){
        System.out.println("TEST 1: Enter CallDoctor Page");
        website.emiasPage().clickCallDoctorButton();
        website.callDoctorPage().clickCallDoctorSearchBtn();
        website.callDoctorPage().waitForSearchResults();
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}