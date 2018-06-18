package mis.regress;

import mis.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD01 extends TestBase {
    String nameGen;

    @BeforeMethod(groups = "mis")
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = nameGen.generator();
        this.nameGen = name;
    }

    @AfterMethod(groups = "mis")
    public void afterMethod(ITestResult testResult) throws Exception {
        //вот тут нужно что бы скрин был только если была ошибка
        takeSnapShot(driver, testResult);
    }

    @Test(groups = "mis", invocationCount = 10)//тут создаем вызов Регистратура без мкаб
    public void testCallRegistr() throws Exception {
        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);
        page.fullCardPage().closeCardBtn();

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
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
}