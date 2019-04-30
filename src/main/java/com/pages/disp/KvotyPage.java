package com.pages.disp;

import com.codeborne.selenide.SelenideElement;
import com.pages.AbstractPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class KvotyPage extends AbstractPage {
    SelenideElement kvotyNumber = $(By.xpath("//*[contains(text(),'Квоты')]"));

    public KvotyPage() {
    }

    public void kvotyBtn() {
        kvotyNumber.click();
    }
}