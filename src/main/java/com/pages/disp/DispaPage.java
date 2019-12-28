package com.pages.disp;

import com.codeborne.selenide.SelenideElement;
import com.pages.WebPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DispaPage extends WebPage {
    SelenideElement
            AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]")),
            ArtPressure = $(By.xpath("//*[contains(text(),'Измерение артериального давления')]")).$(By.xpath("../../.")),
            Opros_Anketirovanie = $(By.xpath("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]")).$(By.xpath("../../.")),
            Antropometriya = $(By.xpath("//div[contains(text(),'Антропометрия (измерение роста стоя, массы тела, окружности талии), расчет индекса массы тела')]")).$(By.xpath("../../.")),
            IndividualnoeProfConsulting = $(By.xpath("//div[contains(text(),'Индивидуальное профилактическое консультирование')]")).$(By.xpath("../../.")),
            OpredelenieLvlGlukozi = $(By.xpath("//*[contains(text(),'Определение уровня глюкозы в крови экспресс-методом (допускается лабораторный метод)')]")).$(By.xpath("../../.")),
            OpredelenieLvlHolesterina = $(By.xpath("//*[contains(text(),'Определение уровня общего холестерина в крови (допускается экспресс-метод)')]")).$(By.xpath("../../.")),
            Flura = $(By.xpath("//*[contains(text(),'Флюорография легких')]")).$(By.xpath("../../.")),
            OpredelenieOtnositelnogoSSR = $x("//*[contains(text(),'Определение относительного суммарного сердечно-сосудистого риска')]")/*.$x("../../.")*/,//убрал, потому что не нажималось
            OsmotrTerapevta = $(By.xpath("//*[contains(text(),'Прием (осмотр) врача-терапевта')]")).$(By.xpath("../../.")),
    /*остальное*/
    Zakluchenie = $x("//a[contains(text(),'Заключение')]"),
            ZakluchenieBorder = $x("//h1[contains(text(),'Заключение')]"),
            VidOplati = $(By.xpath("//*[@placeholder='Вид оплаты']")),
            CelPosesheniya = $(By.xpath("//*[@placeholder='Цель посещения']")),
            MestoObsluzhivaniya = $(By.xpath("//*[@placeholder='Место обслуживания']")),
            ResultatObrasheniya = $(By.xpath("//*[@placeholder='Результат обращения']")),
            IshodObrashenia = $(By.xpath("//*[@placeholder='Исход обращения']")),
            VrachPishetZakluchenie = $(By.xpath("//*[@placeholder='Врач, который пишет заключение']")),
            PodvalSaveBtn = $(By.xpath("//div[@class='fixed-bottom-panel']")).$(By.xpath(".//*[contains(text(),'Сохранить')]")),
            PodvalPodpisatBtn = $(By.xpath("//div[@class='fixed-bottom-panel']")).$(By.xpath(".//*[contains(text(),'Подписать')]")),
            ALARMA_SAVE = $(By.xpath(".//*[contains(text(),'Медицинская запись успешно сохранена.')]")),
            ALARMA_PODPISANA = $(By.xpath(".//*[contains(text(),'Медицинская запись успешно подписана.')]")),
            exampsBlock = $x("//app-disp-exams-map");
}
