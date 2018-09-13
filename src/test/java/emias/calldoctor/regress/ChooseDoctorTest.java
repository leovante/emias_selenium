package emias.calldoctor.regress;

import emias.AbstractTest;
import emias.testngRetryCount2.RetryCountIfFailed;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import static com.codeborne.selenide.Selenide.open;

public class ChooseDoctorTest extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
//        SQLDemonstration.finalizeAllTestCalls();
    }

    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня")
    @Epic("Назначить врача")
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
                .clearAllFilters()
                .searchFilterFio(nameGen)
                .verifyActiveDocGroup(nameGen, "Profile1");
    }

    @Flaky
    @Test(groups = "CD", description = "назначить врача вызову из СМП на сегодня")
    @Epic("Назначить врача")
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
                .clearAllFilters()
                .searchFilterDoctor("Profile2")
                .verifyActiveDocGroup("Profile2");
    }

    @Flaky
    @Test(groups = "CD", description = "назначить врача вызову с Портала на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Portal() throws Exception {
        SQLDemonstration.finalizePacientNumberPol("Profile4");
        open("https://uslugi.mosreg.ru/zdrav/");
        driver.manage().deleteAllCookies();
        open("https://uslugi.mosreg.ru/zdrav/");
        page.portalDashboard().createCall("Profile4", nameGen);
        open(curUrlCalldoctor);
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallProgressFrame();
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile4");
        page.fullCardPage()
                .verifyCallActivityGroup(nameGen, "Profile4")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor("Profile4")
                .verifyActiveDocGroup(nameGen, "Profile4");
    }

    // TODO: 13.08.2018 тест назначить врача вызову из регистратуры на зватра
    // TODO: 13.08.2018 тест назначить врача вызову из КЦ
    // TODO: 07.09.2018 добавить проверку на "плановое время обхода"
}