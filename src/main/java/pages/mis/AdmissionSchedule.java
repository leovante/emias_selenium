package pages.mis;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.codeborne.selenide.commands.PressEscape;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

public class AdmissionSchedule extends AbstractPage {

    SelenideElement RecordsArea = $(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div"));
    SelenideElement selectVibratBtn = $(By.xpath("//button[@id='selectPatientButton']/span"));
    SelenideElement selectMkab = $(By.xpath("//table[@id='mkabScheduleGrid']/tbody/tr[3]/td[3]"));
    SelenideElement recordElement = $(By.xpath("//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']"));
    SelenideElement predvarit = $(By.xpath("//span[contains(.,'Предварительный')]"));

    public AdmissionSchedule() {
    }

    @Step("Сделать запись")
    public void createRecord(String first_doctor_fullname) throws InterruptedException {
//        Actions action = new Actions(driver);
        String mwh = driver.getWindowHandle();
//        waitAllEmias();
        RecordsArea.shouldBe(Condition.visible);
//        waitAllEmias();
        recordElement.shouldBe(Condition.visible);
        recordElement.click();
        new PressEnter();
//        action.sendKeys(Keys.ENTER).perform();//нажали поиск мкаб
        Thread.sleep(2000);
//        waitBlockOverlay();
        selectMkab.click();
//        waitBlockOverlay();
        selectVibratBtn.click();
        predvarit.click();

        Set s = driver.getWindowHandles(); //this method will gives you the handles of all opened windows
        Iterator ite = s.iterator();
        while (ite.hasNext()) {
            String popupHandle = ite.next().toString();
            if (!popupHandle.contains(mwh)) {
                driver.switchTo().window(popupHandle);
                new PressEscape();
//                action.sendKeys(Keys.ESCAPE).perform();
        /*here you can perform operation in pop-up window**
                After finished your operation in pop-up just select the main window again*/
                driver.switchTo().window(mwh);
            }
        }
    }

    public void verifyFindCallName(String nameGen) {
//        waitAllEmias();
        RecordsArea.shouldBe(Condition.visible);
//        waitAllEmias();
        recordElement.should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + nameGen + "')]")).shouldBe(Condition.enabled);
//        assertTrue(containName.isEnabled());
    }

}