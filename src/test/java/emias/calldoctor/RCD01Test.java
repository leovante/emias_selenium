package emias.calldoctor;

import emias.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profile1;
import pages.calldoctor.Profile2;
import pages.utilities.StringGenerator;

public class RCD01Test extends BaseTest implements Profile1, Profile2 {
    String nameGen;

    @BeforeTest(groups = "mis")
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = "mis")
    public void afterTest() throws Exception {
        page.dashboardPage().clickLogoType();
    }

    @Test(groups = "mis", description = "созать вызов с иточником Регистратура")
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro1_3, telephonePro1);
    }

    @Test(groups = "mis", description = "создать вызов с источником СМП и привязкой МКАБ")
    public void testCallRegistrMkab() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile2(nameGen);
        this.nameGen = page.fullCardPage().verifyCallProfile2(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro2_2, telephonePro1);
    }

    @Test(groups = "mis", enabled = false)
    public void testCallApiSMP() {
    }
}