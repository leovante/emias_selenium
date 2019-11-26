package com.pages.disp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.disp.measure.MeasureEnum;
import com.lib.disp.DispAlarms;
import com.pages.disp.measure.Blok;
import com.pages.disp.measure.BlokImpl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class Exams extends DispaPage {
    String examName;
    SelenideElement exam;
    private BlokImpl blok;

    Exams(String examName) {
        this.examName = examName;
        alarms = new DispAlarms();
    }

    Exams() {
        alarms = new DispAlarms();
        this.blok = new Blok();
    }

    public void expand(MeasureEnum measure) {
        blok.expand(measure);
    }

    public Exams openService() {
        sleep(1000);
        exam.$x("../../../.").hover();
        exam.$x("../../../.")
                .$x(".//span[@ng-reflect-ng-class='enebled-med-record']")
                .click();
        sleep(1000);
        exam.$x("../../../.").hover();
        return this;
    }

    public Exams signService() {
        $x("//*[contains(text(),'" + exam + "')]")
                .$x("../tr[3]//*[contains(text(),'Подписать')]").hover().click();
        return this;
    }

    public void fillTemnikov() {
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

    public Exams switchAllServicesTap() {
        AllServicesTap.click();
        return this;
    }

    public Exams fillArtPressure() {
        sleep(4000);
        ArtPressure.$(By.xpath("../.")).hover();
        ArtPressure.click();
        ArtPressure.$(By.xpath("../..//*[contains(text(),'Показатели')]")).shouldBe(Condition.visible);
        ArtPressure.$(By.xpath("td[4]/mat-checkbox")).hover().click();
        ArtPressure.hover().click();
        return this;
    }

    public Exams fillOpros_Anketirovanie() {
        sleep(4000);
        Opros_Anketirovanie.$(By.xpath("../.")).hover();
        Opros_Anketirovanie.click();
        sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).click();
        Opros_Anketirovanie.$(By.xpath("../tr[3]//div[@class='cursorPointer hide-med-record']")).hover();
        sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//button[@mattooltip='Добавить']")).hover();
        sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Opros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Opros_Anketirovanie.hover().click();
        return this;
    }

    public Exams fillAntropometriya() {
        sleep(4000);
        Antropometriya.$(By.xpath("../.")).hover();
        Antropometriya.click();
        sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]//*[contains(text(),'Антропометрия')]")).hover().click();
        sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]//button[@mattooltip='Добавить']")).hover();
        sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).hover().click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Antropometriya.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Antropometriya.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Antropometriya.hover().click();
        return this;
    }

    public Exams fillIndividProfConsulting() {
        sleep(4000);
        IndividualnoeProfConsulting.$(By.xpath("../.")).hover();
        IndividualnoeProfConsulting.click();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).click();
        switchTo().frame(IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("multiLineTextTextarea1")).sendKeys("Автотестовая рекомендация");
        switchTo().defaultContent();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        sleep(1000);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        sleep(1000);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//button[@mattooltip='Добавить']")).hover();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        IndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        IndividualnoeProfConsulting.hover().click();
        return this;
    }

    public Exams fillOpredelenieLvlGlukozi() {
        sleep(4000);
        OpredelenieLvlGlukozi.$(By.xpath("../.")).hover();
        OpredelenieLvlGlukozi.click();
        OpredelenieLvlGlukozi.$(By.xpath("./td[4]/mat-checkbox")).click();
        OpredelenieLvlGlukozi.$(By.xpath("../tr[3]")).hover();
        OpredelenieLvlGlukozi.click();
        return this;
    }

    public Exams fillOpredelenieLvlHolesterina() {
        sleep(4000);
        OpredelenieLvlHolesterina.$(By.xpath("../.")).hover();
        OpredelenieLvlHolesterina.click();
        OpredelenieLvlHolesterina.$(By.xpath("./td[4]/mat-checkbox")).click();
        OpredelenieLvlHolesterina.$(By.xpath("../tr[3]")).hover();
        OpredelenieLvlHolesterina.click();
        return this;
    }

    public Exams fillFlurography() {
        sleep(4000);
        Flura.$(By.xpath("../.")).hover();
        sleep(1000);
        Flura.click();
        sleep(1000);
        Flura.$(By.xpath("../tr[3]")).hover();
        sleep(1000);
        Flura.$(By.xpath("../tr[3]//*[contains(text(),'Результат флюорографии')]")).hover().click();
        sleep(1000);
        switchTo().frame(Flura.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("singleLineTextInput2")).sendKeys("777");
        $(By.id("spanMU4")).click();
        $(By.id("spanMU6")).click();
        switchTo().defaultContent();
        Flura.$(By.xpath("../tr[3]")).hover();
        sleep(1000);
        Flura.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        sleep(1000);
        Flura.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).hover().click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Flura.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Flura.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Flura.hover().click();
        return this;
    }

    public Exams fillOpredelenieOtnositSummSSR() {
        sleep(4000);
        OpredelenieOtnositelnogoSSR.$(By.xpath("../.")).hover();
        OpredelenieOtnositelnogoSSR.click();
        OpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public Exams fillPriem_OsmotrTerapevta() {
        sleep(4000);
        OsmotrTerapevta.$(By.xpath("../.")).hover();
        OsmotrTerapevta.click();
        sleep(1000);
        OsmotrTerapevta.$(By.xpath("../tr[3]")).hover();
        /*медзапись*/
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]")).click();
        sleep(1000);
        OsmotrTerapevta.$(By.xpath("../tr[3]//tbody")).hover();
        OsmotrTerapevta.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).hover().click();
        sleep(1000);
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

    public Exams fillZakluchenie() {
        sleep(4000);
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

    public Exams viewMeasureArtPressure() {
        sleep(4000);
        ArtPressure.hover().click();
        ArtPressure.$(By.xpath("../..//*[contains(text(),'Показатели')]")).shouldBe(Condition.visible);
        ArtPressure.$(By.xpath("td[4]/mat-checkbox")).hover().click();
        ArtPressure.hover().click();
        return this;
    }

    public Exams viewMeasureOpros_Anketirovanie() {
        sleep(4000);
        Opros_Anketirovanie.hover().click();
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Анкета для граждан в возрасте до 75 лет')]")).hover().click();
        Opros_Anketirovanie.$(By.xpath("../tr[3]//tr[@id='84900']"));
        Opros_Anketirovanie.$(By.xpath("../tr[3]//div[@class='cursorPointer hide-med-record']")).hover();
        sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        sleep(1000);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//button[@mattooltip='Добавить']")).hover();
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Сохранить')]")).click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Opros_Anketirovanie.$(By.xpath("../tr[3]//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Opros_Anketirovanie.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Opros_Anketirovanie.hover().click();
        return this;
    }

    public Exams viewAntropometriya() {
        sleep(4000);
        Antropometriya.hover().click();
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Антропометрия')]")).hover().click();
        sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        sleep(1000);
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).hover().click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        Antropometriya.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        Antropometriya.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        Antropometriya.hover().click();
        return this;
    }

    public Exams viewIndividProfConsulting() {
        sleep(4000);
        IndividualnoeProfConsulting.hover().click();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Индивидуальное профилактическое консультирование')]")).hover().click();
        switchTo().frame(IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.id("multiLineTextTextarea1")).sendKeys("Автотестовая рекомендация");
        switchTo().defaultContent();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).hover();
        sleep(1000);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[contains(text(),'Просмотреть')]")).click();
        sleep(1000);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//button[@mattooltip='Добавить']")).hover();
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Сохранить')]")).click();
        ALARMA_SAVE.shouldBe(Condition.visible);
        IndividualnoeProfConsulting.$(By.xpath("../tr[3]")).$(By.xpath(".//*[contains(text(),'Подписать')]")).hover().click();
        ALARMA_PODPISANA.shouldBe(Condition.visible);
        IndividualnoeProfConsulting.$(By.xpath("./td[4]/mat-checkbox")).hover().click();
        IndividualnoeProfConsulting.hover().click();
        return this;
    }

    public Exams viewOpredelenieLvlGlukozi() {
        sleep(4000);
        OpredelenieLvlGlukozi.click();
        OpredelenieLvlGlukozi.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieLvlGlukozi.click();
        return this;
    }

    public Exams viewOpredelenieLvlHolesterina() {
        sleep(4000);
        OpredelenieLvlHolesterina.click();
        OpredelenieLvlHolesterina.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieLvlHolesterina.click();
        return this;
    }

    public Exams viewFlurography() {
        sleep(4000);
        Flura.$(By.xpath("../.")).hover();
        sleep(1000);
        Flura.click();
        sleep(1000);
        Flura.$(By.xpath("../tr[3]")).hover();
        sleep(1000);
        Flura.$(By.xpath("../tr[3]//*[contains(text(),'Результат флюорографии')]")).hover().click();
        sleep(1000);
        switchTo().frame(Flura.$(By.xpath("../tr[3]")).$(By.xpath(".//iframe")));
        $(By.xpath("//*[contains(.,'Флюорография')]")).shouldBe(Condition.visible);
        switchTo().defaultContent();
        return this;
    }

    public Exams viewOpredelenieOtnositSummSSR() {
        sleep(4000);
        OpredelenieOtnositelnogoSSR.$(By.xpath("../tr[2]")).hover();
        OpredelenieOtnositelnogoSSR.click();
        OpredelenieOtnositelnogoSSR.$(By.xpath("td[4]/mat-checkbox")).click();
        OpredelenieOtnositelnogoSSR.click();
        return this;
    }

    public Exams viewPriem_OsmotrTerapevta() {
        sleep(4000);
        OsmotrTerapevta.$(By.xpath("../tr[2]")).hover();
        OsmotrTerapevta.click();
        OsmotrTerapevta.$(By.xpath("../tr[3]")).hover();
        OsmotrTerapevta.$(By.xpath("../tr[3]//*[contains(text(),'Приложение к форме 131-у осмотр Терапевта')]")).click();
        OsmotrTerapevta.$(By.xpath("../tr[3]//tbody")).hover();
        sleep(1000);
        OsmotrTerapevta.$(By.xpath("../tr[3]//button[contains(text(),'Просмотреть')]")).click();
        sleep(1000);
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

    public Exams viewZakluchenie() {
        sleep(4000);
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
    public Exams validateServiceIsSign() {
        $(By.xpath("//*[contains(text(),'Мероприятие успешно подписано')]")).shouldBe(Condition.visible);
        return this;
    }

    public Exams saveBtn() {
        PodvalSaveBtn.click();
        $(By.xpath("//*[contains(text(),'Карта успешно сохранена')]")).shouldBe(Condition.visible);
        return this;
    }

    public Exams podpisatBtn() {
        PodvalPodpisatBtn.click();
        $(By.xpath("//*[contains(text(),'Карта успешно подписана')]")).shouldBe(Condition.visible);
        return this;
    }

    /* меню слева*/
    public Exams zakluchenieMenuBtn() {
        Zakluchenie.click();
        return this;
    }

    public Exams validateFieldParamIsEmpy() {
        lib.disp()
                .routeList()
                .opredelenieOtnositelnogoSSR()
                .click();
        String i = lib.disp()
                .routeList()
                .opredelenieOtnositelnogoSSR()
                .getValue();
        Assert.assertEquals(i, "", "поле показателей должно быть пустым");
        return this;
    }

    @Step("Проверяю валидацию показателя, если поле параметра с пробелом")
    public Exams validateFieldParamWithSpace() {
        lib.disp(OpredelenieOtnositelnogoSSR)
                .expand()
                .setValue(" ")
                .signWithoutDeviations_topBtn();
        alarms.exampError();
        return this;
    }

    @Step("Проверяю валидацию показателя, если поле параметра пустое")
    public Exams validateClearParam() {
        lib.disp(OpredelenieOtnositelnogoSSR)
                .expand()
                .setValue("")
                .signWithoutDeviations_topBtn();
        alarms.exampError();
        return this;
    }

    @Step("Проверяю валидацию поля параметров с дефолтным значением")
    public Exams validateParamNotOpen() {
        sleep(4000);
        OpredelenieOtnositelnogoSSR.$(By.xpath("../.")).hover();
        sleep(2000);
        OpredelenieOtnositelnogoSSR.$x("//mat-checkbox[@formcontrolname='signWithoutDeviations_topBtn']").click();
        Assert.assertTrue($x("//*[contains(text(),'В мероприятии ошибка!')]").is(Condition.visible), "Ошибка не появилась");
        return this;
    }

    @Step("Валидация что карта заблокирована")
    public Exams validateCardIsDisable() {
        PodvalSaveBtn.shouldBe(Condition.visible);
        Assert.assertTrue(PodvalSaveBtn.is(Condition.disabled), "Кнопка сохранить не задизеблина");
        return this;
    }


    @Step("Валидация что заключение отображается")
    public Exams validateZakluchenieBorder() {
        Assert.assertTrue(ZakluchenieBorder.is(Condition.visible), "Заключение не отображается");
        return this;
    }
}