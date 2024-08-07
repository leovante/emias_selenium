package com.pages.mis;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.codeborne.selenide.commands.PressEscape;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.pages.AbstractPage;
import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.profiles_interfaces.Pacient;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class RaspisaniePriemaPage extends AbstractPage {
    static String terapevtTime;

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

    public RaspisaniePriemaPage() {
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

    public void verifyFindCallName(String nameGen) {
        RecordsArea.shouldBe(Condition.visible);
        recordElement.should(Condition.visible);
        $(By.xpath("//*[contains(.,'" + nameGen + "')]")).shouldBe(Condition.enabled);
    }

    public void lastDispPacientCell_kartaProfOsmotra() throws NoSuchFieldException {
        $(By.xpath("//div[@id='schedule']/div/div/div/div[3]/div/div")).shouldBe(Condition.visible);
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

    public RaspisaniePriemaPage generateML(Pacient pacient) throws InterruptedException {
        ml.click();
        sinpmkabScheduleGrid.setValue(
                pacient.getFamily() + " " +
                        pacient.getName() + " " +
                        pacient.getOt());
        mlSearchBtn.click();
        $(By.xpath("//*[contains(text(),'" + pacient.getNumberpol() + "')]")).click();
        selectPatientButton.click();
        $(By.xpath("//*[contains(text(),'Модель пациента: ')]")).shouldBe(Condition.visible);
        $(By.xpath("//span[@ng-click='btnGenerateRouteCard()']")).click();
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

    public RaspisaniePriemaPage getTerapevtTime() {
        terapevtTime = $(By.xpath("//*[contains(text(),'Прием врача-терапевта')]/../../div[6]/span")).getText();
        return this;
    }

    public RaspisaniePriemaPage saveAndCloseBtn() {
        applyBtn.click();
        return this;
    }

    public RaspisaniePriemaPage selectDoctor(Doctor doctor) {
        $(By.xpath("//td/div/span[contains(text(),'" +
                doctor.getFamily() + " " +
                doctor.getName() + " " +
                doctor.getOt() +
                "')]")).click();
        return this;
    }
}