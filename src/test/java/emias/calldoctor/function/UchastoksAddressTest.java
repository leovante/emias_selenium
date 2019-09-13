package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.datas.calldoctor.PacientImpl;
import com.lib.calldoctor.UchastokValidator;
import com.utils.except.NoticeException;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UchastoksAddressTest extends TestBase {

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках, один без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokBezDomov() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile15");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .selectUchastokFromNeUdalosOpredelit();
        $x("//*[contains(text(),'2-й Педиатрический')]").shouldBe(Condition.visible);
        $x("//*[contains(text(),'6-й Педиатрический')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_unikDom_3() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile16");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
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
    public void testUchastok_DomavOboihUchastkah() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile17");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
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
    public void testUchastok_DomavOboihUchastkah_unikDom() throws IOException, InterruptedException, JSONException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile18");
        page.misHome().calldoctor();
        page.createCall(pacientImpl)
                .createCall()
                .selectUchastokFromNeUdalosOpredelit();
        $x("//*[contains(text(),'#6 Педиатрический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'#2 Педиатрический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'#3 Участок врача общей практики')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'#4 Терапевтический')]").shouldNotBe(Condition.visible);
        $x("//*[contains(text(),'#5 Дерматологический')]").shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП, что бы проверить " +
            "что участок определился по адресу вызова, а не мкаб")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokPoAdresuANeMkab() throws IOException, InterruptedException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("ProfileAdressNeIzMkab");
        page.createCall(pacientImpl).createCall_Api();
        page.misHome().calldoctor();
        page.dashboard()
                .searchFilterFio_Fam(pacientImpl)
                .openNewCallDash(pacientImpl);
        page.createCall(pacientImpl).selectUchastokFromNeUdalosOpredelit();
        $x("//*[contains(text(),'#2 Педиатрический')]").shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП, что бы проверить " +
            "что участок не проставляется, если адрес неформализованный")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokNotSet() throws IOException, InterruptedException, JSONException {
        PacientImpl pacientImpl = new PacientImpl("ProfileAdressNeIzMkab_neformal");
        page.createCall(pacientImpl).createCall_Api();
        page.misHome().calldoctor();
        page.dashboard()
                .searchFilterFio_Fam(pacientImpl)
                .openNewCallDash(pacientImpl);
        $(By.xpath("//*[contains(text(),'Участок')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "не отображать участок у вызова с неформализованным адресом")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokWithNullID() throws IOException, InterruptedException, JSONException, ParseException, NoticeException {
        PacientImpl pacientImpl = new PacientImpl("Profile0_3_1");
        page.createCall(pacientImpl).createCall_Api();
        page.misHome().calldoctor();
        page.dashboard().openNewCallDash(pacientImpl);
        $(By.xpath("//*[contains(text(),'КТО ОБСЛУЖИВАЕТ')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'Участок')]")).shouldNotBe(Condition.visible);
    }
    // TODO: 12/3/2018 сделать тест проверки списка участков при привязке адреса к участку на педиатр/взрослый
}