package com.pages.disp;

import com.codeborne.selenide.SelenideElement;
import com.pages.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class KvotyPageBase extends PageBase {
    SelenideElement kvotyNumber = $(By.xpath("//*[contains(text(),'Квоты')]"));

    public KvotyPageBase() {
    }

    public void kvotyBtn() {
        kvotyNumber.click();
    }
}