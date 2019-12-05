package com.pages.medicalrecords;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.Datas;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class Ehr_medicalrecordsMkab {
    Datas d;
    SelenideElement searchPattern = $x("//*[@placeholder = 'Поиск медицинской записи по наименованию']");
    SelenideElement search = $x("//i[@class = 'zmdi zmdi-search']");


    public Ehr_medicalrecordsMkab(Datas d) {
        this.d = d;
    }

    @Step("поиск медзаписи через строку поиска")
    public Ehr_medicalrecordsMkab searchField() {
        searchPattern.setValue(d.getMedicalRecord());
        search.click();
        return this;
    }

    @Step("проверка результата поиска")
    public Ehr_medicalrecordsMkab validateMrIsExistOnSearchResult() {
    Assert.assertTrue(
        $x("//ngx-datatable")
            .$x(".//*[contains(text(),'" + d.getMedicalRecord() + "')]")
                .shouldBe(Condition.visible)
                .isDisplayed());
        return this;
    }

}