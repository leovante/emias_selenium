package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.commons.retryCountListner.RetryCountIfFailed;
import emias.TestDispBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class ExampsViewTest extends TestDispBase {

    @Test(groups = "disp", description = "заполнить карту Темников Дмитрий 24 года", enabled = false)
    @RetryCountIfFailed(2)
    public void testFillExamp()  {
        page.misHome().dispJournal();
        page.exampPage().fillTemnikov();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }


}