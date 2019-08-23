package com.pages.disp.measureBlock;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ExampsImpl implements Examps {
    SelenideElement e;
    SelenideElement oprosAnketirovanie = $x("//*[contains(text(),'Опрос (анкетирование) на выявление хронических неинфекционных заболеваний, факторов риска их развития, потребления наркотических средств и психотропных веществ без назначения врача')]").$x("../../.");

    @Override
    public SelenideElement oprosAnketirovanie() {
        e = oprosAnketirovanie;
        return oprosAnketirovanie;
    }

    @Override
    public void open(SelenideElement e) {

    }
}
