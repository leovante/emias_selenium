package emias.kladr;

import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegressTest extends TestBase {

    @Test(groups = "kl", description = "проверяю что закрытые адреса из кладр формализуются другими нормальными из ФИАС")
    @Epic("Кладр")
    @RetryCountIfFailed(2)
    public void testKladrVSFias() throws IOException, JSONException, InterruptedException {

        //проверка что возвращаются обьекты-дети предыдущего обьекта
        //Московская обл., г. Домодедово,речн
        //сначала вернется улица речная
        //тоже самое, только вместо речной - овражная
        //Московская обл., г. Домодедово, ул. Речная
        //
        //Московская обл., г. Домодедово, ул. Овражная
    }
}