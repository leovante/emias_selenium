package com.pages.calldoctor.controllers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Pacient;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class StAddress {
    private Pacient pacient;
    SelenideElement adress = $x("//input[@placeholder='Адрес']");
    SelenideElement addressBlock = $x("//div[@class='call-doctor-new-address-complaint-block']");
    SelenideElement korpus = $(By.xpath("//input[@placeholder='Корпус']"));
    SelenideElement cancelAdress = $(By.id("4198BD84-7A21-4E38-B36B-3ECB2E956408"));
    SelenideElement kto_pacient_header = $x("//*[contains(text(),'КТО ПАЦИЕНТ')]");
    SelenideElement new_call_header = $x("//*[contains(text(),'Новый вызов')]");

    public StAddress(Pacient pacient) {
        this.pacient = pacient;
    }

    public SelenideElement getAddressSE() {
        return adress;
    }

    public StAddress write(String txt, String dop) throws InterruptedException {
        if (dop != null && dop != "") {
            addressBlock.shouldBe(Condition.visible);
            adress.sendKeys(txt);
            $x("//mat-option/span[contains(text(),'" + dop + "')]")
                    .shouldBe(Condition.visible)
                    .hover()
                    .click();
        } else
            list_first_container(txt);
        return this;
    }

    public StAddress write(String txt) throws InterruptedException {
//        if (txt != null && txt != "") {
//            list_first_container(pacient.getAddress1());
//        }
        if (txt != null && txt != "") {
            adress.sendKeys(txt);
            addressBlock.shouldBe(Condition.visible);
            $x("//mat-option/span[contains(text(),'" + txt + "')]")
                    .hover()
                    .click();
        }
        return this;
    }

    public StAddress list_first_container(String address) throws InterruptedException {
        if (address != null && address != "") {
            adress.hover();
            Thread.sleep(1000);
            WebDriver driver = getWebDriver();
            WebDriverWait wait = new WebDriverWait(driver, 10);

            WebElement address1 = driver.findElement(By.xpath("//input[@placeholder='Адрес']"));
            address1.sendKeys(address);
            Thread.sleep(1000);
            korpus.hover();
            Thread.sleep(1000);
            adress.hover();
            address1.sendKeys(" ");
            $(By.xpath("//mat-option/span[contains(text(),'" + address + "')]"))
                    .shouldBe(Condition.visible)
                    .click();
        }
        return this;
    }

    public StAddress dom(String txt) {
        if (pacient.getNumber() != null && pacient.getNumber() != "") {
            $(By.xpath("//input[@placeholder='Дом']")).setValue(txt);
        }
        return this;
    }

    @Step("жму на крестик. Очищаю поле адреса")
    public void clearAddress() throws InterruptedException {
        addressLoadWaiter();
        cancelAdress.shouldBe(Condition.visible).click();
    }

    @Step("жду загрузку адреса")
    void addressLoadWaiter() throws InterruptedException {
        kto_pacient_header.shouldBe(Condition.visible);
        if (new_call_header.isDisplayed()) {
            int i = 0;
            do {
                Thread.sleep(1000);
                i++;
            } while (!adress.$x("..//mat-chip").is(Condition.visible) && i < 10);
            Assert.assertTrue(adress.$x("..//mat-chip").is(Condition.visible), "адрес не загрузился");
        }
    }

}
