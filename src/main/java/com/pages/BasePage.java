package com.pages;

import com.datas.ModuleData;
import com.datas.calldoctor.Pacient;
import com.lib.Lib;
import com.lib.Alarms;
import com.pages.calldoctor.controllers.StAddress;
import com.pages.disp.measureBlock.Examps;
import com.pages.disp.measureBlock.ExampsImpl;
import com.utils.CallDoctorCards;
import com.lib.assistance.Assistance;
import com.lib.assistance.AssistanceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {
    public StAddress stAddress;
    public CallDoctorCards callDoctorCards;
    public WebDriver driver;
    public Assistance assistance = new AssistanceImpl();
    public Alarms alarms;
    public Lib lib = new Lib();
    public static int callNumber;
    public static Logger LOGGER = LogManager.getLogger();

    @Autowired
    public Examps examps = new ExampsImpl();

    public BasePage() throws IOException {
        this.driver = getWebDriver();
    }

    public void isVisibleText(String text) {
        assistance.isVisibleText(text);
    }

    public String parseTelephone(ModuleData mData) {
        return assistance.parseTelephone(mData);
    }

    public String parseTelephone(Pacient pacientImpl) {
        return assistance.parseTelephone(pacientImpl);
    }

    public ArrayList currentTimeList(String format) {
        return assistance.currentTimeList(format);
    }

    public Integer cardNumberParser(String text) {
        return assistance.cardNumberParser(text);
    }
}