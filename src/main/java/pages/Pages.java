package pages;

import org.openqa.selenium.support.PageFactory;
import pages.callcenter.CallDoctorPage;
import pages.callcenter.FindPatientPage;
import pages.callcenter.LoginPageCC;
import pages.calldoctor.*;
import pages.disp.ServicesPage;
import pages.mis.*;
import pages.portal.PortalDashboard;

import static com.codeborne.selenide.Selenide.page;

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
        return page(TransferRecords.class);
    }

    public DoctorMethods doctorMethods() {
        return page(DoctorMethods.class);
    }

    public CreateCallPage createCallPage() {
        return page(CreateCallPage.class);
    }

    public SetDoctorPage setDoctorPage() {
        SetDoctorPage setDoctorPage = new SetDoctorPage(); //PageFactory.initElements(driver, SetDoctorPage.class);
        return setDoctorPage;
    }

    public FullCardPage fullCardPage() {
        return page(FullCardPage.class);
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