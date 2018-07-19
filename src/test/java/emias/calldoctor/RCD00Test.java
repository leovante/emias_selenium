package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.mis.ManageShedule;
import pages.utilities.SQLDemonstration;

import java.util.ArrayList;

public class RCD00Test extends AbstractTest {

<<<<<<< .merge_file_a09164
    @Test(groups = {"mis"}, description = "Завершаю вызовы у тестовых врачей и создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeTest() throws InterruptedException {
        //driver.get(curUrlCalldoctor);
=======
    @Test(groups = "mis", description = "Завершаю вызовы у тестовых врачей и создаю новое расписание на сегодня")
    @RetryCountIfFailed()
    public void cleanBeforeCallDoctorTests() throws InterruptedException {
        driver.get(curUrlCalldoctor);
>>>>>>> .merge_file_a04816

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
        }

        for (String doctor_num : doctors) {
            page.doctorMethods().selectDoctor(doctor_num);
            page.beforeWork().createShedule();
            page.manageShedule().verifyCreatedShedule();
            page.doctorMethods().selectDoctor(doctor_num);
        }
    }
}