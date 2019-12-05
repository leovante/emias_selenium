package emias.kladr;

import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class KladrFiasVerify extends TestBase {

    @Test(groups = "kl", description = "проверяю что закрытые адреса из кладр формализуются другими нормальными из ФИАС")
    @Epic("Кладр")
    @RetryCountIfFailed(2)
    public void testKladrVSFias() {
        sleep(250);
        page.kladr()
                .getAddressStringList()
                .sendToFormalizerAndVerifyFullKLADRCodeAddress()
                .badAddressCanBeEmpty();
    }
}