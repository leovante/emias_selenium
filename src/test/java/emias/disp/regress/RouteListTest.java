package emias.disp.regress;

import emias.TestBase;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

public class RouteListTest extends TestBase {

    @Test(groups = "disp", description = "проверка что терапевт в конце МЛ после отмены мероприятия")
    @RetryCountIfFailed(2)
    public void testFillExamp() throws InterruptedException {
        page.loginPage().loginMis();
        page.homePageMis().raspisaniPriemaBtn();
        page.raspisaniePriemaPage()
                .createDispMl("Темников", "18.07.1995")
                .generateML()
                .disableIPK()
                .validateTerapevtLast();
    }
    // TODO: 14-Feb-19 сделать тест добавление мероприятия на истекшее время. Бекетова 63 года
    // TODO: 3/26/2019 проверить показатели. В полях должно быть всегда пусто и должна быть валидация
}