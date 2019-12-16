package emias.calldoctor.function;

import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class AddressTest extends TestCallDoctorBase {
    @Test(groups = "CD", description = "вызов от СМП по api от ребенка. Проверяю что адрес подтянулся из вызова.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() {
        Pacient pacient = new PacientImpl("Profile3");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).verifyNewCall();
    }

    @Test(groups = "CD", description = "вызов от СМП по api от взрослого. Проверяю что адрес по кладр.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpAdultKladr() {
        Pacient pacient = new PacientImpl("Profile6");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName())
                .verifyNewCall()
                .editCallBtn();
        $x("//input[@placeholder='Адрес']").getValue().contains(pacient.getAddressStringMin());
    }

    @Test(groups = "CD", description = "проверка заполнения формализованного адреса при выборе мкаб на странице создания вызова")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testFormalizeAddress() {
        Pacient pacient = new PacientImpl("Profile2");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .addNewCall()
                .searchField();
        $x("//*[@placeholder='Адрес']").getText().equals(pacient.getAddress3adv());
    }

    // TODO: 12/13/2019 сделать проверку отображения нескольких вариантов автоформализатора
}