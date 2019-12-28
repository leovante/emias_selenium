package emias.kladr;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class RegressTest extends TestNGBase {

    @Test(groups = "kl", description = "проверяю что закрытые адреса из кладр формализуются другими нормальными из ФИАС")
    @Epic("Кладр")
    @RetryCountIfFailed(2)
    public void testKladrVSFias() {

        //проверка что возвращаются обьекты-дети предыдущего обьекта
        //Московская обл., г. Домодедово,речн
        //сначала вернется улица речная
        //тоже самое, только вместо речной - овражная
        //Московская обл., г. Домодедово, ул. Речная
        //
        //Московская обл., г. Домодедово, ул. Овражная
    }
}