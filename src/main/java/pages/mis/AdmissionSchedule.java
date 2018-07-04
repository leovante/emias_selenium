package pages.mis;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;
import pages.utilities.Waiter;

import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class AdmissionSchedule extends AbstractPage {
    DoctorMethods doctorMethods;

    @FindBy(xpath = "//div[@id='schedule']/div/div/div/div[3]/div")
    @CacheLookup
    WebElement RecordsArea;

    @FindBy(xpath = "//button[@id='selectPatientButton']/span")
    @CacheLookup
    WebElement selectVibratBtn;

    @FindBy(xpath = "//table[@id='mkabScheduleGrid']/tbody/tr[3]/td[3]")
    @CacheLookup
    WebElement selectMkab;

    @FindBy(xpath = "//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']")
    @CacheLookup
    WebElement recordElement;

    @FindBy(xpath = "//span[contains(.,'Предварительный')]")
    @CacheLookup
    WebElement predvarit;

    public AdmissionSchedule(WebDriver driver) {
        super(driver);
    }

    @Step("Сделать запись")
    public void createRecord(String first_doctor_fullname) throws InterruptedException {
        Actions action = new Actions(driver);
        String mwh = driver.getWindowHandle();
        Waiter.waitAllEmias();

        wait.until(ExpectedConditions.elementToBeClickable(RecordsArea));
        Waiter.waitAllEmias();

        wait.until(ExpectedConditions.elementToBeClickable(recordElement));
        recordElement.click();

        action.sendKeys(Keys.ENTER).perform();//нажали поиск мкаб
        Thread.sleep(2000);
        Waiter.waitBlockOverlay();
        click(selectMkab);
        Waiter.waitBlockOverlay();
        click(selectVibratBtn);//выбрать
        click(predvarit);

        Set s = driver.getWindowHandles(); //this method will gives you the handles of all opened windows
        Iterator ite = s.iterator();
        while (ite.hasNext()) {
            String popupHandle = ite.next().toString();
            if (!popupHandle.contains(mwh)) {
                driver.switchTo().window(popupHandle);
                action.sendKeys(Keys.ESCAPE).perform();
        /*here you can perform operation in pop-up window**
                After finished your operation in pop-up just select the main window again*/
                driver.switchTo().window(mwh);
            }
        }
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void verifyFindCallName(String nameGen) {
        Waiter.waitAllEmias();
        wait.until(ExpectedConditions.elementToBeClickable(RecordsArea));
        Waiter.waitAllEmias();
        wait.until(ExpectedConditions.elementToBeClickable(recordElement));
        WebElement containName = driver.findElement(By.xpath("//*[contains(.,'" + nameGen + "')]"));
        assertTrue(containName.isEnabled());
    }

}