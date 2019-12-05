package com.pages;

import com.system.service.HltCallDoctorServiceImpl;
import org.apache.logging.log4j.core.appender.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MainSpringClass {

    @Autowired
    HltCallDoctorServiceImpl hltCallDoctorService;

    @Autowired
    FileManager fileBasedOperations;
}