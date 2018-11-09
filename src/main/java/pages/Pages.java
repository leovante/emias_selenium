package pages;

import pages.callCenter.*;
import pages.calldoctor.*;
import pages.disp.ServicesPage;
import pages.kladr.CreateKladr;
import pages.mis.*;
import pages.portal.PortalDashboard;

import static com.codeborne.selenide.Selenide.page;

public class Pages extends AbstractPage {

    public Pages() {
    }

    public HomePage homePageMis() {
        return page(HomePage.class);
    }

    public LoginPage loginPage() {
        return page(LoginPage.class);
    }

    public NapravlenieNaIssledovanie napravlenieNaIssledovanie() {
        return page(NapravlenieNaIssledovanie.class);
    }

    public ManageShedule manageShedule() {
        return page(ManageShedule.class);
    }

    public CreateMedicalCard medicalCard() {
        return page(CreateMedicalCard.class);
    }

    public AdmissionSchedule admissionSchedule() {
        return page(AdmissionSchedule.class);
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
        return page(SetDoctorPage.class);
    }

    public FullCardPage fullCardPage() {
        return page(FullCardPage.class);
    }

    public DashboardPage dashboardPage() {
        return page(DashboardPage.class);
    }

    public SetLpuPage setLpuPage() {
        return page(SetLpuPage.class);
    }

    public BeforeWork beforeWork() {
        return page(BeforeWork.class);
    }
    // PORTAL
    public PortalDashboard portalDashboard() {
        return page(PortalDashboard.class);
    }

    public ServicesPage servicesPage() {
        return page(ServicesPage.class);
    }
<<<<<<< HEAD
    //CallCenter
    public RecordDoctorPage recordDoctorPage() {return page(RecordDoctorPage.class);}

    public FindPatientPage findPatientPage() {return page(FindPatientPage.class);}

    public WaitingListPage waitingListPage() {return page(WaitingListPage.class);}

    public CallDoctorPage callDoctorPage() {return page(CallDoctorPage.class);}

    public DirectionsPage directionsPage() {return page(DirectionsPage.class);}
=======

    public CreateKladr createKladr() {
        return page(CreateKladr.class);
    }
>>>>>>> 507b077479b4dd788ef5ece1ee49e9de4d6041cc
}