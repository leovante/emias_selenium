package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.IPacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.commons.assistance.Assistance.visible;

public class AddressTest extends TestCallDoctorBase {
    @Test(groups = "CD", description = "вызов от СМП по api от ребенка. Проверяю что адрес подтянулся из вызова.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallSmpChildMkab() {
        IPacient pacient = new PacientImpl("Profile3");
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
        IPacient pacient = new PacientImpl("Profile6");
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
        IPacient pacient = new PacientImpl("Profile2");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .addNewCall()
                .searchField();
        $x("//*[@placeholder='Адрес']").getText().equals(pacient.getAddress3adv());
    }

    @Test(groups = "CD", description = "вызов по мкаб из мис. Адрес неформал. Проверка окна формализации при назначении врача.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void verifyCoupleFormalizatorAddress() {
        IPacient pacient = new PacientImpl("AdressNeformal2");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome()
                .calldoctorAdminTemnikov();
        page.createCall(pacient)
                .addNewCall()
                .searchField();
        visible("Идентифицировать адрес не удалось");
        visible($x("//*[contains(text(),'Красноярский край., Манский р-н, с/с Первоманский, снт Родничок ав дорога Байкал М-53 д Кускун')]"));
        visible($x("//*[contains(text(),'Красноярский край., Манский р-н, с/с Первоманский, снт Родничок ав дорога Байкал М-53 д Кускун, ул Крайняя')]"));
    }
}