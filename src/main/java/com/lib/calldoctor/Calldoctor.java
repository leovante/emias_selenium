package com.lib.calldoctor;

import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.IPacient;

import static com.codeborne.selenide.Selenide.$x;

public class Calldoctor {
    SelenideElement serveColumn = $x("//div[contains(text(),'Обслуженные')]").$x("../../.");
    SelenideElement doctorInServeColumn;
    SelenideElement docBlock;
    IPacient pacient;
    Doctor doctor;

    public Calldoctor(IPacient pacient, Doctor doctor) {
        this.pacient=pacient;
        this.doctor=doctor;
        doctorInServeColumn = serveColumn.$x(".//span[contains(text(),'" + doctor.getFamily() + "')]");
        docBlock = doctorInServeColumn.$x("../../../../../.");
    }

    public Calldoctor expandDoctorInServe() {
        doctorInServeColumn
                .$x("../../../../.")
                .click();
        return this;
    }

    public Calldoctor sortInProgress() {
        docBlock.$x(".//*[contains(text(),'Ожидают обработки')]")
                .$x("../../../../.")
                .$x(".//*[@id='order']").click();
        return this;
    }

    public Calldoctor expandInProgress() {
        docBlock.$x(".//*[contains(text(),'Ожидают обработки')]").click();
        return this;
    }

    public Calldoctor expandPacient() {
        $x("//*[contains(text(),'" + pacient.getAddress() + "')]").click();
        return this;
    }
}