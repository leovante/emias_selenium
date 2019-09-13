package com.pages.mis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.codeborne.selenide.commands.PressEscape;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class RaspisaniePriemaBasePage extends BasePage {
    static String terapevtTime;
    static String terapevtName;

    SelenideElement RecordsArea = $(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div"));
    SelenideElement selectVibratBtn = $(By.xpath("//button[@id='selectPatientButton']/span"));
    SelenideElement selectMkab = $(By.xpath("//table[@id='mkabScheduleGrid']/tbody/tr[3]/td[3]"));
    SelenideElement recordElement = $(By.xpath("//div[@style='background-color:#508132;border-color:#508132;color:#FFFFFF']"));
    SelenideElement predvarit = $(By.xpath("//span[contains(.,'Предварительный')]"));
    SelenideElement ml = $(By.xpath("//*[contains(text(),'Маршрутный лист')]"));
    SelenideElement proverkaKvot = $(By.xpath("//*[contains(text(),'Проверка количества квот')]"));
    SelenideElement kvotyYes = proverkaKvot.$(By.xpath("./../..//*[contains(text(),'Да')]"));
    SelenideElement pacientWasDispancered = $(By.xpath("//*[contains(text(),'Проверка перед генерацией маршрутного листа')]"));
    SelenideElement pacientDispanceredYes = pacientWasDispancered.$(By.xpath("./../..//*[contains(text(),'Да')]"));

    //    SelenideElement alarmaKvotyLimit = $(By.id("//*[contains(text(),'На текущую дату использованы все квоты, Продолжить?')]"));
    SelenideElement sinpmkabScheduleGrid = $(By.id("sinpmkabScheduleGrid"));
    SelenideElement kartaProfOsmotra = $(By.xpath("//span[contains(text(),'Карта проф. осмотра/дисп.')]"));
    SelenideElement mlSearchBtn = $(By.id("btnfindmkabScheduleGrid"));
    SelenideElement mkabSearch = $(By.id("sinpmkabScheduleGrid"));
    SelenideElement mkabSearchTable = $(By.id("mkabScheduleGrid"));
    SelenideElement selectPatientButton = $(By.id("selectPatientButton"));
    SelenideElement schedule = $(By.id("schedule"));
    SelenideElement applyBtn = $(By.id("ApplyBtn"));
    SelenideElement kvotyCount = $(By.xpath("//*[@class='ng-binding'][@ng-hide='!data.IsQuotaDispType']"));


    public RaspisaniePriemaBasePage() throws IOException {
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

    public RaspisaniePriemaBasePage createDispMl(String pacient, String bd) {
        ml.click();
        mkabSearch.val(pacient);
        mlSearchBtn.click();
        mkabSearchTable.$(By.xpath("//*[contains(text(),'" + bd + "')]")).click();
        selectPatientButton.click();
//        $(By.xpath("//*[@ng-click='btnGenerateRouteCard()']")).click();
//        $(By.xpath("//*[@aria-labelledby='ui-dialog-title-whcdialog()']//*[contains(text(),'Да')]")).click();
//        $(By.xpath("//*[@aria-labelledby='ui-dialog-title-whcdialog()']//*[contains(text(),'Да')]")).click();
        return this;
    }

    public RaspisaniePriemaBasePage saveAndClose() {
        $(By.xpath("//*[contains(text(),'Сохранить и закрыть')]")).click();
        return this;
    }

    public RaspisaniePriemaBasePage generateML() throws InterruptedException {
        String i = kvotyCount.getText();
        $(By.id("patientModelList-button")).$x(".//span").getValue();
        $(By.xpath("//span[@ng-click='btnGenerateRouteCard()']")).click();
        if (i.equals("0")) {
            $(By.xpath("//*[@aria-labelledby='ui-dialog-title-whcdialog']//*[contains(text(),'Да')]")).click();
        }
        Thread.sleep(1000);
        $(By.xpath("//*[@aria-labelledby='ui-dialog-title-whcdialog']"))
                .$(By.xpath(".//*[contains(text(),'Да')]")).click();
        return this;
    }

    public void verifyFindCallName(String nameGen) {
        RecordsArea.shouldBe(Condition.visible);
        recordElement.should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + nameGen + "')]")).shouldBe(Condition.enabled);
    }

    public void lastDispPacientCell_kartaProfOsmotra() throws NoSuchFieldException {
        $x("//div[@id='schedule']/div/div/div/div[3]/div/div").shouldBe(Condition.visible);
        ElementsCollection cells =
                $$(By.xpath("//div[@style='background-color:#AC6060;border-color:#AC6060;color:#FFFFFF']" +
                        "//div[contains(text(),'" + terapevtTime + "')]"));
        if (cells.size() > 0) {
            cells.last().click();
        } else {
            throw new NoSuchFieldException("Нет ячеек карты диспансеризациии");
        }
        kartaProfOsmotra.click();
        switchTo().window("Медицинская Информационная Система");
    }

    public RaspisaniePriemaBasePage generateML(Pacient pacient) throws InterruptedException {
        ml.click();
        sinpmkabScheduleGrid.setValue(
                pacient.getFamily() + " " +
                        pacient.getName() + " " +
                        pacient.getOt());
        mlSearchBtn.click();
        $(By.id("gview_mkabScheduleGrid"))
                .$x(".//*[contains(text(),'" + pacient.getNumberpol() + "')]")
                .click();
        selectPatientButton.click();
        $x("//*[contains(text(),'Модели:')]").shouldBe(Condition.visible);
        $x("//span[@ng-click='btnGenerateRouteCard()']").shouldBe(Condition.visible).click();
        $x("//*[contains(text(),'Модели:')]").shouldBe(Condition.visible);
        $x("//span[@ng-click='btnGenerateRouteCard()']").click();
        for (int i = 0; i < 5; i++) {
            if (proverkaKvot.isDisplayed()) {
                kvotyYes.click();
                break;
            }
            Thread.sleep(1000);
        }
        for (int i = 0; i < 5; i++) {
            if (pacientWasDispancered.isDisplayed()) {
                pacientDispanceredYes.click();
                break;
            }
            Thread.sleep(1000);
        }
        return this;
    }

    public RaspisaniePriemaBasePage getTerapevtTime() {
        terapevtTime = $x("//*[contains(text(),'Прием врача-терапевта')]/../../div[7]/span").getText();
//        terapevtName = $(By.xpath("//*[contains(text(),'Прием врача-терапевта')]/../../div[8]/span[2]")).getText();
        return this;
    }

    public RaspisaniePriemaBasePage saveAndCloseBtn() {
        applyBtn.click();
        return this;
    }

    public RaspisaniePriemaBasePage selectDoctor(Doctor doctor) {
        $(By.xpath("//td/div/span[contains(text(),'" +
                doctor.getFamily() + " " +
                doctor.getName() + " " +
                doctor.getOt() +
                "')]")).click();
        return this;
    }

    public RaspisaniePriemaBasePage disableIPK() {
        $(By.xpath("//*[contains(text(),'Индивидуальное профилактическое консультирование')]"))
                .$(By.xpath("./../..//div[13]/span[2]"))//[@ng-click='CancelService(exam)'][@ng-model='exam']
                .scrollTo()
                .click();
        $(By.xpath("//*[@aria-labelledby='ui-dialog-title-whcdialog']"))
                .$(By.xpath(".//*[contains(text(),'Да')]"))
                .hover()
                .click();
        return this;
    }

    public RaspisaniePriemaBasePage validateTerapevtLast() {
        $$(By.xpath("//div[class='examListBody']")).last()
                .$(By.xpath(".//*[contains(text(),'Прием врача-терапевта')]"))
                .scrollTo()
                .shouldBe(Condition.visible);
        return this;
    }
}