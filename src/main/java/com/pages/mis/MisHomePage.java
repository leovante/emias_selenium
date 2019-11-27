package com.pages.mis;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.pages.WebPage;
import com.utils.DispUrlParser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.utils.assistance.Assistance.visible;

public class MisHomePage extends WebPage {

    public MisHomePage()   {
    }

    @Step("Открываю стенд")
    public void loginMis() {
        open(conf.getUrl());
        $(By.id("Login")).setValue(conf.getLogin());
        $(By.id("Password")).setValue(conf.getPassword());
        $(By.id("loginBtn")).click();
        logger.info("Открыл дашборд МИС " + conf.getUrl());
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
        logger.debug("Open CallDoctor with in URL: " + conf.getCalldoctor());
    }

    @Step("Вход в модуль диспетчер от взрослой поликлиникой")
    public void calldoctorVzroslaya() {
        open(conf.getCalldoctorVz());
        logger.info("Открыл модуль диспетчер по прямой ссылке от взрослого подразделения: " + conf.getCalldoctorVz());
    }

    @Step("Вход в модуль диспетчер от взрослой поликлиникой")
    public void calldoctorUdina() {
        open(conf.getCalldoctorUdinaVz());
        logger.info("Открыл модуль диспетчер по прямой ссылке от взрослого подразделения: " + conf.getCalldoctorVz());
    }

    @Step("Вход в диспетчер через МИС под админом")
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
        visible("Журнал");
        logger.info("Открыл модуль диспансеризация на странице журнала по прямой ссылке " + conf.getDispJournal());
    }

    @Step("Вход в карту диспансеризации")
    public void dispCard() {
        open(conf.getDispCard());
        logger.info("Открыл модуль диспансеризация на странице карты по прямой ссылке " + conf.getDispCard());
    }

    @Step("Вход в карту диспансеризации")
    public void dispCard42() {
        open(conf.getDispCard42());
        logger.info("Открыл модуль диспансеризация на странице карты по прямой ссылке " + conf.getDispCard42());
    }

    @Step("Медзаписи через ТАП")
    public void mrFromTap() {
        open(conf.getMrFromTap());
        logger.info("Открыл модуль медзаписей через ТАП по прямой ссылке " + conf.getMrFromTap());
    }

    @Step("Медзаписи через МКАБ")
    public void mr_mkab() {
        open(conf.getMr_mkab());
        logger.info("Открыл модуль медзаписей через МКАБ по прямой ссылке " + conf.getMr_mkab());
    }

    @Step("Вход в карту диспансеризации")
    public Integer getDispCardNumber() {
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