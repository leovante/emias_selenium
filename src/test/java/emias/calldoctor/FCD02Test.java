/**
 * проверяем участки и адреса
 */

package emias.calldoctor;

import com.codeborne.selenide.Condition;
import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.utilities.SQLDemonstration;
import pages.utilities.StringGenerator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FCD02Test extends AbstractTest {
    String nameGen;

    @BeforeMethod(groups = {"CD", "test"})
    public void beforeMethod() {
        StringGenerator nameGen = new StringGenerator();
        String name = String.valueOf(nameGen.generator());
        this.nameGen = name;
    }

    @AfterMethod(groups = {"CD", "test"})
    public void afterMethod() {
//        SQLDemonstration.finalizeAllTestCalls();
    }

    @Flaky
    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках, один без домов")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testUchastokBezDomov() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile15", nameGen, "n");
        $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);

        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Flaky
    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testUchastok_unikDom_3() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile16", nameGen, "n");
        $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);

        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Flaky
    @Test(groups = "test", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках с домами")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testUchastok_DomavOboihUchastkah() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile17", nameGen, "n");
        $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldBe(Condition.visible);

        $(By.xpath("//*[contains(text(),'#1 Гинекологический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адреса нет ни в одном из участков")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testUchastok_DomavOboihUchastkah_unikDom() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile18", nameGen, "n");
        $(By.xpath("//*[contains(text(),'Не удалось однозначно определить участок')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#6 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#2 Педиатрический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#3 Участок врача общей практики')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#4 Терапевтический')]")).shouldNotBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'#5 Дерматологический')]")).shouldNotBe(Condition.visible);
    }

    @Flaky
    @Test(groups = "CD", description = "создаю вызов через СМП с авторизацией по токену, что бы проверить " +
            "что участок определился по адресу вызова, а не мкаб")
    @Epic("Создание вызова")
    @RetryCountIfFailed(2)
    public void testUchastokWithCallAdress() throws IOException {
        open(curUrlCalldoctor);
        SQLDemonstration.finalizePacientNumberPol("ProfileDetkinaVGostyah");
        page.createCallPage().createCallProfileDetkinaVGostah();
        page.dashboardPage()
                .searchFilterFio_Fam("ProfileDetkinaVGostyah")
                .openNewCallProgressFrame();
        page.fullCardPage().verifyCallProfileDetkina("ProfileDetkinaVGostyah");
    }
}