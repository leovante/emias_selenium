package com.commons.assistance;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

public interface SelenideElementCustom extends WebElement {

    default void setStringValue(String text){

    }
}