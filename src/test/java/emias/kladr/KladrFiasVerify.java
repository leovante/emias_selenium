package emias.kladr;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;

public class KladrFiasVerify extends AbstractTestGrid {

    @Test(groups = "kl", description = "проверяю что закрытые адреса из кладр формализуются другими нормальными из ФИАС")
    @Epic("Кладр")
    @RetryCountIfFailed(2)
    public void testKladrVSFias() throws IOException, JSONException, InterruptedException {
        Thread.sleep(500);
        page.kladr()
                .getAddressStringList()
                .sendToFormalizerAndVerifyFullKLADRCodeAddress()
                .badAddressCanBeEmpty();
    }
}