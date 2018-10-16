package emias.calldoctor.function;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;
import java.text.ParseException;

public class CreateCallTestRandom extends AbstractTestGrid {

    @Test(groups = "CD", description = "пустой вызов")
    @Epic("Создание рандомного вызова")
    @RetryCountIfFailed(0)
    public void testCall() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(pacient);
        page.fullCardPage()
                .verifyNewCall(pacient)
                .closeCardBtn();
    }
}

