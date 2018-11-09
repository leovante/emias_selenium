package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExampsFillTest extends AbstractTestGrid {

    @Test(groups = "disp", description = "проверка что мероприятия открываются корректно")
    @RetryCountIfFailed(3)
    public void testFillExamp() {
        open(dispProfile);
        page.exampPage().fillTemnikov();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }
    // TODO: 04.09.2018 для второго этапа добавить карту женщины 30 лет что бы в мероприятиях был врач окушер фельдшер. Т.к. там есть заключение
}