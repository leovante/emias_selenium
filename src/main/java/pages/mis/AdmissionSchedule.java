package pages.mis;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.codeborne.selenide.commands.PressEscape;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

public class AdmissionSchedule extends AbstractPage {

    SelenideElement RecordsArea = $(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div"));
    SelenideElement selectVibratBtn = $(By.xpath("//button[@id='selectPatientButton']/span"));
    SelenideElement selectMkab = $(By.xpath("//table[@id='mkabScheduleGrid']/tbody/tr[3]/td[3]"));
    SelenideElement recordElement = $(By.xpath("//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']"));
    SelenideElement predvarit = $(By.xpath("//span[contains(.,'Предварительный')]"));
    SelenideElement ml = $(By.xpath("//*[contains(.,'Маршрутный лист')]"));
    SelenideElement mlSearchBtn = $(By.id("btnfindmkabScheduleGrid"));
    SelenideElement mkabSearch = $(By.id("sinpmkabScheduleGrid"));
    SelenideElement mkabSearchTable = $(By.id("mkabScheduleGrid"));
    SelenideElement selectPatientButton = $(By.id("selectPatientButton"));
    SelenideElement schedule = $(By.id("schedule"));

    public AdmissionSchedule() {
    }

    @Step("Сделать запись")
    public void createRecord(String first_doctor_fullname) throws InterruptedException {
        String mwh = driver.getWindowHandle();
        RecordsArea.shouldBe(Condition.visible);
        recordElement.shouldBe(Condition.visible);
        recordElement.click();
        new PressEnter();
        Thread.sleep(2000);
        selectMkab.click();
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

    public void createDispMl(Pacient pacient) {
        ml.click();
        mkabSearch.val(pacient.getFamily());
        mlSearchBtn.click();
        mkabSearchTable.$(By.xpath("//*[contains(text(),'" + pacient.getBirthdate("dd.MM.yyyy") + "')]")).click();
        selectPatientButton.click();
        $(By.xpath("//*[@ng-click='btnGenerateRouteCard()']")).click();
        $(By.xpath("//*[@aria-labelledby='ui-dialog-title-whcdialog()']//*[contains(text(),'Да')]")).click();
        $(By.xpath("//*[@aria-labelledby='ui-dialog-title-whcdialog()']//*[contains(text(),'Да')]")).click();
        $(By.xpath("//*[contains(text(),'Сохранить и закрыть')]")).click();
    }

    public void selectCell() {
//        schedule.
        // TODO: 11/13/2018 сделал задачу Лёше что бы как то находить ячейки в расписании
    }

    public void verifyFindCallName(String nameGen) {
        RecordsArea.shouldBe(Condition.visible);
        recordElement.should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + nameGen + "')]")).shouldBe(Condition.enabled);
    }
}