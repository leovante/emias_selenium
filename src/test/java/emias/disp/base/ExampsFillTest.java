package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import emias.TestDispBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class ExampsFillTest extends TestDispBase {

    @Test(groups = "disp", description = "проверка заполнения мероприятий М24", enabled = false)//
    @RetryCountIfFailed(2)
    public void testFillExamp()  {
//        DBScripts.setDefaultServices("3169");
        page.misHome().dispCard();
        page.exampPage().fillTemnikov();
        $(By.xpath("//div[@mattooltip='Процент завершенности диспансеризации'][contains(.,'(100%)')]")).shouldBe(Condition.visible);
        page.exampPage().saveBtn();
        page.exampPage().podpisatBtn();
    }


    // TODO: 04.09.2018 для второго этапа добавить карту женщины 30 лет что бы в мероприятиях был врач окушер фельдшер. Т.к. там есть заключение
}