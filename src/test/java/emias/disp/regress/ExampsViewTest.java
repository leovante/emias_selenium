package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExampsViewTest extends AbstractTestGrid {

    @Test(groups = "disp", description = "заполнить карту Темников Дмитрий 24 года")
    @RetryCountIfFailed(3)
    public void testFillExamp() {
        open(dispJournal);
        page.exampPage().fillTemnikov();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }
}