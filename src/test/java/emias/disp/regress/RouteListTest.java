package emias.disp.regress;

import emias.TestBase;
import org.testng.annotations.Test;
import utils.testngRetryCount.RetryCountIfFailed;

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
    // TODO: 4/17/2019 проверить отображение кнопки просмотреть у мероприятия исследование кала на скрытую кровь http://192.168.7.24/test/disp;doctorId=2124;doctorGuid=c46f9814-ca4e-4783-af14-cf3278deb0aa;doctorTypeGuid=81d86a3b-2c5a-44b0-8ef9-48e34fbce21d;ticket=4mv%2FQ%2FIyd7PZ5BEqmxjKPtBE7pOFs%2B7Ly51c67wldzPHmnsQt0Ijyo4sY3HeZMk0PvogiIMSgidunJj0MlSNlq0682MswdMHtdWWYGdXxeae6borusURm3SnOWUtO3StxBFV%2Fj87TzEAEnCYzk1cBOl4yOrzbtO%2Bs9bUMvnZM3Q6W0aTHddskTa5pEv6Ttt3Ig4aZhUWjQ64OK3O3owuJ9wycmA59ShmhsLFs8SM2VTBMiYmWvb8GYe86Bta1rXPdvNUQCiL25wbK8fYvivygGg4SiNGowHMbCjlLvbkCYUmdWEInRq9gAcMkGQ5I3Z0SMDfUA%3D%3D/card/467?ticket=4mv%2FQ%2FIyd7PZ5BEqmxjKPtBE7pOFs%2B7Ly51c67wldzPHmnsQt0Ijyo4sY3HeZMk0PvogiIMSgidunJj0MlSNlq0682MswdMHtdWWYGdXxeae6borusURm3SnOWUtO3StxBFV%2Fj87TzEAEnCYzk1cBOl4yOrzbtO%2Bs9bUMvnZM3Q6W0aTHddskTa5pEv6Ttt3Ig4aZhUWjQ64OK3O3owuJ9wycmA59ShmhsLFs8SM2VTBMiYmWvb8GYe86Bta1rXPdvNUQCiL25wbK8fYvivygGg4SiNGowHMbCjlLvbkCYUmdWEInRq9gAcMkGQ5I3Z0SMDfUA%3D%3D&mkabId=0&dvtId=1467230&docPrvdId=2124&MisUrl=http:%2F%2F192.168.7.54%2Ftest&ReturnUrl=http:%2F%2F192.168.7.54%2Ftest%2FSchedule 
}