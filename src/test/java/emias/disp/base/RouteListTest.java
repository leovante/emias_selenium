package emias.disp.base;

import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.pages.disp.Services.issledovanieKala;

public class RouteListTest extends TestBase {
    @Ignore
    @Test(groups = "disp", description = "проверка что терапевт в конце МЛ после отмены мероприятия", enabled = false)
//сейчас даже если терапевт не последний, тап и заключение отображается как надо
    @RetryCountIfFailed(2)
    public void testCancelTerapevt() throws InterruptedException {
        page.misHomePage().loginMis();
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
        page.misHomePage().dispCard();
        page.exampPage().validateFieldParamIsEmpy();
    }

    @Test(groups = "disp", description = "показатели не должны сохраняться с пробелом")
    @RetryCountIfFailed(2)
    public void testSpaceValidationFieldParams() throws InterruptedException {
        page.misHomePage().dispCard();
        page.exampPage().validateFieldParamWithSpace();
    }

    @Test(groups = "disp", description = "показатели не должны сохраняться с дефолтным пустым полем")
    @RetryCountIfFailed(2)
    public void testDefaultValidationFieldParams() throws InterruptedException {
        page.misHomePage().dispCard();
        page.exampPage().validateDefaultParamWithSpace();
    }

    @Test(groups = "disp", description = "пустое мероприятие не должно промаркироваться, даже если его не раскрыли", enabled = false)
    @RetryCountIfFailed(2)
    public void validateParamNotOpen() throws InterruptedException {
        page.misHomePage().dispCard();
        page.exampPage()
                .switchAllServicesTap()
                .validateParamNotOpen();
    }
    // TODO: 7/2/2019 пока не работает
    // TODO: 14-Feb-19 сделать тест добавление мероприятия на истекшее время. Бекетова 63 года

    @Test(groups = "disp", description = "отображение кнопки просмотреть у мероприятия без маркировок. И подписание")
    @RetryCountIfFailed(2)
    public void validateKallMeasure() throws InterruptedException {
        open("http://192.168.7.24/test/disp;doctorId=2124;doctorGuid=c46f9814-ca4e-4783-af14-cf3278deb0aa;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=4mv%2FQ%2FIyd7PZ5BEqmxjKPtBE7pOFs%2B7Ly51c67wldzPHmnsQt0Ijyo4sY3HeZMk0PvogiIMSgidunJj0MlSNlq0682MswdMHtdWWYGdXxeae6borusURm3SnOWUtO3StxBFV%2Fj87TzEAEnCYzk1cBOl4yOrzbtO%2Bs9bUMvnZM3Q6W0aTHddskTa5pEv6Ttt3Ig4aZhUWjQ64OK3O3owuJ9wycmA59ShmhsLFs8SM2VTBMiYmWvb8GYe86Bta1rXPdvNUQCiL25wbK8fYvivygGg4SiNGowHMbCjlLvbkCYUmdWEInRq9gAcMkGQ5I3Z0SMDfUA%3D%3D/card/467?ticket=4mv%2FQ%2FIyd7PZ5BEqmxjKPtBE7pOFs%2B7Ly51c67wldzPHmnsQt0Ijyo4sY3HeZMk0PvogiIMSgidunJj0MlSNlq0682MswdMHtdWWYGdXxeae6borusURm3SnOWUtO3StxBFV%2Fj87TzEAEnCYzk1cBOl4yOrzbtO%2Bs9bUMvnZM3Q6W0aTHddskTa5pEv6Ttt3Ig4aZhUWjQ64OK3O3owuJ9wycmA59ShmhsLFs8SM2VTBMiYmWvb8GYe86Bta1rXPdvNUQCiL25wbK8fYvivygGg4SiNGowHMbCjlLvbkCYUmdWEInRq9gAcMkGQ5I3Z0SMDfUA%3D%3D&mkabId=0&dvtId=1467230&docPrvdId=2124&MisUrl=http:%2F%2F192.168.7.54%2Ftest&ReturnUrl=http:%2F%2F192.168.7.54%2Ftest%2FSchedule");
        page.exampPage()
                .switchAllServicesTap()
                .openService(issledovanieKala)
                .signService()
                .validateServiceIsSign();
    }

    // TODO: 5/14/2019 сделать проверку задизеблинной кнопки подписать и сохранить у мероприятия при входе через чужую ячейку расписания
    // TODO: 5/14/2019 сделать проверку отсутствующего тапа в заключении терапевта у врача без должности врач
}