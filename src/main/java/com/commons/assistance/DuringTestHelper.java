package com.commons.assistance;

import com.datas.calldoctor.Pacient;
import com.pages.WebPage;
import com.system.service.HltCallDoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class DuringTestHelper extends WebPage {

    @Autowired
    private HltCallDoctorServiceImpl hltCallDoctorService;

    public void beforeCleanDecider(Pacient pacient) {
        if (conf.isCleanBeforeTest())
            hltCallDoctorService.cancelByNPol(pacient.getNumberpol());
    }
}