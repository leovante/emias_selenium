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

    public CreateMedicalCard medicalCard() {
        return new CreateMedicalCard(webDriver);
    }

    public CreateCall callDoctor_CreateCall() {
        return new CreateCall(webDriver);
    }

    public AdmissionSchedule admissionSchedule() {
        return new AdmissionSchedule(webDriver);
    }

    public TransferRecords transferRecords() {
        return new TransferRecords(webDriver);
    }

    public Wait waitAll(){return new Wait(webDriver);}
}