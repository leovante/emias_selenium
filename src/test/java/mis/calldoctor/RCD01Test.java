package mis.calldoctor;

import mis.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD01Test extends BaseTest {
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


        //вот тут нужно что бы скрин был только если была ошибка
//        takeSnapShot(driver, testResult);
    }

    @Test(groups = "mis", description = "создать вызов через Диспетчер с иточником Регистратура", invocationCount = 1)
//тут создаем вызов Регистратура без мкаб
    public void testCallRegistr() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
        page.dashboardPage().clearFilterFio();
    }

    @Test(groups = "mis", description = "создать вызов через Диспетчер с источником СМП и привязкой МКАБ", enabled = false)
//тут создаем вызов СМП с мкаб
    public void testCallRegistrMkab() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile2(nameGen);
        page.fullCardPage().verifyCallProfile2(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
    }

    @Test(groups = "mis", enabled = false)//тут создаем вызов Регистратура без мкаб
    public void testCallApiSMP() {

    }
}