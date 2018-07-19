package pages;

import org.openqa.selenium.support.PageFactory;
import pages.callcenter.CallDoctorPage;
import pages.callcenter.FindPatientPage;
import pages.callcenter.LoginPageCC;
import pages.calldoctor.*;
import pages.mis.*;
import pages.portal.PortalDashboard;

public class Pages extends AbstractPage {

    public Pages(/*WebDriver driver*/ ) {
//        super();
        //super(/*driver*/);
    }

    public HomePage homePage() {
        HomePage homePage = new HomePage(); //PageFactory.initElements(driver, HomePage.class);
        return homePage;
    }

    public LoginPage loginPage() {
        LoginPage loginPage = new LoginPage();// = PageFactory.initElements(driver, LoginPage.class);
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
        CreateCallPage createCallPage = new CreateCallPage(); //PageFactory.initElements(driver, CreateCallPage.class);
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

    public PerformCardPage editCardPage() {
        PerformCardPage editCardPage = PageFactory.initElements(driver, PerformCardPage.class);
        return editCardPage;
    }


    /**
     * CALL CENTER
     */
    public LoginPageCC loginPageCC() {
        LoginPageCC loginPageCC = PageFactory.initElements(driver, LoginPageCC.class);
        return loginPageCC;
    }

    public FindPatientPage findPatientPage() {
        FindPatientPage findPatientPage = PageFactory.initElements(driver, FindPatientPage.class);
        return findPatientPage;
    }

    public CallDoctorPage callDoctorPage() {
        CallDoctorPage callDoctorPage = PageFactory.initElements(driver, CallDoctorPage.class);
        return callDoctorPage;
    }

    /**
     * PORTAL
     */
    public PortalDashboard portalDashboard() {
        PortalDashboard portalDashboard = new PortalDashboard();// PageFactory.initElements(driver, PortalDashboard.class);
        return portalDashboard;
    }
}