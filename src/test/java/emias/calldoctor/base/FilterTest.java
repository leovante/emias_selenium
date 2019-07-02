package emias.calldoctor.base;

import com.pages.calldoctor.doctors_interfaces.Doctor;
import com.pages.calldoctor.pacients.PacientImpl;
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
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacientImpl)
                .verifyNewCallGroup(pacientImpl);
    }

    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() throws InterruptedException, IOException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn();
        page.fullCardPage(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorToday(doctor);
        page.fullCardPage(pacientImpl, testName()).closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacientImpl, doctor);
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testTypeCall() throws InterruptedException, IOException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile3_1");
        page.createCallPage(pacientImpl).createCall_Api();
        page.misHomePage().calldoctor();
        page.dashboardPage().openNewCallDash(pacientImpl);
        page.fullCardPage(pacientImpl, testName()).closeCardBtn();
        page.dashboardPage()
                .searchFilterFio_Fam(pacientImpl)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup(pacientImpl);
    }

    @Test(groups = "CD", description = "фильтр сортировка все|сегодня|завтра")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterActiveGroup() throws InterruptedException, IOException, JSONException, ParseException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile2_2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.misHomePage().calldoctor();
        page.createCallPage(pacientImpl)
                .createCall()
                .saveBtn()
                .allertBtn();
        page.fullCardPage(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctorPage().chooseDoctorTomorrow(doctor);
        page.fullCardPage(pacientImpl, testName()).closeCardBtn();
        page.dashboardPage()
                .clearAllFilters()
                .filter_all_tomorrow()
                .verifyActiveDocGroup(pacientImpl, doctor)
                .filter_tomorrow_today()
                .verifyActiveDocGroupNotVisible(pacientImpl, doctor);
    }
    // TODO: 13.08.2018 сделать тест отображение вызовов в различных подразделениях и группах
}