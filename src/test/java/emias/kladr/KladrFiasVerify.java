package emias.kladr;

import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class KladrFiasVerify extends TestBase {

    @Test(groups = "kl", description = "проверяю что закрытые адреса из кладр формализуются другими нормальными из ФИАС")
    @Epic("Кладр")
    @RetryCountIfFailed(2)
    public void testKladrVSFias() throws IOException, JSONException, InterruptedException {
        Thread.sleep(250);
        page.kladr()
                .getAddressStringList()
                .sendToFormalizerAndVerifyFullKLADRCodeAddress()
                .badAddressCanBeEmpty();
    }
}