package emias.disp.base;

import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import org.testng.annotations.Test;

public class AutonavigationTest extends TestBase {

    @Test(groups = "disp", description = "проверка автоскролла бокового меню к блоку заключение при редактировании МЛ", enabled = false)
    @RetryCountIfFailed(2)
    public void testFillExamp1() {
        page.misHome().dispCard();
        page.exampPage()
                .switchAllServicesTap()
                .zakluchenieMenuBtn()
                .validateZakluchenieBorder();
    }

    @Test(groups = "disp", description = "проверка редиректа к блоку заключение при просмотре МЛ из журнала", enabled = false)
    @RetryCountIfFailed(2)
    public void testFillExamp2() {
        page.misHome().dispJournal();
        page.journalPage()
                .journalMenuBtn()
                .openCardByNumber(180);
        page.exampPage()
                .switchAllServicesTap()
                .zakluchenieMenuBtn()
                .validateZakluchenieBorder();
    }
}