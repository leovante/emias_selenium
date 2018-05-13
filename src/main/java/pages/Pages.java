package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.calldoctor.CallDoctorPage;
import pages.calldoctor.CreateMedicalCard;
import pages.shedule.AdmissionSchedulePage;
import pages.shedule.DoctorMethods;
import pages.shedule.ManageShedulePage;
import pages.shedule.TransferRecordsPage;

public class Pages extends BasePage {

    public Pages(WebDriver driver) {
        super(driver);
    }

    public MainPage mainPage() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        return mainPage;
    }

    public LoginPage loginPage() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;
    }

    public ManageShedulePage manageShedule() {
        ManageShedulePage manageShedule = PageFactory.initElements(driver, ManageShedulePage.class);
        return manageShedule;
    }

    public CreateMedicalCard medicalCard() {
        CreateMedicalCard medicalCard = PageFactory.initElements(driver, CreateMedicalCard.class);
        return medicalCard;
    }

    public AdmissionSchedulePage admissionSchedule() {
        AdmissionSchedulePage admissionSchedule = PageFactory.initElements(driver, AdmissionSchedulePage.class);
        return admissionSchedule;
    }

    public TransferRecordsPage transferRecords() {
        TransferRecordsPage transferRecords = PageFactory.initElements(driver, TransferRecordsPage.class);
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