package emias.disp;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.sql.DemonstrationDB;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RDisp00Test extends AbstractTestGrid {

    @Test(description = "Обнуляю карты диспансеризации")
    @RetryCountIfFailed(2)
    public void cleanBeforeDisp() throws FileNotFoundException {
        setDefaultCard();
        setTestServices();
        createShedule();
    }

    @Step("Обнуляю карты диспансеризации")
    public void setDefaultCard() {
        ArrayList<String> cardID = new ArrayList<>();
        cardID.add("1837");
        cardID.add("2183");
        for (String cards : cardID) {
            DemonstrationDB.setDefaultServices(cards);
        }
    }

    @Step("Подготовка мероприятий")
    public void setTestServices() throws FileNotFoundException {
        DemonstrationDB.runSqlScript("delete hlt_disp_ServiceDocPrvd.txt");
        DemonstrationDB.runSqlScript("insert test hlt_disp_ServiceDocPrvd.txt");
    }

    @Step("Создание расписания для врачей")
    public void createShedule() throws FileNotFoundException {
        DemonstrationDB.deleteSheduleByPrvdid("1285");
        DemonstrationDB.createShedule("1285");
    }
}