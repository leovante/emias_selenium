package com.commons.assistance;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class visibleByText {

    public SelenideElement byText(String text){
        return $x("//*[contains(text(),'" + text + "')]").shouldNotBe(Condition.visible);
    }
}
