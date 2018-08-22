package emias.callcenter;

import emias.AbstractTest;
import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

public class RTD01Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"mis", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @Test(groups = "mis", description = "создаю направление на исследование")
    @Issue("EMIAS-90")
//    @RetryCountIfFailed(2)
    public void testNapravlenie() {
//        open(curUrlCalldoctor);

        page.homePage().napravlenieNaIssledovanie();
        page.napravlenieNaIssledovanie().addNapravlenie();
    }
}