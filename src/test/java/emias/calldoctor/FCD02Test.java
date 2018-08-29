package emias.calldoctor;

import com.codeborne.selenide.Condition;
import emias.AbstractTest;
import emias.testngRetryCount.RetryCountIfFailed;
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
        SQLDemonstration.finalizeAllTestCalls();
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках, один без домов")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testUchastok() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile15", nameGen, "n");
        $(By.xpath("Не удалось однозначно определить участок")).shouldBe(Condition.visible);
        $(By.xpath("#2 Педиатрический")).shouldBe(Condition.visible);
        $(By.xpath("#6 Педиатрический")).shouldBe(Condition.visible);

        $(By.xpath("#1 Гинекологический")).shouldNotBe(Condition.visible);
        $(By.xpath("#3 Участок врача общей практики")).shouldNotBe(Condition.visible);
        $(By.xpath("#4 Терапевтический")).shouldNotBe(Condition.visible);
        $(By.xpath("#5 Дерматологический")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testUchastok_unikDom_3() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile16", nameGen, "n");
        $(By.xpath("#2 Педиатрический")).shouldBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках с домами")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testUchastok_DomavOboihUchastkah() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile17", nameGen, "n");
        $(By.xpath("Не удалось однозначно определить участок")).shouldBe(Condition.visible);
        $(By.xpath("#6 Педиатрический")).shouldBe(Condition.visible);
        $(By.xpath("#2 Педиатрический")).shouldBe(Condition.visible);

        $(By.xpath("#3 Участок врача общей практики")).shouldNotBe(Condition.visible);
        $(By.xpath("#4 Терапевтический")).shouldNotBe(Condition.visible);
        $(By.xpath("#5 Дерматологический")).shouldNotBe(Condition.visible);
    }

    @Test(groups = "CD", description = "проверка окна 'не удалось однозначно определить участок'. Адрес в двух участках с домами")
    @Issue("EMIAS-90")
    @RetryCountIfFailed(2)
    public void testUchastok_DomavOboihUchastkah_unikDom() throws IOException, InterruptedException {
        open(curUrlCalldoctor);
        page.createCallPage().createNewCall("Profile18", nameGen, "n");
        $(By.xpath("Не удалось однозначно определить участок")).shouldBe(Condition.visible);
        $(By.xpath("#6 Педиатрический")).shouldBe(Condition.visible);
        $(By.xpath("#2 Педиатрический")).shouldBe(Condition.visible);

        $(By.xpath("#3 Участок врача общей практики")).shouldNotBe(Condition.visible);
        $(By.xpath("#4 Терапевтический")).shouldNotBe(Condition.visible);
        $(By.xpath("#5 Дерматологический")).shouldNotBe(Condition.visible);
    }
}