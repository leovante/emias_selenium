package emias.kladr;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

public class KladrFiasVerify extends AbstractTestGrid {

    @Test(groups = "kl", description = "рандомный вызов по кладр", enabled = false)
    @Epic("Кладр")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr() {
        page.createKladr().getAddressString();//беру адрес из базы в виде стринги
        page.createKladr().sendFormalizer();//отправляю в фиас и получаю ответ в формализованном виде
        page.createKladr().verifyKladrCode();//сверяю коды кладр с фиас
    }
}