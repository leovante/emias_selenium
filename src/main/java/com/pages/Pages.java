package com.pages;

import com.datas.Datas;
import com.pages.callcenter.*;
import com.pages.calldoctor.*;
import com.pages.calldoctor.pacients.Pacient;
import com.pages.calldoctor.pacients.PacientImpl;
import com.pages.disp.ExampPage;
import com.pages.disp.JournalPage;
import com.pages.disp.KvotyPage;
import com.pages.kladr.Kladr;
import com.pages.medicalrecords.Ehr_medicalrecords;
import com.pages.mis.*;
import com.pages.portal.PortalDashboard;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

public class Pages extends PageBase {

    public Pages() throws IOException {
    }

    //MIS
    public HomePageBase homePageMis() {
        return page(HomePageBase.class);
    }

    public MisHomePage misHomePage() {
        return page(MisHomePage.class);
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

    public CreateCallPage createCallPage(Pacient pacientImpl) throws IOException {
        return new CreateCallPage(pacientImpl);
    }

    public MkabPage mkabPage() throws IOException {
        return new MkabPage();
    }

    public SetDoctorPage setDoctorPage() {
        return page(SetDoctorPage.class);
    }

    public FullCardPage fullCardPage(Pacient pacientImpl, String s) throws IOException {
        return new FullCardPage(pacientImpl, s);
    }

    public PrintFormPage printFormPage(PacientImpl pacientImpl, String s) throws IOException {
        return new PrintFormPage(pacientImpl, s);
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
    public Ehr_medicalrecords ehr_medicalrecords(Datas d) {
        return new Ehr_medicalrecords(d);
    }
}