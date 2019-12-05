package com.pages;

import com.config.ConfigFile;
import com.lib.Alarms;
import com.lib.Lib;
import com.pages.calldoctor.controllers.StAddress;
import com.system.service.HltCallDoctorServiceImpl;
import com.utils.CallDoctorCards;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {
    public static Logger logger = LogManager.getLogger();
    protected ConfigFile conf;
    protected StAddress stAddress;
    protected CallDoctorCards callDoctorCards;
    protected Alarms alarms;
    public WebDriver driver;
    public Lib lib = new Lib();

    public HltCallDoctorServiceImpl hltCallDoctorService;

    public BasePage() {
        ApplicationContext context = SpringContext.getApplicationContext();
        hltCallDoctorService = (HltCallDoctorServiceImpl)context.getBean("HltCallDoctorServiceImpl");
        this.driver = getWebDriver();
        this.conf = new ConfigFile();
    }
}