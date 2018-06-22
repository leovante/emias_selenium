package mis.work;

import io.qameta.allure.Description;
import mis.BaseTest;
import mis.RetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTT;

public class RMISTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        page.homePage().logoHomeBtn();
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }


    @Test(groups = "shedule", description = "Создать расписание")
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        page.homePage().manageSheduleBtn();
        String docFullName = page.doctorMethods().getUnicalDoctor(null);
        String secondName = page.manageShedule().getSecondName(docFullName);
        CleanDoctorTT.deleteShedule(secondName);
        page.doctorMethods().selectDoctor(docFullName);
        page.manageShedule().createShedule();

        page.manageShedule().verifyCreatedShedule();
    }

    @Test(groups = "shedule", description = "Копировать расписание")
    public void copyShedule() throws InterruptedException, ClassNotFoundException {

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

    @Test(groups = "shedule", description = "Указать неприемные дни")
    public void setNotReceiveDays() throws InterruptedException {
        page.homePage().manageSheduleBtn();
        String firstDoctor = page.doctorMethods().getUnicalDoctor(null);
        page.manageShedule().setNotReceiveDays(firstDoctor);

        page.manageShedule().verifyNotReceiveDays();
    }

    @Test(groups = "shedule")
    @Description("Удалить расписание")
    public void deleteShedule() throws InterruptedException, ClassNotFoundException {
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

    @Test(groups = "shedule", description = "Перенести запись", retryAnalyzer = RetryAnalyzer.class)
    public void surviveShedule() throws InterruptedException, ClassNotFoundException {
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