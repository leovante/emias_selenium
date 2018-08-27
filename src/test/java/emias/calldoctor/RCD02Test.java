package emias.calldoctor;

import emias.AbstractTest;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class RCD02Test extends AbstractTest {

    @Test(groups = "CD", description = "проверка страницы редактирвоания карты вызова")
    @Issue("EMIAS-90")
    public void testVerifyEditPageProfile1() throws Exception {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile1", nameGen, "n");
        page.createCallPage()
                .editCallBtn()
                .verifyCallProfile1("Profile1", nameGen);
    }

//    @Test(groups = "CD", description = "изменить карту вызова из регистратуры")
//    @Issue("EMIAS-90")
//    public void testEditCallProfile1() throws Exception {
//        open(curUrlCalldoctor);
//        page.createCallPage().createNewCall("Profile1", nameGen, "n");
//        page.createCallPage()
//                .editCallBtn()
//                .setDeafult()
//                .editCallProfile2("Profile2", nameGen);
//        page.fullCardPage()
//                .verifyCallNewCallGroup("Profile2", nameGen)
//                .closeCardBtn();
//        page.dashboardPage()
//                .clearFilterDepart()
////                .searchFilterFio(nameGen)
//                .verifyNewCallGroup("Profile2");
//    }
}