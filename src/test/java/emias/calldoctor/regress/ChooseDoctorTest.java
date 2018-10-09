package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.sql.DemonstrationDB;
import pages.utilities.StringGenerator;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChooseDoctorTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "назначить вызову из регистратуры врача на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_Registr() throws Exception {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();
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

    @Test(groups = "CD", description = "назначить врача вызову из СМП на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(2)
    public void testAppendDoctorToCall_SMP() throws Exception {
        String nameGen = new StringGenerator().generator();
        beforecdCD.loginMis_Calldoctor();
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

    @Test(groups = "CD", description = "назначить врача вызову из Интернета на сегодня")
    @Epic("Назначить врача")
    @RetryCountIfFailed(3)
    public void testAppendDoctorToCall_Portal() throws Exception {
        String nameGen = new StringGenerator().generator();
        DemonstrationDB.finalizePacientNumberPol("Profile4");
        open("https://uslugi.mosreg.ru/zdrav/");
        page.portalDashboard().createCall("Profile4", nameGen);
        beforecdCD.loginMis_Calldoctor();
        page.dashboardPage()
                .clearAllFilters()
                .openNewCallProgressFrame("Profile4");
        $(By.xpath("//*[contains(text(),'Интернет')]")).shouldBe(Condition.visible);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage()
                .saveAddress()
                .chooseDoctor("Profile4");
        page.fullCardPage()
                .verifyCallActivityGroup(nameGen, "Profile4")
                .closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .verifyActiveDocGroup("Profile4");
    }

    // TODO: 13.08.2018 тест назначить врача вызову из регистратуры на зватра
    // TODO: 13.08.2018 тест назначить врача вызову из КЦ
}