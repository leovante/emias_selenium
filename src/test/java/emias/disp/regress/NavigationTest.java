package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NavigationTest extends AbstractTestGrid {

    @Test(groups = "disp", description = "проверка редиректа к блоку заключение при редактировании МЛ")
    @RetryCountIfFailed(3)
    public void testFillExamp1() {
        open(DISP_CARD_URL);
        page.exampPage().zakluchenieMenuBtn();
        $(By.xpath("//*[@placeholder='Основной диагноз']")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "проверка редиректа к блоку заключение при просмотре МЛ из журнала")
    @RetryCountIfFailed(3)
    public void testFillExamp2() {
        open(DISP_CARD_URL);
        page.journalPage().journalMenuBtn();
        page.journalPage().openCardByPolis(7654321);
        page.exampPage().zakluchenieMenuBtn();
        $(By.xpath("//*[@placeholder='Основной диагноз']")).shouldBe(Condition.visible);
    }
}