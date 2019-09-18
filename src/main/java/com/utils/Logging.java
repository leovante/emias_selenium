package com.utils;

import org.apache.logging.log4j.Logger;
import org.testng.reporters.ExitCodeListener;

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
//                logger.info(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        Screenshots.finishContext();
//    }
}