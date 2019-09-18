package com.pages.mis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.pages.BasePage;
import com.utils.DispUrlParser;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.*;

public class MisHomePage extends BasePage {

    public MisHomePage() throws IOException {
    }

    @Step("Открываю стенд")
    public void loginMis() {
        open(conf.getUrl());
        $(By.id("Login")).setValue(conf.getLogin());
        $(By.id("Password")).setValue(conf.getPassword());
        $(By.id("loginBtn")).click();
        logger2.info("Открыл дашборд МИС " + conf.getUrl());
    }

    @Step("изменяю куки для входа под юр.лицом")
    public void setCookieOfDepartment() {
        String name = "__cp354";
        String value = "1239";
        Cookie department = new Cookie(name, value);
        WebDriverRunner.getWebDriver().manage().addCookie(department);
    }

    @Step("Open CallDoctor with in URL")
    public void calldoctor() {
        open(conf.getCalldoctor());
        logger2.debug("Open CallDoctor with in URL: " + conf.getCalldoctor());
    }

    @Step("Вход в модуль диспетчер от взрослой поликлиникой")
    public void calldoctorVzroslaya() {
        open(conf.getCalldoctorVz());
        logger2.info("Открыл модуль диспетчер по прямой ссылке от взрослого подразделения: " + conf.getCalldoctorVz());
    }

    @Step("Захожу в диспетчер через МИС под админом")
    public void calldoctorFromMis() {
        open(conf.getUrl());
        $(By.id("Login")).setValue(conf.getAdminLogin());
        $(By.id("Password")).setValue(conf.getAdminPassword());
        $(By.id("loginBtn")).click();
        $x("//span[contains(.,'Диспетчер')]").click();
        switchTo().window("Медицинская Информационная Система");
    }

    @Step("Вход в модуль диспансеризация через журнал")
    public void dispJournal() {
        open(conf.getDispJournal());
        logger2.info("Открыл модуль диспансеризация на странице журнала по прямой ссылке " + conf.getDispJournal());
    }

    @Step("Вход в карту диспансеризации")
    public void dispCard() {
        open(conf.getDispCard());
        logger2.info("Открыл модуль диспансеризация на странице карты по прямой ссылке " + conf.getDispCard());
    }

    @Step("Вход в карту диспансеризации")
    public Integer getDispCardNumber() throws MalformedURLException {
        DispUrlParser dp = new DispUrlParser(conf.getDispCard());
        return dp.getCardNumber();
    }

    @Step("Вход в карту диспансеризации")
    public void callCenter() {
        SelenideElement log = $(By.id("USER_LOGIN"));
        SelenideElement pass = $(By.id("USER_PASSWORD"));
        SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));
        open("http://call.emias.mosreg.ru/");
        log.val("ccg");
        pass.val("ccg123");
        loginButton.click();
        open("http://call.emias.mosreg.ru/call2_dev/to_work//");
    }

    @Step("Валидация страницы логина")
    public void validateLoginPage() {
        SelenideElement se = $x("//*[contains(.,'Вход в систему')]").shouldBe(Condition.visible);
        Assert.assertTrue(se.isDisplayed(), "Страница логина не отображается");
    }

    @Step("Валидация инструкции на форуме")
    public void validateForumInstruction() {
        SelenideElement se = $x("//span[contains(text(),'Инструкция диспетчера по вызову врача на дом.pdf')]").shouldBe(Condition.visible);
        Assert.assertTrue(se.isDisplayed(), "Инструкция пользователя диспетчером не найдена на странице");
    }

    @Step("Следующая страница на форуме тех.поддержки")
    public MisHomePage nextPage(){
        $x("//a[contains(text(),'След.')]").click();
        return this;
    }
}