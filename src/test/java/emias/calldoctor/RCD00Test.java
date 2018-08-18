package emias.calldoctor;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.mis.ManageShedule;
import pages.utilities.SQLDemonstration;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;

public class RCD00Test extends AbstractTest {

    @Test(groups = "mis", description = "Завершаю вызовы у тестовых врачей и создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() throws InterruptedException {
        open(curUrlCalldoctor);
        page.homePage().manageSheduleBtn();
        createDoctorShedule();
        finallizeOldCalls();
    }

    @Step("Создаю расписание врача")
    public void createDoctorShedule() throws InterruptedException {
        ArrayList<String> doctors = new ArrayList<>();
        doctors.add("Темников Дмитрий Олегович");
        doctors.add("Моков Павел Александрович");
        doctors.add("Серова Нина Кузьминична");
        doctors.add("Немцова Татьяна Андреевна");
        for (String doctor_num : doctors) {
            String doctor_fam = ManageShedule.getSecondName(doctor_num);
            SQLDemonstration.finalizeCallLpuDoctor(doctor_fam);
            SQLDemonstration.deleteShedule(doctor_fam);
        }
        for (String doctor_num : doctors) {
            page.doctorMethods().selectDoctor(doctor_num);
            page.beforeWork().createShedule();
            page.manageShedule().verifyCreatedShedule();
            page.doctorMethods().selectDoctor(doctor_num);
        }
    }

    @Step("Завершение вызовов до прошлой недели")
    public void finallizeOldCalls() {

    }
}