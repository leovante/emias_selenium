package pages;

import pages.callCenter.*;
import pages.calldoctor.*;
import pages.disp.ExampPage;
import pages.disp.JournalPage;
import pages.disp.KvotyPage;
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

    public ExampPage exampPage() {
        return page(ExampPage.class);
    }

    public JournalPage journalPage() {
        return page(JournalPage.class);
    }

    public KvotyPage kvotyPage() {
        return page(KvotyPage.class);
    }

    //CallCenter
    public RecordDoctorPage recordDoctorPage() {return page(RecordDoctorPage.class);}

    public FindPatientPage findPatientPage() {return page(FindPatientPage.class);}

    public WaitingListPage waitingListPage() {return page(WaitingListPage.class);}

    public CallDoctorPage callDoctorPage() {return page(CallDoctorPage.class);}

    public DirectionsPage directionsPage() {return page(DirectionsPage.class);}

    public CreateKladr createKladr() {
        return page(CreateKladr.class);
    }
}