package com.lib.disp;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ParametersImpl implements Parameters {

    @Override
    public SelenideElement returnValueField(SelenideElement measure) {
        return measure.$x(".//div[contains(text(),'Показатели')]")
                .$x("../../../.")
                .$x(".//input[@formcontrolname='value']");
    }
}