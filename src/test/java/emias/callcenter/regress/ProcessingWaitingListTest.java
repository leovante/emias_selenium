package emias.callcenter.regress;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.PacientImpl;
import com.testRunner.TestNGBase;
import io.qameta.allure.Epic;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;


public class ProcessingWaitingListTest extends TestNGBase {

    @org.testng.annotations.Test(groups = "VD", description = "Создание листа ожидания")
    @Epic("листы ожидания")
    @RetryCountIfFailed(2)
    public void testWaitingList() throws IOException, InterruptedException, ParseException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("Profile0");
        page.misHome().callCenter();
        page.waitingListPage().waitingList(pacientImpl);
    }

}