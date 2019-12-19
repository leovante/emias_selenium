package com.pages.calldoctor;

import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.IPacient;
import com.pages.mis.BeforeWork;
import com.pages.mis.MkabPage;
import org.springframework.stereotype.Component;

@Component
public interface Calldoctor {
    default CreateCallPage createCall(IPacient pacient) {
        return new CreateCallPage(pacient);
    }

    default MkabPage mkabPage() {
        return new MkabPage();
    }

    default SetDoctorPage setDoctor() {
        return new SetDoctorPage();
    }

    default FullCardPage fullCard(IPacient pacient, String s) {
        return new FullCardPage(pacient, s);
    }

    default FullCardPage fullCard(IPacient pacient) {
        return new FullCardPage(pacient);
    }

    default PrintFormPage printForm(IPacient pacient, String s) {
        return new PrintFormPage(pacient, s);
    }

    default DashboardPage dashboard() {
        return new DashboardPage();
    }

    default PassLpuPage passLpu(Doctor doctor) {
        return new PassLpuPage(doctor);
    }

    default PassLpuPage passLpu() {
        return new PassLpuPage();
    }

    default BeforeWork beforeWork() {
        return new BeforeWork();
    }
}