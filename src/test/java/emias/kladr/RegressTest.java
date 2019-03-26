package emias.kladr;

import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;

public class RegressTest extends TestBase {

    @org.testng.annotations.Test(groups = "kl", description = "проверяю что закрытые адреса из кладр формализуются другими нормальными из ФИАС")
    @Epic("Кладр")
    @RetryCountIfFailed(2)
    public void testKladrVSFias() throws IOException, JSONException, InterruptedException {

        //проверка что возвращаются обьекты-дети предыдущего обьекта
        //Московская обл., г. Домодедово,речн
        //сначала вернется улица речная
        //тоже самое, только вместо речной - овражная

    }
}