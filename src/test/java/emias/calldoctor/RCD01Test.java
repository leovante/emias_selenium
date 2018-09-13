package emias.calldoctor;

import emias.BaseTestGrid;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class RCD01Test extends BaseTestGrid {

    @Test(description = "пустой вызов")
    public void testCallRegistrEmpy() throws IOException {
        String nameGen = StringGenerator.nameGen();
        open(curUrlCalldoctor);
        System.out.println("тест RegistrEmpy " + Thread.currentThread().getId());

        page.createCallPage().createNewCall("Profile0", nameGen, "n");
        page.fullCardPage()
                .verifyCallProfile0("Profile0")
                .closeCardBtn();
    }
}