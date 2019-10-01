package com.lib.disp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.lib.Alarms;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class DispAlarms implements Alarms {
    SelenideElement se = $x("//simple-snack-bar/span[contains(text(),'В мероприятии ошибка!')]");

    @Override
    public void exampError() {
        Assert.assertTrue(se.shouldBe(Condition.visible).is(Condition.visible));
    }
}
