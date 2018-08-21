package emias.calldoctor.steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import emias.AbstractTest;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs extends AbstractTest {

    @Когда("^открываем open yandex.ru$")
    public void открываемOpenYandexRu() throws Throwable {
        open("ya.ru");
    }

    @И("^в поле поиска вводим \"([^\"]*)\"$")
    public void вПолеПоискаВводим(String arg0) {
        $(By.id("text")).setValue(arg0);
    }

    @Тогда("^в результатах поиска появляется ссылка на клип Бритнис Спирс \"([^\"]*)\"$")
    public void вРезультатахПоискаПоявляетсяСсылкаНаКлипБритнисСпирс(String arg0) {
        $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).shouldBe(Condition.visible);
    }





    @And("^enter \"([^\"]*)\"$")
    public void enter(String arg0) throws Throwable {
        $(By.id("text")).setValue(arg0);
    }

    @Then("^shows \"([^\"]*)\"$")
    public void shows(String arg0) throws Throwable {
        $(By.xpath("//*[contains(text(),'" + arg0 + "')]")).shouldBe(Condition.visible);
    }

    @When("^open site \"([^\"]*)\"$")
    public void openSite(String arg0) throws Throwable {
        open(arg0);
    }
}
