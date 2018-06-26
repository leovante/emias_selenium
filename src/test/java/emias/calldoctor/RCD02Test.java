package emias.calldoctor;

import emias.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.StringGenerator;

public class RCD02Test extends BaseTest implements Profile1, Profile2 {
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

    @Test(groups = "CD", description = "изменить карту вызова, созданную по п.1.1", enabled = false)
    public void testEditProfile1() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);

        page.editCardPage().editCallBtn();
        page.editCardPage().editCallProfile2(nameGen);
        page.fullCardPage().verifyCallProfile2(nameGen);

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro1_2, telephonePro1);
    }
}