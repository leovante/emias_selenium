package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.sql.SQLDemonstration;
import utilities.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExampsFillTest extends AbstractTestGrid {

    @Test(groups = "disp", description = "проверка заполнения мероприятий М24")
    @RetryCountIfFailed(3)
    public void testFillExamp() throws InterruptedException {
        SQLDemonstration.setDefaultServices("3169");
        open(dispProfile);
        page.exampPage().fillTemnikov();
        $(By.xpath("//div[@mattooltip='Процент завершенности диспансеризации'][contains(.,'(100%)')]")).shouldBe(Condition.visible);
        page.exampPage().saveBtn();
        page.exampPage().podpisatBtn();
    }
    // TODO: 04.09.2018 для второго этапа добавить карту женщины 30 лет что бы в мероприятиях был врач окушер фельдшер. Т.к. там есть заключение
}