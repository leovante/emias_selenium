package emias.disp.before;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.commons.sql.DBScripts;
import com.system.service.HltDispExamMrServiceImpl;
import com.system.service.HltDispExamServiceImpl;
import com.system.service.HltDispServiceDocPrvdServiceImpl;
import emias.TestDispBase;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class BeforeTestDisp extends TestDispBase {
    @Autowired
    public HltDispExamServiceImpl hltDispExamService;

    @Autowired
    public HltDispExamMrServiceImpl hltDispExamMrService;

    @Autowired
    public HltDispServiceDocPrvdServiceImpl hltDispServiceDocPrvdService;

    @Test(description = "Подготовка БД")//сделано тестом что бы запускать отдельно
    @RetryCountIfFailed(2)
    public void run() {
//        cleanTestCard();
        createShedule();//создание нового расписания у врачей
//        setTestServices();//тестовые ресурсы мероприятий
//        setDefaultCard();//обнулить карты
    }

    @Step("Подготовка мероприятий")
    private void setTestServices() {
        hltDispServiceDocPrvdService.deleteAllDocPrvd();
        hltDispServiceDocPrvdService.addDocPrvd();
//        DBScripts.runSqlScript("delete hlt_disp_ServiceDocPrvd.txt");// TODO: 5/16/2019 исправить тут перенести на hibernate
//        DBScripts.runSqlScript("test hlt_disp_ServiceDocPrvd_192.168.7.54.txt");
    }

    @Step("Создание расписания для врачей")
    private void createShedule() {
        Map<Integer, Integer> LPUDoctor = new <Integer, Integer>HashMap();
        LPUDoctor.put(3075, 2137);
        for (Map.Entry<Integer, Integer> pair : LPUDoctor.entrySet()) {
            DBScripts.deleteShedule(pair.getKey(), pair.getValue());
            DBScripts.createSheduleDisp(pair.getKey(), pair.getValue());
        }
    }

    @Step("Очистка тестовой карты диспансеризации")
    private void cleanTestCard() {
//        hltDispCardService.open(418);
        hltDispExamService.resetCardExams(418);
        hltDispExamMrService.delete(418);
//        hltDispExamSmService.delete();
//        DBScripts.runSqlScript("clear_card");
        // TODO: 10/31/2019 сделать очистку карты полностью на репозитории
    }
}