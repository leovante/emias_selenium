package com.pages.disp.measureBlock;

import com.codeborne.selenide.SelenideElement;

public class MethodsImpl implements Methods {
    @Override
    public void open(SelenideElement e) {
        e.hover().click();
    }
}
