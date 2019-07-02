package emias.callcenter.regress;

import com.pages.calldoctor.pacients.PacientImpl;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingWaitingListTest extends TestBase {

    @org.testng.annotations.Test(groups = "VD", description = "Создание листа ожидания")
    @Epic("листы ожидания")
    @RetryCountIfFailed(2)
    public void testWaitingList() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHomePage().callCenter();
        page.waitingListPage().waitingList(pacientImpl);
    }

}

// TODO: 18.08.2018 сделать пару тестов для проверки кладра (выписать адреса с которыми было много проблем)
// TODO: 29.08.2018 делать проверку на время создания вызова
// TODO: 29.08.2018 сделать тест добавление адреса в адресное пространство