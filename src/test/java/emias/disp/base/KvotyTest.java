package emias.disp.base;

import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestBase;
import org.testng.annotations.Test;

public class KvotyTest extends TestBase {
    @Test(groups = "disp", description = "отображение элементов на странице квот")
    @RetryCountIfFailed(2)
    public void testKvotyPageElements(){
        page.misHome().dispJournal();
        page.kvotyPage().kvotyBtn()
                .validKvotyElements();
    }
    // TODO: 12/14/2018 сделать тест поиск квот
}