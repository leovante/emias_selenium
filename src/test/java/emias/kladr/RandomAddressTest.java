package emias.kladr;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class RandomAddressTest extends AbstractTestGrid {

    @Test(groups = "kl", description = "рандомный вызов по кладр", enabled = false)
    @Epic("Кладр")
    @RetryCountIfFailed(2)
    public void testCancelCallFrom_Registr() {
        page.createKladr().getAddressString();
        page.createKladr().sendFormalizer();
        page.createKladr().verifyKladrCode();
    }
}