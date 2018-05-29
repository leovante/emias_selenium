import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTimeTableSQL;

public class BeforeWork extends TestBase {

    @Test
    public void cleanBeforeWork() throws ClassNotFoundException, InterruptedException {
        CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();
        //page.loginPage().login();
        page.homePage().manageSheduleBtn();
/*получаем имена 20 врачей*/
        String doctor_1 = page.doctorMethods().getUnicalDoctor3(1);
        String doctor_1_fam = page.manageShedule().getSecondName(doctor_1);

        String doctor_2 = page.doctorMethods().getUnicalDoctor3(2);
        String doctor_2_fam = page.manageShedule().getSecondName(doctor_2);

        String doctor_3 = page.doctorMethods().getUnicalDoctor3(3);
        String doctor_3_fam = page.manageShedule().getSecondName(doctor_3);

        String doctor_4 = page.doctorMethods().getUnicalDoctor(doctor_3);
        String doctor_4_fam = page.manageShedule().getSecondName(doctor_4);
        String doctor_5 = page.doctorMethods().getUnicalDoctor(doctor_4);
        String doctor_5_fam = page.manageShedule().getSecondName(doctor_5);
        String doctor_6 = page.doctorMethods().getUnicalDoctor(doctor_5);
        String doctor_6_fam = page.manageShedule().getSecondName(doctor_6);
        String doctor_7 = page.doctorMethods().getUnicalDoctor(doctor_6);
        String doctor_7_fam = page.manageShedule().getSecondName(doctor_7);
        String doctor_8 = page.doctorMethods().getUnicalDoctor(doctor_7);
        String doctor_8_fam = page.manageShedule().getSecondName(doctor_8);
        String doctor_9 = page.doctorMethods().getUnicalDoctor(doctor_8);
        String doctor_9_fam = page.manageShedule().getSecondName(doctor_9);
        String doctor_10 = page.doctorMethods().getUnicalDoctor(doctor_9);
        String doctor_10_fam = page.manageShedule().getSecondName(doctor_10);
        String doctor_11 = page.doctorMethods().getUnicalDoctor(doctor_10);
        String doctor_11_fam = page.manageShedule().getSecondName(doctor_11);
        String doctor_12 = page.doctorMethods().getUnicalDoctor(doctor_11);
        String doctor_12_fam = page.manageShedule().getSecondName(doctor_12);
        String doctor_13 = page.doctorMethods().getUnicalDoctor(doctor_12);
        String doctor_13_fam = page.manageShedule().getSecondName(doctor_13);
        String doctor_14 = page.doctorMethods().getUnicalDoctor(doctor_13);
        String doctor_14_fam = page.manageShedule().getSecondName(doctor_14);
        String doctor_15 = page.doctorMethods().getUnicalDoctor(doctor_14);
        String doctor_15_fam = page.manageShedule().getSecondName(doctor_15);
        String doctor_16 = page.doctorMethods().getUnicalDoctor(doctor_15);
        String doctor_16_fam = page.manageShedule().getSecondName(doctor_16);
        String doctor_17 = page.doctorMethods().getUnicalDoctor(doctor_16);
        String doctor_17_fam = page.manageShedule().getSecondName(doctor_17);
        String doctor_18 = page.doctorMethods().getUnicalDoctor(doctor_17);
        String doctor_18_fam = page.manageShedule().getSecondName(doctor_18);
/*удаляем из базы расписание 20 врачей*/
        sql.deleteShedule(doctor_1_fam);
        sql.deleteShedule(doctor_2_fam);
        sql.deleteShedule(doctor_3_fam);
        sql.deleteShedule(doctor_4_fam);
        sql.deleteShedule(doctor_5_fam);
        sql.deleteShedule(doctor_6_fam);
        sql.deleteShedule(doctor_7_fam);
        sql.deleteShedule(doctor_8_fam);
        sql.deleteShedule(doctor_9_fam);
        sql.deleteShedule(doctor_10_fam);
        sql.deleteShedule(doctor_11_fam);
        sql.deleteShedule(doctor_12_fam);
        sql.deleteShedule(doctor_13_fam);
        sql.deleteShedule(doctor_14_fam);
        sql.deleteShedule(doctor_15_fam);
        sql.deleteShedule(doctor_16_fam);
        sql.deleteShedule(doctor_17_fam);
        sql.deleteShedule(doctor_18_fam);

        sql.finalizeCallDoctor(doctor_1_fam);
/*создаем расписание для 20 врачей*/
        page.doctorMethods().selectDoctor(doctor_1);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_1);
        page.doctorMethods().selectDoctor(doctor_2);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_2);
        page.doctorMethods().selectDoctor(doctor_3);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_3);
        page.doctorMethods().selectDoctor(doctor_4);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_4);
        page.doctorMethods().selectDoctor(doctor_5);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_5);
        page.doctorMethods().selectDoctor(doctor_6);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_6);
        page.doctorMethods().selectDoctor(doctor_7);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_7);
        page.doctorMethods().selectDoctor(doctor_8);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_8);
        page.doctorMethods().selectDoctor(doctor_9);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_9);
        page.doctorMethods().selectDoctor(doctor_10);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_10);
        page.doctorMethods().selectDoctor(doctor_11);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_11);
        page.doctorMethods().selectDoctor(doctor_12);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_12);
        page.doctorMethods().selectDoctor(doctor_13);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_13);
        page.doctorMethods().selectDoctor(doctor_14);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_14);
        page.doctorMethods().selectDoctor(doctor_15);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_15);
        page.doctorMethods().selectDoctor(doctor_16);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_16);
        page.doctorMethods().selectDoctor(doctor_17);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();

        page.doctorMethods().selectDoctor(doctor_17);
        page.doctorMethods().selectDoctor(doctor_18);
        page.manageShedule().createShedule();
        page.manageShedule().verifyCreatedShedule();
    }
}
