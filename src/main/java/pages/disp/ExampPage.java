package pages.disp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ExampPage extends AbstractPage {
    SelenideElement AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]"));
    SelenideElement MeasureArtPressure = $(By.xpath("//*[contains(text(),'Измерение артериального давления')]")).$(By.xpath("../../."));
    SelenideElement MeasureOpros_Anketirovanie = $(By.xpath("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]")).$(By.xpath("../../."));
    SelenideElement MeasureAntropometriya = $(By.xpath("//div[contains(text(),'Антропометрия (измерение роста стоя, массы тела, окружности талии), расчет индекса массы тела')]")).$(By.xpath("../../."));
    SelenideElement MeasureIndividualnoeProfConsulting = $(By.xpath("//div[contains(text(),'Индивидуальное профилактическое консультирование')]")).$(By.xpath("../../."));
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

    public ExampPage() {

    }

    public void fillTemnikov() {
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

    public ExampPage switchAllServicesTap() {
        AllServicesTap.click();
        return this;
    }

    public ExampPage fillMeasureArtPressure() {
        MeasureArtPressure.hover().click();
        MeasureArtPressure.$(By.xpath("../..//*[contains(text(),'Показатели')]")).shouldBe(Condition.visible);
        MeasureArtPressure.$(By.xpath("td[4]/mat-checkbox")).hover().click();
        MeasureArtPressure.hover().click();
        return this;
    }

    public ExampPage fillMeasureOpros_Anketirovanie() {
        MeasureOpros_Anketirovanie.hover().click();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).hover().click();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//tr[@id='84900']"));
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//div[@class='cursorPointer hide-med-record']")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureOpros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        MeasureOpros_Anketirovanie.hover().click();
        return this;
    }

    public ExampPage fillAntropometriya() {
        MeasureAntropometriya.hover().click();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Антропометрия')]")).hover().click();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureAntropometriya.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        MeasureAntropometriya.hover().click();
        return this;
    }

    public ExampPage fillIndividProfConsulting() {
        MeasureIndividualnoeProfConsulting.hover().click();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).hover().click();
        switchTo().frame(MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("multiLineTextTextarea1")).sendKeys("Автотестовая рекомендация");
        switchTo().defaultContent();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureIndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        MeasureIndividualnoeProfConsulting.hover().click();
        return this;
    }

    public ExampPage fillOpredelenieLvlGlukozi() {
        MeasureOpredelenieLvlGlukozi.click();
        MeasureOpredelenieLvlGlukozi.$(By.xpath("td[4]/mat-checkbox")).click();
        MeasureOpredelenieLvlGlukozi.click();
        return this;
    }

    public ExampPage fillOpredelenieLvlHolesterina() {
        MeasureOpredelenieLvlHolesterina.click();
        MeasureOpredelenieLvlHolesterina.$(By.xpath("td[4]/mat-checkbox")).click();
        MeasureOpredelenieLvlHolesterina.click();
        return this;
    }

    public ExampPage fillFlurography() {
        MeasureFlura.$(By.xpath("../tr[2]")).hover();
        MeasureFlura.click();
        MeasureFlura.$(By.xpath("../tr[3]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Результат флюорографии')]")).click();
        switchTo().frame(MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("singleLineTextInput2")).sendKeys("666");
        switchTo().defaultContent();
        MeasureFlura.$(By.xpath("../tr[3]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureFlura.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        MeasureFlura.hover().click();
        return this;
    }

    public ExampPage fillOpredelenieOtnositSummSSR() {
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("../tr[2]")).hover();
        MeasureOpredelenieOtnositelnogoSSR.click();
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        MeasureOpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public ExampPage fillPriem_OsmotrTerapevta() {
        MeasureOsmotrTerapevta.$(By.xpath("../tr[2]")).hover();
        MeasureOsmotrTerapevta.click();
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).hover();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]"))
                .click();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//tbody"))
                .hover();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//button[contains(text(),'Просмотреть')]"))
                .click();
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//table")).$(By.xpath("../div")).hover();
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
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
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Без отклонений')]")).click();

        MeasureOsmotrTerapevta.hover();
        MeasureOsmotrTerapevta.click();
        return this;
    }

    public ExampPage fillZakluchenie() {
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


    public void viewTemnikov() {
        switchAllServicesTap()
                .viewMeasureArtPressure()
                .viewMeasureOpros_Anketirovanie()
                .viewAntropometriya()
                .viewIndividProfConsulting()
                .viewOpredelenieLvlGlukozi()
                .viewOpredelenieLvlHolesterina()
                .viewFlurography()
                .viewOpredelenieOtnositSummSSR()
                .viewPriem_OsmotrTerapevta()
                .viewZakluchenie();
    }

    public ExampPage viewMeasureArtPressure() {
        MeasureArtPressure.hover().click();
        MeasureArtPressure.$(By.xpath("../..//*[contains(text(),'Показатели')]")).shouldBe(Condition.visible);
        MeasureArtPressure.$(By.xpath("td[4]/mat-checkbox")).hover().click();
        MeasureArtPressure.hover().click();
        return this;
    }

    public ExampPage viewMeasureOpros_Anketirovanie() {
        MeasureOpros_Anketirovanie.hover().click();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).hover().click();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//tr[@id='84900']"));
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//div[@class='cursorPointer hide-med-record']")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureOpros_Anketirovanie.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureOpros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        MeasureOpros_Anketirovanie.hover().click();
        return this;
    }

    public ExampPage viewAntropometriya() {
        MeasureAntropometriya.hover().click();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Антропометрия')]")).hover().click();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureAntropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureAntropometriya.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        MeasureAntropometriya.hover().click();
        return this;
    }

    public ExampPage viewIndividProfConsulting() {
        MeasureIndividualnoeProfConsulting.hover().click();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).hover().click();
        switchTo().frame(MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("multiLineTextTextarea1")).sendKeys("Автотестовая рекомендация");
        switchTo().defaultContent();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureIndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureIndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        MeasureIndividualnoeProfConsulting.hover().click();
        return this;
    }

    public ExampPage viewOpredelenieLvlGlukozi() {
        MeasureOpredelenieLvlGlukozi.click();
        MeasureOpredelenieLvlGlukozi.$(By.xpath("td[4]/mat-checkbox")).click();
        MeasureOpredelenieLvlGlukozi.click();
        return this;
    }

    public ExampPage viewOpredelenieLvlHolesterina() {
        MeasureOpredelenieLvlHolesterina.click();
        MeasureOpredelenieLvlHolesterina.$(By.xpath("td[4]/mat-checkbox")).click();
        MeasureOpredelenieLvlHolesterina.click();
        return this;
    }

    public ExampPage viewFlurography() {
        MeasureFlura.$(By.xpath("../tr[2]")).hover().click();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Результат флюорографии')]")).hover().click();
        switchTo().frame(MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("singleLineTextInput2")).sendKeys("666");
        switchTo().defaultContent();
        MeasureFlura.$(By.xpath("../tr[3]")).hover();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureFlura.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
        MeasureFlura.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        MeasureFlura.hover().click();
        return this;
    }

    public ExampPage viewOpredelenieOtnositSummSSR() {
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("../tr[2]")).hover();
        MeasureOpredelenieOtnositelnogoSSR.click();
        MeasureOpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        MeasureOpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public ExampPage viewPriem_OsmotrTerapevta() {
        MeasureOsmotrTerapevta.$(By.xpath("../tr[2]")).hover();
        MeasureOsmotrTerapevta.click();
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).hover();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]"))
                .click();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//tbody"))
                .hover();
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//button[contains(text(),'Просмотреть')]"))
                .click();
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//table")).$(By.xpath("../div")).hover();
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        Alarma_MedZapisUspeshnoSohranena.shouldBe(Condition.visible);
        MeasureOsmotrTerapevta.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        Alarma_MedZapisUspeshnoPodpisana.shouldBe(Condition.visible);
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
        MeasureOsmotrTerapevta
                .$(By.xpath("../tr[3]"))
                .$(By.xpath(".//*[contains(text(),'Без отклонений')]")).click();

        MeasureOsmotrTerapevta.hover();
        MeasureOsmotrTerapevta.click();
        return this;
    }

    public ExampPage viewZakluchenie() {
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


    public ExampPage saveBtn() {
        PodvalSaveBtn.click();
        return this;
    }

    public ExampPage podpisatBtn() {
        PodvalPodpisatBtn.click();
        return this;
    }

    /**
     * меню слева
     */
    public ExampPage zakluchenieMenuBtn() {
        $(By.id("mCSB_1_container")).$(By.xpath(".//*[contains(text(),'Заключение')]")).click();
        return this;
    }
}