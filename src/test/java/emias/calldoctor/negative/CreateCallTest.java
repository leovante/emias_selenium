package emias.calldoctor.negative;

import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.PacientImpl;
import com.pages.calldoctor.controllers.StAddress;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class CreateCallTest extends TestCallDoctorBase {

    @Test(groups = "CD", description = "сразу при вводе адреса должна быть выпадашка")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testCallRegistrEmpy() {
        PacientImpl pacient = new PacientImpl("Profile1");
        StAddress stAddress = new StAddress(pacient);
        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient).addNewCall();
        stAddress.list_first_container(pacient.getAddress2());
        $x("//input[@placeholder='Адрес']").getValue().contains(pacient.getAddress2());
    }
}