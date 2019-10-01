package com.pages.disp;

import com.codeborne.selenide.SelenideElement;
import com.pages.BasePage;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class KvotyPage extends BasePage {
    SelenideElement kvotyNumber = $(By.xpath("//*[contains(text(),'Квоты')]"));

    public KvotyPage() throws IOException {
    }

    public void kvotyBtn() {
        kvotyNumber.click();
    }
}