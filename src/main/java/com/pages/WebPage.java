package com.pages;

import com.commons.CallDoctorCards;
import com.commons.assistance.Assistance;
import com.lib.Alarms;
import com.lib.Lib;
import com.pages.calldoctor.controllers.StAddress;
import com.settings.ConfigFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class WebPage  {
    public static Logger logger = LogManager.getLogger();
    protected ConfigFile conf;
    protected StAddress stAddress;
    protected CallDoctorCards callDoctorCards;
    protected Alarms alarms;
    public WebDriver driver;
    public Lib lib = new Lib();
    public Assistance assistance;

    public WebPage() {
        this.driver = getWebDriver();
        this.conf = new ConfigFile();
        assistance = new Assistance();
    }
}