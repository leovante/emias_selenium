package pages.shedule;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;
import pages.Wait;

import java.util.*;

public class AdmissionSchedulePage {
    private WebDriver webDriver;
    Pages website;
    private WebDriverWait wait;
    Wait waitAll;

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

    public AdmissionSchedulePage(WebDriver driver) {
        webDriver = driver;
        website = new Pages(webDriver);
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void createRecord() throws InterruptedException {
        Actions action = new Actions(webDriver);
        String mwh = webDriver.getWindowHandle();
        waitAll.waitAll();

        wait.until(ExpectedConditions.elementToBeClickable(RecordsArea));
        waitAll.waitAll();
        String first_doctor_fullname = website.doctorOperators().getUnicalDoctor(null);
        website.doctorOperators().selectDoctor(first_doctor_fullname);

        wait.until(ExpectedConditions.elementToBeClickable(recordElement));
        recordElement.click();

        action.sendKeys(Keys.ENTER).perform();//нажали поиск мкаб
        Thread.sleep(2000);
        waitAll.waitBlockOverlay();
        wait.until(ExpectedConditions.elementToBeClickable(selectMkab));
        selectMkab.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectVibratBtn));
        selectVibratBtn.click();//выбрать
        waitAll.waitAll();

        wait.until(ExpectedConditions.elementToBeClickable(predvarit));
        predvarit.click();
        waitAll.waitAll();

        Set s = webDriver.getWindowHandles(); //this method will gives you the handles of all opened windows
        Iterator ite = s.iterator();
        while (ite.hasNext()) {
            String popupHandle = ite.next().toString();
            if (!popupHandle.contains(mwh)) {
                webDriver.switchTo().window(popupHandle);
        /*here you can perform operation in pop-up window**
                After finished your operation in pop-up just select the main window again*/
                webDriver.switchTo().window(mwh);
            }
        }
    }

    public void waitWhileClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
