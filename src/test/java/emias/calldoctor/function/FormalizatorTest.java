package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.commons.assistance.Assistance.visible;

public class FormalizatorTest extends TestBase {

    @Test(groups = "CD", description = "проверка заполнения неформализованного адреса при выборе мкаб на странице создания вызова")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testNotformalizeAddress() {
        Pacient pacient = new PacientImpl("AdressNeformal");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .addNewCall()
                .searchField();
        visible(pacient.getAddress());
    }

    @Test(groups = "CD", description = "вызов от СМП по api с неформализованным адресом. Проверка окна формализации при назначении врача.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void smpChildMkab_dontChoseDoctor_neformalAddress() {
        Pacient pacient = new PacientImpl("Profile19");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).createCall_Api();
        page.dashboard().openNewCallDash(pacient);
        page.fullCard(pacient, testName()).chooseDoctorBtn();

        $x("//*[contains(text(),'Производится попытка формализации адреса')]")
                .shouldBe(Condition.visible);
        sleep(2000);
        $x("//mat-form-field")
                .$x(".//*[contains(text(),'" + pacient.getAddress() + "')]")
                .shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "вызов по мкаб из мис. Адрес неформал. Проверка окна формализации при назначении врача.")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void misNeformalAddress_dontChangeDoctor() {
        Pacient pacient = new PacientImpl("AdressNeformal");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall_Mkab();

        page.fullCard(pacient, testName()).chooseDoctorBtn();
        $x("//*[contains(text(),'Производится попытка формализации адреса')]")
                .shouldBe(Condition.visible);
        sleep(2000);
        $x("//mat-form-field")
                .$x(".//*[contains(text(),'" + pacient.getAddress() + "')]")
                .shouldBe(Condition.visible);
    }
}