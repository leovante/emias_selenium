package com.pages.calldoctor;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.pages.WebPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SetDoctorPage extends WebPage {
    private SelenideElement
            appenToday = $x("//span[contains(.,'Назначить на сегодня')]"),
            appenTomorrow = $x("//span[contains(.,'Назначить на завтра')]"),
            zapisat = $x("//span[contains(text(),'Записать')]"),
            zapisatDobavit = $x("//span[contains(text(),'Записать и добавить')]");

    @Step("назначиь врача на сегодня")
    public SetDoctorPage chooseDoctorToday(Doctor doctor) {
        $(By.xpath("//div[contains(text(),'" + doctor.getFamily() + "')]")).click();
        appenToday.click();
        logger.info("Врач выбран!");
        return this;
    }

    @Step("назначиь врача на сегодня")
    public SetDoctorPage chooseDoctorTodayBooster(Doctor doctor) {
        $(By.xpath("//div[contains(text(),'" + doctor.getFamily() + "')]")).click();
        for (int i = 1; appenToday.isDisplayed(); i++) {
            appenToday.click();
            logger.info("нажал на кнопку " + i + " раз");
        }
        logger.info("Врач выбран!");
        return this;
    }

    @Step("назначиь врача на завтра")
    public SetDoctorPage chooseDoctorTomorrow(Doctor doctor) {
        $(By.xpath("//div[contains(text(),'" + doctor.getFamily() + "')]")).click();
        appenTomorrow.click();
        logger.info("Врач выбран!");
        return this;
    }

    @Step("назначиь врача")
    public SetDoctorPage saveAddress() {
        SelenideElement shoseDoctor = $(By.xpath("//*[contains(text(),'Выберите врача')]"));
        SelenideElement adressIsRecognize = $(By.xpath("//*[contains(text(),'Адрес успешно распознан')]"));
        for (int i = 0; i < 10; i++) {
            sleep(1000);
            if (!shoseDoctor.isDisplayed()) {
                if (adressIsRecognize.isDisplayed()) {
                    $(By.xpath("//*[contains(text(),'Адрес успешно распознан')]")).shouldBe(Condition.visible);
                    $(By.xpath("//*[contains(text(),'Сохранить адрес')]")).click();
                }
            }
        }
        return this;
    }

    @Step("нажать записать много раз")
    public SetDoctorPage zapisatClickBooster(Doctor doctor) {
        $(By.xpath("//div[contains(text(),'" + doctor.getFamily() + "')]")).click();
        appenToday.click();
        zapisat.click();
        for (int i = 1; zapisat.isDisplayed() && i < 100; i++) {
            zapisat.click();
            logger.info("Я нажал на эту кнопку " + i + " раз");
        }
        return this;
    }

    @Step("нажать записать и добавить много раз")
    public SetDoctorPage zapisatDobavitClickBooster(Doctor doctor) {
        $(By.xpath("//div[contains(text(),'" + doctor.getFamily() + "')]")).click();
        appenToday.click();
        zapisatDobavit.click();
        for (int i = 1; zapisatDobavit.isDisplayed() && i < 100; i++) {
            zapisatDobavit.click();
            logger.info("Я нажал на эту кнопку " + i + " раз");
        }
        return this;
    }

    @Step("записать")
    public SetDoctorPage zapisatBtn(Doctor doctor) {
        zapisat.click();
        return this;
    }
}