package com.pages.disp;

import com.pages.WebPage;

import static com.lib.assistance.Assistance.placeholder;
import static com.lib.assistance.Assistance.visible;

public class KvotyPage extends WebPage implements KvotyPageElem{
    public KvotyPage() {
    }

    public KvotyPage kvotyBtn() {
        kvotyMenuBtn.click();
        return this;
    }

    public KvotyPage validKvotyElements(){
        visible(header);
        visible(placeholder(num));
        visible(period);
        visible(clean);
        visible(journalMenuBtn);
        visible(kvotyMenuBtn);
        visible(planGraphMenuBtn);
        return this;
    }
}