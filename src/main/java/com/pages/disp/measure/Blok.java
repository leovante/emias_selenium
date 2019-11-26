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

public class Blok extends DispaPage implements BlokImpl {
    private SelenideElement examTitle;
    private SelenideElement examBlok;
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
    public void expand(MeasureEnum measure) {
        findExam(measure);
        examBlok.hover();
        examTitle.click();
        examBlok.hover();
        examBlok.$x(".//app-medical-records-list").shouldBe(Condition.visible);
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
}