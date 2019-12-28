package com.pages.portal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.PacientImpl;
import com.pages.WebPage;
import com.system.service.HltCallDoctorServiceImpl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class PortalDashboard extends WebPage {
    SelenideElement enterRegister = $(By.xpath("//a[@class='b-btn b-btn--red b-registry-form__btn c-registry-form__btn']"));
    SelenideElement numberPolise = $(By.xpath("//input[@name='nPol']"));
    SelenideElement birthdate = $(By.xpath("//input[@name='birthday']"));
    SelenideElement closeWindow = $(By.id("create-home-visit-popup-success")).$(By.xpath(".//*[contains(.,'Закрыть окно')]"));
    SelenideElement entrance = $(By.id("call_entrance"));
    SelenideElement codeDomophone = $(By.id("call_doorphone"));
    SelenideElement phone = $(By.id("call_phone"));
    SelenideElement description = $(By.id("call_description"));
    SelenideElement address = $(By.id("call_address"));
    SelenideElement floor = $(By.id("call_stage"));
    SelenideElement callDoctor = $(By.xpath("//a[contains(text(),'Вызвать врача на дом')]"));
    SelenideElement confirmCall = $(By.xpath("//a[contains(text(),'Подтвердить вызов врача')]"));
    SelenideElement waitHeader = $(By.xpath("//*[contains(text(),'Адрес вызова')]"));
    SelenideElement standEMIAS = $(By.xpath("//*[contains(text(),'Стенд ЕМИАС МО')]"));

    @Autowired
    public HltCallDoctorServiceImpl hltCallDoctorService;

    public PortalDashboard() throws IOException {
    }

    @Step("создаю вызов через портал")
    public void createCall(PacientImpl pacientImpl) {
        hltCallDoctorService.cancelByNPol(pacientImpl.getNumberpol());

        numberPolise.sendKeys(String.valueOf(pacientImpl.getNumberpol()));
        birthdate.sendKeys(String.valueOf(pacientImpl.getBirthdate("dd.MM.yyyy")));
        enterRegister.click();
        standEMIAS.shouldBe(Condition.visible);
        callDoctor.click();
        waitHeader.shouldBe(Condition.visible);

        address.setValue(pacientImpl.getAddress());
        entrance.setValue(String.valueOf(pacientImpl.getEntrance()));
        floor.setValue(String.valueOf(pacientImpl.getFloor()));
        codeDomophone.setValue(pacientImpl.getCodedomophone());
        phone.setValue(pacientImpl.getPhone());
        description.setValue(pacientImpl.getComplaint());
        confirmCall.click();

        closeWindow.shouldBe(Condition.visible).click();
    }
}