package emias.calldoctor;

import emias.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.StringGenerator;

public class RCD05Test extends BaseTest implements Profile1, Profile2 {
    String nameGen;

    @BeforeTest(groups = "CD")
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = "CD")
    public void afterTest() throws Exception {
        page.dashboardPage().clickLogoType();
    }

    @Test(groups = "test", description = "пустой вызов", enabled = false)
    public void testCallRegistrEmpy() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile0();
        page.fullCardPage().cancelRecord();
    }
}