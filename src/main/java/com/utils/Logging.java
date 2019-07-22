package com.utils;

import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.ex.UIAssertionError;
import com.codeborne.selenide.impl.ScreenShotLaboratory;
import com.codeborne.selenide.testng.ScreenShooter;
import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.reporters.ExitCodeListener;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.ex.ErrorMessages.screenshot;

//@Listeners({ScreenShooter.class})
public class Logging extends ExitCodeListener {
    public static Logger LOGGER;
    public String screenshot_file_path = "demoScreenshoot.png";
    public String rp_message = "test message for Report Portal";

//    @Override
//    public void onTestFailure(ITestResult result) {
//        super.onTestFailure(result);
//        if (!(result.getThrowable() instanceof UIAssertionError)) {
//            try {
//                ReportPortalMessage message = new ReportPortalMessage(new File(screenshot(driver())), rp_message);
//                LOGGER.info(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        Screenshots.finishContext();
//    }
}