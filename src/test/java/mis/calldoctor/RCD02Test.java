package mis.calldoctor;

import mis.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RCD02Test extends BaseTest {
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

    @Test(groups = "mis", description = "изменить карту вызова, созданную по п.1.1", enabled = false)
//нужен ID на поле учистки адреса
    public void testEditProfile1() throws Exception {
        driver.get(curUrlCalldoctor);

        page.createCallPage().createCallProfile1(nameGen);
        page.fullCardPage().verifyCallProfile1(nameGen);

        page.editCardPage().editCallBtn();
        page.editCardPage().editCallProfile2(nameGen);
        page.fullCardPage().verifyCallProfile2(nameGen);

        page.dashboardPage().searchFilterFio(nameGen);
        page.dashboardPage().verifyNewCallProgressFrame(nameGen);
    }
}