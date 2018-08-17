package pages.disp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class ServicesPageVerify extends AbstractPage {
    SelenideElement AllServicesTap = $(By.xpath("//*[contains(text(),'Все мероприятия')]"));
    SelenideElement MeasureArtPressure = $(By.id("be884e59-2883-40a4-8033-4508a0ccb3ac"));
    SelenideElement MeasureOpros_Anketirovanie = $(By.id("beccc8c1-33b3-4ed0-8c0b-22f78b792769"));

    public ServicesPageVerify() {

    }

}