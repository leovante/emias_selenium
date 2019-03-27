package pages.portal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.AbstractPage;
import pages.calldoctor2.profiles_interfaces.Pacient;
import utilities.sql.DBScripts;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class PortalDashboard extends AbstractPage {

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

    public PortalDashboard() {
    }

    @Step("создаю вызов через портал")
    public void createCall(Pacient pacient) throws IOException {
        DBScripts.finalizeCall_NPol(pacient.getNumberpol());
        numberPolise.sendKeys(String.valueOf(pacient.getNumberpol()));

        birthdate.sendKeys(String.valueOf(pacient.getBirthdate("dd.MM.yyyy")));
        enterRegister.click();
        standEMIAS.shouldBe(Condition.visible);
        callDoctor.click();
        waitHeader.shouldBe(Condition.visible);

        address.setValue(pacient.getAddress());
        entrance.setValue(String.valueOf(pacient.getEntrance()));
        floor.setValue(String.valueOf(pacient.getFloor()));
        codeDomophone.setValue(pacient.getCodedomophone());
        phone.setValue(pacient.getPhone());
        description.setValue(pacient.getComplaint());
        confirmCall.click();

        closeWindow.shouldBe(Condition.visible).click();
    }
}