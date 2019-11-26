package com.pages.disp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.pages.WebPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.lib.assistance.Assistance.placeholder;
import static com.lib.assistance.Assistance.visible;

public class JournalPage extends WebPage implements JournalPageElem{
    SelenideElement cardNumberFiled = $x("//*[@placeholder='№ Карты']");
    SelenideElement pol_nField = $(By.xpath("//*[@placeholder='Полис: (серия/номер)']"));
    SelenideElement fioField = $(By.xpath("//*[@placeholder='ФИО пациента']"));
    SelenideElement searchBtn = $(By.xpath("//*[@class='zmdi zmdi-search search-icon']"));
    SelenideElement journalBtn = $(By.xpath("//*[contains(text(),'Журнал')]"));
    SelenideElement kvotyBtn = $x("//*[contains(text(),'Квоты')]");
    SelenideElement grida = $x("//datatable-body-row[@class='datatable-body-row datatable-row-even ng-star-inserted']");
    SelenideElement grida2 = $x("//datatable-body[@class='datatable-body']");
    SelenideElement openCard = $(By.xpath("//datatable-body[@class='datatable-body']")).$(By.xpath(".//*[@mattooltip='Просмотр']"));
    SelenideElement closeCard = $(By.xpath("//datatable-body[@class='datatable-body']")).$(By.xpath(".//*[@mattooltip='Закрыть']"));
    SelenideElement oprosMeasure = $(By.xpath("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]"));
    SelenideElement oprosMeasureExamp = $(By.xpath("//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]"));
    SelenideElement MeasureFlura = $(By.xpath("//*[contains(text(),'Флюорография легких')]")).$(By.xpath("../../."));

    public JournalPage()  {
    }

    public JournalPage journalMenuBtn() {
        journalBtn.click();
        return this;
    }

    public JournalPage searchByCardNumber(int number) {
        cardNumberFiled.val(String.valueOf(number));
        return this;
    }

    public void searchByPolNumber(int number) {
        pol_nField.val(String.valueOf(number));
    }

    public void fioIsVisible(String fio) {
        $x("//datatable-body[@class='datatable-body']").$x(".//*[contains(.,'" + fio + "')]").shouldBe(Condition.visible);
    }

    public void searchByFio(String fio) {
        fioField.val(String.valueOf(fio));
    }

    public JournalPage clickSearchBtn() {
        searchBtn.click();
        return this;
    }

    public JournalPage openCardByPolis(int number) {
        pol_nField.val(String.valueOf(number));
        searchBtn.click();
        grida.$x(".//*[contains(.,'" + number + "')]").click();
        openCard.click();
        return this;
    }

    public JournalPage openCardByNumber(int number) {
        cardNumberFiled.val(String.valueOf(number));
        searchBtn.click();
        grida.click();
        openCard.click();
        return this;
    }

    public JournalPage editCardBtn(int numberPol) {
        grida2.$x(".//div[contains(.,'" + numberPol + "')]").click();
        openCard.click();
        return this;
    }

    public JournalPage closeCardBtn(int numberPol) {
        grida2.$x(".//div[contains(.,'" + numberPol + "')]").click();
        closeCard.click();
        return this;
    }

    public JournalPage setCloseReasonDeath() {
        grida2.$x(".//*[contains(text(),'Причина закрытия')]").click();
        $x("//*[contains(text(),'Смерть')]").click();
        return this;
    }

    public JournalPage setCloseReasonDescription() {
        grida2.$x(".//*[@placeholder='Примечание']").val("Подавился печенькой");
        return this;
    }

    public JournalPage closeCard2() {
        $x("//*[contains(text(),'Закрыть')]").click();
        $x("//*[contains(text(),'Карта подписана')]").shouldBe(Condition.visible);
        return this;
    }

    public JournalPage changeCardStatus_toClosed() {
        $x("//*[@aria-label='Статус карты']").click();
//        $x("//*[contains(text(),'Статус карты')]").click();
        $x("//*[contains(text(),'Закрытая')]").click();
        return this;
    }

    public JournalPage validJournalElements(){
        visible(placeholder(numMkab));
        visible(placeholder(polis));
        visible(allCreateCard);
        visible(placeholder(dispType));
        visible(kvoty);
        visible(planGraph);
        return this;
    }
}