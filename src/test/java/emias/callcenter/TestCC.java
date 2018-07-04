package emias.callcenter;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestCC extends AbstractTest {
    String nPol = null;
    String birthDay = null;
    int count = 0;

    @BeforeTest(groups = "CC")
    public void patient() {
        ArrayList<String> date = new ArrayList<>();
        date.add("18.08.1991");
        date.add("10.01.2002");
        date.add("25.10.1999");
        date.add("30.11.1975");
        date.add("19.02.2016");
        date.add("12.12.2012");

        ArrayList<String> pol = new ArrayList<>();
        pol.add("5051800881001952");
        pol.add("5098799789000154");
        pol.add("45 558320");
        pol.add("38-09 560219");
        pol.add("7854215965847521");
        pol.add("7754610821003323");

        this.nPol = pol.get(count);
        this.birthDay = date.get(count);
    }

    @Test(groups = "CC", invocationCount = 6)
    @RetryCountIfFailed(4)
    public void testCallCenter() throws InterruptedException {
        page.loginPageCC().login();
        page.findPatientPage().findPatient(nPol, birthDay);
        page.callDoctorPage().calldoctor();
        count++;
    }
}