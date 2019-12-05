package com.testng;


import com.commons.Timer;
import org.testng.annotations.BeforeSuite;

public class TestNGBase {
    protected static Timer timer;

    public static long getTestRunTime() {
        return timer.timePassedInMSec();
    }

    @BeforeSuite(alwaysRun = true)
    public static void stSetUp(){
//        initFromProperties();
    }
}
