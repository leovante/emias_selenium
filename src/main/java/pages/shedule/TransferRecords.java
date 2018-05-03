package pages.shedule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferRecords {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public TransferRecords(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void clickDoctor(){


        //нужно проверить что верстка таблицы с врачами аналогична в ДОМЕ как на страницы создания расписания.
        //если это так, то можно использовать паттерн PageElements
        //
    }

//    нажать на первого врача
//    нажать на кнопку перенос записей
//    выбрать дату и нажать перенести
//    нажать на врача
//    надать правой кнопкой на запись и выбрать - перенести
//    выбрать второго врача
//    выбрать первую строку времени для запси
//    нажать перенести
//    подтвердить всплывающееьокно enter
//    снять выделение с первого врача и нажать на второго
//    найти перенесенную запись
}
