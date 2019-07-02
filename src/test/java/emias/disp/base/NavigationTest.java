package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class NavigationTest extends TestBase {

    @Test(groups = "disp", description = "проверка автоскролла бокового меню к блоку заключение при редактировании МЛ")
    @RetryCountIfFailed(2)
    public void testFillExamp1() {
        page.misHomePage().dispCard();
        page.exampPage()
                .switchAllServicesTap()
                .zakluchenieMenuBtn()
                .validateZakluchenieBorder();
    }

    @Test(groups = "disp", description = "проверка редиректа к блоку заключение при просмотре МЛ из журнала")
    @RetryCountIfFailed(2)
    public void testFillExamp2() {
        page.misHomePage().dispJournal();
        page.journalPage()
                .journalMenuBtn()
                .openCardByNumber(180);
        page.exampPage()
                .switchAllServicesTap()
                .zakluchenieMenuBtn()
                .validateZakluchenieBorder();
    }
}