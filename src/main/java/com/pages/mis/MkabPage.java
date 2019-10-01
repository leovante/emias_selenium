package com.pages.mis;

import com.pages.BasePage;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class MkabPage extends BasePage {

    public MkabPage() throws IOException {
    }

    public MkabPage fio(String fio) {
        $(By.id("patientMkab")).val(fio);
        return this;
    }

    public MkabPage serchBtn() {
        $(By.id("searchMkabByFilter")).click();
        return this;
    }

    public MkabPage openMkab(String name) {
        $(By.id("MkabGrid"))
                .$x(".//td[@title='" + name + "']")
                .$x("./../.")
                .$x(".//*[@class='ui-icon ui-icon-carat-1-s contextmenucolumn']")
                .click();
        return this;
    }
}
