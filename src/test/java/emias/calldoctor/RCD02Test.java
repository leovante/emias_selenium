package emias.calldoctor;

import emias.BaseTestGrid;
import org.testng.annotations.Test;
import pages.utilities.StringGenerator;

import static com.codeborne.selenide.Selenide.open;

public class RCD02Test extends BaseTestGrid {

    public String nameGen() {
        return String.valueOf(new StringGenerator().generator());
    }

    @Test(description = "проверка страницы редактирвоания карты вызова")
    public void testVerifyEditPageProfile1() throws Exception {
        String nameGen = nameGen();
        open(curUrlCalldoctor);
        System.out.println("тест VerifyEditPageProfile1 " + Thread.currentThread().getId());
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.createCallPage()
                .editCallBtn()
                .verifyCallProfile1("Profile1", nameGen);
    }
}