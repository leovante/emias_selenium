package com.pages.medicalrecords;

import com.codeborne.selenide.ElementsCollection;
import com.datas.Datas;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.pages.WebPage;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class EhrMedRecords extends WebPage {
    int mrCount = 0;
    Datas d;
    SelenideElement new_mr = $x("//*[contains(text(),'Новая медицинская запись')]");
    SelenideElement mr = $x("//st-accordion-menu-click").$x(".//*[contains(text(),'Медицинские записи')]");
    SelenideElement vse_shabloni = $x("//*[contains(text(),'Все шаблоны')]");
    SelenideElement searchPattern = $x("//*[@placeholder = 'Поиск шаблона по номеру, наименованию и специализации']");
    SelenideElement searchMR = $x("//*[@placeholder = 'Поиск медицинской записи по наименованию']");
    SelenideElement search = $x("//i[@class = 'zmdi zmdi-search']");
    SelenideElement prosmotret = $x("//*[contains(text(),'Просмотреть')]");
    SelenideElement cancel = $x("//*[contains(text(),'Отменить')]");
    SelenideElement edit = $x("//*[contains(text(),'Редактировать')]");
    SelenideElement allActions = $x("//*[contains(text(),'Все действия')]");
    SelenideElement save = $x("//*[contains(text(),'Сохранить')]");
    SelenideElement podpisat = $x("//*[contains(text(),'Подписать')]");
    SelenideElement msg_mr_podpisana = $x("//*[contains(.,'Медицинская запись успешно подписана')]");

    EhrMedRecords(Datas d) {
        this.d = d;
    }

    public EhrMedRecords loginFromTap(){
        open(conf.getMrFromTap());
        logger.info("Открыл модуль медзаписей через ТАП по прямой ссылке " + conf.getMrFromTap());
        return this;
    }

    public EhrMedRecords newMrMenuBtn() {
        new_mr.click();
        return this;
    }

    public EhrMedRecords medicalRecordsMenuBtn() {
        mr.click();
        return this;
    }

    public EhrMedRecords allPatternsBtn() {
        vse_shabloni.click();
        return this;
    }

    public EhrMedRecords searchField() {
        $x("//datatable-row-wrapper[@class='datatable-row-wrapper ng-star-inserted']").shouldBe(Condition.visible);
        searchPattern.setValue(d.getMedicalRecord());
        search.click();
        return this;
    }

    public EhrMedRecords searchMR() {
        waitLoad(mrCount);
        mrCount = getMrCount();
        $x("//datatable-row-wrapper[@class='datatable-row-wrapper ng-star-inserted']").shouldBe(Condition.visible);
        searchMR.setValue(d.getMedicalRecord());
        search.click();
        waitLoad(mrCount);
        return this;
    }

    private void waitLoad(int mrCount){
        int mrCount2 = getMrCount();
        for (int i = 0; i < 20; i++) {
            if(mrCount == mrCount2){
                sleep(1000);
                mrCount2 = getMrCount();
            }
        }
    }

    public EhrMedRecords openMr()   {
        SelenideElement osmotr_gastroenterolga =
                $x("//span[contains(text(),'" + d.getMedicalRecord() + "')]");
        osmotr_gastroenterolga.doubleClick();
        validateIframe();
        return this;
    }

    public EhrMedRecords deleteMR() {
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

    public EhrMedRecords podpisanaSortColumn() {
        $x("//datatable-header").$x("//span[contains(text(),'Подписана')]").click();
        return this;
    }

    public EhrMedRecords view()   {
        validateIframe();
        prosmotret.click();
        return this;
    }

    public EhrMedRecords cancelBtn()   {
        cancel.click();
        return this;
    }

    public EhrMedRecords edit()   {
        validateIframe();
        edit.click();
        return this;
    }

    public EhrMedRecords allActions()   {
        validateIframe();
        allActions.click();
        return this;
    }

    public EhrMedRecords save()   {
        validateIframe();
        save.shouldNotBe(Condition.disabled);//добавил для теста test_edit_mr_after_save
        save.click();
        $x("//*[contains(text(),'Медицинская запись успешно сохранена')]").shouldBe(Condition.visible);
        return this;
    }

    public EhrMedRecords podpisat()   {
        validateIframe();
        podpisat.click();
        return this;
    }

    public EhrMedRecords validateMrIsExistOnSearchResult() {
        Assert.assertTrue(
                $x("//ngx-datatable")
                        .$x(".//*[contains(text(),'" + d.getMedicalRecord() + "')]")
                        .shouldBe(Condition.visible)
                        .isDisplayed());
        return this;
    }

    public EhrMedRecords assertSignSuccesfull() {
        msg_mr_podpisana.shouldBe(Condition.visible);
        Assert.assertTrue(msg_mr_podpisana.is(Condition.visible));
        return this;
    }

    private EhrMedRecords validateIframe() {
        SelenideElement iframe = $x("//app-template-frame[not(contains(@style,'display: none;'))]/.//iframe").shouldBe(Condition.visible);
        switchTo().frame(iframe);
        $x("//body/.//*[contains(text(),'" + d.getMedicalRecord() + "')]").shouldBe(Condition.visible);
        switchTo().defaultContent();
        sleep(1000);
        return this;
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
//            System.out.println(value);
        }
        return Integer.parseInt(value);
    }
}