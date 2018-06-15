package mis;/*eto pattern proektirovania facad
*echo patterni
* singleton - bil tolko odin instance odnogo klassa po vsey sisteme
* bilder - sobrat config testa. Sobrat' nogo url s raznimi parametrami u kazhdogo
* bridge
* proxy
* factory method -
* factory class
*patternov mnogo i oni delyatca po tipam
* page object
*
*
*
*
* */

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.utilities.CleanDoctorTT;

public class RMIS extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws Exception {
        page.homePage().logoHomeBtn();
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }


    @Test//KEYS 1.1
    public void createShedule() throws InterruptedException, ClassNotFoundException {
        page.homePage().manageSheduleBtn();
        String docFullName = page.doctorMethods().getUnicalDoctor(null);
        String secondName = page.manageShedule().getSecondName(docFullName);
        CleanDoctorTT.deleteShedule(secondName);
        page.doctorMethods().selectDoctor(docFullName);
        page.manageShedule().createShedule();

        page.manageShedule().verifyCreatedShedule();
    }

    @Test//KEYS 1.2
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

    @Test//KEYS 1.3
    public void setNotReceiveDays() throws InterruptedException {
        page.homePage().manageSheduleBtn();
        String firstDoctor = page.doctorMethods().getUnicalDoctor(null);
        page.manageShedule().setNotReceiveDays(firstDoctor);

        page.manageShedule().verifyNotReceiveDays();
    }

    @Test//KEYS 1.4
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

    @Ignore
    @Test//KEYS 1.5
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