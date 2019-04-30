package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import com.pages.calldoctor.pacients.Pacient;
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

public class UchastoksAddressTest extends TestBase {

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках, один без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokBezDomov() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile15");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .selectUchastokFromNeUdalosOpredelit();
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_unikDom_3() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile16");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        page.createCallPage(pacient).selectUchastokFromNeUdalosOpredelit();
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках с домами")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_DomavOboihUchastkah() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile17");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn()
                .selectUchastokFromNeUdalosOpredelit();
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адреса нет ни в одном из участков")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_DomavOboihUchastkah_unikDom() throws IOException, InterruptedException, ParseException, JSONException, NoticeException {
        Pacient pacient = new Pacient("Profile18");
        page.loginPage().calldoctor();
        page.createCallPage(pacient)
                .createCall()
                .saveBtn();
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП, что бы проверить " +
            "что участок определился по адресу вызова, а не мкаб")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokPoAdresuANeMkab() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("ProfileAdressNeIzMkab");
        page.createCallPage(pacient).createCall_Api();
        page.loginPage().calldoctor();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .openNewCallDash(pacient);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "создаю вызов через СМП, что бы проверить " +
            "что участок не проставляется, если адрес неформализованный")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokNotSet() throws IOException, InterruptedException, JSONException {
        Pacient pacient = new Pacient("ProfileAdressNeIzMkab_neformal");
        page.createCallPage(pacient).createCall_Api();
        page.loginPage().calldoctor();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .openNewCallDash(pacient);
        $(By.xpath("//*[contains(text(),'Участок')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "не отображать участок у вызова с неформализованным адресом")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokWithNullID() throws IOException, InterruptedException, JSONException, ParseException, NoticeException {
        Pacient pacient = new Pacient("Profile0_3");
        page.createCallPage(pacient).createCall_Api();
        page.loginPage().calldoctor();
        page.createCallPage(pacient).createCall_Mkab();
        page.fullCardPage(pacient, testName())
                .verifyNewCall(pacient);
        $(By.xpath("//*[contains(text(),'Участок')]")).shouldNotBe(Condition.visible);
    }
    // TODO: 12/3/2018 сделать тест проверки списка участков при привязке адреса к участку на педиатр/взрослый
}