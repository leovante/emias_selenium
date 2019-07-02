package emias.disp.base;

import com.codeborne.selenide.Condition;
import com.utils.testngRetryCount.RetryCountIfFailed;
import emias.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class KvotyTest extends TestBase {

    @Test(groups = "disp", description = "проверка что открываются квоты")
    @RetryCountIfFailed(3)
    public void testSearchCard1() {
        page.misHomePage().dispJournal();
        page.kvotyPage().kvotyBtn();
        $(By.xpath("//*[contains(.,'Квоты диспансеризации')]")).shouldBe(Condition.visible);
    }

    // TODO: 12/14/2018 сделать тест поиск квот
}