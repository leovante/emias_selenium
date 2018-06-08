import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTimeTableSQL;

public class BeforeWork extends TestBase {

    @Test
    public void cleanBeforeWork() throws ClassNotFoundException, InterruptedException {
        CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();
        page.homePage().manageSheduleBtn();

        createShedule(15);
    }

    public void createShedule(int i) throws ClassNotFoundException, InterruptedException {
        CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();
        int n = 1;

        while (n <= i) {
            System.out.println("Обрабатываю врача №: " + n);
            String doctor_num = page.doctorMethods().getUnicalDoctor3(n);
            String doctor_num_fam = page.manageShedule().getSecondName(doctor_num);
            sql.deleteShedule(doctor_num_fam);

            page.doctorMethods().selectDoctor(doctor_num);
            page.beforeWork().createShedule();
            page.manageShedule().verifyCreatedShedule();
            page.doctorMethods().selectDoctor(doctor_num);

            n++;
        }
        sql.finalizeCallDoctor();
    }
}
