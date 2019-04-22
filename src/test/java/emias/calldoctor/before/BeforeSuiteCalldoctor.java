package emias.calldoctor.before;

import emias.TestBase;
import org.testng.annotations.Test;
import utils.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;

public class BeforeSuiteCalldoctor extends TestBase {

    @Test(description = "Создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() throws IOException, ParseException {
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