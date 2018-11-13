package emias.disp.before;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class BeforeSuiteDisp extends AbstractTestGrid {

    @Test(description = "Обнуляю карты диспансеризации")
    @RetryCountIfFailed(2)
    public void cleanBeforeDisp() throws IOException, ParseException {
        setDefaultCard();
        setTestServices();
        deleteShedule();
        createShedule();
    }

    @Step("Обнуляю карты диспансеризации")
    void setDefaultCard() {
        ArrayList<String> cardID = new ArrayList<>();
        cardID.add("1837");
        cardID.add("2183");
        for (String cards : cardID) {
            SQLDemonstration.setDefaultServices(cards);
        }
    }

    @Step("Подготовка мероприятий")
    void setTestServices() throws IOException {
        SQLDemonstration.runSqlScript("delete hlt_disp_ServiceDocPrvd.txt");
        SQLDemonstration.runSqlScript("insert test hlt_disp_ServiceDocPrvd.txt");
    }

    @Step("Удаляю расписание")
    void deleteShedule() throws FileNotFoundException, ParseException {
        SQLDemonstration.deleteShedule(2100, 1285);
    }

    @Step("Создание расписания для врачей")
    void createShedule() throws FileNotFoundException, ParseException {
        SQLDemonstration.createShedule(2100, 1285);
        System.out.println();
    }
}