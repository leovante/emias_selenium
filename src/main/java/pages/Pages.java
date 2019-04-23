package pages;

import dataGenerator.ModuleData;
import pages.callcenter.*;
import pages.calldoctor.*;
import pages.calldoctor.pacients.Pacient;
import pages.disp.ExampPage;
import pages.disp.JournalPage;
import pages.disp.KvotyPage;
import pages.kladr.Kladr;
import pages.mis.*;
import pages.portal.PortalDashboard;

import static com.codeborne.selenide.Selenide.page;

public class Pages extends AbstractPage {

    public Pages() {
    }

    //MIS
    public HomePage homePageMis() {
        return page(HomePage.class);
    }

    public LoginPage loginPage() {
        return page(LoginPage.class);
    }

    public NapravlenieNaIssledovanie napravlenieNaIssledovanie() {
        return page(NapravlenieNaIssledovanie.class);
    }

    public VedenieRaspisaniyaPage manageShedule() {
        return page(VedenieRaspisaniyaPage.class);
    }

    public CreateMedicalCard medicalCard() {
        return page(CreateMedicalCard.class);
    }

    public RaspisaniePriemaPage raspisaniePriemaPage() {
        return page(RaspisaniePriemaPage.class);
    }

    public TransferRecords transferRecords() {
        return page(TransferRecords.class);
    }

    public DoctorMethods doctorMethods() {
        return page(DoctorMethods.class);
    }

    public CreateCallPage createCallPage(Pacient pacient) {
        return new CreateCallPage(pacient);
    }

    public SetDoctorPage setDoctorPage() {
        return page(SetDoctorPage.class);
    }

    public FullCardPage fullCardPage(Pacient pacient, String s) {
        return new FullCardPage(pacient, s);
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

    public Kladr kladr() {
        return page(Kladr.class);
    }

    //======================
    //MIS
    public pages.calldoctor2.CreateCallPage createCallPage(ModuleData mData) {
        return new pages.calldoctor2.CreateCallPage(mData);
    }

    public pages.calldoctor2.FullCardPage fullCardPage(ModuleData mData) {
        return new pages.calldoctor2.FullCardPage(mData);
    }

    public pages.calldoctor2.DashboardPage dashboardPage(ModuleData mData) {
        return new pages.calldoctor2.DashboardPage(mData);
    }

}