package emias.disp.before;

import com.utils.sql.DBScripts;
import com.utils.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Step;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Ignore
public class BeforeTestDisp extends TestBase {

    @Test(description = "Подготовка БД")//сделано тестом что бы запускать отдельно
    @RetryCountIfFailed(2)
    public void run() throws IOException, ParseException {
        setDefaultCard();//обнулить карты
//        setTestServices();//тестовые ресурсы мероприятий
//        createShedule();//создание нового расписания у врачей
    }

    @Step("Обнуляю карты диспансеризации")
    void setDefaultCard() {
        ArrayList<String> cardID = new ArrayList<>();
        cardID.add("3059");
        for (String cards : cardID) {
            DBScripts.setDefaultServices(cards);
        }
    }

    @Step("Подготовка мероприятий")
    void setTestServices() throws IOException {
        DBScripts.runSqlScript("delete hlt_disp_ServiceDocPrvd.txt");// TODO: 5/16/2019 исправить тут перенести на hibernate
        DBScripts.runSqlScript("test hlt_disp_ServiceDocPrvd_192.168.7.54.txt");
    }

    @Step("Создание расписания для врачей")
    void createShedule() throws FileNotFoundException, ParseException {
        Map<Integer, Integer> LPUDoctor = new <Integer, Integer>HashMap();
        LPUDoctor.put(3075, 2137);

        Iterator<Map.Entry<Integer, Integer>> it = LPUDoctor.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            DBScripts.deleteShedule(pair.getKey(), pair.getValue());
            DBScripts.createShedule(pair.getKey(), pair.getValue());
        }
    }
}