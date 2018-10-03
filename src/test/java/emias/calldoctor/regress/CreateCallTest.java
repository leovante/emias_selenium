package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class CreateCallTest extends AbstractTestGrid {

    @Test(groups = "test", description = "пустой вызов")
    @Epic("Создание вызова")
    @RetryCountIfFailed(0)
    public void testCallRegistrEmpy() throws IOException, InterruptedException, ParseException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile0");
        page.fullCardPage()
                .verifyNewCall("Profile0")
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.fullCardPage()
                .verifyNewCall("Profile1")
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup("Profile1");
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile2");
        page.fullCardPage()
                .verifyNewCall("Profile2")
                .closeCardBtn();
        page.dashboardPage().verifyNewCallGroup("Profile2");
    }

    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException, InterruptedException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall_Api("Profile3");
        page.dashboardPage().openNewCallDash("Profile3");
        page.fullCardPage().verifyNewCall("Profile3");
    }

    @Test(groups = "CD", description = "вызов от СМП по api, Взрослый без МКАБ по КЛАДР")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() throws IOException, InterruptedException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall_Api("Profile6");
        page.dashboardPage().openNewCallDash("Profile6");
        page.fullCardPage().verifyNewCall("Profile6");
    }

    @Test(groups = "CD", description = "вызов ребенка с Портала")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws IOException, InterruptedException {
        enterSite.enterPortal();
        page.portalDashboard().createCall("Profile4");
        enterSite.enterCalldoctor();
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallDash("Profile4");
        page.fullCardPage().verifyNewCall("Profile4");
    }

    @Flaky
    @Test(groups = "CD", description = "вызов из Колл-Центра по api, ребенок по МКАБ без КЛАДР. 2 участка. Проставиться не должен ни один")
    @Epic("Создание вызова")
    @Issue("EMIAS-657")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab() throws IOException, InterruptedException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall_Api("Profile14");
        page.dashboardPage().openNewCallDash("Profile14");
        page.fullCardPage().verifyNewCall("Profile14");//почему-то 2 педиатрический сразу. С Таким адресом два участка
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "вызов из Колл-Центра по api, ребенок по МКАБ без КЛАДР.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab2() throws IOException, InterruptedException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall_Api("Profile20_2");
        page.dashboardPage().openNewCallDash("Profile20_2");
        page.fullCardPage().verifyNewCall("Profile20_2");
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
    }
}

// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 19.08.2018 на странице выбора врача в поле формализации адреса ввести другой адрес. Проверить что в хедере данный адрес изменился
// TODO: 29.08.2018 делать проверку на время создания вызова
// TODO: 29.08.2018 сделать тест добавление адреса в адресное пространство