package emias.calldoctor.base;

import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class FilterTest extends TestCallDoctorBase {

    @Test(groups = "CD", description = "фильтр поиск по ФИО")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterFIO() {
        Pacient pacient = new PacientImpl("Profile1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).closeCardBtn();
        page.dashboard()
                .dashFilter_fio(pacient)
                .verifyNewCallGroup(pacient);
    }

    @Test(groups = "CD", description = "фильтр поиск по врачу")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterDoctor() {
        Pacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName()).closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .searchFilterDoctor(doctor)
                .verifyActiveDocGroup(pacient, doctor);
    }

    @Test(groups = "CD", description = "фильтр поиск по виду вызова")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testTypeCall()  {
        Pacient pacient = new PacientImpl("Profile3_1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.createCall(pacient).createCall_Api();
        page.misHome().calldoctorAdminTemnikov();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).closeCardBtn();
        page.dashboard()
                .dashFilter_fio(pacient)
                .searchFilterTypeCallNeotlozhniy()
                .verifyNewCallGroup(pacient);
    }

    @Test(groups = "CD", description = "фильтр сортировка все|сегодня|завтра")
    @Epic("Проверка фильтра")
    @RetryCountIfFailed(2)
    public void testFilterActiveGroup()  {
        Pacient pacient = new PacientImpl("Profile2_2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorTomorrow(doctor);
        page.fullCard(pacient, testName()).closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .filter_all_tomorrow()
                .verifyActiveDocGroup(pacient, doctor)
                .filter_tomorrow_today()
                .verifyActiveDocGroupNotVisible(pacient, doctor);
    }
}