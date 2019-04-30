package com.pages;

import com.dataGenerator.ModuleData;
import com.pages.callcenter.*;
import com.pages.calldoctor.*;
import com.pages.calldoctor.pacients.Pacient;
import com.pages.disp.ExampPage;
import com.pages.disp.JournalPage;
import com.pages.disp.KvotyPage;
import com.pages.kladr.Kladr;
import com.pages.medicalrecords.NewMRPage;
import com.pages.mis.*;
import com.pages.portal.PortalDashboard;

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

    //MIS
    public com.pages.calldoctor2.CreateCallPage createCallPage(ModuleData mData) {
        return new com.pages.calldoctor2.CreateCallPage(mData);
    }

    public com.pages.calldoctor2.FullCardPage fullCardPage(ModuleData mData) {
        return new com.pages.calldoctor2.FullCardPage(mData);
    }

    public com.pages.calldoctor2.DashboardPage dashboardPage(ModuleData mData) {
        return new com.pages.calldoctor2.DashboardPage(mData);
    }

    //MedicalRecords
    public NewMRPage newMRPage() {
        return new NewMRPage();
    }

}