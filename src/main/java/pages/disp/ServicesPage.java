package pages.disp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class ServicesPage extends AbstractPage {
    SelenideElement AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]"));
    SelenideElement MeasureArtPressure = $(By.id("be884e59-2883-40a4-8033-4508a0ccb3ac"));
    SelenideElement MeasureOpros_Anketirovanie = $(By.id("beccc8c1-33b3-4ed0-8c0b-22f78b792769"));
    SelenideElement MeasureAntropometriya = $(By.id("25f46d44-4c68-4c4f-a335-44598a650311"));
    SelenideElement MeasureIndividualnoeProfConsulting = $(By.id("a8025542-603e-41b2-aa0d-0eb21c5d2a79"));
    SelenideElement MeasureOpredelenieLvlGlukozi = $(By.id("943965b9-7193-465f-9d8f-8a8be0d4c1f6"));
    SelenideElement MeasureOpredelenieLvlHolesterina = $(By.id("060c0f05-72d1-45b7-ba3c-a05cb4681dc5"));
    SelenideElement MeasureFlura = $(By.id("b4a9f405-b61a-45eb-a2bb-2421ce2dbf23"));
    SelenideElement MeasureOpredelenieOtnositelnogoSSR = $(By.id("0356c7d1-bd48-48dd-ae8f-cbb8db035a5e"));

    public ServicesPage() {

    }

    public void fillProfile1() throws InterruptedException {
        switchAllServicesTap()
                .fillMeasureArtPressure()
                .fillMeasureOpros_Anketirovanie()
                .fillAntropometriya()
                .fillIndividProfConsulting()
                .fillOpredelenieLvlGlukozi()
                .fillOpredelenieLvlHolesterina()
                .fillFlurography()
                .fillOpredelenieOtnositSummSSR()
                .fillPriem_OsmotrTerapevta()
                .fillZakluchenie()
                .saveBtn();
    }

    public ServicesPage switchAllServicesTap() {
        AllServicesTap.click();
        return this;
    }

    public ServicesPage fillMeasureArtPressure() throws InterruptedException {
        Thread.sleep(700);
        MeasureArtPressure.click();
        Thread.sleep(700);
        MeasureArtPressure.$(By.xpath("td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureArtPressure.click();
        return this;
    }

    public ServicesPage fillMeasureOpros_Anketirovanie() throws InterruptedException {
        Thread.sleep(700);
        MeasureOpros_Anketirovanie.hover();
        MeasureOpros_Anketirovanie.click();
        Thread.sleep(700);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).click();
        Thread.sleep(700);
        // TODO: 17.08.2018 сделать переключение на iframe пока не удалось
        //        SelenideElement frame = $(By.xpath("//iframe[@src='/test/disp/disp_ui/webmis/api/ehr/medicalrecords/95a0f83b-36d4-498e-bd10-e9d3fc3e8916/editview']"));
        //        switchTo().frame(frame);
        //        $(By.xpath("//*[contains(text(),'1. Говорил ли Вам врач когда-либо, что у Вас имеется')]")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//tr[@id='84900']"));
        Thread.sleep(1500);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//div[@class='cursorPointer hide-med-record']")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(3000);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Thread.sleep(700);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).click();
        Thread.sleep(700);
        MeasureOpros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureOpros_Anketirovanie.hover();
        MeasureOpros_Anketirovanie.click();
        return this;
    }

    public ServicesPage fillAntropometriya() throws InterruptedException {
        Thread.sleep(700);
        MeasureAntropometriya.hover();
        MeasureAntropometriya.click();
        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Антропометрия')]")).hover();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Антропометрия')]")).click();
        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(3000);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).click();
        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("./td[4]/mat-checkbox")).hover();
        MeasureAntropometriya.$(By.xpath("./td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureAntropometriya.hover();
        MeasureAntropometriya.click();
        return this;
    }

    public ServicesPage fillIndividProfConsulting() throws InterruptedException {
        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.hover();
        MeasureIndividualnoeProfConsulting.click();
        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).click();
        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.$(By.id("multiLineText1")).hover();
        MeasureIndividualnoeProfConsulting.$(By.id("multiLineTextTextarea1")).sendKeys("Тестовая рекомендацтя");
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(3000);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).click();
        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.hover();
        MeasureIndividualnoeProfConsulting.click();
        return this;
    }

    public ServicesPage fillOpredelenieLvlGlukozi() throws InterruptedException {
        Thread.sleep(700);
        MeasureOpredelenieLvlGlukozi.click();
        Thread.sleep(700);
        MeasureOpredelenieLvlGlukozi.$(By.xpath("td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureOpredelenieLvlGlukozi.click();
        return this;
    }

    public ServicesPage fillOpredelenieLvlHolesterina() throws InterruptedException {
        Thread.sleep(700);
        MeasureOpredelenieLvlHolesterina.click();
        Thread.sleep(700);
        MeasureOpredelenieLvlHolesterina.$(By.xpath("td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureOpredelenieLvlHolesterina.click();
        return this;
    }

    public ServicesPage fillFlurography() throws InterruptedException {
        Thread.sleep(700);
        MeasureFlura.hover();
        MeasureFlura.click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Результат флюорографии')]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Результат флюорографии')]")).click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(3000);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("./td[4]/mat-checkbox")).hover();
        MeasureFlura.$(By.xpath("./td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureFlura.hover();
        MeasureFlura.click();
        return this;
    }

    public ServicesPage fillOpredelenieOtnositSummSSR() throws InterruptedException {
        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.click();
        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public ServicesPage fillPriem_OsmotrTerapevta() throws InterruptedException {
        Thread.sleep(700);
        MeasureFlura.hover();
        MeasureFlura.click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]")).click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(3000);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("./td[4]/mat-checkbox")).hover();
        MeasureFlura.$(By.xpath("./td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureFlura.hover();
        MeasureFlura.click();
        return this;
    }

    public ServicesPage fillZakluchenie() {
        return this;
    }

    public ServicesPage saveBtn() {
        return this;
    }

    public ServicesPage podpisatBtn() {
        return this;
    }
}