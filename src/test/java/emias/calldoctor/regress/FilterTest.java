package emias.calldoctor.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;


public class FilterTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException, IOException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile1");
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
//                .searchFilterFio()
                .verifyNewCallGroup(pacient);
    }

    @Test(groups = "test", description = "фильтр поиск по врачу")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() throws InterruptedException, IOException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor(pacient)
                .verifyActiveDocGroup(pacient, doctor);
    }

    @Test(groups = "test", description = "фильтр поиск по виду вызова")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testTypeCall() throws InterruptedException, IOException, JSONException {
        Pacient pacient = new Pacient("Profile3");
        page.createCallPage().createCall_Api(pacient);
        enterSite.enterCalldoctor();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup(pacient);
    }

    @Flaky
    @Test(groups = "test", description = "проверка кнопки выход")
    @Epic("Проверка фильтра")
    @Issue("EMIAS-658")
    @RetryCountIfFailed(2)
    public void testExitToMis() {
        enterSite.enterCalldoctor();
        page.dashboardPage().exitToMis();
        $(By.xpath("//span[contains(text(),'Расписание приёма')]")).shouldBe(Condition.visible);
    }

    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}