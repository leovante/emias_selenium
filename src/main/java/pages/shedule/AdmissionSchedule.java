package pages.shedule;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.utilities.Waiter;

import java.util.Iterator;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class AdmissionSchedule extends BasePage {
    DoctorMethods doctorMethods;

    @FindBy(xpath = "//div[@id='schedule']/div/div/div/div[3]/div")
    WebElement RecordsArea;

    @FindBy(xpath = "//button[@id='selectPatientButton']/span")
    WebElement selectVibratBtn;

    @FindBy(xpath = "//table[@id='mkabgrid1']/tbody/tr[2]/td[3]")
    WebElement selectMkab;

    @FindBy(xpath = "//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']")
    WebElement recordElement;

    @FindBy(xpath = "//span[@class='ui-button-text'][contains(text(),'Предварительный')]")
    WebElement predvarit;

    public AdmissionSchedule(WebDriver driver) {
        super(driver);
    }

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
        wait.until(ExpectedConditions.elementToBeClickable(selectMkab));
        selectMkab.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectVibratBtn));
        selectVibratBtn.click();//выбрать
        Waiter.waitAllEmias();

        wait.until(ExpectedConditions.elementToBeClickable(predvarit));
        predvarit.click();
        Waiter.waitAllEmias();

        Set s = driver.getWindowHandles(); //this method will gives you the handles of all opened windows
        Iterator ite = s.iterator();
        while (ite.hasNext()) {
            String popupHandle = ite.next().toString();
            if (!popupHandle.contains(mwh)) {
                driver.switchTo().window(popupHandle);
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