package emias.disp.regress;

import emias.TestBase;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

public class RouteListTest extends TestBase {

    @Test(groups = "disp", description = "проверка что терапевт в конце МЛ после отмены мероприятия")
    @RetryCountIfFailed(2)
    public void testCancelTerapevt() throws InterruptedException {
        page.loginPage().loginMis();
        page.homePageMis().raspisaniPriemaBtn();
        page.raspisaniePriemaPage()
                .createDispMl("Темников", "18.07.1995")
                .generateML()
                .disableIPK()
                .validateTerapevtLast();
    }

    @Test(groups = "disp", description = "проверка пустых значений в показателях")
    @RetryCountIfFailed(2)
    public void testEmpyFieldParams() throws InterruptedException {
        page.loginPage().dispCard();
        page.exampPage().validateFieldParamIsEmpy();
    }

    @Test(groups = "disp", description = "показатели не должны сохраняться с пробелом")
    @RetryCountIfFailed(2)
    public void testSpaceValidationFieldParams() throws InterruptedException {
        page.loginPage().dispCard();
        page.exampPage().validateFieldParamWithSpace();
    }

    @Test(groups = "disp", description = "показатели не должны сохраняться с дефолтным пустым полем")
    @RetryCountIfFailed(2)
    public void testDefaultValidationFieldParams() throws InterruptedException {
        page.loginPage().dispCard();
        page.exampPage().validateDefaultParamWithSpace();
    }

    @Test(groups = "disp", description = "пустое мероприятие не должно промаркироваться, даже если его не раскрыли")
    @RetryCountIfFailed(2)
    public void validateParamNotOpen() throws InterruptedException {
        page.loginPage().dispCard();
        page.exampPage().validateParamNotOpen();
    }
    // TODO: 14-Feb-19 сделать тест добавление мероприятия на истекшее время. Бекетова 63 года
}