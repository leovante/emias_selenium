package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class NavigationTest extends TestBase {

    @Test(groups = "disp", description = "проверка редиректа к блоку заключение при редактировании МЛ")
    @RetryCountIfFailed(3)
    public void testFillExamp1() {
        page.loginPage().dispCard();
        page.exampPage().zakluchenieMenuBtn();
        $(By.xpath("//*[@placeholder='Основной диагноз']")).shouldBe(Condition.visible);
    }

    @org.testng.annotations.Test(groups = "disp", description = "проверка редиректа к блоку заключение при просмотре МЛ из журнала")
    @RetryCountIfFailed(3)
    public void testFillExamp2() {
        page.loginPage().dispCard();
        page.journalPage().journalMenuBtn();
        page.journalPage().openCardByPolis(7654321);
        page.exampPage().zakluchenieMenuBtn();
        $(By.xpath("//*[@placeholder='Основной диагноз']")).shouldBe(Condition.visible);
    }
}