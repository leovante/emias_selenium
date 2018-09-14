package emias;

import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.mis.ManageShedule;
import pages.utilities.SQLDemonstration;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.switchTo;

public class BeforeTest extends AbstractTestGrid {

    @Test(description = "Завершаю вызовы у тестовых врачей и создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() throws InterruptedException {
        switchTo().window(0);
        page.homePage().manageSheduleBtn();
        createDoctorShedule();
    }

    @Step("Создаю расписание врача")
    public void createDoctorShedule() throws InterruptedException {
        ArrayList<String> doctors = new ArrayList<>();
        doctors.add("Темников Дмитрий Олегович");
        doctors.add("Моков Павел Александрович");
        doctors.add("Серова Нина Кузьминична");
        doctors.add("Немцова Татьяна Андреевна");
        doctors.add("Юдина Татьяна Борисовна");//взрослая поликлиника
        doctors.add("Зайцева Татьяна Михайловна");//детская поликлиника
        for (String doctor_num : doctors) {
            String doctor_fam = ManageShedule.getSecondName(doctor_num);
            SQLDemonstration.finalizeCallLpuDoctor(doctor_fam);
            SQLDemonstration.deleteShedule(doctor_fam);
        }
        for (String doctor_num : doctors) {
            page.doctorMethods().selectDoctor(doctor_num);
            page.beforeWork().createShedule();
            page.manageShedule().verifyCreatedShedule(doctor_num);
            page.doctorMethods().selectDoctor(doctor_num);
        }
    }
}