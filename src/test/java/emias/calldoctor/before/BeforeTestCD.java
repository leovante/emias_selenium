package emias.calldoctor.before;

import com.utils.sql.DBScripts;
import com.utils.retryCountListner.RetryCountIfFailed;
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

    /**
     *select de.DepartmentNAME, hl.num, *
     * from hlt_DocPRVD dp
     *        join oms_Department de on de.DepartmentID = dp.rf_DepartmentID
     *        join hlt_HealingRoom hl on dp.rf_HealingRoomID = hl.HealingRoomID
     * where rf_LPUDoctorID in (select LPUDoctorID from hlt_LPUDoctor where FAM_V like 'И%'
     *                                                                 and IM_V like 'Э%'
     *                                                                 and OT_V like 'Д%')
     *   and D_END > getdate()
     * */
    public void updateStend() throws IOException, ParseException {
        Map<Integer, Integer> LPUDoctor = new <Integer, Integer>HashMap();
        LPUDoctor.put(3068, 2123);//Темников Дмитрий
        LPUDoctor.put(1831, 417);//Моков
        LPUDoctor.put(2924, 2091);//Серова
        LPUDoctor.put(1856, 2042);//Немцова
        LPUDoctor.put(3074, 2134);//Гинекологов
        LPUDoctor.put(3078, 2162);//Зайцева
        LPUDoctor.put(3079, 2164);//Юдина
        LPUDoctor.put(3006, 1785);//всякое
        LPUDoctor.put(2937, 2031);//всякое
        LPUDoctor.put(1828, 2102);//всякое
        LPUDoctor.put(3019, 1856);//всякое
        LPUDoctor.put(1891, 558);//всякое
        LPUDoctor.put(2993, 1764);//всякое
        LPUDoctor.put(1822, 1634);//всякое
        LPUDoctor.put(1823, 408);//всякое
        LPUDoctor.put(2949, 1693);//всякое
        LPUDoctor.put(1818, 497);//всякое
        LPUDoctor.put(1812, 401);//всякое
        LPUDoctor.put(1811, 2080);//всякое
        LPUDoctor.put(2950, 1694);//всякое
        LPUDoctor.put(3000, 1778);//всякое
        LPUDoctor.put(2915, 1628);//всякое
        LPUDoctor.put(2920, 1636);//всякое
        LPUDoctor.put(2991, 1768);//всякое
        LPUDoctor.put(1804, 1642);//всякое
        LPUDoctor.put(2897, 2194);//всякое
        LPUDoctor.put(1868, 1902);//всякое
        LPUDoctor.put(2976, 1953);//всякое
        LPUDoctor.put(3022, 1967);//всякое
        LPUDoctor.put(2910, 2189);//всякое
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