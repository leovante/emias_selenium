package emias.calldoctor.before;

import emias.AbstractTestGrid;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeforeSuiteCalldoctor extends AbstractTestGrid {
    Map<Integer, Integer> LPUDoctor = new <Integer, Integer>HashMap();

    @Test(description = "Создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void cleanBeforeCallDoctorTests() throws IOException, ParseException {
        LPUDoctor.put(2078, 1220);
        LPUDoctor.put(1958, 1253);
        LPUDoctor.put(2075, 1244);
        LPUDoctor.put(1932, 1249);
        LPUDoctor.put(1941, 1278);
        LPUDoctor.put(2062, 1202);
        Iterator<Map.Entry<Integer, Integer>> it = LPUDoctor.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            SQLDemonstration.deleteShedule(pair.getKey(), pair.getValue());
            SQLDemonstration.createSheduleCD(pair.getKey(), pair.getValue());
        }
    }
}