package emias.calldoctor.steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {

    @Когда("^открываем open yandex.ru$")
    public void открываемOpenYandexRu() {
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
}
