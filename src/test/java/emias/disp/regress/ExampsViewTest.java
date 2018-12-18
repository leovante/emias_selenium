package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;

public class ExampsViewTest extends AbstractTestGrid {

    @Test(groups = "disp", description = "заполнить карту Темников Дмитрий 24 года", enabled = false)
    @RetryCountIfFailed(3)
    public void testFillExamp() throws InterruptedException {
        enter.enterDispJournalFromMis();
        page.exampPage().fillTemnikov();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }
}