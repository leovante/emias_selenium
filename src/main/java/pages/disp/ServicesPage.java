package pages.disp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ServicesPage extends AbstractPage {
    SelenideElement AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]"));
    SelenideElement MeasureArtPressure = $(By.id("be884e59-2883-40a4-8033-4508a0ccb3ac"));
    SelenideElement MeasureOpros_Anketirovanie = $(By.id("beccc8c1-33b3-4ed0-8c0b-22f78b792769"));
    SelenideElement MeasureAntropometriya = $(By.id("25f46d44-4c68-4c4f-a335-44598a650311"));
    SelenideElement MeasureIndividualnoeProfConsulting = $(By.id("a8025542-603e-41b2-aa0d-0eb21c5d2a79"));
    SelenideElement IFrameIndividualnoeProfConsulting = $(By.xpath("//*[contains(text(),'/test/disp/disp_ui/webmis/api/ehr/medicalrecords/3eee9c96-13b0-48aa-966b-ee9abe4a6092/editview')]"));

    SelenideElement MeasureOpredelenieLvlGlukozi = $(By.id("943965b9-7193-465f-9d8f-8a8be0d4c1f6"));
    SelenideElement MeasureOpredelenieLvlHolesterina = $(By.id("060c0f05-72d1-45b7-ba3c-a05cb4681dc5"));
    SelenideElement MeasureFlura = $(By.id("b4a9f405-b61a-45eb-a2bb-2421ce2dbf23"));
    SelenideElement MeasureOpredelenieOtnositelnogoSSR = $(By.id("0356c7d1-bd48-48dd-ae8f-cbb8db035a5e"));
    SelenideElement MeasureOsmotrTerapevta = $(By.id("bf064816-995c-4720-a2e6-c6b016faa9dd"));
    SelenideElement Zakluchenie = $(By.xpath("//*[contains(text(),'Заключение')]"));
    SelenideElement VidOplati = $(By.xpath("//*[@placeholder='Вид оплаты']"));
    SelenideElement CelPosesheniya = $(By.xpath("//*[@placeholder='Цель посещения']"));
    SelenideElement MestoObsluzhivaniya = $(By.xpath("//*[@placeholder='Место обслуживания']"));
    SelenideElement ResultatObrasheniya = $(By.xpath("//*[@placeholder='Результат обращения']"));
    SelenideElement IshodObrashenia = $(By.xpath("//*[@placeholder='Исход обращения']"));
    SelenideElement VrachPishetZakluchenie = $(By.xpath("//*[@placeholder='Врач, который пишет заключение']"));

    public ServicesPage() {

    }

    public void fillProfile1() {
        switchAllServicesTap()
//                .fillMeasureArtPressure()
//                .fillMeasureOpros_Anketirovanie()
//                .fillAntropometriya()
//                .fillIndividProfConsulting()
//                .fillOpredelenieLvlGlukozi()
//                .fillOpredelenieLvlHolesterina()
//                .fillFlurography()
//                .fillOpredelenieOtnositSummSSR()
//                .fillPriem_OsmotrTerapevta()
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
        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover();
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

        switchTo().frame(MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("multiLineTextTextarea1")).sendKeys("Автотестовая рекомендация");
        switchTo().defaultContent();

        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(3000);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
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
        MeasureFlura.$(By.xpath("../tr[2]")).hover();
        MeasureFlura.click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Результат флюорографии')]")).click();
        Thread.sleep(700);

        switchTo().frame(MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("singleLineTextInput2")).sendKeys("666");
        switchTo().defaultContent();

        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Thread.sleep(700);
        MeasureFlura.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Thread.sleep(700);
        MeasureFlura.hover().click();
        return this;
    }

    public ServicesPage fillOpredelenieOtnositSummSSR() throws InterruptedException {
        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("../tr[2]")).hover();
        MeasureOpredelenieOtnositelnogoSSR.click();
        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public ServicesPage fillPriem_OsmotrTerapevta() throws InterruptedException {
        Thread.sleep(700);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[2]")).hover();
        MeasureOsmotrTerapevta.click();
        Thread.sleep(700);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).hover();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]"))
                .click();
        Thread.sleep(3000);
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//tbody"))
                .hover();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//button[contains(text(),'Просмотреть')]"))
                .click();
        Thread.sleep(3000);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//table")).$(By.xpath("../div")).hover();
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Thread.sleep(700);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Thread.sleep(700);
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]"))
                .click();
        /*диагнозы*/
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div[2]"))
                .$(By.xpath(".//*[contains(text(),'add')]")).click();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[2]"))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[2]"))
                .$(By.xpath(".//*[contains(text(),'1 - Предварительный')]")).click();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[3]"))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[3]"))
                .$(By.xpath(".//*[contains(text(),'2 - Установлено ранее')]")).click();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[4]"))
                .$(By.xpath(".//*[@placeholder = 'undefined']")).val("J20.1");
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[4]"))
                .$(By.xpath(".//*[contains(text(),'J20.1 - Острый бронхит, вызванный Haemophilus influenzae [палочкой Афанасьева-Пфейффера]')]")).click();
        /*услуги*/
        Thread.sleep(700);
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Без отклонений')]")).click();

        Thread.sleep(700);
        MeasureOsmotrTerapevta.hover();
        MeasureOsmotrTerapevta.click();
        return this;
    }

    public ServicesPage fillZakluchenie() {
        Zakluchenie
                .$(By.xpath("../../conclusion"))
                .hover();
        Zakluchenie
                .$(By.xpath("../../conclusion"))
                .$(By.xpath(".//div[contains(text(),'низкий')]")).click();
//        Zakluchenie
//                .$(By.xpath("../../conclusion"))
//                .$(By.xpath(".//div[3][contains(text(),'I группа')]")).click();
//        Zakluchenie
//                .$(By.xpath("../../conclusion"))
//                .$(By.xpath(".//div[4][contains(text(),'да')]")).click();
//        Zakluchenie
//                .$(By.xpath("../../conclusion"))
//                .$(By.xpath(".//div[5][contains(text(),'да')]")).click();
//        Zakluchenie
//                .$(By.xpath("../../conclusion"))
//                .$(By.xpath(".//div[6][contains(text(),'да')]")).click();
//        Zakluchenie
//                .$(By.xpath("../../conclusion"))
//                .$(By.xpath(".//div[7][contains(text(),'да')]")).click();
//        Zakluchenie
//                .$(By.xpath("../../conclusion"))
//                .$(By.xpath(".//div[8][contains(text(),'да')]")).click();
//        Zakluchenie
//                .$(By.xpath("../../conclusion"))
//                .$(By.xpath(".//div[9][contains(text(),'да')]")).click();

        VrachPishetZakluchenie.hover();
        VidOplati
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        VidOplati
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'ОМС')]")).click();
        CelPosesheniya
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        CelPosesheniya
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'1 - Заболевание')]")).click();
        MestoObsluzhivaniya
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        MestoObsluzhivaniya
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'1 - Поликлиника')]")).click();
        ResultatObrasheniya
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        ResultatObrasheniya
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'01 - Выписан')]")).click();
        ResultatObrasheniya
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        ResultatObrasheniya
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'01 - Выписан')]")).click();
        return this;
    }

    public ServicesPage saveBtn() {
        return this;
    }

    public ServicesPage podpisatBtn() {
        return this;
    }
}