package emias.disp;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;

public class RDisp00Test extends AbstractTest {

    @Test(groups = "mis", description = "Обнуляю карты диспансеризации")
    @RetryCountIfFailed(2)
    public void cleanBeforeDisp() throws FileNotFoundException {
        open(curUrlCalldoctor);
        page.homePage().manageSheduleBtn();
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
            SQLDemonstration.setDefaultServices(cards);
        }
    }

    @Step("Подготовка мероприятий")
    public void setTestServices() throws FileNotFoundException {
        SQLDemonstration.runSqlScript("delete default hlt_disp_ServiceDocPrvd.txt");
        SQLDemonstration.runSqlScript("insert test hlt_disp_ServiceDocPrvd.txt");
    }

    @Step("Создание расписания для врачей")
    public void createShedule() throws FileNotFoundException {
        SQLDemonstration.deleteSheduleByPrvdid("1285");
        SQLDemonstration.createShedule("1285");
    }
}