package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class CreateCallTest extends AbstractTestGrid {

    @Test(description = "пустой вызов")
    @Epic("создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws IOException, InterruptedException {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile0", nameGen, "n");
        page.fullCardPage()
                .verifyCallProfile0("Profile0")
                .closeCardBtn();
    }

    @Test(description = "вызов с иточником Регистратура без МКАБ")
    @Epic("создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage()
                .createNewCall("Profile1", nameGen, "n");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile1", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup("Profile1", nameGen);
    }

    @Test(description = "вызов с источником СМП и привязкой МКАБ")
    @Epic("создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile2", nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .verifyNewCallGroup("Profile2");
    }

    @Test(description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР")
    @Epic("создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() throws IOException {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createCallProfile3(nameGen);
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallNewCallGroup("Profile3", nameGen);
    }

    @Test(description = "вызов от СМП по api, Взрослый без МКАБ по КЛАДР")
    @Epic("создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() throws IOException {
        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createCallProfile6(nameGen);
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallNewCallGroup("Profile6", nameGen);
    }

    @Flaky
    @Test(description = "вызов ребенка с Портала")
    @Epic("создание вызова")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws IOException {
        open("https://uslugi.mosreg.ru/zdrav/");
//        driver.manage().deleteAllCookies();
//        System.out.println("Куки должны отсутствовать: " + driver.manage().getCookies());
        open("https://uslugi.mosreg.ru/zdrav/");
        SQLDemonstration.finalizePacientNumberPol("Profile4");

        page.portalDashboard()
                .createCall("Profile4", nameGen);
        beforecdCD.loginMis_Calldoctor();
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallProgressFrame();
        page.fullCardPage()
                .verifyCallNewCallGroup("Profile4", nameGen);
    }

    @Test(description = "вызов из Колл-Центра по api, ребенок по МКАБ без КЛАДР")
    @Epic("создание вызова")
    @RetryCountIfFailed(2)
    public void testCallCenterChildMkab() throws IOException {
        SQLDemonstration.finalizePacientNumberPol("Profile14");

        beforecdCD.loginMis_Calldoctor();
        page.createCallPage().createCallProfile14();
        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallProfileDetkina("Profile14");//почему-то 2 педиатрический сразу. С Таким адресом два участка
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