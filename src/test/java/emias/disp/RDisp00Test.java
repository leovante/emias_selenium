package emias.disp;

import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;

public class RDisp00Test extends AbstractTest {

    @Test(groups = "mis", description = "обнуляю карты диспансеризации")
    @RetryCountIfFailed(2)
    public void cleanBeforeDisp() {
        open(curUrlCalldoctor);
        page.homePage().manageSheduleBtn();
        setDefaultCard();
    }

    @Step("Обнуляю карты диспансеризации")
    public void setDefaultCard() {
        ArrayList<String> cardID = new ArrayList<>();
        cardID.add("1837");
        for (String cards : cardID) {
            SQLDemonstration.setDefaultServices(cards);
        }
    }
}