package emias.calldoctor.base;

import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.DataProviderRealisation;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.IPacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class CompleteServiceTest extends TestCallDoctorBase {

    @Test(groups = "CD", description = "завершить обслуживание вызова")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(2)
    public void testCompleteCallRegistr() {
        IPacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .chooseDoctorBtn();
        page.setDoctor()
                .chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .completeServiceBtn()
                .verifyDoneCall(doctor)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .verifyPacientNumberInServe(pacient, doctor);
    }

    @Test(groups = "CD",
            dataProvider = "jsonDataProvider", dataProviderClass = DataProviderRealisation.class,
            description = "завершить обслуживание вызова с дата провайдером")
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(2)
    public void testCompleteCall(PacientImpl pacient) {
//        IPacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall();
        page.fullCard(pacient, testName())
                .chooseDoctorBtn();
        page.setDoctor()
                .chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .completeServiceBtn()
                .verifyDoneCall(doctor)
                .closeCardBtn();
        page.dashboard()
                .clearFilterDepart()
                .verifyPacientNumberInServe(pacient, doctor);
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ и ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkab_TapIconGrey() {
        IPacient pacient = new PacientImpl("Profile1");
        Doctor doctor = new Doctor("SerovaStendTestovoe");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .completeServiceBtn()
                .verifyMkabIconDisable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD", description = "проверка что индикатор МКАБ красный, а ТАП серый")
    @Epic("Проверка иконок МКАБ и ТАП")
    @RetryCountIfFailed(2)
    public void testMkabIconRed_TapIconGrey() {
        IPacient pacient = new PacientImpl("Profile2");
        Doctor doctor = new Doctor("NemcovaVzroslRegistratura");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Mkab();
        page.fullCard(pacient, testName()).chooseDoctorBtn();
        page.setDoctor().chooseDoctorToday(doctor);
        page.fullCard(pacient, testName())
                .completeServiceBtn()
                .verifyMkabIconEnable()
                .verifyTapIconDisable()
                .closeCardBtn();
    }

    @Test(groups = "CD",
            description = "завершить обслуживание вызова с дата провайдером",
            enabled = false)
    @Epic("Завершить обслуживание")
    @RetryCountIfFailed(2)
    public static void testCompleteCall2() {
//        int x = 5 * 4 % 3;
//        int y = 4 % 3;
//        System.out.println(x);
//        System.out.println(y);

//        Integer a;
//        System.out.println(a);

        String devName = "Petrov";
        Developer dev = () -> System.out.println("writing" + devName);
        dev.writeCode();

//        List<Integer> numerics = new ArrayList<>(List.of(5, 4, 3, 2, 1, 5));
//        List<Integer> numerics = Arrays.asList(5,4,3,2,1,5);
//        System.out.println(numerics);
//        List<Integer> numerics2 = numerics.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        numerics2.forEach(System.out::print);
    }

    interface Developer{
        void writeCode();
    }
}