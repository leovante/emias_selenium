package emias.calldoctor.before;

import com.utils.sql.DBScripts;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeforeTestCD extends TestBase {

    @Test(description = "Создаю новое расписание на сегодня")//сделано тестом что бы запускать отдельно
    @RetryCountIfFailed(2)
    public void run() throws IOException, ParseException {
        updateStend();
        cleanOperatorCalls();
        doctorsPreset();
    }

    public void updateStend() throws IOException, ParseException {
        Map<Integer, Integer> LPUDoctor = new <Integer, Integer>HashMap();
        LPUDoctor.put(3068, 2123);//Темников Дмитрий
        LPUDoctor.put(1831, 417);//Моков
        LPUDoctor.put(2924, 2091);//Серова
        LPUDoctor.put(1856, 2042);//Немцова
        LPUDoctor.put(3074, 2134);//Гинекологов
        LPUDoctor.put(3078, 2162);//Зайцева
        LPUDoctor.put(3079, 2164);//Юдина
        Iterator<Map.Entry<Integer, Integer>> it = LPUDoctor.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            DBScripts.deleteShedule(pair.getKey(), pair.getValue());
            DBScripts.createSheduleCD(pair.getKey(), pair.getValue());
        }
    }

    public void cleanOperatorCalls() {
        DBScripts.finalizeCallsOperatorTemnikov();
    }

    public void doctorsPreset() {

    }
}