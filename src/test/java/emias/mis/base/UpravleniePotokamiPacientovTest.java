package emias.mis.base;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.commons.sql.DBScripts;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;


public class UpravleniePotokamiPacientovTest extends TestNGBase {
    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Создать расписание")
    @RetryCountIfFailed(2)
    public void createShedule() {
        IPage.misHome().loginMis();
        IPage.homePageMis().vedenieRaspisaniyaBtn();
        String docFullName = IPage.doctorMethods().getUnicalDoctor(null);
        String secondName = IPage.manageShedule().getSecondName(docFullName);
        DBScripts.deleteShedule(secondName);
        IPage.doctorMethods().selectDoctor(docFullName);
        IPage.manageShedule().createShedule();

        IPage.manageShedule().verifyCreatedShedule(secondName);
    }

    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Копировать расписание")
    @RetryCountIfFailed(2)
    public void copyShedule() {
        IPage.misHome().loginMis();
        IPage.homePageMis().vedenieRaspisaniyaBtn();
        String firstDoctor = IPage.doctorMethods().getUnicalDoctor(null);
        String secondDoctor = IPage.doctorMethods().getUnicalDoctor(firstDoctor);
        String second_doctor_fam = IPage.manageShedule().getSecondName(secondDoctor);
        DBScripts.deleteShedule(second_doctor_fam);

        IPage.doctorMethods().selectDoctor(firstDoctor);
        IPage.manageShedule().createShedule();
        IPage.doctorMethods().selectDoctor(secondDoctor);
        IPage.manageShedule().copyShedule(firstDoctor);
        IPage.doctorMethods().selectDoctor(firstDoctor);

        IPage.manageShedule().verifyCreatedShedule(second_doctor_fam);
    }

    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Указать неприемные дни")
    @RetryCountIfFailed(2)
    public void setNotReceiveDays() {
        IPage.misHome().loginMis();
        IPage.homePageMis().vedenieRaspisaniyaBtn();
        String firstDoctor = IPage.doctorMethods().getUnicalDoctor(null);
        IPage.manageShedule()
                .setNotReceiveDays(firstDoctor)
                .verifyNotReceiveDays();
    }

    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Удалить расписание")
    @RetryCountIfFailed(2)
    public void deleteShedule() {
        IPage.misHome().loginMis();
        IPage.homePageMis().vedenieRaspisaniyaBtn();
        String first_doctor_fullname = IPage.doctorMethods().getUnicalDoctor(null);
        String first_doctor_fam = IPage.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = IPage.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        String second_doctor_fam = IPage.manageShedule().getSecondName(second_doctor_fullname);
        DBScripts.deleteShedule(first_doctor_fam);
        DBScripts.deleteShedule(second_doctor_fam);

        IPage.doctorMethods().selectDoctor(first_doctor_fullname);
        IPage.manageShedule().createShedule();
        IPage.doctorMethods()
                .selectDoctor(first_doctor_fullname)
                .selectDoctor(second_doctor_fullname);
        IPage.manageShedule().createShedule();

        IPage.manageShedule()
                .verifyCreatedShedule(second_doctor_fam)
                .deleteShedule()
                .verifyDeletedShedle();
    }

    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Перенести запись")
    @RetryCountIfFailed(2)
    public void surviveShedule() {
        IPage.misHome().loginMis();
        IPage.homePageMis().vedenieRaspisaniyaBtn();
        String first_doctor_fullname = IPage.doctorMethods().getUnicalDoctor(null);
        String first_doctor_fam = IPage.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = IPage.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        String second_doctor_fam = IPage.manageShedule().getSecondName(second_doctor_fullname);
        DBScripts.deleteShedule(first_doctor_fam);
        DBScripts.deleteShedule(second_doctor_fam);

        IPage.doctorMethods().selectDoctor(first_doctor_fullname);
        IPage.manageShedule().createShedule();
        IPage.doctorMethods()
                .selectDoctor(first_doctor_fullname)
                .selectDoctor(second_doctor_fullname);
        IPage.manageShedule().createShedule();

        IPage.homePageMis()
                .logoHomeBtn()
                .raspisaniPriemaBtn();

        IPage.doctorMethods().selectDoctor(first_doctor_fullname);
        IPage.raspisaniePriemaPage().createRecord(first_doctor_fullname);

        IPage.homePageMis()
                .logoHomeBtn()
                .transferRecordsBtn();

        first_doctor_fullname = IPage.doctorMethods().getUnicalDoctor(null);
        second_doctor_fullname = IPage.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        IPage.doctorMethods().selectDoctor(first_doctor_fullname);
        IPage.transferRecords().trancferRecord(second_doctor_fullname);
        IPage.doctorMethods()
                .selectDoctor(first_doctor_fullname)
                .selectDoctor(second_doctor_fullname);

        IPage.transferRecords().verifyTransferShedule();
    }
}