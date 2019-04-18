package emias.calldoctor.regress;

import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.doctors_interfaces.Doctor;
import pages.calldoctor.profiles_interfaces.Pacient;
import utils.except.NoticeException;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

public class FilterTest extends TestBase {

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException, IOException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .verifyNewCallGroup(pacient);
    }

    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() throws InterruptedException, IOException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(testName()).closeCardBtn();
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
        page.createCallPage(pacient).createCall_Api();
        page.loginPage().calldoctor();
        page.dashboardPage().openNewCallDash(pacient);
        page.fullCardPage(testName()).closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup(pacient);
    }

    @Test(groups = "CD", description = "фильтр сортировка все|сегодня|завтра")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterActiveGroup() throws InterruptedException, IOException, JSONException, ParseException, NoticeException {
        Pacient pacient = new Pacient("Profile2_2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall();
        page.fullCardPage(testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorTomorrow(doctor);
        page.fullCardPage(testName()).closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .filterTomorrow()
                .verifyActiveDocGroup(pacient, doctor)
                .filterToday()
                .verifyActiveDocGroupNotVisible(pacient, doctor);
    }
    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}