package steps.shedule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CleanDoctorTimeTableSQL;
import pages.Pages;
import pages.WaitAll;

public class TransferRecords {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Pages website;
    CleanDoctorTimeTableSQL sql = new CleanDoctorTimeTableSQL();
    WaitAll waitAll;

    public TransferRecords(WebDriver driver) {
        webDriver = driver;
        website = new Pages(webDriver);
        wait = new WebDriverWait(webDriver, 60);
        waitAll = new WaitAll(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void trancRecord() throws InterruptedException, ClassNotFoundException {
        String first_doctor_fullname = website.transferRecords().getUnicalDoctor(null);
        String second_doctor_fullname = website.transferRecords().getUnicalDoctor(first_doctor_fullname);
        website.transferRecords().selectDoctor(first_doctor_fullname);
        website.transferRecords().trancRecord(second_doctor_fullname);
        website.transferRecords().selectDoctor(first_doctor_fullname);
        website.transferRecords().selectDoctor(second_doctor_fullname);
    }

    public void verifyTransferShedule() throws InterruptedException {
        website.transferRecords().verifyTransferShedule();
    }
}