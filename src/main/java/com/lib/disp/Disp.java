package com.lib.disp;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

public class Disp {
    SelenideElement se;

    public Disp(SelenideElement se) {
        this.se = se;
    }

    public Disp setValue(String a) {
        SelenideElement row = se
                .$x("../../../.")
                .$x(".//div[@class='table-row-middle']");
        SelenideElement rowText = row.$x(".//input[@formcontrolname='value']");
        rowText.clear();
        if (!a.equals("")) {
            rowText.setValue(a);
            Assert.assertTrue(rowText.getValue().equals(a));
        }
        return this;
    }

    public Disp signWithoutDeviations_topBtn() {
        se
                .$x("../../../.")
                .$x(".//mat-checkbox[@ng-reflect-name='withoutDeviations']").click();
        return this;
    }

    public Disp expand() throws InterruptedException {
        Thread.sleep(4000);
        se.$x("../.").hover();
        se.click();
        Thread.sleep(2000);
        return this;
    }

    public Disp collapse() {
        se.click();
        return this;
    }
}