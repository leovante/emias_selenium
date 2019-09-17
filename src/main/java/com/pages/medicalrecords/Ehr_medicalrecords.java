package com.pages.medicalrecords;

import com.datas.Datas;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class Ehr_medicalrecords {
    Datas d;
    SelenideElement new_mr = $x("//*[contains(text(),'Новая медицинская запись')]");
    SelenideElement vse_shabloni = $x("//*[contains(text(),'Все шаблоны')]");
    SelenideElement searchPattern = $x("//*[@placeholder = 'Поиск шаблона по номеру, наименованию и специализации']");
    SelenideElement search = $x("//i[@class = 'zmdi zmdi-search']");
    SelenideElement prosmotret = $x("//*[contains(text(),'Просмотреть')]");
    SelenideElement edit = $x("//*[contains(text(),'Редактировать')]");
    SelenideElement all_actions = $x("//*[contains(text(),'Все действия')]");
    SelenideElement save = $x("//*[contains(text(),'Сохранить')]");
    SelenideElement podpisat = $x("//*[contains(text(),'Подписать')]");
    SelenideElement msg_mr_podpisana = $x("//*[contains(.,'Медицинская запись успешно подписана')]");

    public Ehr_medicalrecords(Datas d) {
        this.d = d;
    }

    public Ehr_medicalrecords new_mr_menuBtn() {
        new_mr.click();
        return this;
    }

    public Ehr_medicalrecords all_patterns() {
        vse_shabloni.click();
        return this;
    }

    @Step("поиск медзаписи через строку поиска")
    public Ehr_medicalrecords search_field() {
        searchPattern.setValue(d.getMedicar_record());
        search.click();
        return this;
    }

    public Ehr_medicalrecords open_MR() {
        SelenideElement osmotr_gastroenterolga =
                $x("//span[contains(text(),'" + d.getMedicar_record() + "')]");
        osmotr_gastroenterolga.doubleClick();
        return this;
    }

    public Ehr_medicalrecords prosmotret() throws InterruptedException {
        validate_iframe();
        prosmotret.click();
        return this;
    }

    public Ehr_medicalrecords edit() throws InterruptedException {
        validate_iframe();
        edit.click();
        return this;
    }

    public Ehr_medicalrecords all_actions() throws InterruptedException {
        validate_iframe();
        all_actions.click();
        return this;
    }

    public Ehr_medicalrecords save() throws InterruptedException {
        validate_iframe();
        save.shouldNotBe(Condition.disabled);//добавил для теста test_edit_mr_after_save
        save.click();
        return this;
    }

    public Ehr_medicalrecords podpisat() throws InterruptedException {
        validate_iframe();
        podpisat.click();
        return this;
    }

    public Ehr_medicalrecords assert_sign_succesfull() {
        msg_mr_podpisana.shouldBe(Condition.visible);
        Assert.assertTrue(msg_mr_podpisana.is(Condition.visible));
        return this;
    }

    public Ehr_medicalrecords validate_iframe() throws InterruptedException {
        switchTo().frame($x("//iframe"));
        $x("//center[contains(text(),'" + d.getMedicar_record() + "')]")
                .shouldBe(Condition.visible);
        switchTo().defaultContent();
        Thread.sleep(1000);
        return this;
    }
}