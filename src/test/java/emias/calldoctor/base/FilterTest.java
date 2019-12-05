package emias.calldoctor.base;

import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.PacientImpl;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class FilterTest extends TestBase {

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterFIO() {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).closeCardBtn();
        page.dashboard()
                .searchFilterFio_Fam(pacientImpl)
                .verifyNewCallGroup(pacientImpl);
    }

    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() {
        PacientImpl pacientImpl = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacientImpl, testName()).closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacientImpl, doctor);
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testTypeCall()  {
        PacientImpl pacientImpl = new PacientImpl("Profile3_1");
        page.createCall(pacientImpl).createCall_Api();
        page.misHome().calldoctor();
        page.dashboard().openNewCallDash(pacientImpl);
        page.fullCard(pacientImpl, testName()).closeCardBtn();
        page.dashboard()
                .searchFilterFio_Fam(pacientImpl)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup(pacientImpl);
    }

    @Test(groups = "CD", description = "фильтр сортировка все|сегодня|завтра")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterActiveGroup()  {
        PacientImpl pacientImpl = new PacientImpl("Profile2_2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        page.misHome().calldoctor();
        page.createCall(pacientImpl).createCall();
        page.fullCard(pacientImpl, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorTomorrow(doctor);
        page.fullCard(pacientImpl, testName()).closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .filter_all_tomorrow()
                .verifyActiveDocGroup(pacientImpl, doctor)
                .filter_tomorrow_today()
                .verifyActiveDocGroupNotVisible(pacientImpl, doctor);
    }
}