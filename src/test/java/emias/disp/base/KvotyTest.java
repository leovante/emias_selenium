package emias.disp.base;

import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestDispBase;
import org.testng.annotations.Test;

public class KvotyTest extends TestDispBase {
    @Test(groups = "disp", description = "отображение элементов на странице квот")
    @RetryCountIfFailed(2)
    public void testKvotyPageElements(){
        IPage.misHome().dispJournal();
        IPage.kvotyPage().kvotyBtn()
                .validKvotyElements();
    }
    // TODO: 12/14/2018 сделать тест поиск квот
}