package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.commons.assistance.DuringTestHelper;
import com.commons.retryCountListner.RetryCountIfFailed;
import com.datas.calldoctor.Pacient;
import com.datas.calldoctor.PacientImpl;
import emias.TestCallDoctorBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class UchastoksAddressTest extends TestCallDoctorBase {

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках, один без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokBezDomov() {
        Pacient pacient = new PacientImpl("Profile15");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall()
                .selectUchastokFromNeUdalosOpredelit();
        $x("//*[contains(text(),'2-й Педиатрический')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'6-й Педиатрический')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_unikDom_3() {
        Pacient pacient = new PacientImpl("Profile16");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall()
                .selectUchastokFromNeUdalosOpredelit();
        $x("//*[contains(text(),'2-й Педиатрический')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'6-й Педиатрический')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'1-й Гинекологический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'3-й Участок врача общей практики')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'4-й Терапевтический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'5-й Дерматологический')]").shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках с домами")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_DomavOboihUchastkah() {
        Pacient pacient = new PacientImpl("Profile17");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall()
                .selectUchastokFromNeUdalosOpredelit();
        $x("//*[contains(text(),'2-й Педиатрический')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'6-й Педиатрический')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'1-й Гинекологический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'3-й Участок врача общей практики')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'4-й Терапевтический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'5-й Дерматологический')]").shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адреса нет ни в одном из участков")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_DomavOboihUchastkah_unikDom() {
        Pacient pacient = new PacientImpl("Profile18");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.misHome().calldoctorAdminTemnikov();
        page.createCall(pacient)
                .createCall()
                .selectUchastokFromNeUdalosOpredelit();
        $x("//*[contains(text(),'#6 Педиатрический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'#2 Педиатрический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'#3 Участок врача общей практики')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'#4 Терапевтический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'#5 Дерматологический')]").shouldNotBe(Condition.visible);
    }

    @Epic("Участки")
    @RetryCountIfFailed(2)
    @Test(groups = "CD",
            description = "авторизованный вызов от СМП, участок определился по адресу вызова, а не мкаб")
    public void testUchastokPoAdresuANeMkab() {
        Pacient pacient = new PacientImpl("ProfileAdressNeIzMkab");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.createCall(pacient).createCall_Api_Auth();
        page.misHome().calldoctorAdminTemnikov();
        page.dashboard()
                .dashFilter_fio(pacient)
                .openNewCallDash(pacient);
        $x("//*[contains(text(),'Интернет')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'2-й Педиатрический')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП, что бы проверить " +
            "что участок не проставляется, если адрес неформализованный")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokNotSet() {
        Pacient pacient = new PacientImpl("ProfileAdressNeIzMkab_neformal");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.createCall(pacient).createCall_Api();
        page.misHome().calldoctorAdminTemnikov();
        page.dashboard()
                .dashFilter_fio(pacient)
                .openNewCallDash(pacient);
        $x("//*[contains(text(),'Участок')]").shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "не отображать участок у вызова с неформализованным адресом")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokWithNullID() {
        Pacient pacient = new PacientImpl("Profile0_3_1");
        new DuringTestHelper().beforeCleanDecider(pacient);

        page.createCall(pacient).createCall_Api();
        page.misHome().calldoctorAdminTemnikov();
        page.dashboard().openNewCallDash(pacient);
        $x("//*[contains(text(),'КТО ОБСЛУЖИВАЕТ')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'Участок')]").shouldNotBe(Condition.visible);
    }
    // TODO: 12/3/2018 сделать тест проверки списка участков при привязке адреса к участку на педиатр/взрослый
}