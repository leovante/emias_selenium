package com.commons.assistance;

import com.datas.calldoctor.Pacient;
import com.pages.WebPage;

public class DuringTestHelper extends WebPage {

    public void beforeCleanDecider(Pacient pacient) {
        if (conf.isCleanBeforeTest())
            hltCallDoctorService.cancelByNPol(pacient.getNumberpol());
    }
}
