package com.pages;

import com.config.ConfigFile;
import com.datas.ModuleData;
import com.datas.calldoctor.Pacient;
import com.lib.Lib;
import com.lib.Alarms;
import com.pages.calldoctor.controllers.StAddress;
import com.pages.disp.measureBlock.Examps;
import com.pages.disp.measureBlock.ExampsImpl;
import com.system.service.HltCallDoctorServiceImpl;
import com.utils.CallDoctorCards;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {
    public static Logger logger = LogManager.getLogger();
    protected ConfigFile conf;
    protected StAddress stAddress;
    protected CallDoctorCards callDoctorCards;
    protected Alarms alarms;
    public WebDriver driver;
    public Lib lib = new Lib();

    @Autowired
    public Examps examps = new ExampsImpl();

    @Autowired
    public HltCallDoctorServiceImpl callDoctorService = new HltCallDoctorServiceImpl();

    public BasePage() {
        this.driver = getWebDriver();
        this.conf = new ConfigFile();
    }
}