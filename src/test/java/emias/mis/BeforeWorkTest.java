package emias.mis;

import emias.BaseTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTT;

public class BeforeWorkTest extends BaseTest {
    CleanDoctorTT sql = new CleanDoctorTT();

    @Test(groups = "mis", description = "Создание расисания у врачей и закрытие старых вызовов")
    @RetryCountIfFailed(2)
    public void cleanBeforeWork() throws ClassNotFoundException, InterruptedException {

        page.homePage().manageSheduleBtn();
        createShedule(15);
        page.homePage().logoHomeBtn();
    }

    public void createShedule(int i) throws ClassNotFoundException, InterruptedException {
        int n = 1;
        sql.finalizeCallDoctor();

        while (n <= i) {
            System.out.println("Обрабатываю врача №: " + n);
            String doctor_num = page.doctorMethods().getUnicalDoctor3(n);
//            String doctor_num = "Темников Дмитрий Олегович";
            String doctor_num_fam = page.manageShedule().getSecondName(doctor_num);
            CleanDoctorTT.deleteShedule(doctor_num_fam);

            page.doctorMethods().selectDoctor(doctor_num);
            page.beforeWork().createShedule();
            page.manageShedule().verifyCreatedShedule();
            page.doctorMethods().selectDoctor(doctor_num);

            n++;
        }
    }
}