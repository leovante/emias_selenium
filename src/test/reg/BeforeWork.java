import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTT;

public class BeforeWork extends TestBase {
    CleanDoctorTT sql = new CleanDoctorTT();

    @Test
    public void cleanBeforeWork() throws ClassNotFoundException, InterruptedException {
        page.homePage().manageSheduleBtn();
        createShedule(15);
    }

    public void createShedule(int i) throws ClassNotFoundException, InterruptedException {
        int n = 1;

        while (n <= i) {
            System.out.println("Обрабатываю врача №: " + n);
            String doctor_num = page.doctorMethods().getUnicalDoctor3(n);
            String doctor_num_fam = page.manageShedule().getSecondName(doctor_num);
            CleanDoctorTT.deleteShedule(doctor_num_fam);

            page.doctorMethods().selectDoctor(doctor_num);
            page.beforeWork().createShedule();
            page.manageShedule().verifyCreatedShedule();
            page.doctorMethods().selectDoctor(doctor_num);

            n++;
        }
        sql.finalizeCallDoctor();
    }
}
