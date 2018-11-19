/**
 * проверяем участки и адреса
 */

package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import utilities.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.calldoctor.profiles_interfaces.Pacient;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class UchastoksAddressTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках, один без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokBezDomov() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile15");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage()
                .createCall(pacient)
                .selectUchastokFromNeUdalosOpredelit();
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_unikDom_3() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile16");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.createCallPage().selectUchastokFromNeUdalosOpredelit();
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
    public void testUchastok_DomavOboihUchastkah() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile17");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
        page.createCallPage().selectUchastokFromNeUdalosOpredelit();
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
    public void testUchastok_DomavOboihUchastkah_unikDom() throws IOException, InterruptedException, ParseException, JSONException {
        Pacient pacient = new Pacient("Profile18");
        enterSite.enterCalldoctorFromMis();
        page.createCallPage().createCall(pacient);
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
        page.createCallPage().createCall_Api(pacient);
        enterSite.enterCalldoctorFromMis();
        page.dashboardPage()
                .searchFilterFio_Fam(pacient)
                .openNewCallDash(pacient);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
    }
}