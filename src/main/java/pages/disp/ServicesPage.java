package pages.disp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ServicesPage extends AbstractPage {
    SelenideElement AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]"));
    SelenideElement MeasureArtPressure = $(By.xpath("//*[contains(text(),'Измерение артериального давления')]")).$(By.xpath("../../."));
    SelenideElement MeasureOpros_Anketirovanie = $(By.xpath("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]")).$(By.xpath("../../."));
    SelenideElement MeasureAntropometriya = $(By.xpath("//*[contains(text(),'Антропометрия (измерение роста стоя, массы тела, окружности талии), расчет индекса массы тела')]")).$(By.xpath("../../."));
    SelenideElement MeasureIndividualnoeProfConsulting = $(By.xpath("//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).$(By.xpath("../../."));

    SelenideElement MeasureOpredelenieLvlGlukozi = $(By.xpath("//*[contains(text(),'Определение уровня глюкозы в крови экспресс-методом (допускается лабораторный метод)')]")).$(By.xpath("../../."));
    SelenideElement MeasureOpredelenieLvlHolesterina = $(By.xpath("//*[contains(text(),'Определение уровня общего холестерина в крови (допускается экспресс-метод)')]")).$(By.xpath("../../."));
    SelenideElement MeasureFlura = $(By.xpath("//*[contains(text(),'Флюорография легких')]")).$(By.xpath("../../."));
    SelenideElement MeasureOpredelenieOtnositelnogoSSR = $(By.xpath("//*[contains(text(),'Определение относительного суммарного сердечно-сосудистого риска')]")).$(By.xpath("../../."));
    SelenideElement MeasureOsmotrTerapevta = $(By.xpath("//*[contains(text(),'Прием (осмотр) врача-терапевта')]")).$(By.xpath("../../."));
    SelenideElement Zakluchenie = $(By.xpath("//*[contains(text(),'Заключение')]"));
    SelenideElement VidOplati = $(By.xpath("//*[@placeholder='Вид оплаты']"));
    SelenideElement CelPosesheniya = $(By.xpath("//*[@placeholder='Цель посещения']"));
    SelenideElement MestoObsluzhivaniya = $(By.xpath("//*[@placeholder='Место обслуживания']"));
    SelenideElement ResultatObrasheniya = $(By.xpath("//*[@placeholder='Результат обращения']"));
    SelenideElement IshodObrashenia = $(By.xpath("//*[@placeholder='Исход обращения']"));
    SelenideElement VrachPishetZakluchenie = $(By.xpath("//*[@placeholder='Врач, который пишет заключение']"));
    SelenideElement PodvalSaveBtn = $(By.xpath("//div[@class='fixed-bottom-panel']")).$(By.xpath(".//*[contains(text(),'Сохранить')]"));
    SelenideElement PodvalPodpisatBtn = $(By.xpath("//div[@class='fixed-bottom-panel']")).$(By.xpath(".//*[contains(text(),'Подписать')]"));

    SelenideElement Alarma_MedZapisUspeshnoSohranena = $(By.xpath(".//*[contains(text(),'Медицинская запись успешно сохранена.')]"));
    SelenideElement Alarma_MedZapisUspeshnoPodpisana = $(By.xpath(".//*[contains(text(),'Медицинская запись успешно подписана.')]"));

    public ServicesPage() {

    }

    public void zapolnenieProfile1() throws InterruptedException {
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
                .fillZakluchenie();
    }

    public ServicesPage switchAllServicesTap() {
        AllServicesTap.click();
        return this;
    }

    public ServicesPage fillMeasureArtPressure() {
//        Thread.sleep(700);
        MeasureArtPressure.hover().click();
//        Thread.sleep(700);
        MeasureArtPressure.$(By.xpath("../..//*[contains(text(),'Показатели')]")).shouldBe(Condition.visible);
        MeasureArtPressure.$(By.xpath("td[4]/mat-checkbox")).hover().click();
//        Thread.sleep(700);
        MeasureArtPressure.hover().click();
        return this;
    }

    public ServicesPage fillMeasureOpros_Anketirovanie() {
//        Thread.sleep(700);
        MeasureOpros_Anketirovanie.hover().click();
//        Thread.sleep(700);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).hover().click();
//        Thread.sleep(700);

        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//tr[@id='84900']"));
//        Thread.sleep(1500);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//div[@class='cursorPointer hide-med-record']")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
//        Thread.sleep(3000);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
//        Thread.sleep(1000);
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
//        Thread.sleep(700);
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureOpros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
//        Thread.sleep(700);
        MeasureOpros_Anketirovanie.hover().click();
        return this;
    }

    public ServicesPage fillAntropometriya() {
//        Thread.sleep(700);
        MeasureAntropometriya.hover().click();
//        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Антропометрия')]")).hover().click();
//        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
//        Thread.sleep(3000);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
//        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
//        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
//        Thread.sleep(700);
        MeasureAntropometriya.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
//        Thread.sleep(700);
        MeasureAntropometriya.hover().click();
        return this;
    }

    public ServicesPage fillIndividProfConsulting() {
//        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.hover().click();
//        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).hover().click();
//        Thread.sleep(700);

        switchTo().frame(MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("multiLineTextTextarea1")).sendKeys("Автотестовая рекомендация");
        switchTo().defaultContent();

        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
//        Thread.sleep(3000);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
//        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
//        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
//        Thread.sleep(700);
        MeasureIndividualnoeProfConsulting.hover().click();
        return this;
    }

    public ServicesPage fillOpredelenieLvlGlukozi() {
//        Thread.sleep(700);
        MeasureOpredelenieLvlGlukozi.click();
//        Thread.sleep(700);
        MeasureOpredelenieLvlGlukozi.$(By.xpath("td[4]/mat-checkbox")).click();
//        Thread.sleep(700);
        MeasureOpredelenieLvlGlukozi.click();
        return this;
    }

    public ServicesPage fillOpredelenieLvlHolesterina() {
//        Thread.sleep(700);
        MeasureOpredelenieLvlHolesterina.click();
//        Thread.sleep(700);
        MeasureOpredelenieLvlHolesterina.$(By.xpath("td[4]/mat-checkbox")).click();
//        Thread.sleep(700);
        MeasureOpredelenieLvlHolesterina.click();
        return this;
    }

    public ServicesPage fillFlurography() {
//        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[2]")).hover();
        MeasureFlura.click();
//        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Результат флюорографии')]")).click();
//        Thread.sleep(700);

        switchTo().frame(MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("singleLineTextInput2")).sendKeys("666");
        switchTo().defaultContent();

//        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
//        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
//        Thread.sleep(700);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
//        Thread.sleep(700);
        MeasureFlura.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
//        Thread.sleep(700);
        MeasureFlura.hover().click();
        return this;
    }

    public ServicesPage fillOpredelenieOtnositSummSSR() {
//        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("../tr[2]")).hover();
        MeasureOpredelenieOtnositelnogoSSR.click();
//        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
//        Thread.sleep(700);
        MeasureOpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public ServicesPage fillPriem_OsmotrTerapevta() {
//        Thread.sleep(700);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[2]")).hover();
        MeasureOsmotrTerapevta.click();
//        Thread.sleep(700);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).hover();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]"))
                .click();
//        Thread.sleep(3000);
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//tbody"))
                .hover();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//button[contains(text(),'Просмотреть')]"))
                .click();
//        Thread.sleep(3000);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//table")).$(By.xpath("../div")).hover();
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
//        Thread.sleep(700);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
//        Thread.sleep(700);
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
//        Thread.sleep(700);
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Без отклонений')]")).click();

//        Thread.sleep(700);
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
                .$(By.xpath(".//*[contains(text(),'01 - ВЫПИСАН')]")).click();
        IshodObrashenia
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        IshodObrashenia
                .$(By.xpath("../."))
                .$(By.xpath(".//*[contains(text(),'01 - ВЫЗДОРОВЛЕНИЕ')]")).click();
        return this;
    }

    public ServicesPage saveBtn() {
        PodvalSaveBtn.click();
        return this;
    }

    public ServicesPage podpisatBtn() {
        PodvalPodpisatBtn.click();
        return this;
    }
}