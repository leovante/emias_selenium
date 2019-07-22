package com.utils;

import com.api.TestStend;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class FirstListner{
    TestStend testStend = new TestStend();
    boolean checkCreateCall;
    boolean checkKladrFind;
    boolean ehr_medrecords;
    boolean disp_journal;
    boolean disp_card;
    boolean calldoctor;
    boolean calldoctorVz;

    public FirstListner(String gridRun) throws IOException {
        if (Boolean.parseBoolean(gridRun)) {
            checkCreateCall = testStend.call_doctor_ef_api();
            checkKladrFind = testStend.kladrsave();
            ehr_medrecords = testStend.ehr_medrecords();
            disp_journal = testStend.disp_journal();
            disp_card = testStend.disp_card();
            calldoctor = testStend.calldoctor();
            calldoctorVz = testStend.calldoctorVz();
        }
    }

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (!checkCreateCall |
                !checkKladrFind |
                !ehr_medrecords |
                !disp_journal |
                !disp_card |
                !calldoctor |
                !calldoctorVz) {
            throw new SkipException(
                    "\nпроверка api диспетчера: " + checkCreateCall +
                            "\nпроверка api КЛАДР: " + checkKladrFind +
                            "\nпроверка медзаписей: " + ehr_medrecords +
                            "\nжурнал диспы: " + disp_journal +
                            "\nкарта диспы: " + disp_card +
                            "\nдиспетчер: " + calldoctor +
                            "\nдиспетчер взрослая поликлиника: " + calldoctorVz
            );
        }

    }
}
