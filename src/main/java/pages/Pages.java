package pages;

import org.openqa.selenium.support.PageFactory;
import pages.callcenter2.CallDoctorPage;
import pages.callcenter2.FindPatientPage;
import pages.callcenter2.LoginPageCC;
import pages.calldoctor.*;
import pages.disp.ServicesPage;
import pages.mis2.*;
import pages.portal.PortalDashboard;

public class Pages extends AbstractPage {

    public Pages() {
    }

    public HomePage homePage() {
        HomePage homePage = new HomePage(); //PageFactory.initElements(driver, HomePage.class);
        return homePage;
    }

    public LoginPage loginPage() {
        LoginPage loginPage = new LoginPage();// = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;
    }

    public NapravlenieNaIssledovanie napravlenieNaIssledovanie() {
        NapravlenieNaIssledovanie napravlenieNaIssledovanie = new NapravlenieNaIssledovanie();// = PageFactory.initElements(driver, LoginPage.class);
        return napravlenieNaIssledovanie;
    }

    public ManageShedule manageShedule() {
        ManageShedule manageShedule = new ManageShedule(); //PageFactory.initElements(driver, ManageShedule.class);
        return manageShedule;
    }

    public CreateMedicalCard medicalCard() {
        CreateMedicalCard medicalCard = new CreateMedicalCard();//PageFactory.initElements(driver, CreateMedicalCard.class);
        return medicalCard;
    }

    public AdmissionSchedule admissionSchedule() {
        AdmissionSchedule admissionSchedule = new AdmissionSchedule(); //PageFactory.initElements(driver, AdmissionSchedule.class);
        return admissionSchedule;
    }

    public TransferRecords transferRecords() {
        TransferRecords transferRecords = new TransferRecords(); //PageFactory.initElements(driver, TransferRecords.class);
        return transferRecords;
    }

    public DoctorMethods doctorMethods() {
        DoctorMethods doctorMethods = new DoctorMethods(); //PageFactory.initElements(driver, DoctorMethods.class);
        return doctorMethods;
    }

    public CreateCallPage createCallPage() {
        CreateCallPage createCallPage = new CreateCallPage(); //PageFactory.initElements(driver, CreateCallPage.class);
        return createCallPage;
    }

    public SetDoctorPage setDoctorPage() {
        SetDoctorPage setDoctorPage = new SetDoctorPage(); //PageFactory.initElements(driver, SetDoctorPage.class);
        return setDoctorPage;
    }

    public FullCardPage fullCardPage() {
        FullCardPage fullCardPage = new FullCardPage(); //PageFactory.initElements(driver, FullCardPage.class);
        return fullCardPage;
    }

    public DashboardPage dashboardPage() {
        DashboardPage dashboardPage = new DashboardPage();// = PageFactory.initElements(driver, DashboardPage.class);
        return dashboardPage;
    }

    public SetLpuPage setLpuPage() {
        SetLpuPage setLpuPage = new SetLpuPage();// = PageFactory.initElements(driver, DashboardPage.class);
        return setLpuPage;
    }

    public BeforeWork beforeWork() {
        BeforeWork beforeWork = new BeforeWork(); //PageFactory.initElements(driver, BeforeWork.class);
        return beforeWork;
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

    public ServicesPage servicesPage() {
        ServicesPage servicesPage = new ServicesPage();// PageFactory.initElements(driver, PortalDashboard.class);
        return servicesPage;
    }


}