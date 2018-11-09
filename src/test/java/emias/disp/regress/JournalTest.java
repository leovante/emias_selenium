package emias.disp.regress;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import emias.AbstractTestGrid;
import emias.testngRetryCount.RetryCountIfFailed;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JournalTest extends AbstractTestGrid {
    SelenideElement grida = $(By.xpath("//datatable-body-row[@class='datatable-body-row datatable-row-even ng-star-inserted']"));

    @Test(groups = "disp", description = "поиск карты по номеру")
    @RetryCountIfFailed(3)
    public void testSearchCard1() {
        open(dispProfile);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(3059);
        page.journalPage().clickSearchBtn();
        grida.$(By.xpath(".//*[contains(.,'Темников Дмитрий Олегович')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "поиск карты по полису")
    @RetryCountIfFailed(3)
    public void testSearchCard2() {
        open(dispProfile);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByPolNumber(7654321);
        page.journalPage().clickSearchBtn();
        grida.$(By.xpath(".//*[contains(.,'Темников Дмитрий Олегович')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "поиск карты по ФИО")
    @RetryCountIfFailed(3)
    public void testSearchCard3() {
        open(dispProfile);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByFio("Темников Дмитрий Олегович");
        page.journalPage().clickSearchBtn();
        grida.$(By.xpath(".//*[contains(.,'Темников Дмитрий Олегович')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "поиск карты по номеру")
    @RetryCountIfFailed(3)
    public void testSearchCard4() {
        open(dispJournal);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByCardNumber(3059);
        page.journalPage().clickSearchBtn();
        grida.$(By.xpath(".//*[contains(.,'Темников Дмитрий Олегович')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "поиск карты по полису")
    @RetryCountIfFailed(3)
    public void testSearchCard5() {
        open(dispJournal);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByPolNumber(7654321);
        page.journalPage().clickSearchBtn();
        grida.$(By.xpath(".//*[contains(.,'Темников Дмитрий Олегович')]")).shouldBe(Condition.visible);
    }

    @Test(groups = "disp", description = "поиск карты по ФИО")
    @RetryCountIfFailed(3)
    public void testSearchCard6() {
        open(dispJournal);
        page.journalPage().journalMenuBtn();
        page.journalPage().searchByFio("Темников Дмитрий Олегович");
        page.journalPage().clickSearchBtn();
        grida.$(By.xpath(".//*[contains(.,'Темников Дмитрий Олегович')]")).shouldBe(Condition.visible);
    }
}