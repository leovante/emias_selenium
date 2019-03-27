package pages;

import dataGenerator.ModuleData;
import pages.callcenter.*;
import pages.calldoctor2.*;
import pages.disp.ExampPage;
import pages.disp.JournalPage;
import pages.disp.KvotyPage;
import pages.kladr.Kladr;
import pages.mis.*;
import pages.portal.PortalDashboard;

import static com.codeborne.selenide.Selenide.page;

public class Pages2 extends AbstractPage {

    public Pages2() {
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

    public CreateCallPage createCallPage(ModuleData mData) {
        return new CreateCallPage(mData);
    }

    public SetDoctorPage setDoctorPage() {
        return page(SetDoctorPage.class);
    }

    public FullCardPage fullCardPage(ModuleData mData) {
        return new FullCardPage(mData);
    }

    public DashboardPage dashboardPage(ModuleData mData) {
        return new DashboardPage(mData);
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
    public RecordDoctorPage recordDoctorPage() {
        return page(RecordDoctorPage.class);
    }

    public FindPatientPage findPatientPage() {
        return page(FindPatientPage.class);
    }

    public WaitingListPage waitingListPage() {
        return page(WaitingListPage.class);
    }

    public CallDoctorPage callDoctorPage() {
        return page(CallDoctorPage.class);
    }

    public DirectionsPage directionsPage() {
        return page(DirectionsPage.class);
    }

    public Kladr kladr() {
        return page(Kladr.class);
    }
}