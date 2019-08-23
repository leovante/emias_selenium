package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.switchTo;

@Deprecated
public class SwitchToPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void switchToPage() {
// by index
        switchTo().window(1);

// by name or title or handle
//        switchTo().window("Title of the window");

// for switching to default window
//        switchTo().defaultContent();
    }
}
