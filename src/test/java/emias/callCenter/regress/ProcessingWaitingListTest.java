package emias.callCenter.regress;

import emias.AbstractTestGrid;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;
import utilities.testngRetryCount.RetryCountIfFailed;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingWaitingListTest extends AbstractTestGrid {

    @Test(groups = "VD", description = "Создание листа ожидания")
    @Epic("листы ожидания")
    @RetryCountIfFailed(2)
    public void testWaitingList() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile0");
        enterSite.enterCallCenter();
        page.waitingListPage().waitingList(pacient);
    }

}

// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 29.08.2018 делать проверку на время создания вызова
// TODO: 29.08.2018 сделать тест добавление адреса в адресное пространство