package pages;

import org.openqa.selenium.WebDriver;
import pages.shedule.AdmissionSchedule;
import pages.shedule.TransferRecords;
import pages.calldoctor.SearchRow;
import pages.calldoctor.CreateCall;
import pages.calldoctor.CreateMedicalCard;
import pages.shedule.ManageShedule;

public class Pages {
    WebDriver webDriver;

    public Pages(WebDriver driver) {
        webDriver = driver;
    }

    public MainPage mainPage() {return new MainPage(webDriver);}

    public LoginPage loginPage(){
        return new LoginPage(webDriver);
    }

    public SearchRow callDoctorPage() {
        return new SearchRow(webDriver);
    }

    public ManageShedule manageShedule() {
        return new ManageShedule(webDriver);
    }

    public CreateMedicalCard moduleMedicalCard() {
        return new CreateMedicalCard(webDriver);
    }

    public CreateCall moduleCallDoctor_CreateCall() {
        return new CreateCall(webDriver);
    }

    public AdmissionSchedule moduleAdmissionSchedule() {
        return new AdmissionSchedule(webDriver);
    }

    public TransferRecords moduleTransferRecords() {
        return new TransferRecords(webDriver);
    }
}