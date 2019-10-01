package com.pages.callcenter;

import com.codeborne.selenide.SelenideElement;
import com.pages.BasePage;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class DirectionsBasePage extends BasePage {
    SelenideElement closemodal = $(By.xpath("//*[@id='ccInfoModal']/div/div/div[3]/button"));
//    @FindBy(xpath = "//*[@id='direction-list-tab']")
//    WebElement apo;
//    JavascriptExecutor js = (JavascriptExecutor) remoteDriver;

    public DirectionsBasePage() throws IOException {
    }

    public void eqNapr(String arg0, String arg1, String arg2){
        //*[@id="a7f391d4-d5d8-44d5-a770-f7b527bb1233ED313B81-4FB4-4933-B991-E786756CCB63"]/strong[1]
        SelenideElement lpu = $(By.xpath("//button[contains(text("+arg0+")) and contains(text("+arg1+")) and contains(text("+arg2+")) ]"));
        lpu.click();
    }

    public void apoinmets() throws InterruptedException {
//        (js).executeScript("arguments[0].scrollIntoView();"
//                , apo);
//        apoinmentsList.click();
//        apoinment.click();
//        apoLpu.click();


        $(By.xpath("//*[@id='day-doc-schedule']/div/div/div[2]/button[17]")).click();
        $(By.xpath("//*[@id='record-to-doc-form']/div/div[2]/button")).click();
        closemodal.click();
    }
}
