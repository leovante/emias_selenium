package emias.disp.base;

import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestDispBase;
import org.testng.annotations.Test;

public class AutonavigationTest extends TestDispBase {

    @Test(groups = "disp", description = "проверка автоскролла бокового меню к блоку заключение при редактировании МЛ", enabled = false)
    @RetryCountIfFailed(2)
    public void testFillExamp1() {
        IPage.misHome().dispCard();
        IPage.exampPage()
                .switchAllServicesTap()
                .zakluchenieMenuBtn()
                .validateZakluchenieBorder();
    }

    @Test(groups = "disp", description = "проверка редиректа к блоку заключение при просмотре МЛ из журнала", enabled = false)
    @RetryCountIfFailed(2)
    public void testFillExamp2() {
        IPage.misHome().dispJournal();
        IPage.journalPage()
                .journalMenuBtn()
                .openCardByNumber(180);
        IPage.exampPage()
                .switchAllServicesTap()
                .zakluchenieMenuBtn()
                .validateZakluchenieBorder();
    }
}