package com.pages.calldoctor;

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
    default CreateCallPage createCall(Pacient pacientImpl) {
        return new CreateCallPage(pacientImpl);
    }

    default MkabPage mkabPage()   {
        return new MkabPage();
    }

    default SetDoctorPage setDoctor() {
        return page(SetDoctorPage.class);
    }

    default FullCardPage fullCard(Pacient pacient, String s){
        return new FullCardPage(pacient, s);
    }

    default PrintFormPage printForm(Pacient pacient, String s) {
        return new PrintFormPage(pacient, s);
    }

    default DashboardPage dashboard()  {
        return new DashboardPage();
    }

    default PassLpuPage passLpu(Doctor doctor)  {
        return new PassLpuPage(doctor);
    }

    default PassLpuPage passLpu()  {
        return new PassLpuPage();
    }

    default BeforeWork beforeWork()  {
        return new BeforeWork();
    }
}
