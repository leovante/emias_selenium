/**
 * проверяем участки и адреса
 */

package emias.calldoctor.function;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

import static com.codeborne.selenide.Selenide.$;

public class UchastoksAddressTest extends AbstractTestGrid {

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках, один без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokBezDomov() throws IOException, InterruptedException, ParseException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile15");
//        $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок')]")).shouldBe(Condition.visible);
//        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках без домов")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastok_unikDom_3() throws IOException, InterruptedException, ParseException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile16");
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
    public void testUchastok_DomavOboihUchastkah() throws IOException, InterruptedException, ParseException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile17");
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
    public void testUchastok_DomavOboihUchastkah_unikDom() throws IOException, InterruptedException, ParseException {
        enterSite.enterCalldoctor();
        page.createCallPage().createCall("Profile18");
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "test", description = "создаю вызов через СМП с авторизацией по токену, что бы проверить " +
            "что участок определился по адресу вызова, а не мкаб")
    @Epic("Участки")
    @RetryCountIfFailed(2)
    public void testUchastokPoAdresuANeMkab() throws IOException, InterruptedException {
        page.createCallPage().createCall_Api("ProfileAdressNeIzMkab");
        enterSite.enterCalldoctor();
        page.dashboardPage()
                .searchFilterFio_Fam("ProfileAdressNeIzMkab")
                .openNewCallDash("ProfileAdressNeIzMkab");
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
    }
}