package com.commons.assistance;

import com.datas.calldoctor.IPacient;
import com.pages.WebPage;
import com.system.service.HltCallDoctorServiceImpl;

import static com.beans.SpringBeansUtil.getBean;

public class DuringTestHelper extends WebPage {

    public void beforeCleanDecider(IPacient pacient) {
        if (conf.isCleanBeforeTest() && pacient.getNumberpol() != null)
            getBean(HltCallDoctorServiceImpl.class).cancelByNPol(pacient.getNumberpol());
        else{
            logger.info("Ошибка отмены вызова. Вызов не отменен!");
        }
    }
}