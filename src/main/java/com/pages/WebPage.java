package com.pages;

import com.settings.ConfigFile;
import com.lib.Alarms;
import com.lib.Lib;
import com.pages.calldoctor.controllers.StAddress;
import com.system.service.HltCallDoctorServiceImpl;
import com.commons.CallDoctorCards;
import com.commons.assistance.Assistance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class WebPage  {
    public static Logger logger = LogManager.getLogger();
    protected ConfigFile conf;
    protected StAddress stAddress;
    protected CallDoctorCards callDoctorCards;
    protected Alarms alarms;
    public WebDriver driver;
    public Lib lib = new Lib();
    public HltCallDoctorServiceImpl hltCallDoctorService;
    public Assistance assistance;

    public WebPage() {
        ApplicationContext context = SpringContext.getApplicationContext();
        hltCallDoctorService = (HltCallDoctorServiceImpl)context.getBean("HltCallDoctorServiceImpl");
        this.driver = getWebDriver();
        this.conf = new ConfigFile();
        assistance = new Assistance();
    }



//    public <T extends WebElement> T expand(){
//        return expand(null);
//    }

//    @Override
//    public void click() {
//
//    }

//    public <T extends SelenideElement> T expand(){
//        return expand(null);
//    }

//    <T extends WebElement> T expand(SelenideElement se){
//        se.click();
//        return (T) this;
//    }
}