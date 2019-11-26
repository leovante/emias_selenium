package com.pages.mis;

import com.codeborne.selenide.SelenideElement;
import com.pages.WebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HomeWebPage extends WebPage {
    SelenideElement homePageBtn = $(By.xpath("//span[contains(.,'ЕМИАС Московской области')]"));
    SelenideElement timeTableBtn = $(By.xpath("//span[contains(.,'Ведение расписания')]"));
    SelenideElement admissionScheduleBtn = $(By.xpath("//span[contains(.,'Расписание приёма')]"));
    SelenideElement transferRecordsBtn = $(By.xpath("//span[contains(.,'Перенос записей')]"));
    SelenideElement callDoctorBtn = $(By.xpath("//span[contains(.,'Диспетчер')]"));
    SelenideElement napravlenieNaIssledovanie = $(By.xpath("//span[contains(.,'Направления на исследование')]"));

    public HomeWebPage() {
    }

    @Step("Захожу в ведение расписания")
    public void vedenieRaspisaniyaBtn() {
        timeTableBtn.click();
    }

    @Step("Захожу в расписание приема")
    public HomeWebPage raspisaniPriemaBtn() {
        admissionScheduleBtn.click();
        return this;
    }

    @Step("Захожу в перенос записей")
    public HomeWebPage transferRecordsBtn() {
        transferRecordsBtn.click();
        return this;
    }

    @Step("Нажимаю на логотип")
    public HomeWebPage logoHomeBtn() {
        homePageBtn.click();
        return this;
    }

    @Step("Захожу в направление на исследование")
    public HomeWebPage napravlenieNaIssledovanie() {
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
    public void dispCardJournalBtn() {
        sleep(1000);
        $(By.xpath("//span[contains(.,'Карты диспансеризации')]")).click();
    }

    @Step("Нажимаю на Карты диспансеризации")
    public void mkabBtn() {
        $(By.xpath("//span[contains(.,'Медицинские карты')]")).click();
    }

    @Step("Сделать запись")
    public void createSomeRecords(int i) {
        try {
            int n = 1;
            while (n <= i) {
                logger.info("Обрабатываю врача №: " + n);
                String doctor_num = null;

                doctor_num = new DoctorMethods().getUnicalDoctor3(n);

                String doctor_num_fam = VedenieRaspisaniyaWebPage.getSecondName(doctor_num);
//            SQLDemonstration.deleteShedule(doctor_num_fam);
                new DoctorMethods().selectDoctor(doctor_num);
                new BeforeWork().createShedule();
                new VedenieRaspisaniyaWebPage().verifyCreatedShedule(doctor_num_fam);
                new DoctorMethods().selectDoctor(doctor_num);
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}