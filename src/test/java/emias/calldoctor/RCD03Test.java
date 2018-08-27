package emias.calldoctor;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import static com.codeborne.selenide.Selenide.open;

public class RCD03Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
        SQLDemonstration.finalizePacientName(nameGen);
    }

    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage()
                .verifyCallActivityGroup(nameGen, "Profile1")
                .closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .clearFilterDepart()
                .verifyActiveDocGroup(nameGen, "Profile1");
    }

    @Test(groups = "CD", description = "назначить вызову из СМП врача на сегодня")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_SMP() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile2", nameGen, "y");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile2");
        page.fullCardPage()
                .verifyCallActivityGroup(nameGen, "Profile2")
                .closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .clearFilterDepart()
                .verifyActiveDocGroup(nameGen, "Profile2");
    }

    @Test(groups = "CD", description = "назначить вызову с Портала врача на сегодня")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Portal() throws Exception {
        open("https://uslugi.mosreg.ru/zdrav/");
        driver.manage().deleteAllCookies();
        open("https://uslugi.mosreg.ru/zdrav/");
        SQLDemonstration.finalizePacientNumberPol("Profile4");
        page.portalDashboard()
                .createCall("Profile4", nameGen);
        open(curUrlCalldoctor);
        page.dashboardPage()
                .clearFilterDepart()
                .openNewCallProgressFrame();
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile4");
        page.fullCardPage()
                .verifyCallActivityGroup(nameGen, "Profile4")
                .closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .clearFilterDepart()
                .verifyActiveDocGroup(nameGen, "Profile4");
    }


    // TODO: 13.08.2018 тест назначить врача вызову из регистратуры на зватра
    // TODO: 13.08.2018 тест назначить врача вызову из КЦ
}