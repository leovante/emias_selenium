package com.pages.disp;

import com.codeborne.selenide.SelenideElement;
import com.pages.WebPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DispaPage extends WebPage {
    SelenideElement AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]"));
    SelenideElement ArtPressure = $(By.xpath("//*[contains(text(),'Измерение артериального давления')]")).$(By.xpath("../../."));
    SelenideElement Opros_Anketirovanie = $(By.xpath("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]")).$(By.xpath("../../."));
    SelenideElement Antropometriya = $(By.xpath("//div[contains(text(),'Антропометрия (измерение роста стоя, массы тела, окружности талии), расчет индекса массы тела')]")).$(By.xpath("../../."));
    SelenideElement IndividualnoeProfConsulting = $(By.xpath("//div[contains(text(),'Индивидуальное профилактическое консультирование')]")).$(By.xpath("../../."));
    SelenideElement OpredelenieLvlGlukozi = $(By.xpath("//*[contains(text(),'Определение уровня глюкозы в крови экспресс-методом (допускается лабораторный метод)')]")).$(By.xpath("../../."));
    SelenideElement OpredelenieLvlHolesterina = $(By.xpath("//*[contains(text(),'Определение уровня общего холестерина в крови (допускается экспресс-метод)')]")).$(By.xpath("../../."));
    SelenideElement Flura = $(By.xpath("//*[contains(text(),'Флюорография легких')]")).$(By.xpath("../../."));
    SelenideElement OpredelenieOtnositelnogoSSR = $x("//*[contains(text(),'Определение относительного суммарного сердечно-сосудистого риска')]")/*.$x("../../.")*/;//убрал, потому что не нажималось
    SelenideElement OsmotrTerapevta = $(By.xpath("//*[contains(text(),'Прием (осмотр) врача-терапевта')]")).$(By.xpath("../../."));
    /*остальное*/
    SelenideElement Zakluchenie = $x("//a[contains(text(),'Заключение')]");
    SelenideElement ZakluchenieBorder = $x("//h1[contains(text(),'Заключение')]");
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
    SelenideElement exampsBlock = $x("//app-disp-exams-map");
}
