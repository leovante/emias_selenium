package pages.mis;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.utilities.CleanDoctorTT;
import pages.utilities.Waiter;

import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class AdmissionSchedule extends BasePage {
    DoctorMethods doctorMethods;

    @FindBy(xpath = "//div[@id='schedule']/div/div/div/div[3]/div")
    WebElement RecordsArea;

    @FindBy(xpath = "//button[@id='selectPatientButton']/span")
    WebElement selectVibratBtn;

    @FindBy(xpath = "//table[@id='mkabScheduleGrid']/tbody/tr[3]/td[3]")
    WebElement selectMkab;

    @FindBy(xpath = "//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']")
    WebElement recordElement;

    @FindBy(xpath = "//span[contains(.,'Предварительный')]")
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

    @Step("Сделать запись")
    public void createShedule(int i) throws ClassNotFoundException, InterruptedException {
        DoctorMethods doctorMethods = new DoctorMethods(driver);
        BeforeWork beforeWork = new BeforeWork(driver);
        ManageShedule manageShedule = new ManageShedule(driver);

        int n = 1;
        CleanDoctorTT sql = new CleanDoctorTT();
        sql.finalizeCallDoctor();

        while (n <= i) {
            System.out.println("Обрабатываю врача №: " + n);
            String doctor_num = doctorMethods.getUnicalDoctor3(n);
            String doctor_num_fam = ManageShedule.getSecondName(doctor_num);
            CleanDoctorTT.deleteShedule(doctor_num_fam);

            doctorMethods.selectDoctor(doctor_num);
            beforeWork.createShedule();
            manageShedule.verifyCreatedShedule();
            doctorMethods.selectDoctor(doctor_num);

            n++;
        }
    }
}