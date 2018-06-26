package emias.calldoctor;

import emias.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.calldoctor.Profiles_interfaces.Profile1;
import pages.calldoctor.Profiles_interfaces.Profile2;
import pages.utilities.StringGenerator;

public class RCD09Test extends BaseTest implements Profile1, Profile2 {
    String doctorName;
    String doctorFam;
    String nameGen;

    @BeforeTest(groups = {"CD", "test"})
    public void beforeTest() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterTest(groups = "CD")
    public void afterTest() throws Exception {
        page.dashboardPage().clickLogoType();
    }

    @Test(groups = "test", description = "фильтр поиск по ФИО", enabled = false)
    public void testFilterFIO() throws InterruptedException {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen, adressPro1_3, telephonePro1);
    }

    @Test(groups = "test", description = "фильтр поиск по врачу")
    public void testFilterDoctor() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);

        page.fullCardPage().appoindDoctorBtn();
        this.doctorName = page.setDoctorPage().getDoctorName(1);
        page.setDoctorPage().appendDoctor(doctorName);
        this.doctorFam = page.manageShedule().getSecondName(doctorName);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterDoctor(doctorFam);
        page.dashboardPage().verifyActiveDocGroup(doctorFam, nameGen, adressPro1_2, telephonePro1);
    }

    @Test(groups = "test", description = "фильтр поиск по виду вызова")
    public void testTypeCall() throws Exception {
        driver.get(curUrlCalldoctor);

//тут нужно создать вызов через api смп
    }
}