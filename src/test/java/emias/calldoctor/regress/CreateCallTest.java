package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateCallTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "пустой вызов")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile0", nameGen, "n");
        page.fullCardPage()
                .verifyCallProfile0("Profile0")
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage()
                .createNewCall("Profile1", nameGen, "n");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile1", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup("Profile1", nameGen);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile2", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup("Profile2");
    }

    @Test(groups = "test", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException, InterruptedException {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createCallProfile3(nameGen);
        page.dashboardPage().openNewCallProgressFrame("Profile3");
        page.fullCardPage().verifyCallNewCallGroup("Profile3", nameGen);
    }

    @Test(groups = "test", description = "вызов от СМП по api, Взрослый без МКАБ по КЛАДР")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() throws IOException, InterruptedException {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createCallProfile6(nameGen);
        page.dashboardPage().openNewCallProgressFrame("Profile6");
        page.fullCardPage().verifyCallNewCallGroup("Profile6", nameGen);
    }

    @Test(groups = "CD", description = "вызов ребенка с Портала")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws IOException, InterruptedException {
        String nameGen = new StringGenerator().generator();
        SQLDemonstration.finalizePacientNumberPol("Profile4");
        open("https://uslugi.mosreg.ru/zdrav/");
        page.portalDashboard()
                .createCall("Profile4", nameGen);
        beforecdCD.loginMis_Calldoctor();
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallProgressFrame("Profile4");
        $(By.xpath("//*[contains(text(),'Интернет')]")).shouldBe(Condition.visible);
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile4", nameGen);
    }

    @Flaky
    @Test(groups = "test", description = "вызов из Колл-Центра по api, ребенок по МКАБ без КЛАДР. 2 участка. Проставиться не должен ни один")
    @Epic("Создание вызова")
    @Issue("EMIAS-657")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab() throws IOException, InterruptedException {
        SQLDemonstration.finalizePacientNumberPol("Profile14");
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createCallProfile14();
        page.dashboardPage().openNewCallProgressFrame("Profile14");
        page.fullCardPage().verifyCallProfileDetkina("Profile14");//почему-то 2 педиатрический сразу. С Таким адресом два участка
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "test", description = "вызов из Колл-Центра по api, ребенок по МКАБ без КЛАДР")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallCenterChild2Mkab() throws IOException, InterruptedException {
        SQLDemonstration.finalizePacientNumberPol("Profile20");
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createCallProfile20();
        page.dashboardPage().openNewCallProgressFrame("Profile20");
        page.fullCardPage().verifyCallNewCallGroup("Profile20");
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
    }

//    @DataProvider(name = "ProfileRegistr")
//    public static Object[][] credentials() {
//        return new Object[][]{
//                {"Profile1", "n"},
//                {"Profile2", "y"},
//        };
}

// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 19.08.2018 на странице выбора врача в поле формализации адреса ввести другой адрес. Проверить что в хедере данный адрес изменился
// TODO: 29.08.2018 делать проверку на время создания вызова
// TODO: 29.08.2018 сделать тест добавление адреса в адресное пространство