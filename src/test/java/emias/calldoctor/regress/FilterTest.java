package emias.calldoctor.regress;

import emias.AbstractTestGrid;
import utilities.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;
import java.text.ParseException;

public class FilterTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException, IOException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile1");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .verifyNewCallGroup(pacient);
    }

    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() throws InterruptedException, IOException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.fullCardPage().chooseDoctorBtn();
        page.setDoctorPage().chooseDoctor(doctor);
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacient, doctor);
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testTypeCall() throws InterruptedException, IOException, JSONException {
        Pacient pacient = new Pacient("Profile3_1");
        page.createCallPage().createCall_Api(pacient);
        enterSite.enterCalldoctorFromMis();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage().closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup(pacient);
    }
    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}