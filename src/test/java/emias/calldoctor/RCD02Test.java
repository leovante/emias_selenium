package emias.calldoctor;

import emias.AbstractTestGrid;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import static com.codeborne.selenide.Selenide.open;

public class RCD02Test extends AbstractTestGrid {

    @Test(description = "проверка страницы редактирвоания карты вызова")
    public void testVerifyEditPageProfile1() throws Exception {
        String nameGen = StringGenerator.nameGen();
        open(curUrlCalldoctor);
        System.out.println("тест VerifyEditPageProfile1 " + Thread.currentThread().getId());

        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.createCallPage()
                .editCallBtn()
                .verifyCallProfile1("Profile1", nameGen);
    }
}