package com.lib.disp;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class Disp {
    SelenideElement se = $x("//*");

    public Disp(SelenideElement se) {
        this.se = se;
    }

    public Disp() {
    }

    public RouteList routeList(){
        return new RouteList(se);
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

    public Disp expand()  {
        sleep(4000);
        se.$x("../.").hover();
        se.click();
        sleep(2000);
        return this;
    }

    public Disp collapse() {
        se.click();
        return this;
    }
}