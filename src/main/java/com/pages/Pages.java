package com.pages;

import com.pages.callcenter.*;
import com.pages.calldoctor.*;
import com.pages.calldoctor.pacients.Pacient;
import com.pages.calldoctor.pacients.PacientImpl;
import com.pages.disp.ExampPageBase;
import com.pages.disp.JournalPageBase;
import com.pages.disp.KvotyPageBase;
import com.pages.kladr.Kladr;
import com.pages.medicalrecords.NewMRPage;
import com.pages.mis.*;
import com.pages.portal.PortalDashboard;

import static com.codeborne.selenide.Selenide.page;

public class Pages extends PageBase {
    public Pages() {
    }

    //MIS
    public HomePageBase homePageMis() {
        return page(HomePageBase.class);
    }

    public LoginPageBase loginPage() {
        return page(LoginPageBase.class);
    }

    public NapravlenieNaIssledovanie napravlenieNaIssledovanie() {
        return page(NapravlenieNaIssledovanie.class);
    }

    public VedenieRaspisaniyaPageBase manageShedule() {
        return page(VedenieRaspisaniyaPageBase.class);
    }

    public CreateMedicalCard medicalCard() {
        return page(CreateMedicalCard.class);
    }

    public RaspisaniePriemaPageBase raspisaniePriemaPage() {
        return page(RaspisaniePriemaPageBase.class);
    }

    public TransferRecords transferRecords() {
        return page(TransferRecords.class);
    }

    public DoctorMethods doctorMethods() {
        return page(DoctorMethods.class);
    }

    public CreateCallPageBase createCallPage(Pacient pacientImpl) {
        return new CreateCallPageBase(pacientImpl);
    }

    public MkabPage mkabPage() {
        return new MkabPage();
    }

    public SetDoctorPageBase setDoctorPage() {
        return page(SetDoctorPageBase.class);
    }

    public FullCardPageBase fullCardPage(Pacient pacientImpl, String s) {
        return new FullCardPageBase(pacientImpl, s);
    }

    public PrintFormPageBase printFormPage(PacientImpl pacientImpl, String s) {
        return new PrintFormPageBase(pacientImpl, s);
    }

    public DashboardPageBase dashboardPage() {
        return page(DashboardPageBase.class);
    }

    public SetLpuPageBase setLpuPage() {
        return page(SetLpuPageBase.class);
    }

    public BeforeWork beforeWork() {
        return page(BeforeWork.class);
    }

    // PORTAL
    public PortalDashboard portalDashboard() {
        return page(PortalDashboard.class);
    }

    public ExampPageBase exampPage() {
        return page(ExampPageBase.class);
    }

    public JournalPageBase journalPage() {
        return page(JournalPageBase.class);
    }

    public KvotyPageBase kvotyPage() {
        return page(KvotyPageBase.class);
    }

    //CallCenter
    public RecordDoctorPageBase recordDoctorPage() {
        return page(RecordDoctorPageBase.class);
    }

    public FindPatientPageBase findPatientPage() {
        return page(FindPatientPageBase.class);
    }

    public WaitingListPageBase waitingListPage() {
        return page(WaitingListPageBase.class);
    }

    public CallDoctorPageBase callDoctorPage() {
        return page(CallDoctorPageBase.class);
    }

    public DirectionsPageBase directionsPage() {
        return page(DirectionsPageBase.class);
    }

    public Kladr kladr() {
        return page(Kladr.class);
    }

    //MedicalRecords
    public NewMRPage newMRPage() {
        return new NewMRPage();
    }
}