package emias.calldoctor;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class RCD01Test extends AbstractTest {
    private String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        this.nameGen = String.valueOf(nameGen.generator());
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod(ITestResult result) {
        SQLDemonstration.finalizeAllTestCalls();
    }

    @DataProvider(name = "ProfileRegistr")
    public static Object[][] credentials() {
        return new Object[][]{
                {"Profile1", "n"},
                {"Profile2", "y"},
        };
    }

    @Test(groups = "CD", description = "пустой вызов")
    @Issue("EMIAS-90")
    @TmsLink("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile0", nameGen, "n");
        page.fullCardPage()
                .verifyCallProfile0("Profile0")
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура без МКАБ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        open(curUrlCalldoctor);
        open(curUrlCalldoctor);
        page.createCallPage()
                .createNewCall("Profile1", nameGen, "n");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile1", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup("Profile1", nameGen);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile2", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup("Profile2");
    }

    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile3(nameGen);
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallNewCallGroup("Profile3", nameGen);
    }

    @Test(groups = "CD", description = "вызов от СМП по api, Взрослый без МКАБ по КЛАДР")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile6(nameGen);
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallNewCallGroup("Profile6", nameGen);
    }

    @Test(groups = "CD", description = "вызов ребенка с Портала")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws IOException {
        open("https://uslugi.mosreg.ru/zdrav/");
        driver.manage().deleteAllCookies();
        open("https://uslugi.mosreg.ru/zdrav/");
        SQLDemonstration.finalizePacientNumberPol("Profile4");
        page.portalDashboard()
                .createCall("Profile4", nameGen);
        open(curUrlCalldoctor);
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallProgressFrame();
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile4", nameGen);
    }

    @Test(groups = "CD", description = "вызов из Портала по api, ребенок по МКАБ без КЛАДР")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testCallPortalChildMkab() throws IOException {
        open(curUrlCalldoctor);
        page.createCallPage().createCallProfile14();
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallProfileDetkina("Profile14");
    }
}

// TODO: 18.08.2018 create new call from CC for api
// TODO: 18.08.2018 сделать вызовы по апи от смп и проверить отображение подсветки что вызов неотложный и что он без возрастной категории
// TODO: 18.08.2018 создать вызов с адресом как в двух участках (один участок с номерами домов, другой только улица), указать номер дома как в участке с домами. Проверить что появляется окно с выбором участка. В выпадающем списке корректные участки
// TODO: 18.08.2018 создать вызов с адресом как в двух участках (один участок с номерами домов, другой только улица), указать уникальный номер дома. Проверить что появляется окно с выбором участка. В выпадающем списке корректные участки
// TODO: 18.08.2018 создать вызов с адресом как в двух участках (один участок с номерами домов, второй участок с такими же номерами домов), указать такой же номер дома. Проверить что появляется окно с выбором участка. В выпадающем списке корректные участки
// TODO: 18.08.2018 создать вызов с адресом как в двух участках (один участок с номерами домов, второй участок с такими же номерами домов), указать уникальный номер дома. Проверить что появляется окно с выбором участка. В выпадающем списке корректные участки
// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 19.08.2018 на странице выбора врача в поле формализации адреса ввести другой адрес. Проверить что в хедере данный адрес изменился
// TODO: 29.08.2018 делать проверку на время создания вызова
