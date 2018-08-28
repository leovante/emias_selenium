package pages;

import org.openqa.selenium.support.PageFactory;
import pages.callcenter.CallDoctorPage;
import pages.callcenter.FindPatientPage;
import pages.callcenter.LoginPageCC;
import pages.calldoctor.CreateCallPage;
import pages.calldoctor.DashboardPage;
import pages.calldoctor.FullCardPage;
import pages.calldoctor.SetDoctorPage;
import pages.disp.ServicesPage;
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