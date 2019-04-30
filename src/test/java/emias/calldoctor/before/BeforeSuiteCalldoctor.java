package emias.calldoctor.before;

import com.system.service.DoctorTimeTableService;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class BeforeSuiteCalldoctor extends TestBase {

    @Autowired
    DoctorTimeTableService doctorTimeTableService;

    @Test(description = "Создаю новое расписание на сегодня")
    @RetryCountIfFailed(2)
    public void beforeCallDoctorTest() throws IOException, ParseException {
        System.out.println(doctorTimeTableService.deleteShedule(1831, 417));

/*
        Map<Integer, Integer> LPUDoctor = new <Integer, Integer>HashMap();
        int LPUDoctorID, int DocPRVDID
        LPUDoctor.put(2078, 1220);//Темников Дмитрий
        LPUDoctor.put(1831, 417);//Моков
        LPUDoctor.put(2924, 1641);//Серова
        LPUDoctor.put(1856, 2036);//Немцова
        LPUDoctor.put(3074, 2134);//Гинекологов
        LPUDoctor.put(1941, 1005);//Юдина
        LPUDoctor.put(2062, 1202);//Зайцева
        Iterator<Map.Entry<Integer, Integer>> it = LPUDoctor.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            DBScripts.deleteShedule(pair.getKey(), pair.getValue());
            DBScripts.createSheduleCD(pair.getKey(), pair.getValue());
        }
*/
    }
}