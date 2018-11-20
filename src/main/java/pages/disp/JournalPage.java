package pages.disp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class JournalPage extends AbstractPage {
    SelenideElement cardNumber = $(By.xpath("//*[@placeholder='№ Карты']"));
    SelenideElement polNumber = $(By.xpath("//*[@placeholder='Полис: (серия/номер)']"));
    SelenideElement fioField = $(By.xpath("//*[@placeholder='ФИО пациента']"));
    SelenideElement searchBtn = $(By.xpath("//*[@class='zmdi zmdi-search']"));
    SelenideElement journalBtn = $(By.xpath("//*[contains(text(),'Журнал')]"));
    SelenideElement grida = $(By.xpath("//datatable-body-row[@class='datatable-body-row datatable-row-even ng-star-inserted']"));
    SelenideElement oprosMeasure = $(By.xpath("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]"));
    SelenideElement oprosMeasureExamp = $(By.xpath("//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]"));
    SelenideElement MeasureFlura = $(By.xpath("//*[contains(text(),'Флюорография легких')]")).$(By.xpath("../../."));

    public JournalPage() {
    }

    public void journalMenuBtn() {
        journalBtn.click();
    }

    public void searchByCardNumber(int number) {
        cardNumber.val(String.valueOf(number));
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

    public void clickSearchBtn() {
        searchBtn.click();
    }

    public void openCardByPolis(int number) {
        polNumber.val(String.valueOf(number));
        searchBtn.click();
        grida.$(By.xpath(".//*[contains(.,'" + number + "')]")).click();
        grida.$(By.xpath(".//*[@class='zmdi zmdi-edit']")).click();
    }

    public void editCardBtn(int numberPol) {
        $(By.xpath("//datatable-body[@class='datatable-body']")).$(By.xpath(".//div[contains(.,'" + numberPol + "')]")).click();
        $(By.xpath("//datatable-body[@class='datatable-body']")).$(By.xpath(".//*[@mattooltip='Редактировать']")).click();

    }


}