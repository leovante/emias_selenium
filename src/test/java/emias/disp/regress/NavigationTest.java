package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NavigationTest extends AbstractTestGrid {

    @Test(groups = "disp", description = "проверка редиректа к блоку заключение при редактировании МЛ")
    @RetryCountIfFailed(3)
    public void testFillExamp1() {
        open(dispProfile);
        page.exampPage().zakluchenieMenuBtn();
        $(By.xpath("//*[@placeholder='Основной диагноз']")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "проверка редиректа к блоку заключение при просмотре МЛ из журнала")
    @RetryCountIfFailed(3)
    public void testFillExamp2() {
        open(dispProfile);
        page.journalPage().journalMenuBtn();
        page.journalPage().openCardByPolis(7654321);
        page.exampPage().zakluchenieMenuBtn();
        $(By.xpath("//*[@placeholder='Основной диагноз']")).shouldBe(Condition.visible);
    }
}