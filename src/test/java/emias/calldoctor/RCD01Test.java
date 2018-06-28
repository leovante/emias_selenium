package emias.calldoctor;

import emias.BaseTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.StringGenerator;

public class RCD01Test extends BaseTest implements Profile1, Profile2 {
    String nameGen;

    @BeforeTest(groups = {"CD", "Test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = "CD")
    public void afterTest() throws Exception {
    }

    @Test(groups = "test", description = "пустой вызов")
    @RetryCountIfFailed(4)
    public void testCallRegistrEmpy() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile0();
        page.fullCardPage().verifyCallProfile0();
        page.fullCardPage().closeCardBtn();
    }

    @Test(groups = "CD", description = "вызов с иточником Регистратура")
    @RetryCountIfFailed(4)
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro1_3, telephonePro1);
    }

    @Test(groups = "CD", description = "вызов с источником СМП и привязкой МКАБ")
    @RetryCountIfFailed(4)
    public void testCallRegistrMkab() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile2(nameGen);
        this.nameGen = page.fullCardPage().verifyCallProfile2(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro2_2, telephonePro1);
    }

    @Test(groups = "test", description = "вызов от СМП по api, ребенок по МКАБ без КЛАДР", enabled = false)
    @RetryCountIfFailed(4)
    public void testCallSMPApi() throws InterruptedException {
        page.createCallPage().createCallProfile3();
        driver.get(curUrlCalldoctor);

        page.dashboardPage().openNewCallProgressFrame();
        page.fullCardPage().verifyCallProfile3();
    }
}