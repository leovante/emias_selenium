package com.lib;

import com.codeborne.selenide.SelenideElement;
import com.datas.calldoctor.Doctor;
import com.datas.calldoctor.Pacient;
import com.lib.calldoctor.Calldoctor;
import com.lib.disp.Disp;

public class Lib {

    public Lib() {
    }

    public Calldoctor calldoctor(Pacient p, Doctor d) {
        return new Calldoctor(p,d);
    }

    public Disp disp(SelenideElement se) {
        return new Disp(se);
    }

    public Disp disp() {
        return new Disp();
    }
}