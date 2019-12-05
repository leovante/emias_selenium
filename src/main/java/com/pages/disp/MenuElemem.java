package com.pages.disp;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public interface MenuElemem {
    SelenideElement journalMenuBtn = $x("//app-menu").$x(".//h3[contains(text(),'Журнал')]");
    SelenideElement kvotyMenuBtn = $x("//app-menu").$x(".//h3[contains(text(),'Квоты')]");
    SelenideElement planGraphMenuBtn = $x("//app-menu").$x(".//h3[contains(text(),'План-график пациентов')]");
    SelenideElement plan = $x("//app-menu").$x(".//*[contains(text(),'План')]");
    SelenideElement fact = $x("//app-menu").$x(".//*[contains(text(),'Факт')]");
}
