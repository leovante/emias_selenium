package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class ChooseDoctorTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() throws Exception {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile1");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile1");
        page.fullCardPage()
                .verifyActivCall("Profile1")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyActiveDocGroup("Profile1");
    }

    @Test(groups = "CD", description = "назначить врача вызову из СМП на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_SMP() throws Exception {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile2");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor("Profile2");
        page.fullCardPage()
                .verifyActivCall("Profile2")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor("Profile2")
                .verifyActiveDocGroup("Profile2");
    }

    @Test(groups = "CD", description = "назначить врача вызову из Интернета на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Portal() throws Exception {
        enterSite.enterPortal();
        page.portalDashboard().createCall("Profile4");
        enterSite.enterCalldoctor();
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallDash("Profile4");
        page.fullCardPage().verifyNewCall("Profile4");
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage()
                .saveAddress()
                .chooseDoctor("Profile4");
        page.fullCardPage()
                .verifyActivCall("Profile4")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyActiveDocGroup("Profile4");
    }

    // TODO: 13.08.2018 тест назначить врача вызову из регистратуры на зватра
    // TODO: 13.08.2018 тест назначить врача вызову из КЦ
}