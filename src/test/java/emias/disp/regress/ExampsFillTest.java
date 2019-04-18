package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.TestBase;
import org.openqa.selenium.By;
import utils.sql.DBScripts;
import utils.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;

public class ExampsFillTest extends TestBase {

    @org.testng.annotations.Test(groups = "disp", description = "проверка заполнения мероприятий М24")
    @RetryCountIfFailed(3)
    public void testFillExamp() throws InterruptedException {
        DBScripts.setDefaultServices("3169");
        page.loginPage().dispCard();
        page.exampPage().fillTemnikov();
        $(By.xpath("//div[@mattooltip='Процент завершенности диспансеризации'][contains(.,'(100%)')]")).shouldBe(Condition.visible);
        page.exampPage().saveBtn();
        page.exampPage().podpisatBtn();
    }
    // TODO: 04.09.2018 для второго этапа добавить карту женщины 30 лет что бы в мероприятиях был врач окушер фельдшер. Т.к. там есть заключение
}