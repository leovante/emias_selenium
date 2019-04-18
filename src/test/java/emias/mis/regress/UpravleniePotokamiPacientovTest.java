package emias.mis.regress;

import emias.TestBase;
import io.qameta.allure.Epic;
import utils.sql.DBScripts;
import utils.testngRetryCount.RetryCountIfFailed;


public class UpravleniePotokamiPacientovTest extends TestBase {
    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Создать расписание")
    @RetryCountIfFailed(2)
    public void createShedule() throws InterruptedException {
        page.loginPage().loginMis();
        page.homePageMis().vedenieRaspisaniyaBtn();
        String docFullName = page.doctorMethods().getUnicalDoctor(null);
        String secondName = page.manageShedule().getSecondName(docFullName);
        DBScripts.deleteShedule(secondName);
        page.doctorMethods().selectDoctor(docFullName);
        page.manageShedule().createShedule();

        page.manageShedule().verifyCreatedShedule(secondName);
    }

    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Копировать расписание")
    @RetryCountIfFailed(4)
    public void copyShedule() throws InterruptedException {
        page.loginPage().loginMis();
        page.homePageMis().vedenieRaspisaniyaBtn();
        String firstDoctor = page.doctorMethods().getUnicalDoctor(null);
        String secondDoctor = page.doctorMethods().getUnicalDoctor(firstDoctor);
        String second_doctor_fam = page.manageShedule().getSecondName(secondDoctor);
        DBScripts.deleteShedule(second_doctor_fam);

        page.doctorMethods().selectDoctor(firstDoctor);
        page.manageShedule().createShedule();
        page.doctorMethods().selectDoctor(secondDoctor);
        page.manageShedule().copyShedule(firstDoctor);
        page.doctorMethods().selectDoctor(firstDoctor);

        page.manageShedule().verifyCreatedShedule(second_doctor_fam);
    }

    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Указать неприемные дни")
    @RetryCountIfFailed(4)
    public void setNotReceiveDays() {
        page.loginPage().loginMis();
        page.homePageMis().vedenieRaspisaniyaBtn();
        String firstDoctor = page.doctorMethods().getUnicalDoctor(null);
        page.manageShedule()
                .setNotReceiveDays(firstDoctor)
                .verifyNotReceiveDays();
    }

    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Удалить расписание")
    @RetryCountIfFailed(4)
    public void deleteShedule() throws InterruptedException {
        page.loginPage().loginMis();
        page.homePageMis().vedenieRaspisaniyaBtn();
        String first_doctor_fullname = page.doctorMethods().getUnicalDoctor(null);
        String first_doctor_fam = page.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = page.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        String second_doctor_fam = page.manageShedule().getSecondName(second_doctor_fullname);
        DBScripts.deleteShedule(first_doctor_fam);
        DBScripts.deleteShedule(second_doctor_fam);

        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.manageShedule().createShedule();
        page.doctorMethods()
                .selectDoctor(first_doctor_fullname)
                .selectDoctor(second_doctor_fullname);
        page.manageShedule().createShedule();

        page.manageShedule()
                .verifyCreatedShedule(second_doctor_fam)
                .deleteShedule()
                .verifyDeletedShedle();
    }

    @Epic("Управление потоками пациентов")
    @org.testng.annotations.Test(groups = "mis", description = "Перенести запись")
    @RetryCountIfFailed(4)
    public void surviveShedule() throws InterruptedException {
        page.loginPage().loginMis();
        page.homePageMis().vedenieRaspisaniyaBtn();
        String first_doctor_fullname = page.doctorMethods().getUnicalDoctor(null);
        String first_doctor_fam = page.manageShedule().getSecondName(first_doctor_fullname);
        String second_doctor_fullname = page.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        String second_doctor_fam = page.manageShedule().getSecondName(second_doctor_fullname);
        DBScripts.deleteShedule(first_doctor_fam);
        DBScripts.deleteShedule(second_doctor_fam);

        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.manageShedule().createShedule();
        page.doctorMethods()
                .selectDoctor(first_doctor_fullname)
                .selectDoctor(second_doctor_fullname);
        page.manageShedule().createShedule();

        page.homePageMis()
                .logoHomeBtn()
                .raspisaniPriemaBtn();

        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.raspisaniePriemaPage().createRecord(first_doctor_fullname);

        page.homePageMis()
                .logoHomeBtn()
                .transferRecordsBtn();

        first_doctor_fullname = page.doctorMethods().getUnicalDoctor(null);
        second_doctor_fullname = page.doctorMethods().getUnicalDoctor(first_doctor_fullname);
        page.doctorMethods().selectDoctor(first_doctor_fullname);
        page.transferRecords().trancferRecord(second_doctor_fullname);
        page.doctorMethods()
                .selectDoctor(first_doctor_fullname)
                .selectDoctor(second_doctor_fullname);

        page.transferRecords().verifyTransferShedule();
    }
// TODO: 8/24/2018 сделать тест переходов на различные сервисы
// TODO: 8/24/2018 сделать тест переходов на различные сервисы
}
