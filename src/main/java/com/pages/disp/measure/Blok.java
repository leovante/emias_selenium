package com.pages.disp.measure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.datas.disp.measure.IndividualnoeProfKonsultirovanie;
import com.datas.disp.measure.IssledovanieKala;
import com.datas.disp.measure.Measure;
import com.datas.disp.measure.MeasureEnum;
import com.pages.disp.DispaPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.SkipException;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class Blok extends DispaPage implements BlokImpl {
    private SelenideElement examTitle;
    private SelenideElement examBlok;
    private SelenideElement serviceTitle;
    private SelenideElement serviceBlok;
    private Measure m;

    @Override
    public Measure examFactory(MeasureEnum measureEnum) {
        m = null;
        switch (measureEnum) {
            case issledovanie_kala:
                m = new IssledovanieKala();
                break;
            case individualnoe_prof_konsultir:
                m = new IndividualnoeProfKonsultirovanie();
                break;
        }
        return m;
    }

    @Override
    public void expandExam(MeasureEnum measure) {
        findExam(measure);
        this.examBlok.hover();
        this.examTitle.click();
        this.examBlok.hover();
        this.examBlok.$x(".//app-medical-records-list").shouldBe(Condition.visible);
    }

    @Override
    public void expandService() {
        findService();
        this.serviceBlok.hover();
        this.serviceTitle.click();
        this.serviceBlok.hover();
        this.serviceBlok.$x("//tbody/tr[2]").shouldBe(Condition.visible);
        this.serviceBlok.$x("//tbody/tr[2]").$x(".//circle").shouldNotBe(Condition.visible);//херово работает, да и смысла нет из-за vaitera
        iframeWaiter();
        this.examBlok.hover();
    }

    @Override
    public void signMr(){
        $x("//*[contains(text(),'" + m.getExamName() + "')]")
                .$x("../tr[3]//*[contains(text(),'Подписать')]").hover().click();
    }

    private void findExam(MeasureEnum measure) {
        try {
            examFactory(measure);
            this.examBlok = $x("//*[contains(text(),'" + m.getExamName() + "')]").$x("../../../.");
            this.examTitle = $x("//*[contains(text(),'" + m.getExamName() + "')]");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new SkipException("Element not found");
        }
    }

    private void findService() {
        try {
            this.serviceTitle = $x("//*[contains(text(),'" + m.getServiceName() + "')]");
            this.serviceBlok = $x("//*[contains(text(),'" + m.getServiceName() + "')]").$x("../../../../../../../../../../.");//10
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new SkipException("Element not found");
        }
    }

    private void iframeWaiter() {
        SelenideElement iframe = this.serviceBlok.$x(".//app-template-frame[not(contains(@style,'display: none;'))]/.//iframe").shouldBe(Condition.visible);
//        focusElement(iframe);
        switchTo().frame(iframe);
        $x("//body/.//*[contains(text(),'" + m.getMedicalRecordName() + "')]").shouldBe(Condition.visible);
        switchTo().defaultContent();
    }

//    private void focus(SelenideElement iframe){
//        WebDriver driver = getWebDriver();
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("document.getElementById('elementid').focus();");
//    }

//    private void focusElement(WebElement element) {
//        String javaScript = "var evObj = document.createEvent('MouseEvents');"
//                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
//                + "arguments[0].dispatchEvent(evObj);";
//        ((JavascriptExecutor) getWebDriver()).executeScript(javaScript, element);
//    }
}