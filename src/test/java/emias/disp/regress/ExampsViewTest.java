package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;

public class ExampsViewTest extends TestBase {

    @Test(groups = "disp", description = "заполнить карту Темников Дмитрий 24 года", enabled = false)
    @RetryCountIfFailed(3)
    public void testFillExamp() throws InterruptedException {
        page.loginPage().dispJournal();
        page.exampPage().fillTemnikov();
        $(By.xpath("//*[contains(text(),'(100%)')]")).shouldBe(Condition.visible);
    }
}