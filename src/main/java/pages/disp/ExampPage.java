package pages.disp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ExampPage extends AbstractPage {
    /*мероприятия*/
    SelenideElement AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]"));
    SelenideElement ArtPressure = $(By.xpath("//*[contains(text(),'Измерение артериального давления')]")).$(By.xpath("../../."));
    SelenideElement Opros_Anketirovanie = $(By.xpath("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]")).$(By.xpath("../../."));
    SelenideElement Antropometriya = $(By.xpath("//div[contains(text(),'Антропометрия (измерение роста стоя, массы тела, окружности талии), расчет индекса массы тела')]")).$(By.xpath("../../."));
    SelenideElement IndividualnoeProfConsulting = $(By.xpath("//div[contains(text(),'Индивидуальное профилактическое консультирование')]")).$(By.xpath("../../."));
    SelenideElement OpredelenieLvlGlukozi = $(By.xpath("//*[contains(text(),'Определение уровня глюкозы в крови экспресс-методом (допускается лабораторный метод)')]")).$(By.xpath("../../."));
    SelenideElement OpredelenieLvlHolesterina = $(By.xpath("//*[contains(text(),'Определение уровня общего холестерина в крови (допускается экспресс-метод)')]")).$(By.xpath("../../."));
    SelenideElement Flura = $(By.xpath("//*[contains(text(),'Флюорография легких')]")).$(By.xpath("../../."));
    SelenideElement OpredelenieOtnositelnogoSSR = $(By.xpath("//*[contains(text(),'Определение относительного суммарного сердечно-сосудистого риска')]")).$(By.xpath("../../."));
    SelenideElement OsmotrTerapevta = $(By.xpath("//*[contains(text(),'Прием (осмотр) врача-терапевта')]")).$(By.xpath("../../."));
    /*остальное*/
    SelenideElement Zakluchenie = $(By.xpath("//*[contains(text(),'Заключение')]"));
    SelenideElement VidOplati = $(By.xpath("//*[@placeholder='Вид оплаты']"));
    SelenideElement CelPosesheniya = $(By.xpath("//*[@placeholder='Цель посещения']"));
    SelenideElement MestoObsluzhivaniya = $(By.xpath("//*[@placeholder='Место обслуживания']"));
    SelenideElement ResultatObrasheniya = $(By.xpath("//*[@placeholder='Результат обращения']"));
    SelenideElement IshodObrashenia = $(By.xpath("//*[@placeholder='Исход обращения']"));
    SelenideElement VrachPishetZakluchenie = $(By.xpath("//*[@placeholder='Врач, который пишет заключение']"));
    SelenideElement PodvalSaveBtn = $(By.xpath("//div[@class='fixed-bottom-panel']")).$(By.xpath(".//*[contains(text(),'Сохранить')]"));
    SelenideElement PodvalPodpisatBtn = $(By.xpath("//div[@class='fixed-bottom-panel']")).$(By.xpath(".//*[contains(text(),'Подписать')]"));
    SelenideElement ALARMA_SAVE = $(By.xpath(".//*[contains(text(),'Медицинская запись успешно сохранена.')]"));
    SelenideElement ALARMA_PODPISANA = $(By.xpath(".//*[contains(text(),'Медицинская запись успешно подписана.')]"));

    public ExampPage() {
    }

    public void fillTemnikov() throws InterruptedException {
        switchAllServicesTap()
                .fillOpros_Anketirovanie()
                .fillArtPressure()
                .fillAntropometriya()
                .fillOpredelenieLvlGlukozi()
                .fillOpredelenieLvlHolesterina()
                .fillFlurography()
                .fillOpredelenieOtnositSummSSR()
                .fillIndividProfConsulting()
                .fillPriem_OsmotrTerapevta()
                .fillZakluchenie();
    }

    public ExampPage switchAllServicesTap() {
        AllServicesTap.click();
        return this;
    }

    public ExampPage fillArtPressure() throws InterruptedException {
        Thread.sleep(4000);
        ArtPressure.$(By.xpath("../.")).hover();
        ArtPressure.click();
        ArtPressure.$(By.xpath("../..//*[contains(text(),'Показатели')]")).shouldBe(Condition.visible);
        ArtPressure.$(By.xpath("td[4]/mat-checkbox")).hover().click();
        ArtPressure.hover().click();
        return this;
    }

    public ExampPage fillOpros_Anketirovanie() throws InterruptedException {
        Thread.sleep(4000);
        Opros_Anketirovanie.$(By.xpath("../.")).hover();
        Opros_Anketirovanie.click();
        Thread.sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).click();
        Opros_Anketirovanie.$(By.xpath("../tr[3]//div[@class='cursorPointer hide-med-record']")).hover();
        Thread.sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//button[@mattooltip='Добавить']")).hover();
        Thread.sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Opros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Opros_Anketirovanie.hover().click();
        return this;
    }

    public ExampPage fillAntropometriya() throws InterruptedException {
        Thread.sleep(4000);
        Antropometriya.$(By.xpath("../.")).hover();
        Antropometriya.click();
        Thread.sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]//*[contains(text(),'Антропометрия')]")).hover().click();
        Thread.sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]//button[@mattooltip='Добавить']")).hover();
        Thread.sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).hover().click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Antropometriya.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Antropometriya.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Antropometriya.hover().click();
        return this;
    }

    public ExampPage fillIndividProfConsulting() throws InterruptedException {
        Thread.sleep(4000);
        IndividualnoeProfConsulting.$(By.xpath("../.")).hover();
        IndividualnoeProfConsulting.click();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).click();
        switchTo().frame(IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("multiLineTextTextarea1")).sendKeys("Автотестовая рекомендация");
        switchTo().defaultContent();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        Thread.sleep(1000);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(1000);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//button[@mattooltip='Добавить']")).hover();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        IndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        IndividualnoeProfConsulting.hover().click();
        return this;
    }

    public ExampPage fillOpredelenieLvlGlukozi() throws InterruptedException {
        Thread.sleep(4000);
        OpredelenieLvlGlukozi.$(By.xpath("../.")).hover();
        OpredelenieLvlGlukozi.click();
        OpredelenieLvlGlukozi.$(By.xpath("./td[4]/mat-checkbox")).click();
        OpredelenieLvlGlukozi.$(By.xpath("../tr[3]")).hover();
        OpredelenieLvlGlukozi.click();
        return this;
    }

    public ExampPage fillOpredelenieLvlHolesterina() throws InterruptedException {
        Thread.sleep(4000);
        OpredelenieLvlHolesterina.$(By.xpath("../.")).hover();
        OpredelenieLvlHolesterina.click();
        OpredelenieLvlHolesterina.$(By.xpath("./td[4]/mat-checkbox")).click();
        OpredelenieLvlHolesterina.$(By.xpath("../tr[3]")).hover();
        OpredelenieLvlHolesterina.click();
        return this;
    }

    public ExampPage fillFlurography() throws InterruptedException {
        Thread.sleep(4000);
        Flura.$(By.xpath("../.")).hover();
        Thread.sleep(1000);
        Flura.click();
        Thread.sleep(1000);
        Flura.$(By.xpath("../tr[3]")).hover();
        Thread.sleep(1000);
        Flura.$(By.xpath("../tr[3]//*[contains(text(),'Результат флюорографии')]")).hover().click();
        Thread.sleep(1000);
        switchTo().frame(Flura.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("singleLineTextInput2")).sendKeys("777");
        $(By.id("spanMU4")).click();
        $(By.id("spanMU6")).click();
        switchTo().defaultContent();
        Flura.$(By.xpath("../tr[3]")).hover();
        Thread.sleep(1000);
        Flura.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(1000);
        Flura.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).hover().click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Flura.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Flura.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Flura.hover().click();
        return this;
    }

    public ExampPage fillOpredelenieOtnositSummSSR() throws InterruptedException {
        Thread.sleep(4000);
        OpredelenieOtnositelnogoSSR.$(By.xpath("../.")).hover();
        OpredelenieOtnositelnogoSSR.click();
        OpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public ExampPage fillPriem_OsmotrTerapevta() throws InterruptedException {
        Thread.sleep(4000);
        OsmotrTerapevta.$(By.xpath("../.")).hover();
        OsmotrTerapevta.click();
        Thread.sleep(1000);
        OsmotrTerapevta.$(By.xpath("../tr[3]")).hover();
        /*медзапись*/
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]")).click();
        Thread.sleep(1000);
        OsmotrTerapevta.$(By.xpath("../tr[3]//tbody")).hover();
        OsmotrTerapevta.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).hover().click();
        Thread.sleep(1000);
        OsmotrTerapevta.$(By.xpath("../tr[3]//table/../div")).hover();
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).hover().click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]")).click();
        /*диагнозы*/
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div[2]"))
                .$(By.xpath(".//*[contains(text(),'add')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[2]"))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[2]"))
                .$(By.xpath(".//*[contains(text(),'1 - Предварительный')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[3]"))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[3]"))
                .$(By.xpath(".//*[contains(text(),'2 - Установлено ранее')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[4]"))
                .$(By.xpath(".//*[@placeholder = 'undefined']")).val("J20.1");
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[4]"))
                .$(By.xpath(".//*[contains(text(),'J20.1 - Острый бронхит, вызванный Haemophilus influenzae [палочкой Афанасьева-Пфейффера]')]")).click();
        /*услуги*/
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Без отклонений')]")).click();
        OsmotrTerapevta.hover();
        OsmotrTerapevta.click();
        return this;
    }

    public ExampPage fillZakluchenie() throws InterruptedException {
        Thread.sleep(4000);
        Zakluchenie.$(By.xpath("../../conclusion")).hover();
        Zakluchenie.$(By.xpath("../../conclusion//div[contains(text(),'низкий')]")).click();
        VrachPishetZakluchenie.hover();
        VidOplati.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        VidOplati.$(By.xpath("..//*[contains(text(),'ОМС')]")).click();
        CelPosesheniya.$(By.xpath("..//mat-icon[contains(text(),'close')]")).click();
        CelPosesheniya.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        CelPosesheniya.$(By.xpath("..//*[contains(text(),'1 - Заболевание')]")).click();
        MestoObsluzhivaniya.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        MestoObsluzhivaniya.$(By.xpath("..//*[contains(text(),'1 - Поликлиника')]")).click();
        ResultatObrasheniya.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        ResultatObrasheniya.$(By.xpath("..//*[contains(text(),'31 - ЛЕЧЕНИЕ ЗАВЕРШЕНО')]")).click();
        IshodObrashenia.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        IshodObrashenia.$(By.xpath("..//*[contains(text(),'01 - ВЫЗДОРОВЛЕНИЕ')]")).click();
        return this;
    }

    /*тут для тестов по просмотру*/
    public void viewTemnikov() throws InterruptedException {
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

    public ExampPage viewMeasureArtPressure() throws InterruptedException {
        Thread.sleep(4000);
        ArtPressure.hover().click();
        ArtPressure.$(By.xpath("../..//*[contains(text(),'Показатели')]")).shouldBe(Condition.visible);
        ArtPressure.$(By.xpath("td[4]/mat-checkbox")).hover().click();
        ArtPressure.hover().click();
        return this;
    }

    public ExampPage viewMeasureOpros_Anketirovanie() throws InterruptedException {
        Thread.sleep(4000);
        Opros_Anketirovanie.hover().click();
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).hover().click();
        Opros_Anketirovanie.$(By.xpath("../tr[3]//tr[@id='84900']"));
        Opros_Anketirovanie.$(By.xpath("../tr[3]//div[@class='cursorPointer hide-med-record']")).hover();
        Thread.sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//button[@mattooltip='Добавить']")).hover();
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Opros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Opros_Anketirovanie.hover().click();
        return this;
    }

    public ExampPage viewAntropometriya() throws InterruptedException {
        Thread.sleep(4000);
        Antropometriya.hover().click();
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Антропометрия')]")).hover().click();
        Thread.sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Antropometriya.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Antropometriya.hover().click();
        return this;
    }

    public ExampPage viewIndividProfConsulting() throws InterruptedException {
        Thread.sleep(4000);
        IndividualnoeProfConsulting.hover().click();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).hover().click();
        switchTo().frame(IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("multiLineTextTextarea1")).sendKeys("Автотестовая рекомендация");
        switchTo().defaultContent();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        Thread.sleep(1000);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(1000);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        IndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        IndividualnoeProfConsulting.hover().click();
        return this;
    }

    public ExampPage viewOpredelenieLvlGlukozi() throws InterruptedException {
        Thread.sleep(4000);
        OpredelenieLvlGlukozi.click();
        OpredelenieLvlGlukozi.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieLvlGlukozi.click();
        return this;
    }

    public ExampPage viewOpredelenieLvlHolesterina() throws InterruptedException {
        Thread.sleep(4000);
        OpredelenieLvlHolesterina.click();
        OpredelenieLvlHolesterina.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieLvlHolesterina.click();
        return this;
    }

    public ExampPage viewFlurography() throws InterruptedException {
        Thread.sleep(4000);
        Flura.$(By.xpath("../.")).hover();
        Thread.sleep(1000);
        Flura.click();
        Thread.sleep(1000);
        Flura.$(By.xpath("../tr[3]")).hover();
        Thread.sleep(1000);
        Flura.$(By.xpath("../tr[3]//*[contains(text(),'Результат флюорографии')]")).hover().click();
        Thread.sleep(1000);
        switchTo().frame(Flura.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.xpath("//*[contains(.,'Флюорография')]")).shouldBe(Condition.visible);
        switchTo().defaultContent();
        return this;
    }

    public ExampPage viewOpredelenieOtnositSummSSR() throws InterruptedException {
        Thread.sleep(4000);
        OpredelenieOtnositelnogoSSR.$(By.xpath("../tr[2]")).hover();
        OpredelenieOtnositelnogoSSR.click();
        OpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public ExampPage viewPriem_OsmotrTerapevta() throws InterruptedException {
        Thread.sleep(4000);
        OsmotrTerapevta.$(By.xpath("../tr[2]")).hover();
        OsmotrTerapevta.click();
        OsmotrTerapevta.$(By.xpath("../tr[3]")).hover();
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]")).click();
        OsmotrTerapevta.$(By.xpath("../tr[3]//tbody")).hover();
        Thread.sleep(1000);
        OsmotrTerapevta.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        Thread.sleep(1000);
        OsmotrTerapevta.$(By.xpath("../tr[3]/../tr[3]//table")).$(By.xpath("../div")).hover();
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).hover().click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]")).click();
        /*диагнозы*/
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div[2]"))
                .$(By.xpath(".//*[contains(text(),'add')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[2]"))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[2]"))
                .$(By.xpath(".//*[contains(text(),'1 - Предварительный')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[3]"))
                .$(By.xpath(".//*[contains(text(),'arrow_drop_down')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[3]"))
                .$(By.xpath(".//*[contains(text(),'2 - Установлено ранее')]")).click();
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[4]"))
                .$(By.xpath(".//*[@placeholder = 'undefined']")).val("J20.1");
        OsmotrTerapevta
                .$(By.xpath("../tr[3]//*[contains(text(),'Диагнозы')]"))
                .$(By.xpath("../../../../../div/table/tbody/tr/td[4]"))
                .$(By.xpath(".//*[contains(text(),'J20.1 - Острый бронхит, вызванный Haemophilus influenzae [палочкой Афанасьева-Пфейффера]')]")).click();

        /*услуги*/
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Без отклонений')]")).click();
        OsmotrTerapevta.hover();
        OsmotrTerapevta.click();
        return this;
    }

    public ExampPage viewZakluchenie() throws InterruptedException {
        Thread.sleep(4000);
        Zakluchenie.$(By.xpath("../../conclusion")).hover();
        Zakluchenie.$(By.xpath("../../conclusion//div[contains(text(),'низкий')]")).click();
        VrachPishetZakluchenie.hover();
        VidOplati.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        VidOplati.$(By.xpath("..//*[contains(text(),'ОМС')]")).click();
        CelPosesheniya.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        CelPosesheniya.$(By.xpath("..//*[contains(text(),'1 - Заболевание')]")).click();
        MestoObsluzhivaniya.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        MestoObsluzhivaniya.$(By.xpath("..//*[contains(text(),'1 - Поликлиника')]")).click();
        ResultatObrasheniya.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        ResultatObrasheniya.$(By.xpath("..//*[contains(text(),'01 - ВЫПИСАН')]")).click();
        IshodObrashenia.$(By.xpath("..//*[contains(text(),'arrow_drop_down')]")).click();
        IshodObrashenia.$(By.xpath("..//*[contains(text(),'01 - ВЫЗДОРОВЛЕНИЕ')]")).click();
        return this;
    }

    /*уведомления*/
    public ExampPage saveBtn() {
        PodvalSaveBtn.click();
        $(By.xpath("//*[contains(text(),'Карта успешно сохранена')]")).shouldBe(Condition.visible);
        return this;
    }

    public ExampPage podpisatBtn() {
        PodvalPodpisatBtn.click();
        $(By.xpath("//*[contains(text(),'Карта успешно подписана')]")).shouldBe(Condition.visible);
        return this;
    }

    /* меню слева*/
    public ExampPage zakluchenieMenuBtn() {
        $(By.id("mCSB_1_container")).$(By.xpath(".//*[contains(text(),'Заключение')]")).click();
        return this;
    }

    /* всякие заполнения */
    public ExampPage validateFieldParamIsEmpy() throws InterruptedException {
        Thread.sleep(4000);
        OpredelenieOtnositelnogoSSR.$(By.xpath("../.")).hover();
        OpredelenieOtnositelnogoSSR.click();
        Thread.sleep(2000);//
        String i = OpredelenieOtnositelnogoSSR
                .$(By.xpath("//th[contains(text(),'Показатели')]"))
                .$(By.xpath("../../../."))
                .$(By.xpath(".//mat-form-field[@formgroupname='paramValue']"))
                .$(By.xpath(".//input[@formcontrolname='value']")).getValue();
        Assert.assertEquals(i, "", "поле показателей должно быть пустым");
        return this;
    }

    @Step("Проверяю валидацию поля параметров с пробелом")
    public ExampPage validateFieldParamWithSpace() throws InterruptedException {
        Thread.sleep(4000);
        OpredelenieOtnositelnogoSSR.$(By.xpath("../.")).hover();
        OpredelenieOtnositelnogoSSR.click();
        Thread.sleep(2000);//
        OpredelenieOtnositelnogoSSR
                .$(By.xpath("//th[contains(text(),'Показатели')]"))
                .$(By.xpath("../../../."))
                .$(By.xpath(".//mat-form-field[@formgroupname='paramValue']"))
                .$(By.xpath(".//input[@formcontrolname='value']")).setValue(" ");
        OpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieOtnositelnogoSSR.click();
        $(By.xpath("//*[contains(text(),'В мероприятии ошибка!')]")).shouldBe(Condition.visible);
        return this;
    }
}