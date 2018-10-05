package emias.calldoctor.function;

import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.PersonDTO;

import java.io.IOException;
import java.text.ParseException;

public class CreateCallTestRandom extends AbstractTestGrid {

    @DataProvider(name = "random")
    public static Object[][] getClient1Data() {
        return new Object[][]{{"Profile0", "Profile1", "Profile2", "Profile4", "Profile6", "Profile14", "Profile20_2"}};
    }

    @Test(groups = "test", description = "пустой вызов", dataProvider="random")
    @Epic("Создание рандомного вызова")
    @RetryCountIfFailed(0)
    public void testCallRandom(String user) throws IOException, InterruptedException, ParseException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(user);
        page.fullCardPage()
                .verifyNewCall(user)
                .closeCardBtn();
    }

    @Test(groups = "test", description = "пустой вызов")
    @Epic("Создание рандомного вызова")
    @RetryCountIfFailed(0)
    public void testCall(String pacient) throws IOException, InterruptedException, ParseException {
        new PersonDTO();
        enterSite.enterCalldoctor();
        page.createCallPage().createCall(pacient);
        page.fullCardPage()
                .verifyNewCall(pacient)
                .closeCardBtn();
    }
}

