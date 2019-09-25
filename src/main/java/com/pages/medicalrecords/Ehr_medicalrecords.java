package com.pages.medicalrecords;

import com.codeborne.selenide.ElementsCollection;
import com.datas.Datas;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class Ehr_medicalrecords {
    Datas d;
    SelenideElement new_mr = $x("//*[contains(text(),'Новая медицинская запись')]");
    SelenideElement mr = $x("//st-accordion-menu-click")
            .$x(".//*[contains(text(),'Медицинские записи')]");
    SelenideElement vse_shabloni = $x("//*[contains(text(),'Все шаблоны')]");
    SelenideElement searchPattern = $x("//*[@placeholder = 'Поиск шаблона по номеру, наименованию и специализации']");
    SelenideElement searchMR = $x("//*[@placeholder = 'Поиск медицинской записи по наименованию']");
    SelenideElement search = $x("//i[@class = 'zmdi zmdi-search']");
    SelenideElement prosmotret = $x("//*[contains(text(),'Просмотреть')]");
    SelenideElement cancel = $x("//*[contains(text(),'Отменить')]");
    SelenideElement edit = $x("//*[contains(text(),'Редактировать')]");
    SelenideElement all_actions = $x("//*[contains(text(),'Все действия')]");
    SelenideElement save = $x("//*[contains(text(),'Сохранить')]");
    SelenideElement podpisat = $x("//*[contains(text(),'Подписать')]");
    SelenideElement msg_mr_podpisana = $x("//*[contains(.,'Медицинская запись успешно подписана')]");
    int mrCount;

    public Ehr_medicalrecords(Datas d) {
        this.d = d;
    }

    public Ehr_medicalrecords newMrMenuBtn() {
        new_mr.click();
        return this;
    }

    public Ehr_medicalrecords medicalRecordsMenuBtn() {
        mr.click();
        return this;
    }

    public Ehr_medicalrecords allPatternsBtn() {
        vse_shabloni.click();
        return this;
    }

    @Step("поиск медзаписи через строку поиска")
    public Ehr_medicalrecords searchField() {
        waitLoadGrid();
        searchPattern.setValue(d.getMedicar_record());
        search.click();
        waitLoadGrid();
        return this;
    }

    @Step("поиск медзаписи через строку поиска")
    public Ehr_medicalrecords searchMR() {
        waitLoadGrid();
        searchMR.setValue(d.getMedicar_record());
        search.click();
        waitLoadGrid();
        return this;
    }

    public Ehr_medicalrecords openMr() throws InterruptedException {
        SelenideElement osmotr_gastroenterolga =
                $x("//span[contains(text(),'" + d.getMedicar_record() + "')]");
        osmotr_gastroenterolga.doubleClick();
        validateIframe();
        return this;
    }

    public Ehr_medicalrecords deleteMR() {
        mrCount = getMrCount();
        ElementsCollection medicalRecords = $$x("//span[contains(text(),'Осмотр гастроэнтеролога')]");
        for (SelenideElement mr : medicalRecords) {
            if (mr.$x("../../../.").$x(".//i[contains(text(),'done')]").exists()) {
                mr.click();
            } else {
                mr.click();
                break;
            }
        }
        $x("//i[@title='Удалить медицинскую запись.']").click();
        $x("//i[@title='Удалить медицинскую запись.'][contains(text(),'done')]").click();
        return this;
    }

    public Ehr_medicalrecords podpisanaSortColumn() {
        $x("//datatable-header").$x("//span[contains(text(),'Подписана')]").click();
        return this;
    }

    public Ehr_medicalrecords view() throws InterruptedException {
        validateIframe();
        prosmotret.click();
        return this;
    }

    public Ehr_medicalrecords cancelBtn() throws InterruptedException {
        cancel.click();
        return this;
    }

    public Ehr_medicalrecords edit() throws InterruptedException {
        validateIframe();
        edit.click();
        return this;
    }

    public Ehr_medicalrecords allActions() throws InterruptedException {
        validateIframe();
        all_actions.click();
        return this;
    }

    public Ehr_medicalrecords save() throws InterruptedException {
        validateIframe();
        save.shouldNotBe(Condition.disabled);//добавил для теста test_edit_mr_after_save
        save.click();
        $x("//*[contains(text(),'Медицинская запись успешно сохранена')]").shouldBe(Condition.visible);
        return this;
    }

    public Ehr_medicalrecords podpisat() throws InterruptedException {
        validateIframe();
        podpisat.click();
        return this;
    }

    @Step("проверка что медзапись отображается в результате поиска")
    public Ehr_medicalrecords validateMrIsExistOnSearchResult() {
        Assert.assertTrue(
                $x("//ngx-datatable")
                        .$x(".//*[contains(text(),'" + d.getMedicar_record() + "')]")
                        .shouldBe(Condition.visible)
                        .isDisplayed());
        return this;
    }

    public Ehr_medicalrecords assertSignSuccesfull() {
        msg_mr_podpisana.shouldBe(Condition.visible);
        Assert.assertTrue(msg_mr_podpisana.is(Condition.visible));
        return this;
    }

    private Ehr_medicalrecords validateIframe() throws InterruptedException {
        switchTo().frame($x("//iframe"));
        $x("//center[contains(text(),'" + d.getMedicar_record() + "')]")
                .shouldBe(Condition.visible);
        switchTo().defaultContent();
        Thread.sleep(1000);
        return this;
    }

    private void waitLoadGrid() {
        $x("//datatable-progress").$x(".//div[@class='bar']").shouldBe(Condition.visible);
        $x("//datatable-progress").$x(".//div[@class='bar']").shouldNotBe(Condition.visible);
    }

    public void verifyMrIsDeleted() {
        Assert.assertTrue(mrCount == getMrCount()+1);
    }

    private int getMrCount() {
        $x("//div[@class='datatable-footer-inner']")
                .$x(".//*[contains(text(),'всего')]").shouldBe(Condition.visible);
        String value = $x("//div[@class='datatable-footer-inner']")
                .$x(".//*[contains(text(),'всего')]")
                .getText();
        if (value.contains(" ")) {
            value = value.substring(0, value.indexOf(" "));
            System.out.println(value);
        }
        return Integer.parseInt(value);
    }
}