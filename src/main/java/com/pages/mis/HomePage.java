package com.pages.mis;

import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class HomePageBase extends PageBase {
    SelenideElement homePageBtn = $(By.xpath("//span[contains(.,'ЕМИАС Московской области')]"));
    SelenideElement timeTableBtn = $(By.xpath("//span[contains(.,'Ведение расписания')]"));
    SelenideElement admissionScheduleBtn = $(By.xpath("//span[contains(.,'Расписание приёма')]"));
    SelenideElement transferRecordsBtn = $(By.xpath("//span[contains(.,'Перенос записей')]"));
    SelenideElement callDoctorBtn = $(By.xpath("//span[contains(.,'Диспетчер')]"));
    SelenideElement napravlenieNaIssledovanie = $(By.xpath("//span[contains(.,'Направления на исследование')]"));

    public HomePageBase() throws IOException {
    }

    @Step("Захожу в ведение расписания")
    public void vedenieRaspisaniyaBtn() {
        timeTableBtn.click();
    }

    @Step("Захожу в расписание приема")
    public HomePageBase raspisaniPriemaBtn() {
        admissionScheduleBtn.click();
        return this;
    }

    @Step("Захожу в перенос записей")
    public HomePageBase transferRecordsBtn() {
        transferRecordsBtn.click();
        return this;
    }

    @Step("Нажимаю на логотип")
    public HomePageBase logoHomeBtn() {
        homePageBtn.click();
        return this;
    }

    @Step("Захожу в направление на исследование")
    public HomePageBase napravlenieNaIssledovanie() {
        napravlenieNaIssledovanie.click();
        return this;
    }

    @Step("Захожу в Диспетчер")
    public void callDoctorBtn() {
        $(By.xpath("//span[contains(.,'Диспетчер')]")).click();
    }

    @Step("выход из МИС")
    public void exitBtn() {
        $(By.xpath("//span[contains(.,'Выход')]")).click();
    }

    @Step("Нажимаю на Карты диспансеризации")
    public void dispCardJournalBtn() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//span[contains(.,'Карты диспансеризации')]")).click();
    }

    @Step("Нажимаю на Карты диспансеризации")
    public void mkabBtn() {
        $(By.xpath("//span[contains(.,'Медицинские карты')]")).click();
    }

    @Step("Сделать запись")
    public void createSomeRecords(int i) throws InterruptedException, IOException {
        int n = 1;
        while (n <= i) {
            LOGGER.info("Обрабатываю врача №: " + n);
            String doctor_num = new DoctorMethods().getUnicalDoctor3(n);
            String doctor_num_fam = VedenieRaspisaniyaPageBase.getSecondName(doctor_num);
//            SQLDemonstration.deleteShedule(doctor_num_fam);
            new DoctorMethods().selectDoctor(doctor_num);
            new BeforeWork().createShedule();
            new VedenieRaspisaniyaPageBase().verifyCreatedShedule(doctor_num_fam);
            new DoctorMethods().selectDoctor(doctor_num);
            n++;
        }
    }
}