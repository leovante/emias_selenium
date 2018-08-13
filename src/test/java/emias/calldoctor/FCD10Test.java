package emias.calldoctor;

import com.codeborne.selenide.Condition;
import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FCD10Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @Test(groups = "CD", description = "создаю пустой вызов ребенка М")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile7();
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов ребенка Ж")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall2() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile8();
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов ребенка Без Пола")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall3() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile9();
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Серова')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов взрослого М")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall4() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile10();
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов взрослого Ж")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall5() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile11("Profile11");
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов взрослого Без Пола")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall6() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile12("Profile11");
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов Без Возр Кат, Без Пола, СМП")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall7() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile13("Profile13", nameGen);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов в ВД что бы проверить что отобразился участковый")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithKladr() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile2(nameGen);
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП что бы проверить что отобразился участковый")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithoutKladr() throws IOException {
        open(curUrlCalldoctor);
        SQLDemonstration.finalizePacientNumberPol("ProfileDetkina");
        page.createCallPage().createCallProfileDetkina();
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }
}