package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile4;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

public class RCD01Test extends AbstractTest implements Profile1, Profile2, Profile4 {
    String nameGen;

    @BeforeTest(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = {"CD", "test"})
    public void afterTest() {
        SQLDemonstration.finalizePacientName(nameGen);
    }

    @Test(groups = "CD", description = "пустой вызов")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile0();
        page.fullCardPage().verifyCallProfile0();
        page.fullCardPage().closeCardBtn();
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура")
    @RetryCountIfFailed(2)
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().clearFilterDepart();
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro1_3, telephonePro1);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @RetryCountIfFailed(2)
    public void testCallRegistrMkab() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile2(nameGen);
        this.nameGen = page.fullCardPage().verifyCallProfile2(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().clearFilterDepart();
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro2_2, telephonePro1);
    }

    @Test(groups = "CD", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР")
    @RetryCountIfFailed(2)
    public void testCallSMPApi() throws InterruptedException {
        page.createCallPage().createCallProfile3(nameGen);
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame(nameGen);
        page.fullCardPage().verifyCallProfile3(nameGen);
    }

    @Test(groups = "test", description = "вызов ребенка с Портала")
    @RetryCountIfFailed(2)
    public void testCallPortal() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get("https://uslugi.mosreg.ru/zdrav/");
        SQLDemonstration.finalizePacientNumberPol(nomerPolPro4);
        page.portalDashboard().createCall(
                nomerPolPro4,
                birthDayPro4,
                adressPro4,
                pdPro4,
                etazhPro4,
                dfonPro4,
                telephonePro4,
                zhalobaPro4);
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame(namePro4);
        page.fullCardPage().verifyCallProfile4(nameGen);
    }
}