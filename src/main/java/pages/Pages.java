package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.callcenter.CallDoctorPage;
import pages.callcenter.FindPatientPage;
import pages.callcenter.LoginPageCC;
import pages.calldoctor.*;
import pages.mis.CreateMedicalCard;
import pages.mis.*;

public class Pages extends BasePage {

    public Pages(WebDriver driver) {
        super(driver);
    }

    public HomePage homePage() {
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

    public DoctorMethods doctorMethods() {
        DoctorMethods doctorMethods = PageFactory.initElements(driver, DoctorMethods.class);
        return doctorMethods;
    }

    public CreateCallPage createCallPage() {
        CreateCallPage createCallPage = PageFactory.initElements(driver, CreateCallPage.class);
        return createCallPage;
    }

    public SetDoctorPage setDoctorPage() {
        SetDoctorPage setDoctorPage = PageFactory.initElements(driver, SetDoctorPage.class);
        return setDoctorPage;
    }

    public FullCardPage fullCardPage() {
        FullCardPage fullCardPage = PageFactory.initElements(driver, FullCardPage.class);
        return fullCardPage;
    }

    public DashboardPage dashboardPage() {
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        return dashboardPage;
    }

    public BeforeWork beforeWork() {
        BeforeWork beforeWork = PageFactory.initElements(driver, BeforeWork.class);
        return beforeWork;
    }

    public EditCardPage editCardPage() {
        EditCardPage editCardPage = PageFactory.initElements(driver, EditCardPage.class);
        return editCardPage;
    }


    /**
     * CALL CENTER
     *
     * @return
     */
    public LoginPageCC loginPageCC() {
        LoginPageCC loginPageCC = PageFactory.initElements(driver, LoginPageCC.class);
        return loginPageCC;
    }

    public FindPatientPage findPatientPage() {
        FindPatientPage findPatientPage = PageFactory.initElements(driver, FindPatientPage.class);
        return findPatientPage;
    }

//    public RecordDoctorPage recordDoctorPage() {
//        RecordDoctorPage recordDoctorPage = PageFactory.initElements(driver, RecordDoctorPage.class);
//        return recordDoctorPage;
//    }

//    public WaitingListPage waitingListPage() {
//        WaitingListPage waitingListPage = PageFactory.initElements(driver, WaitingListPage.class);
//        return waitingListPage;
//    }

//    public ApoinmentsPage apoinmentsPage() {
//        ApoinmentsPage apoinmentsPage = PageFactory.initElements(driver, ApoinmentsPage.class);
//        return apoinmentsPage;
//    }

//    public PatientRecordsPage patientRecordsPage() {
//        PatientRecordsPage patientRecordsPage = PageFactory.initElements(driver, PatientRecordsPage.class);
//        return patientRecordsPage;
//    }

    public CallDoctorPage callDoctorPage() {
        CallDoctorPage callDoctorPage = PageFactory.initElements(driver, CallDoctorPage.class);
        return callDoctorPage;
    }

//    public CallCentreTests callCentreTests() {
//        CallCentreTests callCentreTests = PageFactory.initElements(driver, CallCentreTests.class);
//        return callCentreTests;
//    }
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


