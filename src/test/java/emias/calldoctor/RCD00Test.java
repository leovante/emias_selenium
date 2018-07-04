package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.mis.ManageShedule;
import pages.utilities.SQLDemonstration;

import java.util.ArrayList;

public class RCD00Test extends AbstractTest implements Profile1, Profile2 {

    @Test(groups = "mis", description = "Завершаю вызовы у тестовых врачей и создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.homePage().manageSheduleBtn();
        createDoctorShedule();
    }

    @Step("Создаю расписание врача")
    public void createDoctorShedule() throws InterruptedException {
        ArrayList<String> doctors = new ArrayList<>();
        doctors.add("Темников Дмитрий Олегович");//Юр. лицо глюченное
        doctors.add("Серова Инна Кузьминична");//Юр лицо
        doctors.add("Немцова Татьяна Андреевна");//Взрослая поликлиника

        for (String doctor_num : doctors) {
            String doctor_fam = ManageShedule.getSecondName(doctor_num);
            SQLDemonstration.finalizeCallLpuDoctor(doctor_fam);
            SQLDemonstration.deleteShedule(doctor_fam);

            page.doctorMethods().selectDoctor(doctor_num);
            page.beforeWork().createShedule();
            page.manageShedule().verifyCreatedShedule();
            page.doctorMethods().selectDoctor(doctor_num);
        }
    }
}