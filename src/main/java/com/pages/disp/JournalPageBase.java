package com.pages.disp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class JournalPageBase extends PageBase {
    SelenideElement cardNumber = $(By.xpath("//*[@placeholder='№ Карты']"));
    SelenideElement polNumber = $(By.xpath("//*[@placeholder='Полис: (серия/номер)']"));
    SelenideElement fioField = $(By.xpath("//*[@placeholder='ФИО пациента']"));
    SelenideElement searchBtn = $(By.xpath("//*[@class='zmdi zmdi-search']"));
    SelenideElement journalBtn = $(By.xpath("//*[contains(text(),'Журнал')]"));
    SelenideElement grida = $(By.xpath("//datatable-body-row[@class='datatable-body-row datatable-row-even ng-star-inserted']"));
    SelenideElement grida2 = $(By.xpath("//datatable-body[@class='datatable-body']"));
    SelenideElement openCard = $(By.xpath("//datatable-body[@class='datatable-body']")).$(By.xpath(".//*[@mattooltip='Просмотр']"));
    SelenideElement closeCard = $(By.xpath("//datatable-body[@class='datatable-body']")).$(By.xpath(".//*[@mattooltip='Закрыть']"));
    SelenideElement oprosMeasure = $(By.xpath("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]"));
    SelenideElement oprosMeasureExamp = $(By.xpath("//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]"));
    SelenideElement MeasureFlura = $(By.xpath("//*[contains(text(),'Флюорография легких')]")).$(By.xpath("../../."));

    public JournalPageBase() {
    }

    public JournalPageBase journalMenuBtn() {
        journalBtn.click();
        return this;
    }

    public JournalPageBase searchByCardNumber(int number) {
        cardNumber.val(String.valueOf(number));
        return this;
    }

    public void searchByPolNumber(int number) {
        polNumber.val(String.valueOf(number));
    }

    public void fioIsVisible(String fio) {
        $(By.xpath("//datatable-body[@class='datatable-body']")).$(By.xpath(".//*[contains(.,'" + fio + "')]")).shouldBe(Condition.visible);
    }

    public void searchByFio(String fio) {
        fioField.val(String.valueOf(fio));
    }

    public JournalPageBase clickSearchBtn() {
        searchBtn.click();
        return this;
    }

    public void openCardByPolis(int number) {
        polNumber.val(String.valueOf(number));
        searchBtn.click();
        grida.$(By.xpath(".//*[contains(.,'" + number + "')]")).click();
        openCard.click();
    }

    public JournalPageBase editCardBtn(int numberPol) {
        grida2.$(By.xpath(".//div[contains(.,'" + numberPol + "')]")).click();
        openCard.click();
        return this;
    }

    public JournalPageBase closeCardBtn(int numberPol) {
        grida2.$(By.xpath(".//div[contains(.,'" + numberPol + "')]")).click();
        closeCard.click();
        return this;
    }

    public JournalPageBase setCloseReasonDeath() {
        grida2.$(By.xpath(".//div[contains(.,'Причины закрытия')]")).click();
        $(By.xpath(".//div[contains(.,'Смерть')]")).click();
        return this;
    }

    public JournalPageBase setCloseReasonDescription() {
        grida2.$(By.xpath(".//*[@placeholder='Примечание']")).val("Подавился печенькой");
        return this;
    }

    public JournalPageBase closeCard2() {
        $(By.xpath("//*[text()='Закрыть']")).click();
        return this;
    }

    public JournalPageBase changeCardStatus_toClosed() {
        $(By.xpath("//*[text()='Статус карты']")).click();
        $(By.xpath("//*[text()='Закрытая']")).click();
        return this;
    }
}