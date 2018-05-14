package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.calldoctor.CallDoctorPage;
import pages.calldoctor.CreateMedicalCard;
import pages.shedule.AdmissionSchedule;
import pages.shedule.DoctorMethods;
import pages.shedule.ManageShedule;
import pages.shedule.TransferRecords;
import pages.utilities.Waiter;

public class Pages extends BasePage {

    public Pages(WebDriver driver) {
        super(driver);
    }

    public HomePage mainPage() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        return homePage;
    }

    public LoginPage loginPage() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;
    }

    public ManageShedule manageShedule() {
        ManageShedule manageShedule = PageFactory.initElements(driver, ManageShedule.class);
        return manageShedule;
    }

    public CreateMedicalCard medicalCard() {
        CreateMedicalCard medicalCard = PageFactory.initElements(driver, CreateMedicalCard.class);
        return medicalCard;
    }

    public AdmissionSchedule admissionSchedule() {
        AdmissionSchedule admissionSchedule = PageFactory.initElements(driver, AdmissionSchedule.class);
        return admissionSchedule;
    }

    public TransferRecords transferRecords() {
        TransferRecords transferRecords = PageFactory.initElements(driver, TransferRecords.class);
        return transferRecords;
    }

    public DoctorMethods doctorOperators() {
        DoctorMethods doctorOperators = PageFactory.initElements(driver, DoctorMethods.class);
        return doctorOperators;
    }

    public Waiter waiter() {
        Waiter waiter = PageFactory.initElements(driver, Waiter.class);
        return waiter;
    }

    public CallDoctorPage callDoctorPage() {
        CallDoctorPage callDoctorPage = PageFactory.initElements(driver, CallDoctorPage.class);
        return callDoctorPage;
}
}

//    public steps.AdmissionSchedule admissionSchedule() {
//        steps.AdmissionSchedule admissionSchedule = PageFactory.initElements(driver, steps.AdmissionSchedule.class);
//        return admissionSchedule;
//    }
//
//    public steps.TransferRecords transferRecords() {
//        steps.TransferRecords transferRecords = PageFactory.initElements(driver, steps.TransferRecords.class);
//        return transferRecords;
//    }
//
//    public steps.LoginPage loginPage() {
//        steps.LoginPage loginPage = PageFactory.initElements(driver, steps.LoginPage.class);
//        return loginPage;
//    }


