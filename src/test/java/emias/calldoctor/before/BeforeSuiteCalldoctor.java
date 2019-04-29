package emias.calldoctor.before;

import com.codeborne.selenide.Condition;
import emias.TestBase;
import org.testng.annotations.Test;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.LogManager;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
public class BeforeSuiteCalldoctor extends TestBase {
    LogManager manager = LogManager.getLogManager();

    @Test(description = "Создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() throws IOException, ParseException {
        open("http://yandex.ru");
        $x("//*[contains(text(),'Сейчас ищут')]").shouldBe(Condition.visible);

        /*Map<Integer, Integer> LPUDoctor = new <Integer, Integer>HashMap();
        //int LPUDoctorID, int DocPRVDID
        LPUDoctor.put(2078, 1220);//Темников Дмитрий
        LPUDoctor.put(1958, 1205);//Моков
        LPUDoctor.put(2075, 1196);//Серова
        LPUDoctor.put(1932, 1217);//Немцова
        LPUDoctor.put(1941, 1005);//Юдина
        LPUDoctor.put(2062, 1202);//Зайцева
        Iterator<Map.Entry<Integer, Integer>> it = LPUDoctor.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            DBScripts.deleteShedule(pair.getKey(), pair.getValue());
            DBScripts.createSheduleCD(pair.getKey(), pair.getValue());
        }*/
    }
}