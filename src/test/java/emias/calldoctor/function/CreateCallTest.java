package emias.calldoctor.function;

import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.IPacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.commons.assistance.Assistance.visible;

public class CreateCallTest extends TestCallDoctorBase {

    @Test(groups = "CD", description = "поиск мкаб по серии")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void searchMkabBySeries() {
        IPacient pacient = new PacientImpl("Profile2_3_mkab");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall_Mkab();
        page.fullCard(pacient, testName())
                .verifyNewCall()
                .closeCardBtn();
        page.dashboard()
                .verifyNewCallGroup(pacient);
    }
}