import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTimeTableSQL;

public class RegressCallDoctor extends TestBase {

    @Ignore
    @Test
    public void cleanBeforeWork() throws ClassNotFoundException {
        CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();
        page.loginPage().login();
        page.homePage().manageSheduleBtn();
        String doctor_1 = page.doctorMethods().getUnicalDoctor(null);
        String doctor_1_fam = page.manageShedule().getSecondName(doctor_1);
        String doctor_2 = page.doctorMethods().getUnicalDoctor(doctor_1);
        String doctor_2_fam = page.manageShedule().getSecondName(doctor_2);
        String doctor_3 = page.doctorMethods().getUnicalDoctor(doctor_2);
        String doctor_3_fam = page.manageShedule().getSecondName(doctor_3);
        String doctor_4 = page.doctorMethods().getUnicalDoctor(doctor_3);
        String doctor_4_fam = page.manageShedule().getSecondName(doctor_4);
        String doctor_5 = page.doctorMethods().getUnicalDoctor(doctor_4);
        String doctor_5_fam = page.manageShedule().getSecondName(doctor_5);
        String doctor_6 = page.doctorMethods().getUnicalDoctor(doctor_5);
        String doctor_6_fam = page.manageShedule().getSecondName(doctor_6);
        String doctor_7 = page.doctorMethods().getUnicalDoctor(doctor_6);
        String doctor_7_fam = page.manageShedule().getSecondName(doctor_7);
        sql.deleteShedule(doctor_1_fam);
        sql.deleteShedule(doctor_2_fam);
        sql.deleteShedule(doctor_3_fam);
        sql.deleteShedule(doctor_4_fam);
        sql.deleteShedule(doctor_5_fam);
        sql.deleteShedule(doctor_6_fam);
        sql.deleteShedule(doctor_7_fam);

        sql.finalizeCallDoctor(doctor_1_fam);
    }

    @Test(invocationCount = 20)
    public void testCallRegistratura() throws Exception {
        page.callDoctorPage().createCallRegistratura();
        page.callDoctorPage().verifyCallRegistr();
        page.callDoctorPage().closeRecordPage();
    }

    @Test(invocationCount = 20)
    public void testCallSMP() throws Exception {
        page.callDoctorPage().createCallSMP();
        page.callDoctorPage().verifyCallSMP();
        page.callDoctorPage().closeRecordPage();
    }

    @Ignore
    @Test(dependsOnMethods = {"testCallRegistratura"})
    public void testСancelRecord(){
        page.callDoctorPage().cancelRecord();
        page.callDoctorPage().verifyCancelOnDashbord();
    }

    @Test(dependsOnMethods = {"testCallRegistratura"})
    public void closeBtn() {
        page.callDoctorPage().closeRecordPage();
    }
}