package com.pages;

import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.pages.calldoctor.*;
import com.pages.mis.BeforeWork;
import com.pages.mis.MkabPage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface CalldoctorPage {
    default CreateCallPage createCall(Pacient pacientImpl) throws IOException {
        return new CreateCallPage(pacientImpl);
    }

    default MkabPage mkabPage() throws IOException {
        return new MkabPage();
    }

    default SetDoctorPage setDoctor() {
        return page(SetDoctorPage.class);
    }

    default FullCardPage fullCard(Pacient pacient, String s) throws IOException {
        return new FullCardPage(pacient, s);
    }

    default PrintFormPage printForm(Pacient pacient, String s) throws IOException {
        return new PrintFormPage(pacient, s);
    }

    default DashboardPage dashboard() throws IOException {
        return new DashboardPage();
    }

    default PassLpuPage passLpu(Doctor doctor) throws IOException {
        return new PassLpuPage(doctor);
    }

    default PassLpuPage passLpu() throws IOException {
        return new PassLpuPage();
    }

    default BeforeWork beforeWork() throws IOException {
        return new BeforeWork();
    }
}
