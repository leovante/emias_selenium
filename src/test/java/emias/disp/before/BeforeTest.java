package emias.disp.before;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class BeforeTest extends AbstractTestGrid {

    @Test(description = "Обнуляю карты диспансеризации")
    @RetryCountIfFailed(2)
    public void cleanBeforeDisp() throws FileNotFoundException, ParseException {
//        setDefaultCard();
//        setTestServices();
        createShedule();
    }

//    @Step("Обнуляю карты диспансеризации")
//    void setDefaultCard() {
//        ArrayList<String> cardID = new ArrayList<>();
//        cardID.add("1837");
//        cardID.add("2183");
//        for (String cards : cardID) {
//            SQLDemonstration.setDefaultServices(cards);
//        }
//    }
//
//    @Step("Подготовка мероприятий")
//    void setTestServices() throws FileNotFoundException {
//        SQLDemonstration.runSqlScript("delete hlt_disp_ServiceDocPrvd.txt");
//        SQLDemonstration.runSqlScript("insert test hlt_disp_ServiceDocPrvd.txt");
//    }

    @Step("Создание расписания для врачей")
    void createShedule() throws FileNotFoundException, ParseException {
//        SQLDemonstration.deleteSheduleByPrvdid("1285");
        SQLDemonstration.createShedule(2100, 1285);
        System.out.println();
    }
}