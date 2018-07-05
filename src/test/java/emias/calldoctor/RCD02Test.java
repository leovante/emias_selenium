package emias.calldoctor;

import emias.AbstractTest;
import emias.TestngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Issue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.calldoctor.Profiles_interfaces.Profile5;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

public class RCD02Test extends AbstractTest implements Profile1, Profile2, Profile5 {
    String nameGen;


    @BeforeTest(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = {"CD", "test"})
    public void afterTest() {
        SQLDemonstration.finalizePacientName(nameGen);
    }

    @Test(groups = "test", description = "изменить карту вызова из регистратуры")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testEditProfile1() throws Exception {
        driver.get(curUrlCalldoctor);
        page.createCallPage().createCallProfile1(nameGen);
        page.editCardPage()
                .editCallBtn()
                .verifyCallProfile1()
                .editCallProfile5(nameGen);
        page.fullCardPage()
                .verifyCallProfile5(nameGen)
                .closeCardBtn();
        page.dashboardPage()
                .searchFilterFio(nameGen)
                .verifyNewCallProgressFrame(nameGen, adressPro5_2, telephonePro5);
    }
}