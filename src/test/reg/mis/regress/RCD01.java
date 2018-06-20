package mis.regress;

import mis.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD01 extends TestBase {
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

    @Test(groups = "mis", invocationCount = 1)//тут создаем вызов Регистратура без мкаб
    public void testCallRegistr() throws Exception {
        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
        page.dashboardPage().clearFilterFio();
    }

    @Ignore
    @Test(groups = "mis")//тут создаем вызов СМП с мкаб
    public void testCallRegistrMkab() throws Exception {
        page.createCallPage().createCallProfile2(nameGen);
        page.fullCardPage().verifyCallProfile2(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
    }

    @Ignore
    @Test(groups = "mis")//тут создаем вызов Регистратура без мкаб
    public void testCallApiSMP() {

    }
}