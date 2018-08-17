package pages.dispAngular;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class ServicesPage extends AbstractPage {
    SelenideElement AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]"));
    SelenideElement MeasureArtPressure = $(By.id("be884e59-2883-40a4-8033-4508a0ccb3ac"));
    SelenideElement MeasureOpros_Anketirovanie = $(By.id("beccc8c1-33b3-4ed0-8c0b-22f78b792769"));

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

    public ServicesPage fillAntropometriya() {
        return this;
    }

    public ServicesPage fillIndividProfConsulting() {
        return this;
    }

    public ServicesPage fillOpredelenieLvlGlukozi() {
        return this;
    }

    public ServicesPage fillOpredelenieLvlHolesterina() {
        return this;
    }

    public ServicesPage fillFlurography() {
        return this;
    }

    public ServicesPage fillOpredelenieOtnositSummSSR() {
        return this;
    }

    public ServicesPage fillPriem_OsmotrTerapevta() {
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