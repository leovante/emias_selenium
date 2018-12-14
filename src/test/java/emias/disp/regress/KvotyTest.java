package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class KvotyTest extends AbstractTestGrid {

    @Test(groups = "disp", description = "проверка что открываются квоты")
    @RetryCountIfFailed(3)
    public void testSearchCard1() {
        open(dispProfile);
        page.kvotyPage().kvotyBtn();
        $(By.xpath("//*[contains(.,'Квоты диспансеризации')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "проверка что открываются квоты на странице просмотра карты")
    @RetryCountIfFailed(3)
    public void testSearchCard2() {
        open(dispJournal);
        page.kvotyPage().kvotyBtn();
        $(By.xpath("//*[contains(text(),'Квоты диспансеризации')]")).shouldBe(Condition.visible);
    }

    // TODO: 12/14/2018 сделать тест поиск квот
}