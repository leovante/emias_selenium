package pages;

import org.openqa.selenium.WebDriver;
import pages.shedule.AdmissionSchedulePage;
import pages.shedule.DoctorMethods;
import pages.shedule.TransferRecordsPage;
import pages.calldoctor.SearchRow;
import pages.calldoctor.CreateCall;
import pages.calldoctor.CreateMedicalCard;
import pages.shedule.ManageShedulePage;

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

    public ManageShedulePage manageShedule() {
        return new ManageShedulePage(webDriver);
    }

    public CreateMedicalCard medicalCard() {
        return new CreateMedicalCard(webDriver);
    }

    public CreateCall callDoctor_CreateCall() {
        return new CreateCall(webDriver);
    }

    public AdmissionSchedulePage admissionSchedule() {
        return new AdmissionSchedulePage(webDriver);
    }

    public TransferRecordsPage transferRecords() {
        return new TransferRecordsPage(webDriver);
    }

    public DoctorMethods doctorOperators() {
        return new DoctorMethods(webDriver);
    }


}