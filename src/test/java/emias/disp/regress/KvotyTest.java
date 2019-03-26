package emias.disp.regress;

import com.codeborne.selenide.Condition;
import emias.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.testngRetryCount.RetryCountIfFailed;

import static com.codeborne.selenide.Selenide.$;

public class KvotyTest extends TestBase {

    @Test(groups = "disp", description = "проверка что открываются квоты")
    @RetryCountIfFailed(3)
    public void testSearchCard1() {
        page.loginPage().dispCard();
        page.kvotyPage().kvotyBtn();
        $(By.xpath("//*[contains(.,'Квоты диспансеризации')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "проверка что открываются квоты на странице просмотра карты")
    @RetryCountIfFailed(3)
    public void testSearchCard2() throws InterruptedException {
        page.loginPage().dispJournal();
        page.kvotyPage().kvotyBtn();
        $(By.xpath("//*[contains(text(),'Квоты диспансеризации')]")).shouldBe(Condition.visible);
    }
    // TODO: 12/14/2018 сделать тест поиск квот
}