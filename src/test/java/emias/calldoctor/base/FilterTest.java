package emias.calldoctor.base;

import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.Pacient;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class FilterTest extends TestBase {

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterFIO() throws InterruptedException, IOException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile1");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).closeCardBtn();
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
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacient, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacient, testName()).closeCardBtn();
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
        page.fullCardPage(pacient, testName()).closeCardBtn();
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
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(pacient, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorTomorrow(doctor);
        page.fullCardPage(pacient, testName()).closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .filter_all_tomorrow()
                .verifyActiveDocGroup(pacient, doctor)
                .filter_tomorrow_today()
                .verifyActiveDocGroupNotVisible(pacient, doctor);
    }
    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}