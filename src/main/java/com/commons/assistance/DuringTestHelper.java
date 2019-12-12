package com.commons.assistance;

import com.datas.calldoctor.Pacient;
import com.pages.WebPage;
import com.system.service.HltCallDoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.beans.SpringBeansUtil.getBean;

public class DuringTestHelper extends WebPage {

    public void beforeCleanDecider(Pacient pacient) {
        if (conf.isCleanBeforeTest())
            getBean(HltCallDoctorServiceImpl.class).cancelByNPol(pacient.getNumberpol());
    }
}