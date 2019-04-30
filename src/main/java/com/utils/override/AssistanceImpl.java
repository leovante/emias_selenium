package com.utils.override;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class AssistanceImpl implements Assistance {

    @Override
    public void isVisibleText(String text) {
        $x("//*[contains(.,'" + text + "')]").shouldBe(Condition.visible);
    }

    @Override
    public void isNotVisibleText(String text) {
        $x("//*[contains(.,'" + text + "')]").shouldNotBe(Condition.visible);
    }

    @Override
    public void isContains(String text) {
    }
}
