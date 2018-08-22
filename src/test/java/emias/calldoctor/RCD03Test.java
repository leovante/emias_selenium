package emias.calldoctor;

import emias.AbstractTest;
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

    @Test(groups = "CD", description = "назначить врача на сегодня")
    @Issue("EMIAS-90")
//    @RetryCountIfFailed(2)
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

    // TODO: 13.08.2018 тест назначить врача вызову из регистратуры на зватра
    // TODO: 13.08.2018 тест назначить врача вызову из СМП
    // TODO: 13.08.2018 тест назначить врача вызову из КЦ
    // TODO: 13.08.2018 тест назначить врача вызову из Портала
}