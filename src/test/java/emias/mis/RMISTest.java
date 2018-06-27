package emias.mis;

import emias.BaseTest;
import emias.retry.RetryAnalyzer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTT;

public class RMISTest extends BaseTest {

    @BeforeTest(groups = "mis")
    public void beforeTest() {
        System.out.println();
    }

    @AfterTest(groups = "mis")
    public void afterTest() throws Exception {
    }


    @Test(groups = "mis", description = "Создать расписание", retryAnalyzer = RetryAnalyzer.class)
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        driver.get(curUrlCalldoctor);
        page.homePage().manageSheduleBtn();
        String docFullName = page.doctorMethods().getUnicalDoctor(null);
        String secondName = page.manageShedule().getSecondName(docFullName);
        CleanDoctorTT.deleteShedule(secondName);
        page.doctorMethods().selectDoctor(docFullName);
        page.manageShedule().createShedule();

        page.manageShedule().verifyCreatedShedule();
    }

    @Test(groups = "mis", description = "Копировать расписание", retryAnalyzer = RetryAnalyzer.class)
    public void copyShedule() throws InterruptedException, ClassNotFoundException {
        driver.get(curUrlCalldoctor);
        page.homePage().manageSheduleBtn();
        String firstDoctor = page.doctorMethods().getUnicalDoctor(null);
        String secondDoctor = page.doctorMethods().getUnicalDoctor(firstDoctor);
        String second_doctor_fam = page.manageShedule().getSecondName(secondDoctor);
        CleanDoctorTT.deleteShedule(second_doctor_fam);

        page.doctorMethods().selectDoctor(firstDoctor);
        page.manageShedule().createShedule();
        page.doctorMethods().selectDoctor(secondDoctor);
        page.manageShedule().copyShedule(firstDoctor);
        page.doctorMethods().selectDoctor(firstDoctor);

        page.manageShedule().verifyCreatedShedule();
    }

    @Test(groups = "mis", description = "Указать неприемные дни", retryAnalyzer = RetryAnalyzer.class)
    public void setNotReceiveDays() throws InterruptedException {
        driver.get(curUrlCalldoctor);
        page.homePage().manageSheduleBtn();
        String firstDoctor = page.doctorMethods().getUnicalDoctor(null);
        page.manageShedule().setNotReceiveDays(firstDoctor);

        page.manageShedule().verifyNotReceiveDays();
    }

    @Test(groups = "mis", description = "Удалить расписание", retryAnalyzer = RetryAnalyzer.class)
    public void deleteShedule() throws InterruptedException, ClassNotFoundException {
        driver.get(curUrlCalldoctor);
        page.homePage().manageSheduleBtn();
        String first_doctor_fullname = page.doctorMethods().getUnicalDoctor(null);
        String first_doctor_fam = page.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = page.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        String second_doctor_fam = page.manageShedule().getSecondName(second_doctor_fullname);
        CleanDoctorTT.deleteShedule(first_doctor_fam);
        CleanDoctorTT.deleteShedule(second_doctor_fam);

        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.manageShedule().createShedule();
        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.doctorMethods().selectDoctor(second_doctor_fullname);
        page.manageShedule().createShedule();

        page.manageShedule().verifyCreatedShedule();
        page.manageShedule().deleteShedule();
        page.manageShedule().verifyDeletedShedle();
    }

    @Test(groups = "mis", description = "Перенести запись", retryAnalyzer = RetryAnalyzer.class)
    public void surviveShedule() throws InterruptedException, ClassNotFoundException {
        driver.get(curUrlCalldoctor);
        page.homePage().manageSheduleBtn();
        String first_doctor_fullname = page.doctorMethods().getUnicalDoctor(null);
        String first_doctor_fam = page.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = page.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        String second_doctor_fam = page.manageShedule().getSecondName(second_doctor_fullname);
        CleanDoctorTT.deleteShedule(first_doctor_fam);
        CleanDoctorTT.deleteShedule(second_doctor_fam);

        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.manageShedule().createShedule();
        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.doctorMethods().selectDoctor(second_doctor_fullname);
        page.manageShedule().createShedule();

        page.homePage().logoHomeBtn();
        page.homePage().admissionScheduleBtn();

        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.admissionSchedule().createRecord(first_doctor_fullname);

        page.homePage().logoHomeBtn();
        page.homePage().transferRecordsBtn();

        first_doctor_fullname = page.doctorMethods().getUnicalDoctor(null);
        second_doctor_fullname = page.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.transferRecords().trancferRecord(second_doctor_fullname);
        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.doctorMethods().selectDoctor(second_doctor_fullname);

        page.transferRecords().verifyTransferShedule();
    }
}