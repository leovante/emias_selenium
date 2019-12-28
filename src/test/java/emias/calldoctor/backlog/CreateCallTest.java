package emias.calldoctor.backlog;

import com.commons.except.NoticeException;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.IPacient;
import com.datas.calldoctor.PacientDBImpl;
import com.system.service.HltMkabService;
import com.testRunner.TestNGBase;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class CreateCallTest extends TestNGBase {

    @Qualifier("hltMkabServiceImpl")
    @Autowired
    private HltMkabService hltMkabService;

    @Test(groups = "e2e", description = "пытаюсь взять модель с двумя таблицами", enabled = false)
    @RetryCountIfFailed(2)
    public void testHiber() throws IOException, JSONException, ParseException, InterruptedException, NoticeException {
        IPacient pacientImpl = new PacientDBImpl(hltMkabService);

        IPage.misHome().calldoctorAdminTemnikov();
        IPage.createCall(pacientImpl)
                .createCall_Api();
        IPage.fullCard(pacientImpl, testName())
                .verifyNewCall()
                .closeCardBtn();
        IPage.dashboard().verifyNewCallGroup(pacientImpl);
    }
}