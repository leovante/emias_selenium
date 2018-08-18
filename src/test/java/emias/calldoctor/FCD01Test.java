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

public class FCD01Test extends AbstractTest {
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
        page.createCallPage().createNewCall("Profile7", nameGen, "n");
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
        page.createCallPage().createNewCall("Profile8", nameGen, "n");
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
        page.createCallPage().createNewCall("Profile9", nameGen, "n");
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
        page.createCallPage().createNewCall("Profile10", nameGen, "n");
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
        page.createCallPage().createNewCall("Profile11", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Серова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Немцова')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(.,'Моков')]")).shouldNot(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю пустой вызов взрослого Без пола")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testChildCall6() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile12", nameGen, "n");
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
        page.createCallPage().createNewCall("Profile13", nameGen, "n");
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
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage().chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП с авторизацией по токену, что бы проверить что отобразился участковый")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testPreviewUchDoctorWithoutKladr() throws IOException {
        open(curUrlCalldoctor);
        SQLDemonstration.finalizePacientNumberPol("ProfileDetkina");
        page.createCallPage().createCallProfileDetkina();
        page.dashboardPage()
                .searchFilterFio_Fam("ProfileDetkina")
                .openNewCallProgressFrame();
        page.fullCardPage()
                .verifyCallProfileDetkina("ProfileDetkina")
                .chooseDoctorBtn();
        $(By.xpath("//*[contains(.,'Моков')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ и ТАП серый")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testMkabAndTapIconIsGrey() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneDocGroup("Profile1", nameGen)
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testMkabIconIsRedTapIconIsGrey() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile2");
        page.fullCardPage()
                .completeServiceBtn()
                .verifyDoneDocGroup("Profile2")
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }
}