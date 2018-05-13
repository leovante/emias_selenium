package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utilities.CleanDoctorTimeTableSQL;
import pages.Pages;

public class TransferRecords {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages pages;
    CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();

    public TransferRecords(WebDriver driver) {
        webDriver = driver;
        pages = new Pages(webDriver);
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void trancRecord() throws InterruptedException, ClassNotFoundException {
        webDriver.get("http://emias.mosreg.ru/mis/test_emias/ScheduleWriting/Transfer");
        pages.waiter().waitAllEmias();
        String first_doctor_fullname = pages.doctorOperators().getUnicalDoctor2(null);
        String second_doctor_fullname = pages.doctorOperators().getUnicalDoctor2(first_doctor_fullname);
        pages.doctorOperators().selectDoctor(first_doctor_fullname);
        pages.transferRecords().trancRecord(second_doctor_fullname);
        pages.doctorOperators().selectDoctor(first_doctor_fullname);
        pages.doctorOperators().selectDoctor(second_doctor_fullname);
    }

    public void verifyTransferShedule() throws InterruptedException {
        pages.transferRecords().verifyTransferShedule();
    }
}