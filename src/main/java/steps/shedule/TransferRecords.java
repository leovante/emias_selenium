package steps.shedule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CleanDoctorTimeTableSQL;
import pages.Pages;
import pages.Waiter;
import steps.Steps;

public class TransferRecords {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;
    Steps step;

    CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();

    public TransferRecords(WebDriver driver) {
        webDriver = driver;
        website = new Pages(webDriver);
        step = new Steps(webDriver);
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void trancRecord() throws InterruptedException, ClassNotFoundException {
        webDriver.get("http://emias.mosreg.ru/mis/test_emias/ScheduleWriting/Transfer");
        website.waitLoad().waitAll();
        String first_doctor_fullname = website.doctorOperators().getUnicalDoctor2(null);
        String second_doctor_fullname = website.doctorOperators().getUnicalDoctor2(first_doctor_fullname);
        website.doctorOperators().selectDoctor(first_doctor_fullname);
        website.transferRecords().trancRecord(second_doctor_fullname);
        website.doctorOperators().selectDoctor(first_doctor_fullname);
        website.doctorOperators().selectDoctor(second_doctor_fullname);
    }

    public void verifyTransferShedule() throws InterruptedException {
        website.transferRecords().verifyTransferShedule();
    }
}