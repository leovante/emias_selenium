package emias.disp.before;

import com.utils.sql.DBScripts;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class BeforeTestDisp extends TestBase {

    @Test(description = "Обнуляю карты диспансеризации")
    @RetryCountIfFailed(2)
    public void cleanBeforeDisp() throws IOException, ParseException {
        setDefaultCard();//обнулить карты
        setTestServices();//тестовые ресурсы мероприятий
        createShedule();//создание нового расписания у врачей
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
//        DBScripts.runSqlScript("delete hlt_disp_ServiceDocPrvd.txt");
//        DBScripts.runSqlScript("insert test hlt_disp_ServiceDocPrvd.txt");
    }

    @Step("Создание расписания для врачей")
    void createShedule() throws FileNotFoundException, ParseException {
//        DBScripts.deleteShedule(2100, 1285);
//        DBScripts.createShedule(2100, 1285);
    }
}