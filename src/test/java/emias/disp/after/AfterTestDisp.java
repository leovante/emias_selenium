package emias.disp.after;

import com.utils.sql.DBScripts;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class AfterTestDisp extends TestBase {

    @Test(description = "Обнуляю карты диспансеризации", enabled = false)
    @RetryCountIfFailed(2)
    public void cleanBeforeDisp() throws IOException, ParseException {
        setDefaultServices();//тестовые ресурсы мероприятий
    }

    @Step("Подготовка мероприятий")
    void setDefaultServices() throws IOException {
        DBScripts.runSqlScript("delete hlt_disp_ServiceDocPrvd.txt");// TODO: 5/16/2019 исправить тут перенести на hibernate
        DBScripts.runSqlScript("default hlt_disp_ServiceDocPrvd_192.168.7.54.txt");
    }
}
